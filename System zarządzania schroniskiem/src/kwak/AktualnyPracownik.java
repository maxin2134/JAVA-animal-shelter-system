
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

public class AktualnyPracownik extends JPanel {
    private JFrame f = new JFrame();

    private JLabel loginEtykieta = new JLabel("Login: ");;
    
    private JLabel loginStaraEtykieta;
    
    
    AktualnyPracownik(FormularzPracownik pracownik){
        
    Dimension dim = getPreferredSize();
    dim.width = 250;
    setPreferredSize (dim); 
    Border wewGranica = BorderFactory.createTitledBorder("Aktualne dane");
    Border zewGranica = BorderFactory.createEmptyBorder(5,5,5,5);
    setBorder(BorderFactory.createCompoundBorder(zewGranica, wewGranica));
    
    ustawStarePolaPracownik(pracownik);
    panelGraficznyStaryPracownik();
    
    }
    
    public void ustawStarePolaPracownik(FormularzPracownik pracownik){
    this.loginStaraEtykieta = new JLabel(pracownik.Login);
    }
    private void panelGraficznyStaryPracownik() {
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        
        ////////////NASTEPNY RZAD////////////////////
        gc.gridy = 0;
        
        gc.gridx = 0;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,0);
        add(loginEtykieta,gc);
        
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(loginStaraEtykieta,gc);


    }
}
