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

public class WyszukajOperacje extends JFrame {
    
    private PanelOperacja nowaOperacja = new PanelOperacja();
    private JFrame okno = new JFrame();
    private JButton przyciskWyszukaj = new JButton("Wyszukaj");
    private PolaczenieWyszukajOperacje polaczenie;
    JPanel buttonPane = new JPanel();
    
    WyszukajOperacje(FormularzOperacja operacja){
    
    buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.Y_AXIS));
    buttonPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    buttonPane.add(Box.createHorizontalBox());
    buttonPane.add(przyciskWyszukaj);
    Container contentPane = getContentPane();
    contentPane.add(buttonPane, BorderLayout.BEFORE_FIRST_LINE);
    
    okno.setTitle("Wyszukaj operacje");
    okno.add(contentPane, BorderLayout.SOUTH);
    okno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    okno.setSize(500, 500);
    okno.setMinimumSize(new Dimension(300,300));
    okno.setVisible(true);
    
    Border nowa = BorderFactory.createTitledBorder("Wyszukaj dane");
    nowaOperacja.setBorder(nowa);

    okno.add(nowaOperacja, BorderLayout.WEST);
    
    przyciskWyszukaj.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            int id_zwierzaka = Integer.parseInt(nowaOperacja.getIdZwierzakaPole());
            operacja.ID_Zwierzak = id_zwierzaka;
            
            int id_klient = Integer.parseInt(nowaOperacja.getIdKlientaPole());
            operacja.ID_Klient = id_klient;
            
            int id_pracownika = Integer.parseInt(nowaOperacja.getIdPracownikaPole());
            operacja.ID_Pracownik = id_pracownika;
            
            operacja.Rodzaj_Operacja = nowaOperacja.getRodzajOperacjiPole();
            operacja.Dodanie = nowaOperacja.getDodaniePole();
            operacja.Zakonczenie = nowaOperacja.getZakonczeniePole();
            
            okno.dispose();
            if (polaczenie != null){
                polaczenie.wyszukajOperacje(operacja);
            }
        }
    });
}
 
    public void WyszukajOperacje(PolaczenieWyszukajOperacje pol){
        this.polaczenie = pol;
    }
}
