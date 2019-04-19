package android.fit.ba.myapp.data;

import java.io.Serializable;

/**
 * Created by Adil on 18/06/2016.
 */
public class KorisnikVM implements Serializable{
    private int id;
    private String ime;
    private String prezime;
    private String username;
    private String password;
    private String email;


    public KorisnikVM(int id, String ime, String prezime, String username, String password, String email) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }



    public String getImePrezime() {
        return ime + " " + prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
