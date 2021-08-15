package kwak;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModelTabelaPracownik extends AbstractTableModel {
    
    private ArrayList<FormularzPracownik> db;
    public ModelTabelaPracownik(){}
    private String[] Kolumny = {"ID", "Login"};
    
    public void wstawDane(ArrayList<FormularzPracownik> db){
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
        return 2;
    }

    @Override
    public Object getValueAt(int row, int column) {
        FormularzPracownik pracownik = db.get(row);
        switch (column){
            case 0:
                return pracownik.getID();
            case 1:
                return pracownik.getLogin();
        }
        return null;
    }
}