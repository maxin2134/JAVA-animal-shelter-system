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

public class WyszukajKlienta extends JFrame {
    
    private PanelKlienta nowyKlient = new PanelKlienta();
    private JFrame okno = new JFrame();
    private JButton przyciskWyszukaj = new JButton("Wyszukaj");
    private PolaczenieWyszukajKlienta polaczenie;
    JPanel buttonPane = new JPanel();
    
    WyszukajKlienta(FormularzKlienta klient){
    
    buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.Y_AXIS));
    buttonPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    buttonPane.add(Box.createHorizontalBox());
    buttonPane.add(przyciskWyszukaj);
    Container contentPane = getContentPane();
    contentPane.add(buttonPane, BorderLayout.BEFORE_FIRST_LINE);
    
    okno.setTitle("Wyszukaj Klienta");
    okno.add(contentPane, BorderLayout.SOUTH);
    okno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    okno.setSize(500, 500);
    okno.setMinimumSize(new Dimension(300,300));
    okno.setVisible(true);
    
    Border nowa = BorderFactory.createTitledBorder("Wyszukaj dane");
    nowyKlient.setBorder(nowa);

    okno.add(nowyKlient, BorderLayout.WEST);
    
    przyciskWyszukaj.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            int ID = Integer.parseInt(nowyKlient.getIdPole());
            klient.ID_Osoby = ID;
            okno.dispose();
            if (polaczenie != null){
                polaczenie.WyszukajKlienta(klient);
            }
        }
    });
}
 
    public void WyszukajKlienta(PolaczenieWyszukajKlienta pol){
        this.polaczenie = pol;
    }
}
