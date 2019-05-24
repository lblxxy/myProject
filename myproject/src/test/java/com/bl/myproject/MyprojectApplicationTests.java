package com.bl.myproject;

import com.bl.myproject.constant.ErrorCode;
import com.bl.myproject.util.ResponseResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyprojectApplicationTests {

    @Test
    public void contextLoads() {
        ResponseResult failed = ResponseResult.getFailed();
        ResponseResult failed1 = ResponseResult.getFailed(ErrorCode.FAILED);
        ResponseResult failed2 = ResponseResult.getFailed(ErrorCode.SUCCESS);
        ResponseResult failed3 = ResponseResult.getFailed(ErrorCode.MYBATIS_ERROR);
        ResponseResult success = ResponseResult.getSuccess();
        System.out.println(failed);
        System.out.println(failed1);
        System.out.println(failed2);
        System.out.println(failed3);
        System.out.println(success);
    }

}
