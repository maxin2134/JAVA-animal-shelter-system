package kwak;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TabelaMagazyn extends JPanel {
    
    private JTable tabela;
    private ModelTabelaMagazyn model;
    private JPopupMenu popup;
    private PolaczenieTabelaGui polaczenie;
    
    public TabelaMagazyn (){
        popup = new JPopupMenu();
        model = new ModelTabelaMagazyn();
        tabela = new JTable(model);
        setLayout (new BorderLayout());
        add(new JScrollPane(tabela), BorderLayout.CENTER);
        JMenuItem removeItem = new JMenuItem("Usun wiersz");
        popup.add(removeItem);
        
        tabela.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e) {
                int wiersz = tabela.rowAtPoint(e.getPoint());
                tabela.getSelectionModel().setSelectionInterval(wiersz, wiersz);
                if (e.getButton() == MouseEvent.BUTTON3){
                    popup.show(tabela, e.getX(), e.getY());
                }
            }
            
        });
        
        removeItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                int wiersz = tabela.getSelectedRow();
                if (polaczenie != null){
                    polaczenie.usun(wiersz);
                }
            }
        });
        
    }
    public void wstawDane(ArrayList<FormularzMagazyn> lista){
        model.wstawDane(lista);
        model.fireTableStructureChanged();
        
    }
    
    public void usunTowar(PolaczenieTabelaGui polaczenie){
        this.polaczenie = polaczenie;
    }
    
    public int zwrocZaznaczenie(){
        int wiersz = tabela.getSelectedRow();
        if (wiersz >= 0)    return wiersz;
        else {
        JOptionPane.showConfirmDialog(tabela, "Musisz zaznaczyc osobę do wprowadzenia poprawki",
                "Ostrzeżenie", JOptionPane.OK_OPTION);
        return wiersz;
        }
    }
}
 