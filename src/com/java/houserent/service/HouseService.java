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

    //构造器
    //size前勿忘int
    public HouseService(int size){

        //new houses
        //当创建一个HouseService对象时，指定数组大小
        houses = new House[size];

        //为了测试数组信息，初始化一个House对象
        houses[0] = new House(1,"Xiao","12345","Haidian",2000,"NotRented");
    }

    //list()方法
    //返回houses数组（由House对象组成）
    public House[] list(){
        return houses;
    }

}
