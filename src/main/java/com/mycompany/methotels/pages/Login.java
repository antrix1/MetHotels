package com.mycompany.methotels.pages;

import com.mycompany.methotels.dao.UserDAO;
import com.mycompany.methotels.entities.User;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.corelib.components.BeanEditForm;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;

public class Login
{
    @Inject
    private UserDAO userDAO;
    
    @SessionState
    private User loggedInUser;

    @Property
    private User userLogin;

    @Component
    private BeanEditForm form;
	
    Object onActivate(){
        if(loggedInUser.getEmail() != null){
            return Index.class;
        }
        return null;
    }
    
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
        String password = getMD5Hash(userLogin.getSifra());
        User u = userDAO.checkUser(userLogin.getEmail(), password);
        
        if(u != null){
            loggedInUser = u;
            System.out.println("Logged in");
            return Index.class;
        }else{
            form.recordError("Incorrect credentials");
            return null;
        }
    }
    
  
}
