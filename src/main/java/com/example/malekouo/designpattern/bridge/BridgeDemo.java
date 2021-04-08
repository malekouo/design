package com.example.malekouo.designpattern.bridge;

import sun.plugin.com.event.COMEventHandler;

/**
 * 桥接模式：
 * 把原本复杂的多继承结构，按照维度独立出来，通过组合的方式，桥接到一起
 * 场景：
 * 电脑
 * 台式机                 笔记本
 * 联想台式  苹果台式       联想笔记本 台式笔记本
 * <p>
 * 上面这种多继承结构，如果要新加一种 类型（eg: 平板，至少需要加三个类： 平板父类， 联想平板，台式平板）
 * 其实我们发现上面的东西就 2个维度：（1）品牌（联想，苹果）(2)电脑类型（台式机  笔记本 平板）。
 * 我们把2个维度抽出来，通过组合的的方式桥接到一起，提高代码的拓展性，减少代码量
 */
public class BridgeDemo {
    public static void main(String[] args) {
        //联想台式
        Computer computer1 = new TaishiComputer(new Lenovo());
        computer1.info();
        System.out.println("");
        //联想笔记本
        Computer computer2 = new BookComputer(new Lenovo());
        computer2.info();
        System.out.println("");

        //苹果台式机
        Computer computer3 = new TaishiComputer(new Apple());
        computer3.info();
        System.out.println("");

        //苹果笔记本
        Computer computer4 = new BookComputer(new Apple());
        computer4.info();
        System.out.println("");

    }
}

//==============抽象品牌维度============
//联想品牌
class Lenovo implements  Brand{

    @Override
    public void info() {
        System.out.print("联想");
    }
}
//苹果
class Apple implements  Brand{

    @Override
    public void info() {
        System.out.print("苹果");
    }
}

//==============抽象电脑维度============
abstract class Computer {
    protected Brand brand;
    abstract void info();
}

//台式机
class TaishiComputer extends  Computer{

    public TaishiComputer(Brand brand){
        super.brand = brand;
    }

    @Override
    void info() {
        super.brand.info();
        System.out.print("台式机");
    }
}

//笔记本
class BookComputer extends  Computer{

    public BookComputer(Brand brand){
        super.brand = brand;
    }

    @Override
    void info() {
        super.brand.info();
        System.out.print("笔记本");
    }
}



