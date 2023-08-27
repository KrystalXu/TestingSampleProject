/*
 * Copyright(c) 2012-2014 SpringTour.Ltd. All Rights Reserved.
 */
package com.springtour.sample.features;

import static org.junit.Assert.*;

import org.jmock.Expectations;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import com.springtour.sample.HelloWorld;
import com.springtour.sample.common.TestDoubleBeanPostProcessor;
import com.springtour.sample.util.Clock;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.zh_cn.*;
import cucumber.runtime.java.StepDefAnnotation;

/**
 * 此处为类说明
 * @author lenovo
 * @date 2014-7-30
 */
@StepDefAnnotation
public class HelloWorldSteps {

    private HelloWorld helloWorld;

    private ApplicationContext context;

    private Clock clock;

    private TestDoubleBeanPostProcessor fixture;

    private String helloMessage;

    private int yearsLeft;

    @Before
    public void setUp() {
        fixture = new TestDoubleBeanPostProcessor();
        fixture.addMock("SimpleClock", Clock.class);
        context =
                new ClassPathXmlApplicationContext("com/springtour/sample/sample.xml",
                        "com/springtour/sample/test-double.xml", "classpath:com/springtour/sample/datasource.xml");
        clock = (Clock) context.getBean("SimpleClock");
    }

    @假如("^我有一个打招呼的应用程序$")
    public void 我有一个打招呼的应用程序() throws Throwable {
        helloWorld = (HelloWorld) context.getBean("HelloWorld");
    }

    @当("^我让它跟\"([^\"]*)\" say hi$")
    public void 我让它跟_say_hi(String arg1) throws Throwable {
        helloMessage = helloWorld.sayHello();
    }

    @那么("^它应该说\"([^\"]*)\"$")
    public void 它应该说(String helloMsg) throws Throwable {
        assertEquals(helloMsg, helloMessage);
    }

    @假如("^今年是\"([^\"]*)\"年$")
    public void 今年是_年(final int year) throws Throwable {
        fixture.context.checking(new Expectations() {
            {
                oneOf(clock).yearNow();
                will(returnValue(year));
            }
        });
    }

    @当("^我计算\"([^\"]*)\"还有多久退休$")
    public void 我计算_还有多久退休(String arg1) throws Throwable {
        helloWorld = (HelloWorld) context.getBean("HelloWorld");
        yearsLeft = helloWorld.careerAagsLeft();
    }

    @那么("^他还有\"([^\"]*)\"年退休$")
    public void 他还有_年退休(int careerYearsLeft) throws Throwable {
        assertEquals(careerYearsLeft, yearsLeft);
    }

    @DirtiesContext
    @After
    public void tearDown() {
        fixture.clearMocks();
    }
}
