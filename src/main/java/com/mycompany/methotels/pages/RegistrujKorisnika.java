/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.pages;

import com.mycompany.methotels.dao.UserDAO;
import com.mycompany.methotels.data.Role;
import com.mycompany.methotels.entities.User;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.corelib.components.BeanEditForm;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Andrej
 */
public class RegistrujKorisnika {
    @Property
    private User userReg;
    
    @SessionState
    private User loggedInUser;
    
    @Inject
    private UserDAO userDAO;
    
    @Component
    private BeanEditForm form;
    
    public String getMD5Hash(String yourString) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(yourString.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (Exception e) {
            return "";
        }
    }
    
    @CommitAfter
    Object onSuccess(){
        if(!userDAO.checkIfEmailExists(userReg.getEmail())){
            String unhashPassword = userReg.getSifra();
            userReg.setSifra(getMD5Hash(unhashPassword));
            userReg.setRola(Role.Korisnik);
            User u = userDAO.registerUser(userReg);
            loggedInUser = u;
            return Index.class;
        }else{
            form.recordError("Email vec postoji.");
            return null;
        }
    }
}
