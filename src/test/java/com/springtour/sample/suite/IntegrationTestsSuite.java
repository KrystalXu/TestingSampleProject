/*
 * Copyright(c) 2012-2014 SpringTour.Ltd. All Rights Reserved.
 * 
 */
package com.springtour.sample.suite;

import org.junit.extensions.cpsuite.ClasspathSuite;
import org.junit.extensions.cpsuite.ClasspathSuite.BaseTypeFilter;
import org.junit.runner.RunWith;



/**
 * 集成测试套件
 * @author xuxinyu
 * @date 2014-7-30
 */
@RunWith(ClasspathSuite.class)
@BaseTypeFilter(IntegrationTest.class)
public class IntegrationTestsSuite {

}
