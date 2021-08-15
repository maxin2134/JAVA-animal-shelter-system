
package kwak;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PodgladTabelaOsoba extends JFrame {
    
    private JFrame okno = new JFrame();
    private JButton przyciskDodaj = new JButton("Usun");
    private JPanel buttonPane = new JPanel();
    private PolaczenieToolbarOs3 polaczenie3;
    private TabelaOsoba tabelaOsoba = new TabelaOsoba();
    private FormularzOsoba osoba;
    
    PodgladTabelaOsoba(ArrayList<FormularzOsoba> lista){
    
    buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.Y_AXIS));
    buttonPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    buttonPane.add(Box.createHorizontalBox());
    buttonPane.add(przyciskDodaj);
    Container contentPane = getContentPane();
    contentPane.add(buttonPane, BorderLayout.BEFORE_FIRST_LINE);
    
    tabelaOsoba.wstawDane(lista);
    
    okno.setTitle("Osoby wyszukane");
    okno.add(contentPane, BorderLayout.SOUTH);
    okno.add(tabelaOsoba, BorderLayout.CENTER);
    okno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    okno.setSize(800, 800);
    okno.setMinimumSize(new Dimension(700,700));
    okno.setVisible(true);

    
    przyciskDodaj.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                int id = tabelaOsoba.zwrocZaznaczenie();
                osoba = lista.get(id);
                int K = osoba.ID;
                String k = String.valueOf(K);
                okno.dispose();
                
                if (polaczenie3 != null){
                    polaczenie3.formEventOccurred(k);
                
                }
            }
        });
    
    }
    
 public void polToolbarOs3 ( PolaczenieToolbarOs3 pol){
 this.polaczenie3 = pol;
}
    
}
