/*
 * Copyright(c) 2012-2014 SpringTour.Ltd. All Rights Reserved.
 */
package com.springtour.sample;

import com.springtour.sample.util.Clock;

/**
 * 此处为类说明
 * @author lenovo
 * @date 2014-7-30
 */
public class ZhangYunyan implements Engineer {

    private Clock clock;

    private TechLevelManager techLevelManager;

    private int birthYear;

    private String name;

    public ZhangYunyan() {
        this.birthYear = 1992;
        this.name = "zhangyunyan";
    }

    public String name() {
        return name;
    }

    // 年龄
    public int age() {
        return clock.yearNow() - birthYear;
    }

    // 技术等级
    public int level() {
        int level = techLevelManager.getLevelByName(name);
        return level == 0 ? 3 : level;
    }

    // 技术晋级
    public void levelUp() {
        techLevelManager.storeLevelByName(name, level() + 1);
    }

    public void setTechLevelManager(TechLevelManager techLevelManager) {
        this.techLevelManager = techLevelManager;
    }

    public void setClock(Clock clock) {
        this.clock = clock;

    }

}
