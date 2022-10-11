package com.java.houserent.service;

//HouseService.java<=>业务层
//定义House[],保存House对象
//1-响应HouseView.java的调用
//2-完成房屋信息的各类操作CRUD

//list()方法-返回所有的房屋信息
//将House对象放入House[]数组
//针对House[]数组做CRUD

//思想：各司其职

import com.java.houserent.domain.House;

public class HouseService {

    //创建House数组，存放House对象；
    //关联<=>domain包中House.java
    //声明，默认为空
    private House[] houses;

    //添加变量》记录当前数组长度
    private int houseNums = 1;

    //需要设置House对象的id属性自增长
    //记录当前的id自增长到哪个值
    private int idCounter = 1;

    //构造器
    //size前勿忘int
    public HouseService(int size){

        //new houses
        //当创建一个HouseService对象时，指定数组大小
        houses = new House[size];

        //为了测试数组信息，初始化一个House对象
        houses[0] = new House(1,"Xiao","12345","Haidian",2000,"NotRented");
    }


    //添加新的House对象
    //方法居然写在HouseService()内部
    //add()方法
    //返回boolean值
    //接收一个从HouseView.java传入的新的House对象
    //newHouse<=>形参
    //需要考虑》数组长度，如果数组已满，则报错无法添加》添加变量记录当前数组长度
    //需要考虑》House对象的id自增
    public boolean add(House newHouse) {

        //判断是否还可以继续添加对象（暂时不考虑【数组扩容】）
        if(houseNums == houses.length) { //数组已满，无法添加
            System.out.println("数组已满，无法添加");
            return false;
        }else{

            //向数组添加新的House对象
            //在数组已有对象后加入新对象newHouse
            //houseNums正好是newHouse的数组存入位置（角标）
            //houses[houseNums] = newHouse;
            //houseNums++;
            houses[houseNums++] = newHouse;

            //需要设置House对象的id属性自增长
            //更新newHouse的id
            //存入数组后，再更新也可行
            //idCounter++;
            //newHouse.setId(idCounter);
            newHouse.setId(++idCounter);

            return true;
        }
    }


    //显示
    //list()方法
    //返回houses数组（由House对象组成）
    public House[] list(){
        return houses;
    }

}
