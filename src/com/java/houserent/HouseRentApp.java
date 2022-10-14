package com.java.houserent;

//程序入口
//创建HouseView对象
//显示主菜单

//问题清单
//1-注释方法
//2-数组扩容
//3-形参
//4-类
//5-对象
//6-方法/种类
//7- ==
//8-.var
//9-break
//10-toString()
//11-引用类型
//12-idea格式化

import com.java.houserent.view.HouseView;

public class HouseRentApp {
    public static void main(String[] args) {

        new HouseView().mainMenu(); //创建匿名对象
        System.out.println("==========已退出==========");

        //HouseView hv = new HouseView();
        //hv.mainMenu();
    }
}
