/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.model;

import java.io.Serializable;

/**
 *
 * @author Bogdan-Andrei
 */
public class Cerere implements Serializable
{
    public int angajat_id;
    public int concediu_id;
    public String nume;
    public String prenume;
    public String start;
    public String end;
    
    public Cerere()
    {
        
    }
}
