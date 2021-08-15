
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

public class AktualnaOperacja extends JPanel {
    private JFrame f = new JFrame();

    private JLabel idZwierzakaEtykieta = new JLabel ("ID Zwierzaka: ");
    private JLabel idKlientaEtykieta = new JLabel("ID Klienta: ");;
    private JLabel idPracownikaEtykieta = new JLabel ("ID Pracownika: ");
    private JLabel rodzajOperacjiEtykieta = new JLabel ("Rodzaj operacji: ");
    private JLabel dataDodaniaEtykieta = new JLabel ("Data dodania: ");
    private JLabel dataZakonczeniaEtykieta = new JLabel ("Data zakonczenia: ");
    
    private JLabel idZwierzakaStaraEtykieta;
    private JLabel idKlientaStaraEtykieta;
    private JLabel idPracownikaStaraEtykieta;
    private JLabel rodzajOperacjiStaraEtykieta;
    private JLabel dataDodaniaStaraEtykieta;
    private JLabel dataZakonczeniaStaraEtykieta;
    
    
    AktualnaOperacja(FormularzOperacja operacja){
        
    Dimension dim = getPreferredSize();
    dim.width = 250;
    setPreferredSize (dim); 
    Border wewGranica = BorderFactory.createTitledBorder("Aktualne dane");
    Border zewGranica = BorderFactory.createEmptyBorder(5,5,5,5);
    setBorder(BorderFactory.createCompoundBorder(zewGranica, wewGranica));
    
    ustawStarePolaOperacji(operacja);
    panelGraficznyStaryDokument();
    
    }
    
    public void ustawStarePolaOperacji(FormularzOperacja operacja){
    String id_zwierzaka = String.valueOf(operacja.ID_Zwierzak);
    this.idZwierzakaStaraEtykieta = new JLabel(id_zwierzaka);
    
    String id_klienta = String.valueOf(operacja.ID_Klient);
    this.idKlientaStaraEtykieta = new JLabel(id_klienta);
    
    String id_pracownika = String.valueOf(operacja.ID_Pracownik);
    this.idPracownikaStaraEtykieta = new JLabel(id_pracownika);
    
    this.rodzajOperacjiStaraEtykieta = new JLabel(operacja.Rodzaj_Operacja);
    this.dataDodaniaStaraEtykieta = new JLabel(operacja.Dodanie);
    this.dataZakonczeniaStaraEtykieta = new JLabel(operacja.Zakonczenie);
    
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
        add(idKlientaEtykieta, gc);
        
        gc.gridx = 1;
        gc.gridy = 1;
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
        add(idPracownikaEtykieta, gc);
        
        gc.gridx = 1;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(idPracownikaStaraEtykieta, gc);
        
        //////////////// NASTEPNY RZAD ///////////////////
        
        gc.gridy++;
        
        gc.weightx = 1;
        gc.weighty = 0.1;
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(rodzajOperacjiEtykieta, gc);
        
        gc.gridx = 1;
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,5);
        add(rodzajOperacjiStaraEtykieta, gc);
        
        
        /////////////// NASTEPNY RZAD ////////////////
        
        gc.gridy ++;
        
        gc.weightx = 1;
        gc.weighty = 0.1;
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(dataDodaniaEtykieta ,gc);
        
        gc.gridx = 1;
        gc.gridy = 4;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,5);
        add(dataDodaniaStaraEtykieta, gc);
        
        /////////////// NASTEPNY RZAD ///////
        
        gc.gridy++;
        
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(dataZakonczeniaEtykieta,gc);
        
        gc.gridx = 1;
        gc.gridy = 5;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,5);
        add(dataZakonczeniaStaraEtykieta,gc);
    }
}
