/*
package android.fit.ba.myapp.data;

import java.util.ArrayList;
import java.util.List;


public class Storage {
    private static List<KategorijaPregledVM> kategorije;
    private static int brojacVijesti;

    public static List<KategorijaPregledVM> getKategorije() {
        if (kategorije == null) {
            kategorije = new ArrayList<>();
            kategorije.add(new KategorijaPregledVM(1, "Politika"));
            kategorije.add(new KategorijaPregledVM(2, "Sport"));
            kategorije.add(new KategorijaPregledVM(3, "Kultura"));
            kategorije.add(new KategorijaPregledVM(4, "Zabava"));
            kategorije.add(new KategorijaPregledVM(5, "Hronika"));
            kategorije.add(new KategorijaPregledVM(6, "Zdravlje"));
            kategorije.add(new KategorijaPregledVM(7, "Zanimljivosti"));
        }
        return kategorije;
    }

*/
/*    private static List<KorisnikVM> korisnici;
    public static List<KorisnikVM> getKorisnici()
    {
        if (korisnici == null)
        {
            korisnici = new ArrayList<>();
            korisnici.add(new KorisnikVM(1, "Selma","Soljic","selma","selma","selma@edu.fit.ba"));
            korisnici.add(new KorisnikVM(2, "Adil","Joldic","adil","adil","adil@edu.fit.ba"));
            korisnici.add(new KorisnikVM(3, "Larisa","Dedović","lara","lara","larisa@edu.fit.ba"));
            korisnici.add(new KorisnikVM(4,"Elmin", "Sudic","elmin","elmin","elmin@edu.fit.ba"));
            korisnici.add(new KorisnikVM(5,"Maria", "Herceg","maria","maria","maria@edu.fit.ba"));
        }
        return korisnici;
    }*//*

*/
/*
    private static List<VijestVM> vijesti;
    public static List<VijestVM> getVijesti()
    {
 if (vijesti == null)
        {
            vijesti = new ArrayList<>();
            vijesti.add(new VijestVM("Prehrambene navike",getKategorije().get(6),"Mnogi ljudi smatraju da je teško promijeniti prehrambene navike jer je riječ o velikoj životnoj promjeni. S druge strane, stručnjaci ističu da nije tako teško i da je dovoljno da počnete jednom malom promjenom dnevno, kao što je preskakanje deserta.",new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
            vijesti.add(new VijestVM("Davis cup",getKategorije().get(2),"U teniskom centru \"Memorial Drive\" u Adelaideu obavljen je žrijeb susreta teniskih selekcija Australije i BiH koji se igra u okviru kvalifikacija za finale Svjetske grupe Davis Cup by BNP Pariba",new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
            vijesti.add(new VijestVM("Tajna dugovječnosti",getKategorije().get(6),"Blaga fizička aktivnost može produžiti životni vijek žena",new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
            vijesti.add(new VijestVM("Rezultati istraživanja",getKategorije().get(6),"Vrijeme provedeno pred ekranima direktno utječe na razvoj djece u kasnijem periodu.",new SimpleDateFormat("yyyy-MM-dd").format(new Date())));

        }

        return vijesti;
    }*//*



*/
/*
    public static List<VijestVM> getVrijestiByKategorija(String query) {

        List<VijestVM> rezultat = new ArrayList<>();

        for (VijestVM x: getVijesti())
        {
            if ((x.kategorija.getNaziv()).startsWith(query))
                rezultat.add(x);
        }

        return rezultat;
    }
*//*
*/
/*


    public static KorisnikVM LoginCheck(String username, String password)
    {
        for(KorisnikVM x:getKorisnici())
        {
            if(Objects.equals(x.getUsername(),username) && Objects.equals(x.getPassword(), password))
                return  x;
        }
        return null;
    }


    public static void addVijest(VijestVM vijestVM) {
        vijestVM.brojVijesti = brojacVijesti++;
        getVijesti().add(vijestVM);
    }
    public static void removeVijest(VijestVM vijestVM) {
        getVijesti().remove(vijestVM);
    }

*//*

}
*/
