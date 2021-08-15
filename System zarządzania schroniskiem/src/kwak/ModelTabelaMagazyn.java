
package kwak;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModelTabelaMagazyn extends AbstractTableModel {
    
    private ArrayList<FormularzMagazyn> db;
    public ModelTabelaMagazyn(){}
    private String[] Kolumny = {"ID", "ID Pracownika" , "Nazwa", "Ilosc", "Waznosc", "Gramatura", "Pojemnik", "Polozenie"};
    
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
        return 8;
    }

    @Override
    public Object getValueAt(int row, int column) {
        FormularzMagazyn magazyn = db.get(row);
        switch (column){
            case 0:
                return magazyn.getID();
            case 1:
                return magazyn.getID_Klient();
            case 2:
                return magazyn.getProdukt();
            case 3:
                return magazyn.getIlosc();
            case 4:
                return magazyn.getWaznosc();
            case 5:
                return magazyn.getGramatura();
            case 6:
                return magazyn.getPojemnik();
            case 7:
                return magazyn.getPolozenie();
        }
        return null;
    }
}