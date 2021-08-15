
package kwak;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;

public class WyszukajPrzedawnionyTowar extends JFrame {
    
    private JFrame okno = new JFrame();
    private PolaczenieToolbarOs3 polaczenie3;
    private TabelaOutMagazyn tabelaTowarow = new TabelaOutMagazyn();
    
    WyszukajPrzedawnionyTowar(ArrayList<FormularzMagazyn> lista){

    tabelaTowarow.wstawDane(lista);
    
    okno.setTitle("Przedawnione towary");
    okno.add(tabelaTowarow, BorderLayout.CENTER);
    okno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    okno.setSize(800, 800);
    okno.setMinimumSize(new Dimension(700,700));
    okno.setVisible(true);

    }
    
 public void polToolbarOs3 ( PolaczenieToolbarOs3 pol){
 this.polaczenie3 = pol;
}
    
}
