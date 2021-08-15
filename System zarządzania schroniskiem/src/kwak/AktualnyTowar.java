
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

public class AktualnyTowar extends JPanel {
    private JFrame f = new JFrame();

    private JLabel idPracownikaEtykieta = new JLabel("ID Pracownika ");;
    private JLabel produktEtykieta = new JLabel("Nazwa produktu: ");;
    private JLabel iloscEtykieta = new JLabel ("Ilość: ");
    private JLabel waznoscEtykieta = new JLabel ("Ważność: ");
    private JLabel gramaturaEtykieta = new JLabel ("Gramatura: ");
    private JLabel pojemnikEtykieta = new JLabel ("Pojemnik: ");
    private JLabel polozenieEtykieta = new JLabel ("Polozenie: ");
    
    private JLabel idPracownikaStaraEtykieta;
    private JLabel produktStaraEtykieta;
    private JLabel iloscStaraEtykieta;
    private JLabel waznoscStaraEtykieta;
    private JLabel gramaturaStaraEtykieta;
    private JLabel pojemnikStaraEtykieta;
    private JLabel polozenieStaraEtykieta;
    
    
    AktualnyTowar(FormularzMagazyn towar){
        
    Dimension dim = getPreferredSize();
    dim.width = 250;
    setPreferredSize (dim); 
    Border wewGranica = BorderFactory.createTitledBorder("Aktualne dane");
    Border zewGranica = BorderFactory.createEmptyBorder(5,5,5,5);
    setBorder(BorderFactory.createCompoundBorder(zewGranica, wewGranica));
    
    ustawStarePolaTowaru(towar);
    panelGraficznyStaryMagazyn();
    
    }
    
    public void ustawStarePolaTowaru(FormularzMagazyn towar){
    String id = String.valueOf(towar.ID_Pracownika);
    this.idPracownikaStaraEtykieta = new JLabel(id);
    this.produktStaraEtykieta = new JLabel(towar.produkt);
    String Ilosc = String.valueOf(towar.ilosc);
    this.iloscStaraEtykieta = new JLabel(Ilosc);
    this.waznoscStaraEtykieta = new JLabel(towar.waznosc);
    this.gramaturaStaraEtykieta = new JLabel(towar.gramatura);
    this.pojemnikStaraEtykieta = new JLabel(towar.pojemnik);
    this.polozenieStaraEtykieta = new JLabel(towar.polozenie);
    }
    private void panelGraficznyStaryMagazyn() {
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
        add(idPracownikaEtykieta, gc);
        
        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(idPracownikaStaraEtykieta, gc);
        
        ////////////Drugi rzad///////////
        
        gc.gridy++;
        
        gc.weightx = 1;
        gc.weighty = 0.1;
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(produktEtykieta, gc);
        
        gc.gridx = 1;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(produktStaraEtykieta, gc);
        
                ////////////Drugi rzad///////////
        
        gc.gridy++;
        
        gc.weightx = 1;
        gc.weighty = 0.1;
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(iloscEtykieta, gc);
        
        gc.gridx = 1;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(iloscStaraEtykieta, gc);
        
        //////////////// NASTEPNY RZAD ///////////////////
        
        gc.gridy++;
        
        gc.weightx = 1;
        gc.weighty = 0.1;
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(waznoscEtykieta, gc);
        
        gc.gridx = 1;
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,5);
        add(waznoscStaraEtykieta, gc);
        
        
        /////////////// NASTEPNY RZAD ////////////////
        
        gc.gridy ++;
        
        gc.weightx = 1;
        gc.weighty = 0.1;
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(gramaturaEtykieta ,gc);
        
        gc.gridx = 1;
        gc.gridy = 4;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,5);
        add(gramaturaStaraEtykieta, gc);
        
        /////////////// NASTEPNY RZAD ///////
        
        gc.gridy++;
        
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(pojemnikEtykieta,gc);
        
        gc.gridx = 1;
        gc.gridy = 5;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,5);
        add(pojemnikStaraEtykieta,gc);
        /////////////// NASTEPNY RZAD ///////
        
        gc.gridy++;
        
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(polozenieEtykieta,gc);
        
        gc.gridx = 1;
        gc.gridy = 6;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,5);
        add(polozenieStaraEtykieta,gc);
       
    }
}
