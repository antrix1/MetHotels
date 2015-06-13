/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.pages;

import com.mycompany.methotels.dao.RezervacijaDAO;
import com.mycompany.methotels.dao.SobaDAO;
import com.mycompany.methotels.entities.Rezervacija;
import com.mycompany.methotels.entities.Soba;
import com.mycompany.methotels.services.ProtectedPage;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Andrej
 */
@ProtectedPage
@RolesAllowed(value="Korisnik")
public class DodajRezervaciju {

    @Inject
    private SobaDAO sobaDao;
    
    @Inject
    private RezervacijaDAO rezervacijaDAO;
    
    @Property
    private Soba soba;

    @Property
    private Rezervacija rezervacija;

    @Property
    private List<Rezervacija> rezervacije;
    
    @Property
    private List<Soba> sobe;
    
    @Property
    private Rezervacija iterator;
    
    
    void onActivate(){
        if(rezervacije == null){
            rezervacije = new ArrayList<Rezervacija>();
        }
        rezervacije = rezervacijaDAO.getListaRezervacija();
        sobe = sobaDao.getListaSoba();
    
    }
     
    @CommitAfter
    Object onSuccess(){
        rezervacija.setSobaid(soba);
        rezervacijaDAO.dodajRezervaciju(rezervacija);
        return this;
    }
    
    
    public ValueEncoder getEncoder() {
        return new ValueEncoder<Soba>() {
            @Override
            public String toClient(Soba s) {
                return String.valueOf(s.getSobaid());
            }

            @Override
            public Soba toValue(String string) {
                Soba soba = sobaDao.getSobaById(Integer.parseInt(string));
                return soba;
            }
        };
    }
    
   @CommitAfter
    Object onActionFromDelete(int id){
        rezervacijaDAO.obrisiRezervaciju(id);
        return this;
    }
}
