package com.ujsdog.jdbc;

/**
 * @author 茅伟龙
 * @createTime 2019-11-06 17:53
 */
public class Account {

    private Integer id;
    private String user_name;
    private Double balance;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + user_name + '\'' +
                ", balance=" + balance +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String username) {
        this.user_name = username;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
