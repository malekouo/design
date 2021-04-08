package com.example.malekouo.designpattern.prototype;

import java.util.Hashtable;

/**
 * 原型模式：
 * 创建重复的对象时使用，本质是使用克隆接口创建对象。
 * 适用场景： 对象就那么几种时，减少了读取数据库的次数
 */
public class PrototypeDemo {
    public static void main(String[] args) {

        ShapeCache.loadCache();

        Shape rectangle1 = ShapeCache.getShape("1");
        Shape rectangle2 = ShapeCache.getShape("1");

        System.out.println(rectangle1 == rectangle2);
        rectangle1.draw();
        rectangle2.draw();


        Shape square1 = ShapeCache.getShape("2");
        Shape square2 = ShapeCache.getShape("2");
    }

}


/***
 * 父类实现Cloneable
 *  Cloneable接口是一个标记接口，只有实现Cloneable接口的类才可以克隆成功，否则调用clone会抛出CloneNotSupportedException（克隆不被支持）
 *
 * 注意：clone 出来的对象是一个新的对象，有一个新的引用和内存空间，只是属性值是一样的
 */
abstract class Shape implements Cloneable {

    private String id;
    private String type;

    abstract void draw();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clone;
    }
}

class Rectangle extends Shape {

    public Rectangle() {
        super.setType("Rectangle");
    }

    @Override
    void draw() {
        System.out.println("this is a Rectangle");
    }
}


class Square extends Shape {

    public Square() {
        setType("square");
    }

    @Override
    void draw() {
        System.out.println("this is a square");
    }
}

class ShapeCache {

    private static Hashtable<String, Shape> shapeMap = new Hashtable<>();

    /**
     * 加载原型对象
     */
    public static void loadCache() {
        //这里模拟数据库中取数据
        Rectangle rectangle = new Rectangle();
        shapeMap.put("1", rectangle);

        Square square = new Square();
        shapeMap.put("2", square);
    }

    public static Shape getShape(String shapId) {
        //这样加载就避免一直读数据库
        Shape shape = shapeMap.get(shapId);
        return (Shape) shape.clone();
    }

}



