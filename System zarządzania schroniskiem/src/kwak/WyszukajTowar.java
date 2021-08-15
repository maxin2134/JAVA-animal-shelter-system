package kwak;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class WyszukajTowar extends JFrame {
    
    private PanelMagazyn nowyTowar = new PanelMagazyn();
    private JFrame okno = new JFrame();
    private JButton przyciskWyszukaj = new JButton("Wyszukaj");
    private PolaczenieWyszukajTowar polaczenie;
    JPanel buttonPane = new JPanel();
    
    WyszukajTowar(FormularzMagazyn towar){
    
    buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.Y_AXIS));
    buttonPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    buttonPane.add(Box.createHorizontalBox());
    buttonPane.add(przyciskWyszukaj);
    Container contentPane = getContentPane();
    contentPane.add(buttonPane, BorderLayout.BEFORE_FIRST_LINE);
    
    okno.setTitle("Wyszukaj towar");
    okno.add(contentPane, BorderLayout.SOUTH);
    okno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    okno.setSize(500, 500);
    okno.setMinimumSize(new Dimension(300,300));
    okno.setVisible(true);
    
    Border nowa = BorderFactory.createTitledBorder("Wyszukaj dane");
    nowyTowar.setBorder(nowa);

    okno.add(nowyTowar, BorderLayout.WEST);
    
    przyciskWyszukaj.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            int ID = Integer.parseInt(nowyTowar.getIdPracownikaPole());
            towar.ID_Pracownika = ID;
            
            towar.produkt = nowyTowar.getNazwaPole();
            int Ilosc = Integer.parseInt(nowyTowar.getIloscPole());
            towar.ilosc = Ilosc;
            towar.waznosc = nowyTowar.getWaznoscPole();
            towar.gramatura = nowyTowar.getGramaturaPole();
            towar.pojemnik = nowyTowar.getPojemnikPole();
            towar.polozenie = nowyTowar.getPolozeniePole();
            okno.dispose();
            if (polaczenie != null){
                polaczenie.WyszukajTowar(towar);
            }
        }
    });
}
 
    public void WyszukajTowar(PolaczenieWyszukajTowar pol){
        this.polaczenie = pol;
    }
}
