/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.session;

import com.example.entity.Account;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Pham Viet Khanh
 */
@Local
public interface AccountFacadeLocal {

    void create(Account account);

    void edit(Account account);

    void remove(Account account);

    Account find(Object id);

    List<Account> findAll();

    List<Account> findRange(int[] range);

    int count();
    
    boolean checkLogin(String username , String password);
    
}
