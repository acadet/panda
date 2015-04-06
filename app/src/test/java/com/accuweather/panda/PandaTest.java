package com.accuweather.panda;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

/**
 * @class PandaTest
 * @brief
 */
@Config(emulateSdk = 18, reportSdk = 18)
@RunWith(RobolectricTestRunner.class)
public class PandaTest {

    @Test
    public void PandaNameTest() {
        Panda p = new Panda();

        p.setName("foo");

        Assert.assertEquals("foo", p.getName());
    }

    //    @Test
    //    public void itIsGoingToFail() {
    //        Assert.assertTrue(false);
    //    }
}
