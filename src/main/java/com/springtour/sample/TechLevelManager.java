/*
 * Copyright(c) 2012-2014 SpringTour.Ltd. All Rights Reserved.
 * 
 */
package com.springtour.sample;
/**
 * 此处为类说明
 * @author lenovo
 * @date 2014-7-31
 */
public interface TechLevelManager {

    public int getLevelByName(String name);
    
    public void storeLevelByName(String name, int level);
}
