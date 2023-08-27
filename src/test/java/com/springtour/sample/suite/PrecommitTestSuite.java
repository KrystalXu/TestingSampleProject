/*
 * Copyright(c) 2012-2014 SpringTour.Ltd. All Rights Reserved.
 */
package com.springtour.sample.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * maven surfire 插件与该测试套件集成，以便每次ci跑流水线时会自动验证该套件中的所有单元测试是否通过
 * 
 * 注：如果是web项目，acceptanceTests需要依赖服务器启动的话，
 * 则需要将AcceptanceTestsSuite放到流水线weblogic启动之后执行
 * 
 * 流水线部署路线即：编译 -> PrecommitTestSuite,生成测试报告 -> package,生成javadoc -> db-deploy
 * ->PersistenceTestsSuite -> weblogic-deploy -> AcceptanceTestsSuite,生成测试报告
 * 
 * @author xuxinyu
 * @date 2014-7-30
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ UnitTestsSuite.class, IntegrationTestsSuite.class, AcceptanceTestsSuite.class,
        PersistenceTestsSuite.class })
public class PrecommitTestSuite {

}
