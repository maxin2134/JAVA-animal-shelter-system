
package kwak;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class AktualizujPracownika extends JFrame {
    
    
    private AktualnyPracownik staryPracownik;
    private PanelEdytujPracownika nowyPracownik = new PanelEdytujPracownika();
    private JFrame okno = new JFrame();
    private JButton przyciskAktualizuj = new JButton("Aktualizuj");
    private PolaczenieAktualizujPracownik polaczenie;
    JPanel buttonPane = new JPanel();
    
    AktualizujPracownika(FormularzPracownik pracownik){
        
    buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.Y_AXIS));
    buttonPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    buttonPane.add(Box.createHorizontalBox());
    buttonPane.add(przyciskAktualizuj);
    Container contentPane = getContentPane();
    contentPane.add(buttonPane, BorderLayout.BEFORE_FIRST_LINE);
    
    okno.setTitle("Aktualizuj Pracownika");
    okno.add(contentPane, BorderLayout.SOUTH);
    okno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    okno.setSize(500, 500);
    okno.setMinimumSize(new Dimension(300,300));
    okno.setVisible(true);
    
    staryPracownik = new AktualnyPracownik(pracownik);
    Border nowa = BorderFactory.createTitledBorder("Zmien dane");
    nowyPracownik.setBorder(nowa);

    okno.add(staryPracownik, BorderLayout.EAST);
    okno.add(nowyPracownik, BorderLayout.WEST);
    przyciskAktualizuj.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            String nic = "";
            if (nowyPracownik.getLoginPole().equals(nic)){}else
            pracownik.Login = nowyPracownik.getLoginPole();

            okno.dispose();
            if (polaczenie != null){
                polaczenie.AktualizujPracownika(pracownik);
            }
        }
    });
    
    }
 
    public void polAktualizuj(PolaczenieAktualizujPracownik pol){
        this.polaczenie = pol;
    }
    
    public void aktualizujStan(FormularzPracownik pracownik){
        staryPracownik.ustawStarePolaPracownik(pracownik);
    }
}
