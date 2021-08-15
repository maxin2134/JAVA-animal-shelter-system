package kwak;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class PanelEdytujDokumentacja extends JPanel {
        
    private JLabel idZwierzakaEtykieta = new JLabel ("ID Zwierzaka: ");
    private JLabel nazwaEtykieta = new JLabel("Nazwa dokumentu: ");;
    private JLabel rodzajEtykieta = new JLabel ("Rodzaj: ");
    private JLabel miejsceEtykieta = new JLabel ("Miejsce: ");
    
    private JTextField idZwierzakaPole = new JTextField(10);
    private JTextField nazwaPole = new JTextField(10);
    private JTextField rodzajPole = new JTextField(10);
    private JTextField miejscePole = new JTextField(10);
    
    private PolaczenieOsobaGui polaczenie;
    
    private JCheckBox idZwierzakaBox = new JCheckBox();
    private JCheckBox nazwaBox = new JCheckBox();
    private JCheckBox rodzajBox = new JCheckBox();
    private JCheckBox miejsceBox = new JCheckBox();

    
    public PanelEdytujDokumentacja(){ 
        Dimension dim = getPreferredSize();
        dim.width = 300;
        setPreferredSize (dim);   
        
        idZwierzakaEtykieta.setEnabled(false);
        idZwierzakaPole.setEnabled(false);
        nazwaEtykieta.setEnabled(false);
        nazwaPole.setEnabled(false);
        rodzajEtykieta.setEnabled(false);
        rodzajPole.setEnabled(false);
        miejsceEtykieta.setEnabled(false);
        miejscePole.setEnabled(false);

        
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
        
        nazwaBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                boolean zaznaczone = nazwaBox.isSelected();
                nazwaEtykieta.setEnabled(zaznaczone);
                nazwaPole.setEnabled(zaznaczone);
            }
        });
        
        idZwierzakaBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                boolean zaznaczone = idZwierzakaBox.isSelected();
                idZwierzakaEtykieta.setEnabled(zaznaczone);
                idZwierzakaPole.setEnabled(zaznaczone);
            }
        });
        
        rodzajBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                boolean zaznaczone = rodzajBox.isSelected();
                rodzajEtykieta.setEnabled(zaznaczone);
                rodzajPole.setEnabled(zaznaczone);
            }
        });
        
        miejsceBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                boolean zaznaczone = miejsceBox.isSelected();
                miejsceEtykieta.setEnabled(zaznaczone);
                miejscePole.setEnabled(zaznaczone);
            }
        });
        
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

 
    public void pokazDokument(PolaczenieOsobaGui Formularz){
    this.polaczenie = Formularz;
    }
    
    
    
    public void panelGraficzny(){
        
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        
        //////////Pierwszy rzad///////
        gc.gridy = 0;
        
        gc.weightx = 1;
        gc.weighty = 0.1;
        
        gc.gridx = -1;
        add(idZwierzakaBox,gc);

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
        
        gc.gridx = -1;
        add(nazwaBox, gc);
        
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
        
        gc.gridx = -1;
        add(rodzajBox,gc);
        
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
        
        gc.gridx = -1;
        add(miejsceBox,gc);
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(miejsceEtykieta, gc);
        
        gc.gridx = 1;
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,5);
        add(miejscePole, gc);   
     
    }

}

