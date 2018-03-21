package com.custom.cc.custompieview;

/**
 * Created by CC on 2018/3/21.
 * 饼图实体类
 */

public class PieData {
    private String name;//饼图的名称
    private float value;//数值
    private float percent;//饼图所占百分比
    private  int color=0;//饼图的颜色
    private float angle=0;//饼图的角度

    public PieData(String name, float value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }
}
