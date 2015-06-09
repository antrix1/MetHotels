/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.pages;


import com.mycompany.methotels.entities.Soba;
import java.util.ArrayList;
import java.util.List;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;


/**
 *
 * @author Andrej
 */
public class DodajSobu {

    @Property
    private List<Soba> sobe;
    @Property
    private Soba soba;
    @Inject
    private Session session;
    
    void onActivate(){
        if(sobe == null){
            sobe = new ArrayList<Soba>();
            sobe.add(soba);
        }
        sobe = session.createCriteria(Soba.class).list();
    }
    
    @CommitAfter
    Object onSuccess(){
        session.merge(soba);
        return this;
    }
}
