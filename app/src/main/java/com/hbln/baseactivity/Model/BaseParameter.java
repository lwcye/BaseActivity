package com.hbln.baseactivity.Model;

import com.hbln.baseactivity.FrameWork.BaseModel;

/**
 * 基本参数类
 * Created by lwc on 2015/12/26.
 */
public class BaseParameter extends BaseModel {
    private int index;
    private String arg0;
    private String arg1;

    public BaseParameter(int index) {
        super();
        this.index = index;
    }

    public BaseParameter(String arg0) {
        super();
        this.arg0 = arg0;
    }

    public BaseParameter(int index, String arg0) {
        super();
        this.index = index;
        this.arg0 = arg0;
    }

    public BaseParameter(String arg0, String arg1) {
        super();
        this.arg0 = arg0;
        this.arg1 = arg1;
    }

    public BaseParameter(int index, String arg0, String arg1) {
        super();
        this.index = index;
        this.arg0 = arg0;
        this.arg1 = arg1;
    }


    public int getIndex() {
        return index;
    }


    public void setIndex(int index) {
        this.index = index;
    }


    public String getArg0() {
        return arg0;
    }


    public void setArg0(String arg0) {
        this.arg0 = arg0;
    }


    public String getArg1() {
        return arg1;
    }


    public void setArg1(String arg1) {
        this.arg1 = arg1;
    }


    @Override
    public String toString() {
        return "FragParameter:" + "index=" + index + ",arg0=" + arg0 + ",arg1=" + arg1;
    }
}

