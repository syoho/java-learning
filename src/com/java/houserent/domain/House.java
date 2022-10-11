package com.java.houserent.domain;

//Model
//House对象表示一个房屋信息



public class House {
    //编号 房主 电话 地址 月租 状态（已出租/未出租）
    private int id;
    private String name;
    private String phone;
    private String address;
    private int rent;
    private String state;

    //构造器，setter，getter方法
    //按alt+insert（ MAC 里使用组合键：Command+n）

    public House(int id, String name, String phone, String address, int rent, String state) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.rent = rent;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    //方便输出对象信息
    //实现toString方法
    //按alt+insert（ MAC 里使用组合键：Command+n）
    //编号 房主 电话 地址 月租 状态（已出租/未出租）

    @Override
    public String toString() {
/*        return "House{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", rent=" + rent +
                ", state='" + state + '\'' +
                '}';*/

        return id +
                "\t\t" + name +
                "\t" + phone +
                "\t" + address +
                "\t" + rent +
                "\t" + state;
    }
}
