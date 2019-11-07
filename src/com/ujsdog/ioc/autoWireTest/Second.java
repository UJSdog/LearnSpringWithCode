package com.ujsdog.ioc.autoWireTest;

import org.springframework.stereotype.Component;
import javax.annotation.Resource;

/**
 * @author 茅伟龙
 * @createTime 2019-11-05 19:42
 */
@Component("second")
public class Second {
    @Resource(name="first")
    First first;
    void call(){
        first.call();
        System.out.println("second: CALL!!!");
    }
}
