/*
 * Copyright(c) 2012-2014 SpringTour.Ltd. All Rights Reserved.
 */
package com.springtour.sample;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 * 此处为类说明
 * @author lenovo
 * @date 2014-7-31
 */
public class JdbcTechLevelManagerImpl implements TechLevelManager {

    @SuppressWarnings("deprecation")
    @Resource
    private JdbcTemplate jdbcTemplate;

    @SuppressWarnings("unchecked")
    public int getLevelByName(String name) {
        Map resMap = jdbcTemplate.queryForMap("select level_num from TEST_LEVEL_SAMPLE where en_name= '" + name + "'");
        return Integer.valueOf(resMap.get("level_num").toString());
    }

    public void storeLevelByName(String name, int level) {
        jdbcTemplate.execute("update TEST_LEVEL_SAMPLE set level_num = "+level +" where en_name = '"+name+"'");

    }

}
