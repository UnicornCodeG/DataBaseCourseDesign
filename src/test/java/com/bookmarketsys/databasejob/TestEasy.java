package com.bookmarketsys.databasejob;

import com.alibaba.fastjson.JSON;
import com.bookmarketsys.databasejob.dto.ShoppingCartUserIdMenuIdDTO;
import org.junit.Test;

/**
 * @ClassName TestEasy
 * @Description
 * @Author 龚佳民
 * @Date 2019/12/10
 **/

public class TestEasy {



    @Test
    public void test01() {
        String a = "shoppingCart:1:1";
        int firstIndex = a.indexOf(":");
        int secondIndex = a.indexOf(":", firstIndex + 1);
        int thirdIndex = a.indexOf(":", secondIndex + 1);
        System.out.println(firstIndex);
        System.out.println(secondIndex);
        System.out.println(thirdIndex);
        System.out.println(a.substring(0,firstIndex));
    }
    @Test
    public void test02(){
        String a="{selection:'0'}";
        ShoppingCartUserIdMenuIdDTO shoppingCartUserIdMenuIdDTO = new ShoppingCartUserIdMenuIdDTO().setBookId(1).setNumber(1);
        String jsonString = JSON.toJSONString(shoppingCartUserIdMenuIdDTO);
        System.out.println(jsonString);
        System.out.println(JSON.parseObject(jsonString,ShoppingCartUserIdMenuIdDTO.class));
    }

}
