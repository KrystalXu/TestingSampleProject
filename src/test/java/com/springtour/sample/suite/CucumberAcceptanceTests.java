/*
 * Copyright(c) 2012-2014 SpringTour.Ltd. All Rights Reserved.
 */
package com.springtour.sample.suite;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

/**
 * 此处为类说明
 * @author lenovo
 * @date 2014-7-30
 */

@RunWith(Cucumber.class)
@Cucumber.Options(features = "classpath:.", glue = "com/springtour/sample/features", format = { "html:target/cucumber/" })
public class CucumberAcceptanceTests implements AcceptanceTest {

}
