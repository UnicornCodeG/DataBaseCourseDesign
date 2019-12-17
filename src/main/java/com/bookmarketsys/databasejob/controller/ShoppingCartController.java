package com.bookmarketsys.databasejob.controller;

import com.alibaba.fastjson.JSON;
import com.bookmarketsys.databasejob.dto.ShoppingCartUserIdMenuIdDTO;
import com.bookmarketsys.databasejob.service.ShoppingCartService;
import com.bookmarketsys.databasejob.util.Result;
import com.bookmarketsys.databasejob.util.ResultEnum;
import com.bookmarketsys.databasejob.util.ResultUtil;
import com.bookmarketsys.databasejob.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ShoppingCart
 * @Description
 * @Author 龚佳民
 * @Date 2019/12/9
 **/
@RestController
public class ShoppingCartController {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    ShoppingCartService shoppingCartService;
    private static final Logger logger=LoggerFactory.getLogger(ShoppingCartController.class);
    //显示购物车内的物品
    @GetMapping("/showShoppingCart")
    public Result showShoppingCart(Integer userId){
        String shoppingCartUserKey="shoppingCart:" + userId;
        System.out.println(userId);
        ListOperations listOperations = redisTemplate.opsForList();

        List<List<String>> range = listOperations.range(shoppingCartUserKey, 0, -1);
        List<ShowShoppingCartVO> cartVOList = shoppingCartService.showBookInfomation(range);

        return ResultUtil.success(cartVOList);
    }

    //添加购物车
    @RequestMapping("/addIntoShoppingCart")
    public Result addIntoShoppingCart(@RequestBody AddIntoShoppingCartVO addIntoShoppingCartVO){
        Integer userId = addIntoShoppingCartVO.getUserId();
        Integer bookId = addIntoShoppingCartVO.getBookId();
        Integer menuId = addIntoShoppingCartVO.getMenuId();
        System.out.println(userId+" "+bookId+" "+menuId);
        //该用户下的指定类型图书list的key
        String shoppingCartUserMenuKey="shoppingCart:" + userId + ":" + menuId;
        System.out.println(shoppingCartUserMenuKey);
        //该用户下的购物车的key
        String shoppingCartUserKey="shoppingCart:" + userId;
        ListOperations listOperations = redisTemplate.opsForList();
        //是否需要添加
        boolean flag=true;


        //先判断该menu下是否存在该书，不存在直接添加，存在则数量加一
        List range = listOperations.range(shoppingCartUserMenuKey, 0, -1);
        //购物车移除该menu
        if (range.size()>0) listOperations.remove(shoppingCartUserKey, 1, range);

        for (Object o : range) {
            String objectJson = (String) o;
            ShoppingCartUserIdMenuIdDTO dto = JSON.parseObject(objectJson,ShoppingCartUserIdMenuIdDTO.class);
            //存在
            if (bookId.equals(dto.getBookId())){
                dto.setNumber(dto.getNumber()+1);
                //menu先移除该bookId+number，再添加
                listOperations.remove(shoppingCartUserMenuKey,1,o);
                listOperations.leftPush(shoppingCartUserMenuKey,JSON.toJSONString(dto));
                flag=false;
                break;
            }
        }
        if (flag)
        listOperations.leftPush(shoppingCartUserMenuKey, JSON.toJSONString(new ShoppingCartUserIdMenuIdDTO().setBookId(bookId).setNumber(1)));

        //向购物车中添加
        listOperations.leftPush(shoppingCartUserKey,listOperations.range(shoppingCartUserMenuKey, 0, -1));

        return ResultUtil.success("添加成功");
    }


    //移除购物车(一般都是批量操作)
    @RequestMapping("/removeShoppingCart")
    public Result removeShoppingCart(@RequestBody List<RemoveShoppingCartVO> removeShoppingCartVOList){
        logger.info("执行删除接口");
        ListOperations listOperations = redisTemplate.opsForList();

        for (RemoveShoppingCartVO vo : removeShoppingCartVOList) {
            String shoppingCartUserKey="shoppingCart:" + vo.getUserId();
            //该用户下的指定类型图书list的key
            String shoppingCartUserMenuKey="shoppingCart:" + vo.getUserId() + ":" + vo.getMenuId();

            //找到在该用户的购物车中这个menu的位置
            List userRange = listOperations.range(shoppingCartUserKey, 0, -1);
            int userIndex = userRange.indexOf(listOperations.range(shoppingCartUserMenuKey, 0, -1));
            //json字符串，与redis中存储的一致
            String jsonString = JSON.toJSONString(new ShoppingCartUserIdMenuIdDTO().setBookId(vo.getBookId()).setNumber(vo.getNumber()));
            listOperations.remove(shoppingCartUserMenuKey,1,jsonString);
            List afterRemoveUserMenuRange = listOperations.range(shoppingCartUserMenuKey, 0, -1);
            System.out.println(afterRemoveUserMenuRange.size());
            listOperations.set(shoppingCartUserKey,userIndex,afterRemoveUserMenuRange);
            listOperations.remove(shoppingCartUserKey,1,new ArrayList<>());
        }

        return ResultUtil.success("删除成功");
    }


    //改变数量
    @RequestMapping("/incrBookNumber")
    public Result incrBookNumber(Integer userId,Integer bookId,Integer menuId,Integer number){
        System.out.println(userId+" "+bookId+" "+menuId+" "+number);
        ListOperations listOperations = redisTemplate.opsForList();
        //该用户下的指定类型图书list的key
        String shoppingCartUserMenuKey="shoppingCart:" + userId + ":" + menuId;
        //该用户下的购物车的key
        String shoppingCartUserKey="shoppingCart:" + userId;

        List range = listOperations.range(shoppingCartUserMenuKey, 0, -1);

        int indexOfUserKey = listOperations.range(shoppingCartUserKey, 0, -1).indexOf(range);

        //json字符串，与redis中存储的一致
        String jsonString = null;

        for (Object o : range) {
            String objectJson = (String) o;
            ShoppingCartUserIdMenuIdDTO dto = JSON.parseObject(objectJson,ShoppingCartUserIdMenuIdDTO.class);
            if (bookId.equals(dto.getBookId())){
                logger.info(dto.getBookId()+" "+dto.getNumber());
                jsonString=JSON.toJSONString(new ShoppingCartUserIdMenuIdDTO().setBookId(bookId).setNumber(dto.getNumber()));
                break;
            }
        }
        int index = range.indexOf(jsonString);
        logger.info("index:"+index);
        listOperations.set(shoppingCartUserMenuKey,index,JSON.toJSONString(new ShoppingCartUserIdMenuIdDTO().setBookId(bookId).setNumber(number)));

        //给购物车中的menu更新
        listOperations.set(shoppingCartUserKey,indexOfUserKey,
                listOperations.range(shoppingCartUserMenuKey, 0, -1));
        return ResultUtil.success();
    }


    //减少数量
    @RequestMapping("/decrBookNumber")
    public Result decrBookNumber(Integer userId,Integer bookId,Integer menuId,Integer number){
        if (number==1) return ResultUtil.error(ResultEnum.ERROR.getCode(),"数量为1，不能再减少");
        ListOperations listOperations = redisTemplate.opsForList();
        //该用户下的指定类型图书list的key
        String shoppingCartUserMenuKey="shoppingCart:" + userId + ":" + menuId;
        //json字符串，与redis中存储的一致
        String jsonString = JSON.toJSONString(new ShoppingCartUserIdMenuIdDTO().setBookId(bookId).setNumber(number));
        List range = listOperations.range(shoppingCartUserMenuKey, 0, -1);
        int index = range.indexOf(jsonString);
        listOperations.set(shoppingCartUserMenuKey,index,JSON.toJSONString(new ShoppingCartUserIdMenuIdDTO().setBookId(bookId).setNumber(number-1)));
        return ResultUtil.success();
    }


    //结算金额
    @RequestMapping("/settlementAmount")
    public Result settlementAmount(@RequestBody List<SettlementAmountVO> settlementAmountVOList){
        Double total = shoppingCartService.settlementAmount(settlementAmountVOList);
        return ResultUtil.success(total);
    }

    //生成订单
    @RequestMapping("/createOrder")
    public Result createOrder(@RequestBody CreateOrderVo createOrderVo){
        shoppingCartService.createOrder(createOrderVo);
        return ResultUtil.success();
    }

    //统计购物车内书本的数量的方法
    @RequestMapping("/countTheNumber")
    public Result countTheNumber(Integer userId){
        //该用户下的购物车的key
        String shoppingCartUserKey="shoppingCart:" + userId;
        ListOperations listOperations = redisTemplate.opsForList();

        List<List<String>> range = listOperations.range(shoppingCartUserKey, 0, -1);
        Integer countNumber=0;
        for (List<String> list : range) {
            for (String jsonString : list) {
                Integer number = JSON.parseObject(jsonString, ShoppingCartUserIdMenuIdDTO.class).getNumber();
                countNumber+=number;
            }
        }
        logger.info("书本的数量："+countNumber);
        return ResultUtil.success(countNumber);
    }



}
