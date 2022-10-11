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
                    //System.out.println("新增");
                    addHouse();
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
