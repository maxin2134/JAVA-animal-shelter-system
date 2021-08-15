
package kwak;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModelTabelaOperacja extends AbstractTableModel {
    
    private ArrayList<FormularzOperacja> db;
    public ModelTabelaOperacja(){}
    private String[] Kolumny = {"ID", "ID Zwierzaka" , "ID Klienta", "ID Pracownika", "Rodzaj Operacji", "Data dodania", "Data zakończenia"};
    
    public void wstawDane(ArrayList<FormularzOperacja> db){
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
        return 7;
    }

    @Override
    public Object getValueAt(int row, int column) {
        FormularzOperacja operacja = db.get(row);
        switch (column){
            case 0:
                return operacja.getID();
            case 1:
                return operacja.getID_Zwierzak();
            case 2:
                return operacja.getID_Klient();
            case 3:
                return operacja.getID_Pracownik();
            case 4:
                return operacja.getRodzaj_Operacja();
            case 5:
                return operacja.getDodanie();
            case 6:
                return operacja.getZakonczenie();
        }
        return null;
    }
}