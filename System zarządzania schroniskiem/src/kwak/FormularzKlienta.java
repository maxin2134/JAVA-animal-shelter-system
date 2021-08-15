package kwak;

import java.util.EventObject;

public class FormularzKlienta extends EventObject {
   int ID;
   int ID_Osoby;
   long PESEL;
    
    public FormularzKlienta (Object Source){
        super (Source);
    }
    
    public FormularzKlienta (Object Source, int ID){
    super(Source);
    this.ID = ID;
    }
    
    public FormularzKlienta (Object Source, int ID, int ID_Osoby, long PESEL){
        
       super(Source);
       this.ID = ID;
       this.ID_Osoby = ID_Osoby;
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

    public int getID_Osoby() {
        return ID_Osoby;
    }

    public void setID_Osoby(int ID_Osoby) {
        this.ID_Osoby = ID_Osoby;
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }

}