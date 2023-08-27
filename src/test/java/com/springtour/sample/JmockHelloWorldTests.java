/*
 * Copyright(c) 2012-2014 SpringTour.Ltd. All Rights Reserved.
 */
package com.springtour.sample;

import static org.junit.Assert.*;

import org.jmock.Expectations;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springtour.sample.common.AbstractJMockTests;

/**
 * 使用set方法将模拟出来的对象放置到spring上下文
 * 
 * 如果HelloWorld类的开发人员，不需关心Engineer的实现，则可以
 * 使用Jmock技术来模拟Engineer的调用，这样可以将测试重点
 * 放在HelloWorld类本身。
 * 
 * @author xuxinyu
 * @date 2014-7-30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:com/springtour/sample/sample.xml",
        "classpath:com/springtour/sample/datasource.xml" })
public class JmockHelloWorldTests extends AbstractJMockTests {

    @Autowired
    private HelloWorld helloWorld;

    private Engineer engineer = context.mock(Engineer.class);

    @Before
    public void initMock() {
        helloWorld.setEngineer(engineer);
    }

    // 因为spring test 默认只启动一次上下文，这种模拟对象会导致spring上下文被污染，所以加” @DirtiesContext“
    // 让junit每次执行完测试重新生成新的上下文
    @DirtiesContext
    @Test
    public void printHelloToEngineer() {
        context.checking(new Expectations() {
            {
                oneOf(engineer).name();
                will(returnValue("梁陈"));
            }
        });

        String msg = helloWorld.sayHello();
        assertEquals(msg, "Hello, 梁陈");
    }

    // 因为spring test 默认只启动一次上下文，这种模拟对象会导致spring上下文被污染，所以加” @DirtiesContext“
    // 让junit每次执行完测试重新生成新的上下文
    @DirtiesContext
    @Test
    public void printCareerAgesLeft() {
        context.checking(new Expectations() {
            {
                oneOf(engineer).age();
                will(returnValue(20));
            }
        });
        int left = helloWorld.careerAagsLeft();
        assertTrue(left == 40);
    }

}
