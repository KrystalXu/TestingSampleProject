/*
 * Copyright(c) 2012-2014 SpringTour.Ltd. All Rights Reserved.
 * 
 */
package com.springtour.sample.common;

import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.runner.RunWith;

import com.springtour.sample.suite.UnitTest;

/**
 * jmock基类，继承该类获取上下文来mock对象
 * @author lenovo
 * @date 2014-7-30
 */
@RunWith(JMock.class)
public abstract class AbstractJMockTests implements UnitTest {

    public Mockery context = new JUnit4Mockery();
    
    
}
