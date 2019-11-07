package com.ujsdog.ioc.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 茅伟龙
 * @createTime 2019-11-05 15:59
 */
public class TestIoC {
    public static void main(String[] args) {
        // 👇相对于 src的地址
        // 这里正好放在src所以比较方便
        String xmlPath = "com/ujsdog/ioc/ioc/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(xmlPath);

        UserDao ud = (UserDao) ac.getBean("userDao");
        ud.say();
        UserDao ud2 = (UserDao) ac.getBean("userDao_s");
        ud2.say();

        UserDao ud3 = (UserDao) ac.getBean("userDao_f");
        UserDao ud4 = (UserDao) ac.getBean("userDao_f");
        //当前为 singleton 两者一样
        System.out.println(ud4);
        System.out.println(ud3);


        UserService us1 = (UserService) ac.getBean("userService_p");
        us1.say();
        UserService us2 = (UserService) ac.getBean("userService_c");
        us2.say();




    }
}
