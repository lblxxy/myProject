package com.meiman.meimanwallet.exception;

import com.meiman.meimanwallet.constant.ErrorCode;

/**
 * 异常处理类，定义自己的异常，并自己处理
 * @author zeng_cc
 */
public class WalletException extends Exception {

    private String code;

    private String msg;

    public WalletException() {

    }

    public WalletException(Exception e) {
        super(e);
    }

    public WalletException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public WalletException(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
    }

    public WalletException(ErrorCode errorCode, Exception e) {
        super(e);
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
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
