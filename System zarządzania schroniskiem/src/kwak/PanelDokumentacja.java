package kwak;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class PanelDokumentacja extends JPanel {
    
    private JLabel idZwierzakaEtykieta = new JLabel ("ID Zwierzaka: ");
    private JLabel nazwaEtykieta = new JLabel("Nazwa dokumentu: ");;
    private JLabel rodzajEtykieta = new JLabel ("Rodzaj: ");
    private JLabel miejsceEtykieta = new JLabel ("Miejsce: ");
    
    private JTextField idZwierzakaPole = new JTextField(10);
    private JTextField nazwaPole = new JTextField(10);
    private JTextField rodzajPole = new JTextField(10);
    private JTextField miejscePole = new JTextField(10);

    private PolaczenieDokumentacjaGui polaczenie;
    private JCheckBox zaznaczBox;
    
    public PanelDokumentacja(){ 
        Dimension dim = getPreferredSize();
        dim.width = 300;
        setPreferredSize (dim);        
        zaznaczBox = new JCheckBox();
        
        // ustawienie skrotow klawiszowych
        
        idZwierzakaEtykieta.setDisplayedMnemonic(KeyEvent.VK_Z);
        idZwierzakaEtykieta.setLabelFor(idZwierzakaPole);
        nazwaEtykieta.setDisplayedMnemonic(KeyEvent.VK_N);
        nazwaEtykieta.setLabelFor(nazwaPole);
        rodzajEtykieta.setDisplayedMnemonic(KeyEvent.VK_R);
        rodzajEtykieta.setLabelFor(rodzajPole);
        miejsceEtykieta.setDisplayedMnemonic(KeyEvent.VK_M);
        miejsceEtykieta.setLabelFor(miejscePole);
        
        Border wewGranica = BorderFactory.createTitledBorder("Formularz");
        Border zewGranica = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(zewGranica, wewGranica));
        panelGraficzny();
        
        
    }  

    public String getIdZwierzakaPole() {
        return idZwierzakaPole.getText();
    }

    public String getNazwaPole() {
        return nazwaPole.getText();
    }

    public String getRodzajPole() {
        return rodzajPole.getText();
    }

    public String getMiejscePole() {
        return miejscePole.getText();
    }


    public FormularzDokumentacja ZwrocDokument (){
        int ID = 0;     
        String idklienta = idZwierzakaPole.getText();
        int id = Integer.valueOf(idklienta);
        String nazwa = nazwaPole.getText();
        String rodzaj = rodzajPole.getText();
        String miejsce = miejscePole.getText();

                        
        FormularzDokumentacja FO = new FormularzDokumentacja(this,ID, id ,nazwa,rodzaj,miejsce);
       
        return FO;
    }
    
    public void pokazDokumentacje(PolaczenieDokumentacjaGui Formularz){
    this.polaczenie = Formularz;
    }
        
    public void panelGraficzny(){
        
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        //////////Pierwszy rzad///////
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
        add(idZwierzakaPole, gc);
        
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
        add(nazwaPole, gc);
        
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
        add(rodzajPole, gc);
        
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
        gc.insets = new Insets (0,0,0,0);
        add(miejscePole, gc);
    }

}

