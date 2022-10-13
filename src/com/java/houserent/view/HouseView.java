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
    private HouseService houseService = new HouseService(2);

    //增
    //addHouse()
    //接收输入
    //创建House对象
    //调用HouseService.java的add()方法，将新对象加入数组
    //类型：void ；不是House
    //House对象的id属性为系统分配，用户不能输入，如QQ号/工号
    public void addHouse() {
        System.out.println("==========AddHouse==========");

        System.out.print("姓名：");
        String name = Utility.readString(30); //直接创建一个House对象的属性

        System.out.print("电话：");
        String phone = Utility.readString(30);

        System.out.print("地址：");
        String address = Utility.readString(20);

        System.out.print("月租：");
        int rent = Utility.readInt();

        System.out.print("状态(Rented/NotRented)：");
        String state = Utility.readString(30);

        //创建一个新的House对象
        House newHouse = new House(0, name, phone, address, rent, state);

        //调用HouseService.java的add()方法
        //添加newHouse对象
        //并且返回boolean值，以用来显示是否添加成功
        if(houseService.add(newHouse)) {
            System.out.println("==========Add Successfully==========");
        } else {
            System.out.println("==========Add Failed==========");
        }
    }

    //删
    //delHouse()
    //接收输入的House对象id
    //调用HouseService的del()方法
    public void delHouse() {

        System.out.println("==========DeleteHouse==========");

        System.out.print("请选择删除房屋的编号(-1则退出)：");
        int delId = Utility.readInt();
        if (delId == -1) {
            System.out.println("==========Give Up To Delete==========");
            return; //不用break ； return结束方法 ； void啥都不返回
        }

        //"请输入你的选择(Y/N): 请小心选择"
        //Utility.readConfirmSelection()具有循环判断功能
        //不输入Y/N无法走出该循环
        char choice = Utility.readConfirmSelection();
        if (choice == 'Y') {
            //确定删除
            //HouseService.del(delId);
            if (houseService.del(delId)){
                System.out.println("==========Delete Successfully==========");
            }else {
                System.out.println("==========Wrong ID, Delete Failed==========");
            }

        }else {
            //放弃删除
            System.out.println("==========Give Up To Delete==========");
        }
    }

    //改
    //updateHouse()
    //接收


    //查询
    //findHouse()
    //接收输入的需要查询的房屋信息id
    //调用HouseService.java中的find()方法
    public void findHouse() {

        System.out.println("==========FindHouse==========");

        System.out.print("请输入需要查找房屋的id：");
        int findId = Utility.readInt();

        House house = houseService.findById(findId);

        if (house != null) {
            System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(Rented/NotRented)");
            System.out.println(house);
        } else {
            System.out.println("Not Found");
        }
    }



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

    //退出确认
    //调用Utility
    public void exit() {
        char c = Utility.readConfirmSelection();
        if (c == 'Y') {
            loop = false;
        }
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
                    //System.out.println("新增");
                    addHouse();
                    break;
                case '2' :
                    //System.out.println("查找");
                    findHouse();
                    break;
                case '3' :
                    //System.out.println("删除");
                    delHouse();
                    break;
                case '4' :
                    System.out.println("修改");
                    break;
                case '5' :
                    //System.out.println("显示");
                    listHouse();
                    break;
                case '6' :
                    //System.out.println("退出");
                    //loop = false;
                    exit();
                    break;
            }
        } while (loop);
    }


}
