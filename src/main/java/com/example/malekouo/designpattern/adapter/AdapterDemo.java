package com.example.malekouo.designpattern.adapter;

/**
 * 结构型：
 *      适配器模式：
    （1）模型：USB转接口
 *
 * （2）作用： 使一个类可以去兼容另一个类的类型，从而使用他的接口
 *
 * （3）适用场景:
 *
 * 		系统里面新的类需要使用一些接口，这些接口有一部分已经存在于其他的旧的类中。为了重复使用编码，我们可以使用适配器模式来关联到那个要用到的接口。
 * 	(4)现实举例：
 *     （4.1）	Phone 手机又打电话的功能；新开发的App目前有听音乐，看电影的功能；
 * 	   （4.2）要给APP也加上打电话的功能
 *
 */
public class AdapterDemo {

    public static void main(String[] args) {
        App app = new AdaptePhone(new Phone());
        app.function();
    }

}


/**
 * 电话类，可以打电话
 */
class Phone{
    void call(){
        System.out.println("打电话....");
    }
}

/**
 * APP产品，我可以听音乐，看电影
 */
class App{
    void function(){
        System.out.println("听音乐...");
        System.out.println("看电影...");
    };
}

/**
 * app适配器。加上之后可以有打电话功能。
 * 三步曲：
 *  （1）继承或者实现APP，方便后面的 App app = new AdaptePhone 的指向
 *  （2）以组合的方式引入phone
 *  （3）重写父类的方法，把打电话的功能加上去
 */
class AdaptePhone extends App{
    //使用组合的方式，把Phone引入
    private Phone phone;
    AdaptePhone(Phone phone){
        this.phone = phone;
    }

    @Override
    void function() {
        System.out.println("听音乐...");
        phone.call();
        System.out.println("看电影...");
    }
}



