package com.springtour.sample;

import static org.junit.Assert.*;
import org.jmock.Expectations;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springtour.sample.suite.IntegrationTest;

/**
 * 使用spring上下文做测试
 * @author lenovo
 * @date 2014-7-30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:com/springtour/sample/sample.xml",
        "classpath:com/springtour/sample/datasource.xml" })
public class SpringJunit4HelloWorldTests implements IntegrationTest {

    @Autowired
    private HelloWorld helloWorld;

    @Test
    public void printCareerAgesLeft() {
        int left = helloWorld.careerAagsLeft();
        assertTrue(left == 38);
    }

    @Test
    public void printHelloToEngineer() {
        assertEquals(helloWorld.sayHello(), "Hello, zhangyunyan");
    }
}
