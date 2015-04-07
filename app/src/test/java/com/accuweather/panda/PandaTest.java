package com.accuweather.panda;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;

/**
 * @class PandaTest
 * @brief
 */
@RunWith(RobolectricGradleTestRunner.class)
public class PandaTest {

    private MainActivity _activity;

    @Before
    public void setUp() {
        _activity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void PandaNameTest() {
        Panda p = new Panda();

        p.setName("foo");

        Assert.assertEquals("foo", p.getName());
    }

    @Test
    public void bar() {
        Assert.assertTrue(true);
    }

    //    @Test
    //    public void itIsGoingToFail() {
    //        Assert.assertTrue(false);
    //    }

    @Test
    public void foo() {
        Assert.assertTrue(true);
        Assert.assertNotNull(_activity);
    }
}
