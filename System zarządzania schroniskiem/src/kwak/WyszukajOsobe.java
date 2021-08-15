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

public class WyszukajOsobe extends JFrame {
    
    private PanelOsoby nowaOsoba = new PanelOsoby();
    private JFrame okno = new JFrame();
    private JButton przyciskWyszukaj = new JButton("Wyszukaj");
    private PolaczenieWyszukajOsoba polaczenie;
    JPanel buttonPane = new JPanel();
    
    WyszukajOsobe(FormularzOsoba osoba){
    
    buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.Y_AXIS));
    buttonPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    buttonPane.add(Box.createHorizontalBox());
    buttonPane.add(przyciskWyszukaj);
    Container contentPane = getContentPane();
    contentPane.add(buttonPane, BorderLayout.BEFORE_FIRST_LINE);
    
    okno.setTitle("Wyszukaj Osobe");
    okno.add(contentPane, BorderLayout.SOUTH);
    okno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    okno.setSize(500, 500);
    okno.setMinimumSize(new Dimension(300,300));
    okno.setVisible(true);
    
    Border nowa = BorderFactory.createTitledBorder("Wyszukaj dane");
    nowaOsoba.setBorder(nowa);

    okno.add(nowaOsoba, BorderLayout.WEST);
    
    przyciskWyszukaj.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            osoba.Imie = nowaOsoba.getImiePole();
            osoba.Nazwisko = nowaOsoba.getNazwiskoPole();
            osoba.miasto = nowaOsoba.getMiastoPole();
            
            String nrdomu = nowaOsoba.getNr_domuPole();
            int nrdom = Integer.valueOf(nrdomu);
            osoba.Nr_domu = nrdom;
            
            String nrlokal = nowaOsoba.getNr_lokaluPole();
            int nrlkl = Integer.valueOf(nrlokal);
            osoba.Nr_lokalu = nrlkl;
            
            String kod = nowaOsoba.getKod_pocztowyPole();
            int kd = Integer.valueOf(kod);
            osoba.Kod_pocztowy = kd;
            
            String pesel = nowaOsoba.getPeselPole();
            long PESEL = Long.valueOf(pesel);
            osoba.PESEL = PESEL;
            
            okno.dispose();
            if (polaczenie != null){
                polaczenie.WyszukajOsobe(osoba);
            }
        }
    });
    
    
}
 
    public void WyszukajOsobe(PolaczenieWyszukajOsoba pol){
        this.polaczenie = pol;
    }
}
