package kwak;

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class FiltrPrzeszukiwan extends FileFilter {

    @Override
    public boolean accept(File f) {
        String name = f.getName();
        String rozbudowa = Utils.getRodzajPliku(name);
        
        if (f.isDirectory()){
            return true;
        }
        
        if (rozbudowa == null){
            return false;
        }
        
        if (rozbudowa.equals("db")){
            return true;
        }
        
        return false;
    }

    @Override
    public String getDescription() {
        return "Plik bazodanowy osob (*.db)";
    }
    
}
