package com.ujsdog.jdbc;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 茅伟龙
 * @createTime 2019-11-06 17:57
 */
public class AccounDaoImpl implements AccounDao{
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addAccount(Account account) {
        String sql = "insert into account(user_name,balance) value(?,?)";
        Object[] obj = new Object[]{
                account.getUser_name(),
                account.getBalance()
        };
        return this.jdbcTemplate.update(sql,obj);
    }

    @Override
    public int updateAccount(Account account) {
        String sql = "update account set user_name=?,balance=? where id = ?";
        Object[] obj = new Object[]{
                account.getUser_name(),
                account.getBalance(),
                account.getId()
        };
        return this.jdbcTemplate.update(sql,obj);
    }

    @Override
    public int deleteAccount(int id) {
        String sql = "delete from account where id = ?";
        return this.jdbcTemplate.update(sql,id);
    }

    @Override
    public Account findAccountByID(int id) {
        String sql = "select * from account where id = ?";
        RowMapper<Account> rowMapper =
                new BeanPropertyRowMapper<Account>(Account.class);

        return this.jdbcTemplate.queryForObject(sql,rowMapper,id);
    }

    @Override
    public List<Account> findAllAccount() {
        String sql = "select * from account";
        RowMapper<Account> rowMapper =
                new BeanPropertyRowMapper<Account>(Account.class);

        return this.jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    //// TODO: 2019/11/7 tolearn 
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly = false)
    public void transfer(String outUser, String inUser, Double money) {
        this.jdbcTemplate.update("update account set balance = balance+?" +
                "where user_name = ?",money,inUser);

        //int i = 1/0;
        this.jdbcTemplate.update("update account set balance = balance-?" +
                "where user_name = ?",money,outUser);



    }
}
