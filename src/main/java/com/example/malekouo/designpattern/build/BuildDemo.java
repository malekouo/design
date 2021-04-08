package com.example.malekouo.designpattern.build;

import lombok.Data;


public class BuildDemo {
    public static void main(String[] args) {

        ComputerDirector computerDirector = new ComputerDirector();
        //构建苹果电脑
        MacComputerBuilder macComputerBuilder = new MacComputerBuilder("苹果m1", "i7cpu");
        computerDirector.makeComputer(macComputerBuilder);
        macComputerBuilder.setPrice();
        macComputerBuilder.setSize();
        Computer macComputer = macComputerBuilder.getComputer();

        //构建联想电脑
        LenovoComputerBuilder lenovoComputerBuilder = new LenovoComputerBuilder("联想小新V3000","i5cpu");
        lenovoComputerBuilder.setPrice();
        lenovoComputerBuilder.setSize();
        Computer lenovoComputer = lenovoComputerBuilder.getComputer();

        System.out.println(macComputer.toString());
        System.out.println(lenovoComputer.toString());

    }
}

/**
 * （1）目标类
 */
@Data
class Computer{
    /**
     * 电脑名称（必填）
     */
    private String name;
    /**
     * cpu(选必填填)
     */
    private String cpu;

    /**
     * 价格（可选）
     */
    private Double price;

    /**
     * 尺寸（可选 ）
     */
    private Double size;

    //对于必选的提供构造函数
    public Computer(String name ,String cpu){
        this.name = name;
        this.cpu = cpu;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "name='" + name + '\'' +
                ", cpu='" + cpu + '\'' +
                ", price=" + price +
                ", size='" + size + '\'' +
                '}';
    }
}

/**
 * (2)抽象构造者
 */
abstract class ComputerBuilder{
    //对可选的属性进行搭配
    public abstract void  setPrice();
    public abstract void  setSize();

    //保留创建目标类的接口
    public abstract  Computer getComputer();
}

/**
 * (3)创建构建者实现类（eg:下面就专门构建mac电脑）
 * 这里以联想电脑和苹果电脑为例，有其他的实现还可以加
 */
class MacComputerBuilder extends ComputerBuilder {

    private Computer computer;

    //构造函数嵌套
    public MacComputerBuilder(String name, String cpu) {
        computer = new Computer(name, cpu);
    }

    @Override
    public void setPrice() {
        computer.setPrice(10000D);
    }

    @Override
    public void setSize() {
        computer.setSize(13D);
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
/**
 * (3)创建构建者实现类（eg:下面就专门构建联想电脑）
 *
 */
class LenovoComputerBuilder extends ComputerBuilder {

    private Computer computer;

    //构造函数嵌套
    public LenovoComputerBuilder(String name, String cpu) {
        computer = new Computer(name, cpu);
    }

    @Override
    public void setPrice() {
        computer.setPrice(7000D);
    }

    @Override
    public void setSize() {
        computer.setSize(15D);
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
/**
 * 构建指导者
 */
class  ComputerDirector{
    void makeComputer(ComputerBuilder computerBuilder){
        computerBuilder.setPrice();
        computerBuilder.setSize();
    }
}