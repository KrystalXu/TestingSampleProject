/*
 * Copyright(c) 2012-2014 SpringTour.Ltd. All Rights Reserved.
 */
package com.springtour.sample;

import static org.junit.Assert.*;

import org.jmock.Expectations;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springtour.sample.common.TestDoubleBeanPostProcessor;
import com.springtour.sample.util.Clock;

/**
 * 动态替换模拟对象
 * @author xuxinyu
 * @date 2014-7-30
 */
public class TestDoubleHelloWorldTests extends TestDoubleBeanPostProcessor {

    private HelloWorld helloWorld;

    private Clock clock;

    @Before
    public void initMock() {
        addMock("SimpleClock", Clock.class);
        ApplicationContext ac =
                new ClassPathXmlApplicationContext("com/springtour/sample/sample.xml",
                        "com/springtour/sample/test-double.xml", "classpath:com/springtour/sample/datasource.xml");
        helloWorld = (HelloWorld) ac.getBean("HelloWorld");
        clock = (Clock) ac.getBean("SimpleClock");

    }

    // 因为spring test 默认只启动一次上下文，这种模拟对象会导致spring上下文被污染，所以加” @DirtiesContext“
    // 让junit每次执行完测试重新生成新的上下文
    @DirtiesContext
    @Test
    public void printCareerAgesLeftWhenYear2015() {
        context.checking(new Expectations() {
            {
                oneOf(clock).yearNow();
                will(returnValue(2015));
            }
        });
        int left = helloWorld.careerAagsLeft();
        assertEquals(37, left);
    }

    @After
    public void tearDown() {
        clearMocks();
    }
}
