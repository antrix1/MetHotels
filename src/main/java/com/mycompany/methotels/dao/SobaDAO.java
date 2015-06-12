/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.dao;

import com.mycompany.methotels.entities.Soba;
import java.util.List;

/**
 *
 * @author Andrej
 */
public interface SobaDAO {
    public List<Soba> getListaSoba();
    public Soba getSobaById(Integer id);
    public void dodajSobu(Soba soba);
    public void obrisiSobu(Integer id);
}
