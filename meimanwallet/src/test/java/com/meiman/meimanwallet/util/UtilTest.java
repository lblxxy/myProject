package com.meiman.meimanwallet.util;

import com.meiman.meimanwallet.utils.LongUtils;
import org.junit.Test;

/**
 * @author zeng_
 * @Date 2018/11/30
 */
public class UtilTest {

    @Test
    public void testTime(){
        System.out.println(LongUtils.div(System.currentTimeMillis(),100000000));
    }
}
