
package kwak;

import java.util.EventObject;

public class FormularzPracownik extends EventObject {
    int ID;
    String Login;
    String Haslo;
    
    public FormularzPracownik(Object source){
        super (source);
    }
    
    public FormularzPracownik (Object source,int ID, String Login, String Haslo){
        super(source);
        this.ID = ID;
        this.Login = Login;
        this.Haslo = Haslo;
    }
    public FormularzPracownik (Object source,int ID, String Login){
        super(source);
        this.ID = ID;
        this.Login = Login;
    }
    
    public FormularzPracownik (Object Source, int ID){
    super(Source);
    this.ID = ID;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getHaslo() {
        return Haslo;
    }

    public void setHaslo(String Haslo) {
        this.Haslo = Haslo;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    
}
