package com.ujsdog.ioc.ProxyAOP;

import com.ujsdog.ioc.AOP.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 茅伟龙
 * @createTime 2019-11-06 10:50
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("ProxyAOP");
        String xmlPath = "com/ujsdog/ioc/ProxyAOP/applicationContext.xml";
        //获取上下文
        ApplicationContext ac = new ClassPathXmlApplicationContext(xmlPath);
        //获取代理实例
        UserDao ud = (UserDao) ac.getBean("userDaoProxy");
        ud.addUser();
        ud.deleteUser();

    }
}
