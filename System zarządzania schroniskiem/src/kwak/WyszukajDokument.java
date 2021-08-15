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

public class WyszukajDokument extends JFrame {
    
    private PanelDokumentacja nowyDokument = new PanelDokumentacja();
    private JFrame okno = new JFrame();
    private JButton przyciskWyszukaj = new JButton("Wyszukaj");
    private PolaczenieWyszukajDokument polaczenie;
    JPanel buttonPane = new JPanel();
    
    WyszukajDokument(FormularzDokumentacja dokument){
    
    buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.Y_AXIS));
    buttonPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    buttonPane.add(Box.createHorizontalBox());
    buttonPane.add(przyciskWyszukaj);
    Container contentPane = getContentPane();
    contentPane.add(buttonPane, BorderLayout.BEFORE_FIRST_LINE);
    
    okno.setTitle("Wyszukaj dokument");
    okno.add(contentPane, BorderLayout.SOUTH);
    okno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    okno.setSize(500, 500);
    okno.setMinimumSize(new Dimension(300,300));
    okno.setVisible(true);
    
    Border nowa = BorderFactory.createTitledBorder("Wyszukaj dane");
    nowyDokument.setBorder(nowa);

    okno.add(nowyDokument, BorderLayout.WEST);
    
    przyciskWyszukaj.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            int ID = Integer.parseInt(nowyDokument.getIdZwierzakaPole());
            dokument.ID_Zwierzak = ID;
            
            dokument.nazwa = nowyDokument.getNazwaPole();
            dokument.rodzaj = nowyDokument.getRodzajPole();
            dokument.miejsce = nowyDokument.getMiejscePole();

            
            okno.dispose();
            if (polaczenie != null){
                polaczenie.wyszukajDokument(dokument);
            }
        }
    });
}
 
    public void WyszukajDokument(PolaczenieWyszukajDokument pol){
        this.polaczenie = pol;
    }
}
