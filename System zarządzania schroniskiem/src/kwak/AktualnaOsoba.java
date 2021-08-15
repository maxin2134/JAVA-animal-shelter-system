
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

public class AktualnaOsoba extends JPanel {
    private JFrame f = new JFrame();

    private JLabel imieEtykieta = new JLabel("Imie: ");;
    private JLabel nazwiskoEtykieta = new JLabel ("Nazwisko: ");
    private JLabel nr_domuEtykieta = new JLabel ("Nr domu: ");
    private JLabel nr_lokaluEtykieta = new JLabel ("Nr lokalu: ");
    private JLabel miastoEtykieta = new JLabel ("Miasto: ");
    private JLabel kod_pocztowyEtykieta = new JLabel ("Kod pocztowy: ");
    private JLabel peselEtykieta = new JLabel ("PESEL");
    
    private JLabel imieStaraEtykieta;
    private JLabel nazwiskoStaraEtykieta;
    private JLabel nr_domuStaraEtykieta;
    private JLabel nr_lokaluStaraEtykieta;
    private JLabel miastoStaraEtykieta;
    private JLabel kod_pocztowyStaraEtykieta;
    private JLabel peselStaraEtykieta;
    
    AktualnaOsoba(FormularzOsoba osoba){
        
    Dimension dim = getPreferredSize();
    dim.width = 250;
    setPreferredSize (dim); 
    Border wewGranica = BorderFactory.createTitledBorder("Aktualne dane");
    Border zewGranica = BorderFactory.createEmptyBorder(5,5,5,5);
    setBorder(BorderFactory.createCompoundBorder(zewGranica, wewGranica));
    
    ustawStarePolaOsoba(osoba);
    panelGraficznyStaryOsoba();
    
    }
    
    public void ustawStarePolaOsoba(FormularzOsoba osoba){
    this.imieStaraEtykieta = new JLabel(osoba.Imie);
    this.nazwiskoStaraEtykieta = new JLabel(osoba.Nazwisko);
    String nr_domu = Integer.toString(osoba.Nr_domu);
    this.nr_domuStaraEtykieta = new JLabel (nr_domu);
    String nr_lokalu = Integer.toString(osoba.Nr_lokalu);
    this.nr_lokaluStaraEtykieta = new JLabel(nr_lokalu);
    this.miastoStaraEtykieta = new JLabel(osoba.miasto);
    String kod_pocztowy = Integer.toString(osoba.Kod_pocztowy);
    this.kod_pocztowyStaraEtykieta = new JLabel(kod_pocztowy);
    String pesel = Long.toString(osoba.PESEL);
    this.peselStaraEtykieta = new JLabel(pesel);
    
    
    }
    private void panelGraficznyStaryOsoba() {
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        
        ////////////NASTEPNY RZAD////////////////////
        gc.gridy = 0;
        
        gc.gridx = 0;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,0);
        add(imieEtykieta,gc);
        
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(imieStaraEtykieta,gc);
        
        ////////////////NASTEPNY RZAD ////////////////////
        gc.gridy++;
        
        gc.gridx = 0;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,0);
        add(nazwiskoEtykieta, gc);
        
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(nazwiskoStaraEtykieta, gc);
        
        ///////////// NASTEPNY RZAD ////////////////
        
        gc.gridy++;
        
        gc.gridx = 0;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,0);
        add(nr_domuEtykieta,gc);
        
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(nr_domuStaraEtykieta, gc);
        
        //////////// NASTEPNY RZAD ///////////////////
        
        gc.gridy++;
        
        gc.gridx = 0;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,0);
        add(nr_lokaluEtykieta,gc);
        
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(nr_lokaluStaraEtykieta, gc);
        
        //////////// NASTEPNY RZAD ////////////////
        
        gc.gridy++;
        
        gc.gridx = 0;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,0);
        add(miastoEtykieta,gc);
        
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(miastoStaraEtykieta, gc);
        
        ///////////// NASTEPNY RZAD ///////////////
        
        gc.gridy++;
        
        gc.gridx = 0;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,0);
        add(kod_pocztowyEtykieta, gc);
        
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(kod_pocztowyStaraEtykieta, gc);
        
        //////////////// NASTEPNY RZAD //////////////////
        
        gc.gridy++;
        
        gc.gridx = 0;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,0);
        add(peselEtykieta,gc);
        
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,0);
        add(peselStaraEtykieta,gc);
        
        
    }
}
