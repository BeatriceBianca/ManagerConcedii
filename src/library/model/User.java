package library.model;

import java.io.Serializable;

public class User implements Serializable {

    public String username;
    public String password;
    public String nume;
    public String prenume;
    public int zile_concediu_ramase;
    public int id;
    public int tip; //1-manager, 2-angajat
}
