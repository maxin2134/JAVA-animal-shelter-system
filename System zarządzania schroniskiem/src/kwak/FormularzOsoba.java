package kwak;

import java.util.EventObject;

public class FormularzOsoba extends EventObject {
   int ID;
   String Imie;
   String Nazwisko;
   int Nr_domu;
   int Nr_lokalu;
   String miasto;
   int Kod_pocztowy;
   long PESEL;
    
    public FormularzOsoba (Object Source){
        super (Source);
    }
    
    public FormularzOsoba (Object Source, int ID){
    super(Source);
    this.ID = ID;
    }
    
    public FormularzOsoba (Object Source, long PESEL){
    super(Source);
    this.PESEL = PESEL;
    }
    
    public FormularzOsoba (Object Source,int ID, long PESEL){
    super(Source);
    this.ID = ID;
    this.PESEL = PESEL;
    }
    
    public FormularzOsoba (Object Source, int ID, String Imie, String Nazwisko, int Nr_domu, int Nr_lokalu, String miasto, int Kod_pocztowy, long PESEL){
        
       super(Source);
       this.ID = ID;
       this.Imie = Imie;
       this.Nazwisko = Nazwisko;
       this.Nr_domu = Nr_domu;
       this.Nr_lokalu = Nr_lokalu;
       this.miasto = miasto;
       this.Kod_pocztowy = Kod_pocztowy;
       this.PESEL = PESEL;
    }

    public long getPESEL() {
        return PESEL;
    }

    public void setPESEL(long PESEL) {
        this.PESEL = PESEL;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getImie() {
        return Imie;
    }

    public void setImie(String Imie) {
        this.Imie = Imie;
    }

    public String getNazwisko() {
        return Nazwisko;
    }

    public void setNazwisko(String Nazwisko) {
        this.Nazwisko = Nazwisko;
    }

    public int getNr_domu() {
        return Nr_domu;
    }

    public void setNr_domu(int Nr_domu) {
        this.Nr_domu = Nr_domu;
    }

    public int getNr_lokalu() {
        return Nr_lokalu;
    }

    public void setNr_lokalu(int Nr_lokalu) {
        this.Nr_lokalu = Nr_lokalu;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public int getKod_pocztowy() {
        return Kod_pocztowy;
    }

    public void setKod_pocztowy(int Kod_pocztowy) {
        this.Kod_pocztowy = Kod_pocztowy;
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }

}