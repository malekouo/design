package com.example.malekouo.designpattern.proxy;

/**
 * 静态代理：
 * 1.角色分为： 抽象方法，真实角色，代理角色，客户
 * 2。现实场景举例： 打工人租房子这个事情
 * 角色方法：房屋出租
 * 真实角色：房东（因为房东 拥有出租房子的能力）
 * 代理角色：中介（代替房东租房子）
 * 客户：找房子的打工人
 * 3.优点： 真实角色，也就是房东只需要专注了放房子租出去这个事情，其他约时间看房，签合同这些额外的逻辑 都交给中介
 * 4.缺点： 一个真实的角色就会产生一个代理，会导致很多代理类
 * 5.代码应用：日志。add ,UserServiceImpl, UserServiceProxy , log（ add这些增删改查就是抽象方法，log就是代理加的额外的逻辑处理）
 */
public class StaticPorxy {


    public static void main(String[] args) {
        Mediu mediu = new Mediu(new Landlord());
        mediu.Rent();
    }
}

/**
 * 房东
 */
class Landlord implements House {


    @Override
    public void Rent() {
        System.out.println("房东出租房子");
    }
}

/**
 * 中介(也有房租出租的能力，代理房东)
 * 这个就是 房东的静态代理
 */
class Mediu implements House {

    private Landlord landlord;

    public Mediu(Landlord landlord) {
        this.landlord = landlord;
    }

    @Override
    public void Rent() {
        System.out.println("中介看房");
        landlord.Rent();
        System.out.println("中介签合同交钱");
    }

}

