package com.java.houserent.view;

//1-显示界面
//2-接受用户输入
//3-调用HouseService完成对房屋信息的各种操作
//listHouse()方法-界面
//调用HouseService.java中的list()方法

import com.java.houserent.domain.House;
import com.java.houserent.service.HouseService;
import com.java.houserent.utils.Utility;

public class HouseView {

    private boolean loop = true; //控制显示菜单
    private char key = ' '; //接受用户选择

    //创建HouseService对象，设定size
    //对象<=>属性
    private HouseService houseService = new HouseService(10);

    //listHouse()
    //显示房屋列表
    public void listHouse() {
        System.out.println("==========HouseList==========");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(Rented/NotRented)"); //表头

        //得到所有的装填了（房屋对象House）的（房屋数组House[]）
        House[] houses = houseService.list(); //houseService.list().var
        for (int i = 0 ; i < houses.length ; i++){
            if (houses[i] != null) { //数组对象非空，则显示
                System.out.println(houses[i]);
            }else{
                break; //数组对象为空，则不显示
            }

        }

        System.out.println("==========End==========");
    }


    //显示主菜单
    public void mainMenu() {

        do {
            System.out.println("==========HouseRentSystem==========");
            System.out.println("\t\t\t1 新增房源");
            System.out.println("\t\t\t2 查找房源");
            System.out.println("\t\t\t3 删除房源");
            System.out.println("\t\t\t4 修改房源");
            System.out.println("\t\t\t5 显示房源");
            System.out.println("\t\t\t6 退    出");
            System.out.print("请输入选择1-6："); //print和println区别
            key = Utility.readChar();
            switch (key){
                case '1' :
                    System.out.println("新增");
                    break;
                case '2' :
                    System.out.println("查找");
                    break;
                case '3' :
                    System.out.println("删除");
                    break;
                case '4' :
                    System.out.println("修改");
                    break;
                case '5' :
                    //System.out.println("显示");
                    listHouse();
                    break;
                case '6' :
                    System.out.println("退出");
                    loop = false;
                    break;
            }
        } while (loop);
    }


}
