
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

public class AktualizujZwierzaka extends JFrame {
    
    
    private AktualnyZwierzak staryZwierzak;
    private PanelEdytujZwierzaka nowyZwierzak = new PanelEdytujZwierzaka();
    private JFrame okno = new JFrame();
    private JButton przyciskAktualizuj = new JButton("Aktualizuj");
    private PolaczenieAktualizujZwierzaka polaczenie;
    JPanel buttonPane = new JPanel();
    
    AktualizujZwierzaka(FormularzZwierzaka zwierzak){
        
    buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.Y_AXIS));
    buttonPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    buttonPane.add(Box.createHorizontalBox());
    buttonPane.add(przyciskAktualizuj);
    Container contentPane = getContentPane();
    contentPane.add(buttonPane, BorderLayout.BEFORE_FIRST_LINE);
    
    okno.setTitle("Aktualizuj zwierzaka");
    okno.add(contentPane, BorderLayout.SOUTH);
    okno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    okno.setSize(800, 800);
    okno.setMinimumSize(new Dimension(700,700));
    okno.setVisible(true);
    
    staryZwierzak = new AktualnyZwierzak(zwierzak);
    Border nowa = BorderFactory.createTitledBorder("Zmien dane");
    nowyZwierzak.setBorder(nowa);

    okno.add(staryZwierzak, BorderLayout.EAST);
    okno.add(nowyZwierzak, BorderLayout.WEST);
    
    przyciskAktualizuj.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            
            String nic = "";
            if (nowyZwierzak.getIdKlientaPole().equals(nic)){}else{
            String id = nowyZwierzak.getIdKlientaPole();
            int ID = Integer.parseInt(id);
            zwierzak.ID_Klient = ID;}
            
            if (nowyZwierzak.getImiePole().equals(nic)){}else zwierzak.imie = nowyZwierzak.getImiePole();
            if (nowyZwierzak.getRasaPole().equals(nic)){}else zwierzak.rasa = nowyZwierzak.getRasaPole();
            if (nowyZwierzak.getGatunekPole().equals(nic)){}else zwierzak.gatunek = nowyZwierzak.getGatunekPole();
            if (nowyZwierzak.getPlecPole().equals(nic)){}else zwierzak.plec = nowyZwierzak.getPlecPole();
            if (nowyZwierzak.getPrzybyciePole().equals(nic)){}else zwierzak.Data_przybycia = nowyZwierzak.getPrzybyciePole();
            if (nowyZwierzak.getZwolnieniePole().equals(nic)){}else zwierzak.Data_zwolnienia = nowyZwierzak.getZwolnieniePole();
            zwierzak.opis = "";
            
            okno.dispose();
            if (polaczenie != null){
                polaczenie.aktualizujZwierze(zwierzak);
            }
        }
    });
    
    }
 
    public void polAktualizuj(PolaczenieAktualizujZwierzaka pol){
        this.polaczenie = pol;
    }
    
    public void aktualizujStan(FormularzZwierzaka zwierzak){
        staryZwierzak.ustawStarePolaZwierzaka(zwierzak);
    }
}
