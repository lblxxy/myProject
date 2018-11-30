package com.meiman.meimanwallet.constant;


/**
 * 错误定义
 * @author zeng_cc
 */
public interface ErrorCodeMsg {
    /**
     * 常见错误定义
     */
    ErrorCode SUCCESS = ErrorCode.add("1000");
    ErrorCode FAILED = ErrorCode.add("1001");
    ErrorCode LANGUAGE_CANNOT_SET_NULL = ErrorCode.add("1002");
    ErrorCode NULL_PARAMETER = ErrorCode.add("10013");

}
