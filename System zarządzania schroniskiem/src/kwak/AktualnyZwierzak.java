
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

public class AktualnyZwierzak extends JPanel {
    private JFrame f = new JFrame();

    private JLabel idKlientaEtykieta = new JLabel("ID Klienta ");;
    private JLabel imieEtykieta = new JLabel("ImieŁ ");;
    private JLabel rasaEtykieta = new JLabel ("Rasa: ");
    private JLabel gatunekEtykieta = new JLabel ("Gatunek: ");
    private JLabel plecEtykieta = new JLabel ("Płeć: ");
    private JLabel przybycieEtykieta = new JLabel ("Data przybycia: ");
    private JLabel zwolnienieEtykieta = new JLabel ("Data zwolnienia: ");
    
    private JLabel idKlientaStaraEtykieta;
    private JLabel imieStaraEtykieta;
    private JLabel rasaStaraEtykieta;
    private JLabel gatunekStaraEtykieta;
    private JLabel plecStaraEtykieta;
    private JLabel przybycieStaraEtykieta;
    private JLabel zwolnienieStaraEtykieta;
    
    
    AktualnyZwierzak(FormularzZwierzaka zwierzak){
        
    Dimension dim = getPreferredSize();
    dim.width = 250;
    setPreferredSize (dim); 
    Border wewGranica = BorderFactory.createTitledBorder("Aktualne dane");
    Border zewGranica = BorderFactory.createEmptyBorder(5,5,5,5);
    setBorder(BorderFactory.createCompoundBorder(zewGranica, wewGranica));
    
    ustawStarePolaZwierzaka(zwierzak);
    panelGraficznyStaryPracownik();
    
    }
    
    public void ustawStarePolaZwierzaka(FormularzZwierzaka zwierzak){
     String id = String.valueOf(zwierzak.ID_Klient);
    this.idKlientaStaraEtykieta = new JLabel(id);
    this.imieStaraEtykieta = new JLabel(zwierzak.imie);
    this.rasaStaraEtykieta = new JLabel(zwierzak.rasa);
    this.gatunekStaraEtykieta = new JLabel(zwierzak.gatunek);
    this.plecStaraEtykieta = new JLabel(zwierzak.plec);
    this.przybycieStaraEtykieta = new JLabel(zwierzak.Data_przybycia);
    this.zwolnienieStaraEtykieta = new JLabel(zwierzak.Data_zwolnienia);
    }
    private void panelGraficznyStaryPracownik() {
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        
        ////////////NASTEPNY RZAD////////////////////
        gc.gridy = 0;
        
        gc.weightx = 1;
        gc.weighty = 0.1;
        
        gc.gridx = 0;    
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(idKlientaEtykieta, gc);
        
        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(idKlientaStaraEtykieta, gc);
        
        ////////////Drugi rzad///////////
        
        gc.gridy++;
        
        gc.weightx = 1;
        gc.weighty = 0.1;
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(imieEtykieta, gc);
        
        gc.gridx = 1;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(imieStaraEtykieta, gc);
        
                ////////////Drugi rzad///////////
        
        gc.gridy++;
        
        gc.weightx = 1;
        gc.weighty = 0.1;
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(rasaEtykieta, gc);
        
        gc.gridx = 1;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(rasaStaraEtykieta, gc);
        
        //////////////// NASTEPNY RZAD ///////////////////
        
        gc.gridy++;
        
        gc.weightx = 1;
        gc.weighty = 0.1;
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(gatunekEtykieta, gc);
        
        gc.gridx = 1;
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,5);
        add(gatunekStaraEtykieta, gc);
        
        
        /////////////// NASTEPNY RZAD ////////////////
        
        gc.gridy ++;
        
        gc.weightx = 1;
        gc.weighty = 0.1;
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(plecEtykieta ,gc);
        
        gc.gridx = 1;
        gc.gridy = 4;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,5);
        add(plecStaraEtykieta, gc);
        
        /////////////// NASTEPNY RZAD ///////
        
        gc.gridy++;
        
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(przybycieEtykieta,gc);
        
        gc.gridx = 1;
        gc.gridy = 5;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,5);
        add(przybycieStaraEtykieta,gc);
        
        ///////////////// NASTEPNY RZAD ///////////
        
        gc.gridy++;
        
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(zwolnienieEtykieta,gc);
        
        gc.gridx = 1;
        gc.gridy = 6;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(zwolnienieStaraEtykieta, gc);
    }
}
