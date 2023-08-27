/*
 * Copyright(c) 2012-2014 SpringTour.Ltd. All Rights Reserved.
 */
package com.springtour.sample;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springtour.sample.suite.PersistenceTest;

/**
 *  使用test-scripts里的jdbc:initialize-database 来执行初始化脚本，
 *  以便为每次测试前准备数据。
 *  
 *  用这种方案的话，需要将数据库脚本管理起来，并且最好每个测试用例都有独立的测试脚本
 * @author xuxinyu
 * @date 2014-7-31
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:com/springtour/sample/sample.xml",
        "classpath:com/springtour/sample/datasource.xml",
        "classpath:com/springtour/sample/test-scripts.xml" })
public class PersistenceEngineerTests implements PersistenceTest{

    @Autowired
    private ZhangYunyan zhangYunyan;
    
    @Test
    public void level(){
       int level =  zhangYunyan.level();
       assertEquals(4, level);
    }
    
    @DirtiesContext
    @Test
    public void levelUp(){
        int levelPre =  zhangYunyan.level();
        zhangYunyan.levelUp();
        int levelPost =  zhangYunyan.level();
        assertEquals(levelPre+1, levelPost);
    }
    

}
