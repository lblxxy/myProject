package com.bl.myproject;

import com.bl.myproject.constant.ErrorCode;
import com.bl.myproject.entity.BlUser;
import com.bl.myproject.exception.BlException;
import com.bl.myproject.util.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyprojectApplicationTests {

    @Test
    public void contextLoads() {

        /*System.out.println(PropertiesUtil.readProperty("redis.host"));*/
        /*ResponseResult failed = ResponseResult.getFailed();
        ResponseResult failed1 = ResponseResult.getFailed(ErrorCode.FAILED);
        ResponseResult failed2 = ResponseResult.getFailed(ErrorCode.SUCCESS);
        ResponseResult failed3 = ResponseResult.getFailed(ErrorCode.MYBATIS_ERROR);
        ResponseResult success = ResponseResult.getSuccess();
        System.out.println(failed);
        System.out.println(failed1);
        System.out.println(failed2);
        System.out.println(failed3);
        System.out.println(success);*/
/*        //ArithmeticException 除数不能为0的异常
        divide(5,0);*/
/*//        System.out.println(MD5Uil.encodeByMD5("123456"));*/

/*        //有一个问题，在Redis Desktop Manager 里面，user对象乱码
        BlUser user = new BlUser();
        user.setId(2);
        user.setAge(1);
        user.setName("asd");
        user.setDel(1);
        user.setPwd("asd02123123");
        user.setSex("1");
        String set = RedisUtil.getInstance().set("1", "2", "13", user);
        Object o = RedisUtil.getInstance().get("1", "2", "13");
        System.out.println(set);
        System.out.println(o.toString());*/

/*      //java 8 很多有用的时间类
        System.out.println(TimeUtil.currentDate());
          */
/*        LocalDate  today = LocalDate.now();
        LocalDate someDate = LocalDate.of(2019,3,3);
        Period between = Period.between( someDate,today);
        int months = between.getMonths();
        int days = between.getDays();
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        String text = today.format(formatters);
        System.out.println(text);*/
/*        List<BlUser> list = new ArrayList<>();
        list.add(new BlUser("jack", 20));
        list.add(new BlUser("mike", 25));
        list.add(new BlUser("tom", 30));
        List<String> newlist = list.stream().map(BlUser::getName).collect(toList());
        System.out.println(newlist);*/
        List<String> list = new ArrayList<>();
        list.add("aaa bbb ccc");
        list.add("ddd eee fff");
        list.add("ggg hhh iii");
        list = list.stream().map(s -> s.split(" ")).flatMap(Arrays::stream).collect(toList());
        System.out.println(list);
    }

   /* public  ResponseResult divide(int a, int b) {
        if(b==0){
            *//*BlException e = new BlException(ErrorCode.DIVIDE_NOT_BE_ZERO);
            System.out.println(e.getMsg());*//*
            throw new BlException(ErrorCode.DIVIDE_NOT_BE_ZERO);
        }
        ResponseResult result = ResponseResult.getSuccess();
        result.setData(a / b);
        System.out.println(result);
        return result;
    }*/


}
