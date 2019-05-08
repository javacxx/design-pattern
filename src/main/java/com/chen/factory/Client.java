package com.chen.factory;

/**
 * @author CXX
 * @date 2019/5/7 15:24
 */
public class Client {

    private Client() {};

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(
                        SingletonObjectFactory.getSingleton(Client.class)
                );
            }).start();
        }
    }
}
