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

public class WyszukajZwierzaka extends JFrame {
    
    private PanelZwierzaka nowyZwierzak = new PanelZwierzaka();
    private JFrame okno = new JFrame();
    private JButton przyciskWyszukaj = new JButton("Wyszukaj");
    private PolaczenieWyszukajZwierzaka polaczenie;
    JPanel buttonPane = new JPanel();
    
    WyszukajZwierzaka(FormularzZwierzaka zwierzak){
    
    buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.Y_AXIS));
    buttonPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    buttonPane.add(Box.createHorizontalBox());
    buttonPane.add(przyciskWyszukaj);
    Container contentPane = getContentPane();
    contentPane.add(buttonPane, BorderLayout.BEFORE_FIRST_LINE);
    
    okno.setTitle("Wyszukaj zwierzaka");
    okno.add(contentPane, BorderLayout.SOUTH);
    okno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    okno.setSize(500, 500);
    okno.setMinimumSize(new Dimension(300,300));
    okno.setVisible(true);
    
    Border nowa = BorderFactory.createTitledBorder("Wyszukaj dane");
    nowyZwierzak.setBorder(nowa);

    okno.add(nowyZwierzak, BorderLayout.WEST);
    
    przyciskWyszukaj.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            int ID = Integer.parseInt(nowyZwierzak.getIdKlientaPole());
            zwierzak.ID_Klient = ID;
            
            zwierzak.imie = nowyZwierzak.getImiePole();
            zwierzak.rasa = nowyZwierzak.getRasaPole();
            zwierzak.gatunek = nowyZwierzak.getGatunekPole();
            zwierzak.plec = nowyZwierzak.getPlecPole();
            zwierzak.Data_przybycia = nowyZwierzak.getPrzybyciePole();
            //zwierzak.Data_zwolnienia = nowyZwierzak.getZwolnieniePole();
            
            okno.dispose();
            if (polaczenie != null){
                polaczenie.wyszukajZwierzaka(zwierzak);
            }
        }
    });
}
 
    public void WyszukajZwierzaka(PolaczenieWyszukajZwierzaka pol){
        this.polaczenie = pol;
    }
}
