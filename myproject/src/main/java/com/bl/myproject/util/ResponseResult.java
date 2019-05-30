package com.bl.myproject.util;

import com.bl.myproject.constant.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 调接口响应返回，状态码，信息，数据
 * @author bl
 * @date 2019-5-24
 * @AllArgsConstructor 全构造注解
 * @NoArgsConstructor 无参构造注解
 * @Data 包含了Get、Set，ToString、equals()、hashCode()、toString()
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseResult<T> {

    private boolean success;

    private Integer code;

    private String msg;

    private T data;

    /**
     * 注意：公司用的ErrorCodeMsg接口和ErrorCode类的add方法添加错误码和错误信息 ，再加上初始化语言信息，可以设置不同语言错误信息
     * 但是，一添加一个错误信息，就要add错误码一次，中英文件相应错误信息也要各修改一次，会跳几个文件，较麻烦
     * ====但是针对单语言，完全可以使用枚举，更简单些，我这里就直接用枚举了，ErrorCode.错误常量.key/getKey()或者ErrorCode.错误常量.value/getValue()
     * 一个枚举搞定
     * ===下面的是其他构造
     */
    public ResponseResult(boolean success, Integer code, String msg) {
        this.success = success;
        this.code = code;
        this.msg = msg;
    }

    public ResponseResult(boolean success, Integer code) {
        this.success = success;
        this.code = code;
    }
    /**
     * 根据枚举错误信息返回相应错误的特殊构造
     */
    private  ResponseResult(boolean success,ErrorCode error){
        this.success=success;
        this.code=error.getCode();
        this.msg=error.getMsg();
    }
    /**
     * ===============根据需要设置部分方法=========================
     * 这是组装返回错误信息
     */
    public void setRseult(boolean success,Integer errorCode, String errorCodeMsg){
        this.success=success;
        this.code=errorCode;
        this.msg=errorCodeMsg;
    }

    /**
     * 组装成功的返回，没有数据
     * @param success true
     * @param successCode 请求成功的枚举信息
     */
    public void setSuccess(boolean success,ErrorCode successCode){
        this.success=success;
        this.code=successCode.getCode();
        this.msg=successCode.getMsg();
    }
    /**
     *请求成功返回
     */
    public static ResponseResult getSuccess(){
        return new ResponseResult(true,ErrorCode.SUCCESS.getCode());
    }
    /**
     * 请求失败返回
     */
    public static ResponseResult getFailed(){
        return new ResponseResult(false,ErrorCode.FAILED.getCode());
    }
    /**
     *返回错误代码和错误信息
     * @param error 错误信息
     * @return 错误代码和错误信息
     */
    public static ResponseResult getFailed(ErrorCode error){
        return new ResponseResult(false,error);
    }
    /**
     * 是否成功
     */
    public boolean isSuccess() {
        return success;
    }


}
