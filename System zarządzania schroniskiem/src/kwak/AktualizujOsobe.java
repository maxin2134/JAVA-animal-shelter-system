
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

public class AktualizujOsobe extends JFrame {
    
    
    private AktualnaOsoba staraOsoba;
    private PanelEdytujOsobe nowaOsoba = new PanelEdytujOsobe();
    private JFrame okno = new JFrame();
    private JButton przyciskAktualizuj = new JButton("Aktualizuj");
    private PolaczenieAktualizujOsoba polaczenie;
    JPanel buttonPane = new JPanel();
    
    AktualizujOsobe(FormularzOsoba osoba){
        
    buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.Y_AXIS));
    buttonPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    buttonPane.add(Box.createHorizontalBox());
    buttonPane.add(przyciskAktualizuj);
    Container contentPane = getContentPane();
    contentPane.add(buttonPane, BorderLayout.BEFORE_FIRST_LINE);
    
    okno.setTitle("Aktualizuj Osobe");
    okno.add(contentPane, BorderLayout.SOUTH);
    okno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    okno.setSize(500, 500);
    okno.setMinimumSize(new Dimension(300,300));
    okno.setVisible(true);
    
    staraOsoba = new AktualnaOsoba(osoba);
    Border nowa = BorderFactory.createTitledBorder("Zmien dane");
    nowaOsoba.setBorder(nowa);

    okno.add(staraOsoba, BorderLayout.EAST);
    okno.add(nowaOsoba, BorderLayout.WEST);
    przyciskAktualizuj.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            String nic = "";
            if (nowaOsoba.getImiePole().equals(nic)){}else
            osoba.Imie = nowaOsoba.getImiePole();
            
            if (nowaOsoba.getNazwiskoPole().equals(nic)){}else
            osoba.Nazwisko = nowaOsoba.getNazwiskoPole();
            
            if (nowaOsoba.getMiastoPole().equals(nic)){}else
            osoba.miasto = nowaOsoba.getMiastoPole();
            
            if (nowaOsoba.getNr_domuPole().equals(nic)){}else{
            String nrdomu = nowaOsoba.getNr_domuPole();
            int nrdom = Integer.valueOf(nrdomu);
            osoba.Nr_domu = nrdom;}
            
            if (nowaOsoba.getNr_lokaluPole().equals(nic)){}else{
            String nrlokal = nowaOsoba.getNr_lokaluPole();
            int nrlkl = Integer.valueOf(nrlokal);
            osoba.Nr_lokalu = nrlkl;}
            
            if (nowaOsoba.getKod_pocztowyPole().equals(nic)){}else{
            String kod = nowaOsoba.getKod_pocztowyPole();
            int kd = Integer.valueOf(kod);
            osoba.Kod_pocztowy = kd;}
            
            if (nowaOsoba.getPeselPole().equals(nic)){}else{
            String pesel = nowaOsoba.getPeselPole();
            long PESEL = Long.parseLong(pesel);
            osoba.PESEL = PESEL;}
            
            okno.dispose();
            if (polaczenie != null){
                polaczenie.AktualizujOsobe(osoba);
            }
        }
    });
    
    }
 
    public void polAktualizuj(PolaczenieAktualizujOsoba pol){
        this.polaczenie = pol;
    }
    
    public void aktualizujStan(FormularzOsoba osoba){
        staraOsoba.ustawStarePolaOsoba(osoba);
    }
}
