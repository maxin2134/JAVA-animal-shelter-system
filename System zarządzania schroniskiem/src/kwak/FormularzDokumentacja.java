package kwak;

import java.util.EventObject;

public class FormularzDokumentacja extends EventObject{
    int ID;
    int ID_Zwierzak;
    String nazwa;
    String rodzaj;
    String miejsce;
    
public  FormularzDokumentacja(Object source){
        super (source);
    }

public FormularzDokumentacja(Object source, int id){
    super(source);
    this.ID = id;
  }

public FormularzDokumentacja(Object source, int id, int id_zwierzak, String nazwa, String rodzaj, String miejsce){
    super (source);
    this.ID = id;
    this.ID_Zwierzak = id_zwierzak;
    this.nazwa = nazwa;
    this.rodzaj = rodzaj;
    this.miejsce = miejsce;
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

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getRodzaj() {
        return rodzaj;
    }

    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }

    public String getMiejsce() {
        return miejsce;
    }

    public void setMiejsce(String miejsce) {
        this.miejsce = miejsce;
    }

   

}
