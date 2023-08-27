/*
 * Copyright(c) 2012-2014 SpringTour.Ltd. All Rights Reserved.
 * 
 */
package com.springtour.sample.util;

import java.util.Calendar;

/**
 * 此处为类说明
 * @author lenovo
 * @date 2014-7-30
 */
public class SimpleClock implements Clock {

    public int yearNow() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }
    

}
