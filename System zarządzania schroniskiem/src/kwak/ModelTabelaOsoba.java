
package kwak;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModelTabelaOsoba extends AbstractTableModel {
    
    private ArrayList<FormularzOsoba> db;
    public ModelTabelaOsoba(){}
    private String[] Kolumny = {"ID", "Imie", "Nazwisko", "Nr domu", "Nr lokalu", "Miasto", "Kod pocztowy", "PESEL"};
    
    public void wstawDane(ArrayList<FormularzOsoba> db){
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
        FormularzOsoba osoba = db.get(row);
        switch (column){
            case 0:
                return osoba.getID();
            case 1:
                return osoba.getImie();
            case 2:
                return osoba.getNazwisko();
            case 3:
                return osoba.getNr_domu();
            case 4:
                return osoba.getNr_lokalu();
            case 5:
                return osoba.getMiasto();
            case 6:
                return osoba.getKod_pocztowy();
            case 7:
                return osoba.getPESEL();
        }
        return null;
    }   
}