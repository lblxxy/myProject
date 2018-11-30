package com.meiman.meimanwallet.service;

import com.meiman.meimanwallet.entity.Alias;

/**
 * @author zeng_
 * @Date 2018/11/27
 */
public interface AliasService {
    /**
     * 根据id查询
     * @param id alias
     * @return 查询对象
     */
    Alias getAliasById(String id);

    /**
     * 发送邮件
     * @param title   邮件标题
     * @param context 邮件内容
     * @param to      收件人
     */
    void sendEmil(String title,String context,String to);
}
