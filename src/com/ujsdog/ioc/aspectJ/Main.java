package com.ujsdog.ioc.aspectJ;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @createTime 2019-11-06 10:20
 */
public class Main {

    public static void main(String[] args) {
        String xmlPath = "com/ujsdog/ioc/aspectJ/applicationContext.xml";
        ApplicationContext ac= new ClassPathXmlApplicationContext(xmlPath);
        UserDao ud = (UserDao) ac.getBean("userDao");
        ud.addUser();
    }
}
