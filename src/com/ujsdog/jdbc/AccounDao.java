package com.ujsdog.jdbc;

import java.util.List;

/**
 * @author 茅伟龙
 * @createTime 2019-11-06 17:55
 */
public interface AccounDao {
    int addAccount(Account account);
    int updateAccount(Account account);
    int deleteAccount(int id);
    Account findAccountByID(int id);
    List<Account> findAllAccount();
public void transfer (String outUser,String inUser,Double money);
}
