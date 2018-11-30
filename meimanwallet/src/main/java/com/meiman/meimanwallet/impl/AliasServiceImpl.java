package com.meiman.meimanwallet.impl;

import com.meiman.meimanwallet.dao.mapper.AliasMapper;
import com.meiman.meimanwallet.entity.Alias;
import com.meiman.meimanwallet.service.AliasService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zeng_
 * @Date 2018/11/27
 */
@Service("aliasService")
public class AliasServiceImpl implements AliasService {

    @Resource
    private AliasMapper aliasMapper;

    @Override
    public Alias getAliasById(String id) {
        return aliasMapper.selectByPrimaryKey(id);
    }

    @Async("taskExecutor")
    @Override
    public void sendEmil(String title,String context,String to){
        System.out.println("当前运行的线程名称：" + Thread.currentThread().getName());
    }
}
