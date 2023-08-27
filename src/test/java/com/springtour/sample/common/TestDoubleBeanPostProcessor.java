/*
 * Copyright(c) 2012-2014 SpringTour.Ltd. All Rights Reserved.
 */
package com.springtour.sample.common;

import java.util.HashMap;
import java.util.Map;

import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Ignore;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.*;

/**
 * 更加方便的模拟对象，不再用传统的set方法在spring上下文中设置被模拟对象
 * 
 * 原理：通过BeanPostProcessor 加强bean的实例化功能，以及静态Map来放置mock对象，以便动态的替换模拟对象
 * @author xuxinyu
 * @date 2014-7-30
 */
@Ignore
public  class TestDoubleBeanPostProcessor extends AbstractJMockTests implements BeanPostProcessor {

    private static Map<String, Object> MOCK_OBJS = new HashMap<String, Object>();
    
    public void addMock(String beanName, Class<?> obj){
        MOCK_OBJS.put(beanName, context.mock(obj));
    }
    
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return  bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(MOCK_OBJS.containsKey(beanName)){
           return MOCK_OBJS.get(beanName);
       }
        return bean;
        
    }

    public void clearMocks(){
        MOCK_OBJS = new HashMap<String, Object>();
    }
}
