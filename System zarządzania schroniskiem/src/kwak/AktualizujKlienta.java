
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

public class AktualizujKlienta extends JFrame {
    
    
    private AktualnyKlient staryKlient;
    private PanelKlienta nowyKlient = new PanelKlienta();
    private JFrame okno = new JFrame();
    private JButton przyciskAktualizuj = new JButton("Aktualizuj");
    private PolaczenieAktualizujKlienta polaczenie;
    JPanel buttonPane = new JPanel();
    
    AktualizujKlienta(FormularzKlienta klient){
        
    buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.Y_AXIS));
    buttonPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    buttonPane.add(Box.createHorizontalBox());
    buttonPane.add(przyciskAktualizuj);
    Container contentPane = getContentPane();
    contentPane.add(buttonPane, BorderLayout.BEFORE_FIRST_LINE);
    
    okno.setTitle("Aktualizuj Klienta");
    okno.add(contentPane, BorderLayout.SOUTH);
    okno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    okno.setSize(500, 500);
    okno.setMinimumSize(new Dimension(300,300));
    okno.setVisible(true);
    
    staryKlient = new AktualnyKlient(klient);
    Border nowa = BorderFactory.createTitledBorder("Zmien dane");
    nowyKlient.setBorder(nowa);

    okno.add(staryKlient, BorderLayout.EAST);
    okno.add(nowyKlient, BorderLayout.WEST);
    
    przyciskAktualizuj.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            String nic = "";
            
            if (nowyKlient.getIdPole().equals(nic)){}else{
            String id = nowyKlient.getIdPole();
            int ID = Integer.parseInt(id);
            klient.ID_Osoby = ID;}
            
            if (nowyKlient.getPeselPole().equals(nic)){}else{
            String pesel = nowyKlient.getPeselPole();
            long PESEL = Long.parseLong(pesel);
            klient.PESEL = PESEL;
            }
            okno.dispose();
            if (polaczenie != null){
                polaczenie.AktualizujKlienta(klient);
            }
        }
    });
    
    }
 
    public void polAktualizuj(PolaczenieAktualizujKlienta pol){
        this.polaczenie = pol;
    }
    
    public void aktualizujStan(FormularzKlienta klient){
        staryKlient.ustawStarePolaKlient(klient);
    }
}
