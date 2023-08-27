/*
 * Copyright(c) 2012-2014 SpringTour.Ltd. All Rights Reserved.
 */
package com.springtour.sample.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * 验收测试套件
 * @author xuxinyu
 * @date 2014-7-30
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ CucumberAcceptanceTests.class })
public class AcceptanceTestsSuite {

}
