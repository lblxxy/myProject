package com.meiman.meimanwallet.entity;

/**
 * @author zeng_
 * @Date 2018/11/27
 */
public class Alias {

    private String address;
    private String alias;
    private long blockHeight;

    public Alias() {
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public long getBlockHeight() {
        return blockHeight;
    }

    public void setBlockHeight(long blockHeight) {
        this.blockHeight = blockHeight;
    }

    public Alias(String address, String alias) {
        this.address = address;
        this.alias = alias;
    }
}
