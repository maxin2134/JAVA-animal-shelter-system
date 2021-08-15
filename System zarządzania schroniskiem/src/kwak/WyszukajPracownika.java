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

public class WyszukajPracownika extends JFrame {
    
    private PanelPracownika nowyPracownik = new PanelPracownika();
    private JFrame okno = new JFrame();
    private JButton przyciskWyszukaj = new JButton("Wyszukaj");
    private PolaczenieWyszukajPracownika polaczenie;
    JPanel buttonPane = new JPanel();
    
    WyszukajPracownika(FormularzPracownik pracownik){
    
    buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.Y_AXIS));
    buttonPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    buttonPane.add(Box.createHorizontalBox());
    buttonPane.add(przyciskWyszukaj);
    Container contentPane = getContentPane();
    contentPane.add(buttonPane, BorderLayout.BEFORE_FIRST_LINE);
    
    okno.setTitle("Wyszukaj Pracownika");
    okno.add(contentPane, BorderLayout.SOUTH);
    okno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    okno.setSize(500, 500);
    okno.setMinimumSize(new Dimension(300,300));
    okno.setVisible(true);
    
    Border nowa = BorderFactory.createTitledBorder("Wyszukaj dane");
    nowyPracownik.setBorder(nowa);

    okno.add(nowyPracownik, BorderLayout.WEST);
    
    przyciskWyszukaj.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            pracownik.Login = nowyPracownik.getLoginPole();
            pracownik.Haslo = nowyPracownik.getHasloPole();
            okno.dispose();
            if (polaczenie != null){
                polaczenie.WyszukajPracownika(pracownik);
            }
        }
    });
}
 
    public void WyszukajPracownika(PolaczenieWyszukajPracownika pol){
        this.polaczenie = pol;
    }
}
