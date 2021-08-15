
package kwak;

import java.util.EventObject;


public class FormularzOperacja extends EventObject {
  int ID = 0;
  int ID_Zwierzak;
  int ID_Klient;
  int ID_Pracownik;
  String Rodzaj_Operacja;
  String Dodanie;
  String Zakonczenie;
  
  public FormularzOperacja (Object source){
  super (source);
  }
  
  public FormularzOperacja (Object source, int id){
  super (source);
  this.ID = id;
  }
  
  public FormularzOperacja (Object source, int id, int id_z, int id_k, int id_p, String rodzaj, String dodanie, String Zakonczenie){
  super (source);
  this.ID = id;
  this.ID_Zwierzak = id_z;
  this.ID_Klient = id_k;
  this.ID_Pracownik = id_p;
  this.Rodzaj_Operacja = rodzaj;
  this.Dodanie = dodanie;
  this.Zakonczenie = Zakonczenie;
  }

    public String getZakonczenie() {
        return Zakonczenie;
    }

    public void setZakonczenie(String Zakonczenie) {
        this.Zakonczenie = Zakonczenie;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID_Zwierzak() {
        return ID_Zwierzak;
    }

    public void setID_Zwierzak(int ID_Zwierzak) {
        this.ID_Zwierzak = ID_Zwierzak;
    }

    public int getID_Klient() {
        return ID_Klient;
    }

    public void setID_Klient(int ID_Klient) {
        this.ID_Klient = ID_Klient;
    }

    public int getID_Pracownik() {
        return ID_Pracownik;
    }

    public void setID_Pracownik(int ID_Pracownik) {
        this.ID_Pracownik = ID_Pracownik;
    }

    public String getRodzaj_Operacja() {
        return Rodzaj_Operacja;
    }

    public void setRodzaj_Operacja(String Rodzaj_Operacja) {
        this.Rodzaj_Operacja = Rodzaj_Operacja;
    }

    public String getDodanie() {
        return Dodanie;
    }

    public void setDodanie(String Dodanie) {
        this.Dodanie = Dodanie;
    }
  
  
  
}
