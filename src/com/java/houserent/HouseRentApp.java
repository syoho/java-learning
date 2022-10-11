package com.java.houserent;

//程序入口
//创建HouseView对象
//显示主菜单

import com.java.houserent.view.HouseView;

public class HouseRentApp {
    public static void main(String[] args) {

        new HouseView().mainMenu(); //创建匿名对象
        System.out.println("==========已退出==========");

        //HouseView hv = new HouseView();
        //hv.mainMenu();
    }
}
