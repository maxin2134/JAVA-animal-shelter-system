
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

public class AktualizujDokument extends JFrame {
    
    
    private AktualnyDokument staryDokument;
    private PanelEdytujDokumentacja nowyDokument = new PanelEdytujDokumentacja();
    private JFrame okno = new JFrame();
    private JButton przyciskAktualizuj = new JButton("Aktualizuj");
    private PolaczenieAktualizujDokument polaczenie;
    JPanel buttonPane = new JPanel();
    
    AktualizujDokument(FormularzDokumentacja dokument){
        
    buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.Y_AXIS));
    buttonPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    buttonPane.add(Box.createHorizontalBox());
    buttonPane.add(przyciskAktualizuj);
    Container contentPane = getContentPane();
    contentPane.add(buttonPane, BorderLayout.BEFORE_FIRST_LINE);
    
    okno.setTitle("Aktualizuj dokument");
    okno.add(contentPane, BorderLayout.SOUTH);
    okno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    okno.setSize(800, 800);
    okno.setMinimumSize(new Dimension(700,700));
    okno.setVisible(true);
    
    staryDokument = new AktualnyDokument(dokument);
    Border nowa = BorderFactory.createTitledBorder("Zmien dane");
    nowyDokument.setBorder(nowa);

    okno.add(staryDokument, BorderLayout.EAST);
    okno.add(nowyDokument, BorderLayout.WEST);
    
    przyciskAktualizuj.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            String nic = "";
            if (nowyDokument.getIdZwierzakaPole().equals(nic)){}else {
            String id = nowyDokument.getIdZwierzakaPole();
            int ID = Integer.parseInt(id);
            dokument.ID_Zwierzak = ID;}
            
            if (nowyDokument.getNazwaPole().equals(nic)){}else dokument.nazwa = nowyDokument.getNazwaPole();
            if (nowyDokument.getRodzajPole().equals(nic)){}else dokument.rodzaj = nowyDokument.getRodzajPole();
            if (nowyDokument.getMiejscePole().equals(nic)){}else dokument.miejsce = nowyDokument.getMiejscePole();
            
            okno.dispose();
            if (polaczenie != null){
                polaczenie.atkualizujDokument(dokument);
            }
        }
    });
    
    }
 
    public void polAktualizuj(PolaczenieAktualizujDokument pol){
        this.polaczenie = pol;
    }
    
    public void aktualizujStan(FormularzDokumentacja dokument){
        staryDokument.ustawStarePolaDokumentu(dokument);
    }
}

