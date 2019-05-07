package com.chen.factory;

/**
 * @author CXX
 * @date 2019/5/7 15:24
 */
public class Client {

    private Client() {};

    public static void main(String[] args) {
        Client a = SingletonObjectFactory.getSingleton(Client.class);
        Client b = SingletonObjectFactory.getSingleton(Client.class);
        System.out.println(a);
        System.out.println(b);
    }
}
