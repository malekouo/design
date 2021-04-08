package com.example.malekouo.designpattern.factory;

import java.util.Objects;

/**
 * 简单工厂模式-demo
 * 三角色： 工厂，抽象实例，实现类
 *
 */
public class SimpleFactoryDemo {
    public static void main(String[] args) throws Exception {
        AbstractProduct a = Factory.getProduct("A");
        a.say();
        AbstractProduct b = Factory.getProduct("A");
        b.say();
        AbstractProduct c = Factory.getProduct("C");
        c.say();
    }
}

/**
 * 工厂类
 */
class Factory {

    public static AbstractProduct getProduct(String name) throws Exception {
        if(Objects.equals(name,"A")){
            return new ProductA();
        }else if(Objects.equals(name,"B")){
            return new ProductB();
        }else {
            throw new Exception(String.format("创建bean失败，不存在%s的实例",name));
        }
    }
}

/**
 * 实例抽象类
 */
abstract class  AbstractProduct{

    public abstract void say();

}

/**
 * 实现类
 */
class ProductA extends AbstractProduct{


    @Override
    public void say() {
        System.out.println("我是A");
    }
}

class ProductB extends AbstractProduct{
    @Override
    public void say() {
        System.out.println("我是B");
    }
}