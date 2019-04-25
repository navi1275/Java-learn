package com.navi.observer;

/**
 * Test Class
 *
 * @author navi
 * @date 2019-04-18
 * @since 1.0.0
 */
public class Test {

    public static void main(String[] args) {
        WeChatServer server = new WeChatServer();

        UserObserver zhangsan = new UserObserver("张三");
        UserObserver lisi = new UserObserver("李四");
        UserObserver wangwu = new UserObserver("王五");
        UserObserver sunliu = new UserObserver("孙六");

        server.registerObserver(zhangsan);
        server.registerObserver(lisi);
        server.registerObserver(wangwu);
        server.registerObserver(sunliu);
        server.registerObserver(sunliu);

        server.createMsg("XX明星出轨了");

        server.removeObserver(sunliu);

        server.createMsg("每天坚持吃XX保健品，长命百岁");

    }
}
