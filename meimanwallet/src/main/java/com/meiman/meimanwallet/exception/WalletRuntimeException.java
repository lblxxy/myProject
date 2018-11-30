package com.meiman.meimanwallet.exception;

import com.meiman.meimanwallet.constant.ErrorCode;

/**
 * 异常处理类，定义自己的异常，并自己处理
 * 运行时异常
 * @author zeng_cc
 */
public class WalletRuntimeException extends RuntimeException {

    private String code;

    private String msg;

    public WalletRuntimeException(Exception e) {
        super(e);
    }

    public WalletRuntimeException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public WalletRuntimeException(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
    }


    public WalletRuntimeException(ErrorCode errorCode, String msg) {
        this.code = errorCode.getCode();
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
