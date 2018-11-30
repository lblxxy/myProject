package com.meiman.meimanwallet.constant;


import com.meiman.meimanwallet.i18n.I18nUtils;

/**
 * 错误码定义
 * @author zeng_cc
 */
public class ErrorCode {

    /**
     * 错误码内容
     */
    private String msg;

    /**
     * 错误码编码
     */
    private String code;

    public ErrorCode() {

    }

    /**
     * 构造
     * @param code 错误编码
     */
    private ErrorCode(String code) {
        this.code = code;
        this.msg = code;
        if (null == code) {
            throw new RuntimeException("the errorcode code cann't be null!");
        }
    }

    /**
     * 初始化，根据系统设置，返回不同国际化的语言
     * @return
     */
    public String getMsg() {
        return I18nUtils.get(msg);
    }

    public String getCode() {
        return code;
    }

    /**
     * 定义错误码，定义之后，在语言配置文件中配置好即可
     * @param code 错误码
     * @return 错误码类型
     */
    public static final ErrorCode add(String code) {
        return new ErrorCode(code);
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }
        if (!(obj instanceof ErrorCode)) {
            return false;
        }
        return code.equals(((ErrorCode) obj).getCode());
    }
}