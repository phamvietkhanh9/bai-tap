/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.session;

import com.example.entity.Account;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Pham Viet Khanh
 */
@Stateless
public class AccountFacade extends AbstractFacade<Account> implements AccountFacadeLocal {

    @PersistenceContext(unitName = "EJB1-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccountFacade() {
        super(Account.class);
    }

    @Override
    public boolean checkLogin(String username, String password) {
        Query query = em.createNamedQuery("Account.checkLogin");
        query.setParameter("username", username);
        query.setParameter("password", password);
        
        try{
            query.getSingleResult();
            return true;
        }catch(Exception ex){
            return false;
        }
    }
    
}
