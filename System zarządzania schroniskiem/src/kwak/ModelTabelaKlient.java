
package kwak;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModelTabelaKlient extends AbstractTableModel {
    
    private ArrayList<FormularzKlienta> db;
    public ModelTabelaKlient(){}
    private String[] Kolumny = {"ID", "ID Klienta", "PESEL"};
    
    public void wstawDane(ArrayList<FormularzKlienta> db){
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
        return 3;
    }

    @Override
    public Object getValueAt(int row, int column) {
        FormularzKlienta klient = db.get(row);
        switch (column){
            case 0:
                return klient.getID();
            case 1:
                return klient.getID_Osoby();
            case 2:
                return klient.getPESEL();
        }
        return null;
    }
}