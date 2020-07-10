/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exmple.service;

import com.example.session.AccountFacadeLocal;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Pham Viet Khanh
 */
@WebService(serviceName = "LoginWebService")
public class LoginWebService {

    @EJB
    private AccountFacadeLocal accountFacade;

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "login")
    public boolean login(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {

        return accountFacade.checkLogin(username, password);

//        try{
//           return accountFacade.checkLogin(username, password);
//        
//        }catch(Exception ex){
//            return false;
//        }
        
       }
}
