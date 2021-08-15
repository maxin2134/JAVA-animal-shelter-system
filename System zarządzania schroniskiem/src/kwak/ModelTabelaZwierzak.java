
package kwak;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModelTabelaZwierzak extends AbstractTableModel {
    
    private ArrayList<FormularzZwierzaka> db;
    public ModelTabelaZwierzak(){}
    private String[] Kolumny = {"ID", "ID Klienta" , "Imie", "Rasa", "Gatunek", "Płeć", "Data Przybycia", "Data Opuszczenia"};
    
    public void wstawDane(ArrayList<FormularzZwierzaka> db){
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
        FormularzZwierzaka zwierzak = db.get(row);
        switch (column){
            case 0:
                return zwierzak.getID();
            case 1:
                return zwierzak.getID_Klient();
            case 2:
                return zwierzak.getImie();
            case 3:
                return zwierzak.getRasa();
            case 4:
                return zwierzak.getGatunek();
            case 5:
                return zwierzak.getPlec();
            case 6:
                return zwierzak.getData_przybycia();
            case 7:
                return zwierzak.getData_zwolnienia();
        }
        return null;
    }
}