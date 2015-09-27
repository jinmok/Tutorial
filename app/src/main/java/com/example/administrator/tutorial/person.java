package com.example.administrator.tutorial;

import java.io.Serializable;

/**
 * Created by mok17 on 9/27/2015.
 */
public class person implements Serializable {

    public String name;
    public String stat1;

    protected person(){

        name = "JohnDoe";
        stat1 = "6";
    }
}
