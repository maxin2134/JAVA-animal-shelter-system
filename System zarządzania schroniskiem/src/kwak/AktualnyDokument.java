
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

public class AktualnyDokument extends JPanel {
    private JFrame f = new JFrame();

    private JLabel idZwierzakaEtykieta = new JLabel ("ID Zwierzaka: ");
    private JLabel nazwaEtykieta = new JLabel("Nazwa dokumentu: ");;
    private JLabel rodzajEtykieta = new JLabel ("Rodzaj: ");
    private JLabel miejsceEtykieta = new JLabel ("Miejsce: ");

    
    private JLabel idZwierzakaStaraEtykieta;
    private JLabel nazwaStaraEtykieta;
    private JLabel rodzajStaraEtykieta;
    private JLabel miejsceStaraEtykieta;  
    
    AktualnyDokument(FormularzDokumentacja dokument){
        
    Dimension dim = getPreferredSize();
    dim.width = 250;
    setPreferredSize (dim); 
    Border wewGranica = BorderFactory.createTitledBorder("Aktualne dane");
    Border zewGranica = BorderFactory.createEmptyBorder(5,5,5,5);
    setBorder(BorderFactory.createCompoundBorder(zewGranica, wewGranica));
    
    ustawStarePolaDokumentu(dokument);
    panelGraficznyStaryDokument();
    
    }
    
    public void ustawStarePolaDokumentu(FormularzDokumentacja dokument){
     String id = String.valueOf(dokument.ID_Zwierzak);
    this.idZwierzakaStaraEtykieta = new JLabel(id);
    this.nazwaStaraEtykieta = new JLabel(dokument.nazwa);
    this.rodzajStaraEtykieta = new JLabel(dokument.rodzaj);
    this.miejsceStaraEtykieta = new JLabel(dokument.miejsce);

    }
    private void panelGraficznyStaryDokument() {
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
        add(idZwierzakaEtykieta, gc);
        
        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(idZwierzakaStaraEtykieta, gc);
        
        ////////////Drugi rzad///////////
        
        gc.gridy++;
        
        gc.weightx = 1;
        gc.weighty = 0.1;
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(nazwaEtykieta, gc);
        
        gc.gridx = 1;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(nazwaStaraEtykieta, gc);
        
                ////////////Drugi rzad///////////
        
        gc.gridy++;
        
        gc.weightx = 1;
        gc.weighty = 0.1;
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(rodzajEtykieta, gc);
        
        gc.gridx = 1;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(rodzajStaraEtykieta, gc);
        
        //////////////// NASTEPNY RZAD ///////////////////
        
        gc.gridy++;
        
        gc.weightx = 1;
        gc.weighty = 0.1;
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(miejsceEtykieta, gc);
        
        gc.gridx = 1;
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,5);
        add(miejsceStaraEtykieta, gc);

    }
}
