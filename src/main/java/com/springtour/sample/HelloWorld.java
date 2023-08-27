/*
 * Copyright(c) 2012-2014 SpringTour.Ltd. All Rights Reserved.
 * 
 */
package com.springtour.sample;


/**
 * 此处为类说明
 * @author lenovo
 * @date 2014-7-30
 */
public class HelloWorld {
    
    private Engineer engineer;
    
    public String sayHello(){
        return "Hello, "+engineer.name();
    }

    /**
     * 还剩多少年退休
     */
    public int careerAagsLeft(){
        int retireAge = 60;
        return retireAge - engineer.age();
    }

    
    public void setEngineer(Engineer engineer) {
        this.engineer = engineer;
    }
    
    

}
