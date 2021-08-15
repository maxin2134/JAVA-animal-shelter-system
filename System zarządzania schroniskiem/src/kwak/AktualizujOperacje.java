
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

public class AktualizujOperacje extends JFrame {
    
    
    private AktualnaOperacja staraOperacja;
    private PanelEdytujOperacja nowaOperacja = new PanelEdytujOperacja();
    private JFrame okno = new JFrame();
    private JButton przyciskAktualizuj = new JButton("Aktualizuj");
    private PolaczenieAktualizujOperacje polaczenie;
    JPanel buttonPane = new JPanel();
    // trzeba do paneluedytujoperacje wczytac formularz w celu unikniecia nadpisywania danych z datami czyli new w konstruktorze
    AktualizujOperacje(FormularzOperacja operacja){
        
    buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.Y_AXIS));
    buttonPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    buttonPane.add(Box.createHorizontalBox());
    buttonPane.add(przyciskAktualizuj);
    Container contentPane = getContentPane();
    contentPane.add(buttonPane, BorderLayout.BEFORE_FIRST_LINE);
    
    okno.setTitle("Aktualizuj Operacje");
    okno.add(contentPane, BorderLayout.SOUTH);
    okno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    okno.setSize(800, 800);
    okno.setMinimumSize(new Dimension(700,700));
    okno.setVisible(true);
    
    staraOperacja = new AktualnaOperacja(operacja);
    Border nowa = BorderFactory.createTitledBorder("Zmien dane");
    nowaOperacja.setBorder(nowa);

    okno.add(staraOperacja, BorderLayout.EAST);
    okno.add(nowaOperacja, BorderLayout.WEST);
    
    przyciskAktualizuj.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            String nic = "";
            if (nowaOperacja.getIdZwierzakaPole().equals(nic)){}else{
            String id_zwierzak = nowaOperacja.getIdZwierzakaPole();
            int Id_zwierzak = Integer.parseInt(id_zwierzak);
            operacja.ID_Zwierzak = Id_zwierzak;}
            
            if (nowaOperacja.getIdKlientaPole().equals(nic)){}else{
            String id_klient = nowaOperacja.getIdKlientaPole();
            int Id_klient = Integer.parseInt(id_klient);
            operacja.ID_Klient = Id_klient;}
            
            if (nowaOperacja.getIdPracownikaPole().equals(nic)){}else{
            String id_pracownik = nowaOperacja.getIdPracownikaPole();
            int Id_pracownik = Integer.parseInt(id_pracownik);
            operacja.ID_Pracownik = Id_pracownik;}
            
            if (nowaOperacja.getRodzajOperacjiPole().equals(nic)){}else operacja.Rodzaj_Operacja = nowaOperacja.getRodzajOperacjiPole();
            if (nowaOperacja.getDodaniePole().equals(nic)){}else operacja.Dodanie = nowaOperacja.getDodaniePole();
            if (nowaOperacja.getZakonczeniePole().equals(nic)){}else operacja.Zakonczenie = nowaOperacja.getZakonczeniePole();

            
            okno.dispose();
            if (polaczenie != null){
                polaczenie.aktualizujOperacje(operacja);
            }
        }
    });
    
    }
 
    public void polAktualizuj(PolaczenieAktualizujOperacje pol){
        this.polaczenie = pol;
    }
    
    public void aktualizujStan(FormularzOperacja operacja){
        staraOperacja.ustawStarePolaOperacji(operacja);
    }
}

