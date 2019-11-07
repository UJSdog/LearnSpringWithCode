package com.ujsdog.jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

/**
 * @author 茅伟龙
 * @createTime 2019-11-06 17:24
 */
public class JdbcTemplateTest {

    private ApplicationContext ac;

    private AccounDao ad;
    @Test
    public void createTable (){
        this.ac = new ClassPathXmlApplicationContext("com/ujsdog/jdbc/applicationContext.xml");
        JdbcTemplate jt = (JdbcTemplate) ac.getBean("jdbcTemplate");
        jt.execute("create table account(" +
                "id int primary key auto_increment," +
                "user_name varchar(50)," +
                "balance double )");
        System.out.println("创建成功!");
    }
    public void init (){
        this.ac = new ClassPathXmlApplicationContext("com/ujsdog/jdbc/applicationContext.xml");
        this.ad = (AccounDao) ac.getBean("accountDao");
    }
    @Test
    public void addAccountTest (){

        init();
        Account account = new Account();
        account.setUser_name("alibaba");
        account.setBalance(1000.00);
        int num = ad.addAccount(account);
        System.out.println(num);
    }
    @Test
    public void updateAccountTest (){
        init();
        Account account = new Account();
        account.setId(1);
        account.setUser_name("tomer");
        account.setBalance(1000.00);
        int num = ad.updateAccount(account);
        System.out.println(num);
    }
    @Test
    public void deleteAccountTest (){
        init();
        int num = ad.deleteAccount(2);
        System.out.println(num);
    }
    @Test
    public void findAccountByIdTest (){
        init();
        Account ac = ad.findAccountByID(3);
        System.out.println(ac);
    }
    @Test
    public void findAccountTest (){
        init();
        List<Account> ac = ad.findAllAccount();
        for (Account a:ac){
            System.out.println(a);
        }
    }
        @Test
        public void TransactionXmlTest (){
            init();
            ad.transfer("ali","alibaba",1.00);
            System.out.println("转账成功！");
        }
    @Test
    public void TransactionAnnotationXmlTest (){
        this.ac = new ClassPathXmlApplicationContext("com/ujsdog/jdbc/applicationContext-annotation.xml");
        this.ad = (AccounDao) ac.getBean("accountDao");
        ad.transfer("ali","alibaba",1.00);
        System.out.println("转账成功！");
    }
}
