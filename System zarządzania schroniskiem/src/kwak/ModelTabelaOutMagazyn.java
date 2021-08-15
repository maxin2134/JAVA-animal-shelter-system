
package kwak;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModelTabelaOutMagazyn extends AbstractTableModel {
    
    private ArrayList<FormularzMagazyn> db;
    public ModelTabelaOutMagazyn(){}
    private String[] Kolumny = { "ID","Nazwa", "Ilosc", "Waznosc", "Pojemnik", "Polozenie"};
    
    public void wstawDane(ArrayList<FormularzMagazyn> db){
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
        return 6;
    }

    @Override
    public Object getValueAt(int row, int column) {
        FormularzMagazyn magazyn = db.get(row);
        switch (column){
            case 0:
                return magazyn.getID();
            case 1:
                return magazyn.getProdukt();
            case 2:
                return magazyn.getIlosc();
            case 3:
                return magazyn.getWaznosc();
            case 4:
                return magazyn.getPojemnik();
            case 5:
                return magazyn.getPolozenie();
        }
        return null;
    }
}