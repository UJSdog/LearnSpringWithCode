package com.ujsdog.ioc.autoWireTest;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author 茅伟龙
 * @createTime 2019-11-05 19:44
 */
@Component("third")
public class Third {
    @Resource(name="second")
    Second second;

    void call(){
        second.call();
        System.out.println("third: call!!!!!!!");
    }
}
