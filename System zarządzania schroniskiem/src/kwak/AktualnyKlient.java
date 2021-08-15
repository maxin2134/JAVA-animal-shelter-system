
package kwak;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class AktualnyKlient extends JPanel {
    private JFrame f = new JFrame();

    private JLabel idEtykieta = new JLabel("ID: ");
    private JLabel peselEtykieta = new JLabel("PESEL: ");
    
    private JLabel idStaraEtykieta;
    private JLabel peselStaraEtykieta;
    
    
    AktualnyKlient(FormularzKlienta klient){
        
    Dimension dim = getPreferredSize();
    dim.width = 250;
    setPreferredSize (dim); 
    Border wewGranica = BorderFactory.createTitledBorder("Aktualne dane");
    Border zewGranica = BorderFactory.createEmptyBorder(5,5,5,5);
    setBorder(BorderFactory.createCompoundBorder(zewGranica, wewGranica));
    
    ustawStarePolaKlient(klient);
    panelGraficznyStaryKlient();
    
    }
    
    public void ustawStarePolaKlient(FormularzKlienta klient){
        String ID = Integer.toString(klient.ID_Osoby);
        String PESEL = Long.toString(klient.PESEL);
    this.idStaraEtykieta = new JLabel(ID);
    this.peselStaraEtykieta = new JLabel(PESEL);
    }
    
    private void panelGraficznyStaryKlient() {
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        
        ////////////NASTEPNY RZAD////////////////////
        gc.gridy = 0;
        
        gc.gridx = 0;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,0);
        add(idEtykieta,gc);
        
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(idStaraEtykieta,gc);
        
        ////////////NASTEPNY RZAD////////////////////
        gc.gridy++;
        
        gc.gridx = 0;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,0);
        add(peselEtykieta,gc);
        
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(peselStaraEtykieta,gc);
        

    }
}
