package com.ujsdog.ioc.autoWireTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 茅伟龙
 * @createTime 2019-11-05 19:57
 */
public class Main {
    public static void main(String[] args) {
        String xmlPath = "com/ujsdog/ioc/autoWireTest/autoWire.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(xmlPath);
        Third td = (Third) ac.getBean("third");
        td.call();

    }
}
