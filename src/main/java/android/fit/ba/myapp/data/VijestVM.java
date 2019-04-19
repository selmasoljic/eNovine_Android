package android.fit.ba.myapp.data;

import java.io.Serializable;
import java.util.Date;


public class VijestVM implements Serializable {
    public int id;
    public String naslovVijesti;
    public int kategorijaId;
    public String sadrzajVijesti;
    public String datum;
    public int brojVijesti;
    public int korisnikId;


    public VijestVM()
    {}

    public VijestVM(String naslovVijesti, int kategorija, String sadrzajVijesti) {
        this.naslovVijesti = naslovVijesti;
        this.kategorijaId = kategorija;
        this.sadrzajVijesti = sadrzajVijesti;

    }
    public VijestVM(String naslovVijesti, int kategorija, String sadrzajVijesti, int brojVijesti) {
        this.naslovVijesti = naslovVijesti;
        this.kategorijaId = kategorija;
        this.sadrzajVijesti = sadrzajVijesti;
        this.datum = datum;
        this.brojVijesti = brojVijesti;
    }

  /*  public VijestVM(String naslovVijesti, String sadrzajVijesti, String kategorija) {
        this.naslovVijesti = naslovVijesti;
        this.sadrzajVijesti = sadrzajVijesti;
        this.kategorija = kategorija;
        *//*this.kategorija = Storage.getKategorije().get(0);*//*
    }*/

    public String getNaslovVijesti() {
        return naslovVijesti;
    }

    public String getSadrzajVijesti() { return sadrzajVijesti; }

/*
    public  VijestVM(String prehrambene_navike, KategorijaPregledVM kategorijaVM, String sadrzajVijesti, String format)
    {}*/



}
