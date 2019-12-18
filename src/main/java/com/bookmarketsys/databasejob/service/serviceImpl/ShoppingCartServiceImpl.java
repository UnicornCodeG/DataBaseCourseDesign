package com.bookmarketsys.databasejob.service.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.bookmarketsys.databasejob.dto.BookAndNumberDTO;
import com.bookmarketsys.databasejob.mapper.*;
import com.bookmarketsys.databasejob.pojo.*;
import com.bookmarketsys.databasejob.service.ShoppingCartService;
import com.bookmarketsys.databasejob.vo.BillBookVO;
import com.bookmarketsys.databasejob.vo.CreateOrderVo;
import com.bookmarketsys.databasejob.vo.SettlementAmountVO;
import com.bookmarketsys.databasejob.vo.ShowShoppingCartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ShoppingCartServiceImpl
 * @Description
 * @Author 龚佳民
 * @Date 2019/12/10
 **/
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    BookMapper bookMapper;
    @Autowired
    BillMapper billMapper;
    @Autowired
    BillBookMapper billBookMapper;
    @Autowired
    MenuMapper menuMapper;
    @Autowired
    UserMapper userMapper;



    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createOrder(CreateOrderVo createOrderVo) {
        Integer userId = createOrderVo.getUserId();
        Double amount = createOrderVo.getAmount();
        List<SettlementAmountVO> settlementAmountVOList = createOrderVo.getSettlementAmountVO();
        //设置bill内容
        Bill bill = new Bill();
        bill.setAmount(amount);
        bill.setUserId(userId);
        bill.setNote(createOrderVo.getNote());
        bill.setStatus("未支付");
        User user = userMapper.selectByPrimaryKey(userId);
        bill.setCreateOpr(user.getUserName());
        Date createTime = new Date();
        bill.setCreateTime(createTime);
        billMapper.insert(bill);

        BillExample billExample = new BillExample();
        billExample.createCriteria().andUserIdEqualTo(userId).andCreateTimeEqualTo(createTime);
        Integer billId = billMapper.selectByExample(billExample).get(0).getId();

        for (SettlementAmountVO settlementAmountVO : settlementAmountVOList) {
            Integer bookId = settlementAmountVO.getBookId();
            Integer number = settlementAmountVO.getNumber();
            Double billBookAmount = settlementAmountVO.getSinglePrice()*number;
            BillBook billBook = new BillBook();
            billBook.setAmount(billBookAmount);
            billBook.setBillId(billId);
            billBook.setBookId(bookId);
            billBook.setCount(number);
            billBook.setCreateOpr(user.getUserName());
            billBook.setCreateTime(new Date());
            billBookMapper.insert(billBook);
        }
    }

    //结算金额
    @Override
    public Double settlementAmount(List<SettlementAmountVO> settlementAmountVOList) {
        double total=0;
        for (SettlementAmountVO vo : settlementAmountVOList) {
            Book book = bookMapper.selectByPrimaryKey(vo.getBookId());
            total+=book.getPrice()*vo.getNumber();
        }
        return total;
    }

    //显示购物车内的书本信息
    @Override
    public List<ShowShoppingCartVO> showBookInfomation(List<List<String>> list) {
        List<ShowShoppingCartVO> cartVOList=new ArrayList<>();
        for (List<String> stringList : list) {
            ShowShoppingCartVO showShoppingCartVO = new ShowShoppingCartVO();
            List<BookAndNumberDTO> bookList=new ArrayList<>();
            for (String jsonString : stringList) {
                BookAndNumberDTO bookAndNumberDTO = new BookAndNumberDTO();
                Map<String, Integer> parse = (Map<String, Integer>) JSON.parse(jsonString);
                Integer bookId = parse.get("bookId");
                Integer number = parse.get("number");
                Book book = bookMapper.selectByPrimaryKey(bookId);
                bookAndNumberDTO.setBook(book);
                bookAndNumberDTO.setNumber(number);
                bookList.add(bookAndNumberDTO);
            }
            if (bookList.size()!=0) {
                Menu menu = menuMapper.selectByPrimaryKey(bookList.get(0).getBook().getMenuId());
                showShoppingCartVO.setBookList(bookList);
                showShoppingCartVO.setMenuId(menu.getId());
                showShoppingCartVO.setMenuName(menu.getMenuName());
                cartVOList.add(showShoppingCartVO);
            }
        }

        return cartVOList;
    }

    //显示订单中的书本信息
    @Override
    public List<BillBookVO> selectBillBookDetail(Integer billId){
        BillBookExample billBookExample = new BillBookExample();
        billBookExample.createCriteria().andBillIdEqualTo(billId);
        List<BillBook> billBooks = billBookMapper.selectByExample(billBookExample);
        List<BillBookVO> billBookVOList=new ArrayList<>();
        for (BillBook billBook : billBooks) {
            BillBookVO billBookVO = new BillBookVO();
            billBookVO.setNumber(billBook.getCount());
            billBookVO.setAmount(billBook.getAmount());
            Book book = bookMapper.selectByPrimaryKey(billBook.getBookId());
            billBookVO.setBookName(book.getName());
            billBookVO.setSinglePrice(book.getPrice());
            billBookVO.setPrecess(book.getPress());
            billBookVO.setAuthor(book.getAuthor());
            billBookVOList.add(billBookVO);
        }
        return billBookVOList;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void payForBill(Integer billId){
        Bill bill = billMapper.selectByPrimaryKey(billId);
        bill.setStatus("已支付");
        bill.setPayTime(new Date());
        billMapper.updateByPrimaryKeySelective(bill);
    }
}
