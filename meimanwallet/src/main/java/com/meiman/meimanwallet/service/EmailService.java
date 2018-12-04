package com.meiman.meimanwallet.service;

/**
 * @author zeng_
 */
public interface EmailService {
    /**
     * 发送邮件
     * @param title   邮件标题
     * @param context 邮件内容
     * @param to      收件人
     */
    void sendEmil(String title,String context,String to);
}
