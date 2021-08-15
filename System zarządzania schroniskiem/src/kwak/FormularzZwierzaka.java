package kwak;

import java.util.EventObject;

public class FormularzZwierzaka extends EventObject {
    int ID;
    int ID_Klient;
    String imie;
    String rasa;
    String gatunek;
    String plec;
    String Data_przybycia;
    String Data_zwolnienia;
    String opis;
public FormularzZwierzaka (Object Source){
    super (Source);
}

public FormularzZwierzaka (Object Source, int ID){
    super(Source);
    this.ID = ID;
}

public FormularzZwierzaka (Object Source, int ID, String imie){
    super(Source);
    this.ID = ID;
    this.imie = imie;
}

public FormularzZwierzaka (Object Source, int ID, int ID_Klient, String Imie, String rasa, String gatunek, String plec, String przybycie, String zwolnienie, String opis){
super(Source);
this.ID = ID;
this.ID_Klient = ID_Klient;
this.imie = Imie;
this.rasa = rasa;
this.gatunek = gatunek;
this.plec = plec;
this.Data_przybycia = przybycie;
this.Data_zwolnienia = zwolnienie;
this.opis = opis;
}

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID_Klient() {
        return ID_Klient;
    }

    public void setID_Klient(int ID_Klient) {
        this.ID_Klient = ID_Klient;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getRasa() {
        return rasa;
    }

    public void setRasa(String rasa) {
        this.rasa = rasa;
    }

    public String getGatunek() {
        return gatunek;
    }

    public void setGatunek(String gatunek) {
        this.gatunek = gatunek;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public String getData_przybycia() {
        return Data_przybycia;
    }

    public void setData_przybycia(String Data_przybycia) {
        this.Data_przybycia = Data_przybycia;
    }

    public String getData_zwolnienia() {
        return Data_zwolnienia;
    }

    public void setData_zwolnienia(String Data_zwolnienia) {
        this.Data_zwolnienia = Data_zwolnienia;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }


}
