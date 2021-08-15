
package kwak;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModelTabelaDokumentacja extends AbstractTableModel {
    
    private ArrayList<FormularzDokumentacja> db;
    public ModelTabelaDokumentacja(){}
    private String[] Kolumny = {"ID", "ID Zwierzaka" , "Nazwa dokument", "Rodzaj", "Miejsce"};
    
    public void wstawDane(ArrayList<FormularzDokumentacja> db){
        this.db = db;
    }

    @Override
    public String getColumnName(int column) {
        return Kolumny[column];
    }

    @Override
    public int getRowCount() {
        return db.size();
        
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int row, int column) {
        FormularzDokumentacja dokument = db.get(row);
        switch (column){
            case 0:
                return dokument.getID();
            case 1:
                return dokument.getID_Zwierzak();
            case 2:
                return dokument.getNazwa();
            case 3:
                return dokument.getRodzaj();
            case 4:
                return dokument.getMiejsce();
        }
        return null;
    }
}