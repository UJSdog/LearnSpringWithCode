package com.ujsdog.ioc.autoWireTest;

import org.springframework.stereotype.Component;

/**
 * @author 茅伟龙
 * @createTime 2019-11-05 19:40
 */
@Component("first")
public class First {
    void call(){
        System.out.println("first:  call!");
    }
}
