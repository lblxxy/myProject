package com.meiman.meimanwallet.utils;

import com.meiman.meimanwallet.constant.ErrorCode;
import com.meiman.meimanwallet.constant.ErrorCodeMsg;

/**
 * 返回结果
 * @author zeng_
 */
public class RpcClientResult<T> {
    /**
     * 是否成功
     */
    private boolean success;
    /**
     * 状态码
     */
    private String code;
    /**
     * 具体信息
     */
    private String msg;
    /**
     * 具体内容
     */
    private T data;

    public RpcClientResult() {
    }

    private RpcClientResult(boolean success, String code, String msg) {
        this.success = success;
        this.code = code;
        this.msg = msg;
    }

    public RpcClientResult(boolean success, String code, String msg, T data) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private RpcClientResult(boolean success, ErrorCode errorCode) {
        this.success = success;
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
    }

    public static RpcClientResult getSuccess() {
        return new RpcClientResult(true, ErrorCodeMsg.SUCCESS);
    }

    public static RpcClientResult getFailed() {
        return new RpcClientResult(false, ErrorCodeMsg.FAILED);
    }

    public static RpcClientResult getFailed(String msg) {
        return new RpcClientResult(false, ErrorCodeMsg.FAILED.getCode(), msg);
    }

    public static RpcClientResult getFailed(ErrorCode errorCode) {
        return new RpcClientResult(false, errorCode);
    }

    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
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
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
}
