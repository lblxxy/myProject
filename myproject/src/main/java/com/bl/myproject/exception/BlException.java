package com.bl.myproject.exception;

import com.bl.myproject.constant.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 抛出自己的异常，springboot项目，只能继承RuntimeException，继承Exception的话最终还是抛出Exception
 * 自定义异常意义，你可以选择抛出自定义异常，也可以选择打印到日志、控制台，便于逻辑错误时检查
 * @author bl
 * @date 2019/5/27
 */
@Data
@AllArgsConstructor
public class BlException extends RuntimeException{


    private Integer code;
    private String  msg;
    /**
     * 无参构造方法
     */
    public BlException(){
        super();
    }

    public BlException(String msg){
        super(msg);
    }

    public BlException(ErrorCode errorCode){
        this.code=errorCode.getCode();
        this.msg=errorCode.getMsg();
    }
}
