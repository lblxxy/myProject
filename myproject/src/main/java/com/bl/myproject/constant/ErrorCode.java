package com.bl.myproject.constant;

/**
 * @author bl
 * @date 2019-5-24
 */
public enum  ErrorCode {
    /**
     * 请求成功
     */
    SUCCESS(1000,"请求成功！"),
    /**
     * 请求失败
     */
    FAILED(1001,"请求失败"),
    /**
     * 操作出错
     */
    MYBATIS_ERROR(10001,"数据库操作错误"),

    /**
     * 操作出错
     */
    PARAMETER_ERROR(10002,"参数错误"),

    /**
     * 参数为空
     */
    NULL_PARAMETER(10013,"参数为空")

    ;

    private final Integer code;

    private final String msg;

    private ErrorCode(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public Integer getCode(){
        return code;
    }

    public String getMsg(){
        return msg;
    }

    /**
     * 根据code获取枚举
     * @param code 错误码
     * @return 枚举名
     */
    public static ErrorCode getError(Integer code){
        if (null==code){
            return null;
        }
        for (ErrorCode errorCode:ErrorCode.values()){
            if(errorCode.getCode().equals(code)){
                return errorCode;
            }
        }
        return null;
    }
}
