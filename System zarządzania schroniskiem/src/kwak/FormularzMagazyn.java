package kwak;

import java.util.EventObject;

public class FormularzMagazyn extends EventObject {
    
    int ID;
    int ID_Pracownika;
    String produkt;
    int ilosc;
    String waznosc;
    String gramatura;
    String pojemnik;
    String polozenie;
    
    
    public FormularzMagazyn(Object Source){
    super (Source);
    }
    
    public FormularzMagazyn(Object Source, int id){
    super (Source);
    this.ID = id;
    }
    

    public FormularzMagazyn(Object Source, int id, int idpracownik, String produkt, int ilosc, String waznosc, String gramatura, String pojemnik, String polozenie){
    super (Source);
    this.ID = id;
    this.ID_Pracownika = idpracownik;
    this.produkt = produkt;
    this.ilosc = ilosc;
    this.waznosc = waznosc;
    this.gramatura = gramatura;
    this.pojemnik = pojemnik;
    this.polozenie = polozenie;
    }
    
    public FormularzMagazyn(Object Source,int id, String produkt, int ilosc, String waznosc, String pojemnik, String polozenie){
    super (Source);
    this.ID = id;
    this.produkt = produkt;
    this.ilosc = ilosc;
    this.waznosc = waznosc;
    this.pojemnik = pojemnik;
    this.polozenie = polozenie;
    }

    public int getID_Pracownika() {
        return ID_Pracownika;
    }

    public String getPolozenie() {
        return polozenie;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID_Klient() {
        return ID_Pracownika;
    }

    public void setID_Klient(int ID_Pracownik) {
        this.ID_Pracownika = ID_Pracownik;
    }

    public String getProdukt() {
        return produkt;
    }

    public void setProdukt(String produkt) {
        this.produkt = produkt;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }

    public String getWaznosc() {
        return waznosc;
    }

    public void setWaznosc(String waznosc) {
        this.waznosc = waznosc;
    }

    public String getGramatura() {
        return gramatura;
    }

    public void setGramatura(String gramatura) {
        this.gramatura = gramatura;
    }

    public String getPojemnik() {
        return pojemnik;
    }

    public void setPojemnik(String pojemnik) {
        this.pojemnik = pojemnik;
    }
    
    
}
