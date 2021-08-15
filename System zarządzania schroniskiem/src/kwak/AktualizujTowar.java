
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

public class AktualizujTowar extends JFrame {
    
    
    private AktualnyTowar staryTowar;
    private PanelEdytujMagazyn nowyTowar = new PanelEdytujMagazyn();
    private JFrame okno = new JFrame();
    private JButton przyciskAktualizuj = new JButton("Aktualizuj");
    private PolaczenieAktualizujTowar polaczenie;
    JPanel buttonPane = new JPanel();
    
    AktualizujTowar(FormularzMagazyn towar){
        
    buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.Y_AXIS));
    buttonPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    buttonPane.add(Box.createHorizontalBox());
    buttonPane.add(przyciskAktualizuj);
    Container contentPane = getContentPane();
    contentPane.add(buttonPane, BorderLayout.BEFORE_FIRST_LINE);
    
    okno.setTitle("Aktualizuj towar");
    okno.add(contentPane, BorderLayout.SOUTH);
    okno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    okno.setSize(800, 800);
    okno.setMinimumSize(new Dimension(700,700));
    okno.setVisible(true);
    
    staryTowar = new AktualnyTowar(towar);
    Border nowa = BorderFactory.createTitledBorder("Zmien dane");
    nowyTowar.setBorder(nowa);

    okno.add(staryTowar, BorderLayout.EAST);
    okno.add(nowyTowar, BorderLayout.WEST);
    
    przyciskAktualizuj.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            String nic = "";
            if(nowyTowar.getIdPracownikaPole().equals(nic)){}else{
            String id = nowyTowar.getIdPracownikaPole();
            int ID = Integer.parseInt(id);
            towar.ID_Pracownika = ID;}
            
            if(nowyTowar.getNazwaPole().equals(nic)){}else towar.produkt = nowyTowar.getNazwaPole();
            
            if(nowyTowar.getIloscPole().equals(nic)){}else{
            String Ilosc = nowyTowar.getIloscPole();
            int ilosc = Integer.parseInt(Ilosc);
            towar.ilosc = ilosc;}
            
            if(nowyTowar.getWaznoscPole().equals(nic)){}else towar.waznosc = nowyTowar.getWaznoscPole();
            if(nowyTowar.getGramaturaPole().equals(nic)){}else towar.gramatura = nowyTowar.getGramaturaPole();
            if(nowyTowar.getPojemnikPole().equals(nic)){}else towar.pojemnik = nowyTowar.getPojemnikPole();
            if(nowyTowar.getPolozeniePole().equals(nic)){}else towar.polozenie = nowyTowar.getPolozeniePole();
            
            okno.dispose();
            if (polaczenie != null){
                polaczenie.aktualizuj(towar);
            }
        }
    });
    
    }
 
    public void polAktualizuj(PolaczenieAktualizujTowar pol){
        this.polaczenie = pol;
    }
    
    public void aktualizujStan(FormularzMagazyn towar){
        staryTowar.ustawStarePolaTowaru(towar);
    }
}
