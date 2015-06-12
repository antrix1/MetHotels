/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.pages;


import com.mycompany.methotels.dao.SobaDAO;
import com.mycompany.methotels.entities.Soba;
import java.util.ArrayList;
import java.util.List;
import org.apache.tapestry5.ValueEncoder;
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
    private Soba iterator;
    
    @Property
    private List<Soba> sobe;
    
    @Inject
    private SobaDAO sobaDao;
    
    @Property
    private Soba soba;
    
    
    void onActivate(){
        if(sobe == null){
            sobe = new ArrayList<Soba>();
        }
        sobe = sobaDao.getListaSoba();
    }
    
    @CommitAfter
    Object onSuccess(){
        sobaDao.dodajSobu(soba);
        return this;
    }
    
    @CommitAfter
    Object onActionFromDelete(int id){
        sobaDao.obrisiSobu(id);
        return this;
    }
}
