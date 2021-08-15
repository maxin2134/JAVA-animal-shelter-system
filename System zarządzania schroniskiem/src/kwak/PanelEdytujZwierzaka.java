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

public class PanelEdytujZwierzaka extends JPanel {
        
    private JLabel idKlientaEtykieta = new JLabel ("ID Klienta");
    private JLabel imieEtykieta = new JLabel("Imie ");;
    private JLabel rasaEtykieta = new JLabel ("Rasa: ");
    private JLabel gatunekEtykieta = new JLabel ("Gatunek: ");
    private JLabel plecEtykieta = new JLabel ("Płeć: ");
    private JLabel przybycieEtykieta = new JLabel ("Data przybycia: ");
    private JLabel zwolnienieEtykieta = new JLabel ("Data zwolnienia: ");

    private JTextField idKlientaPole = new JTextField(10);
    private JTextField imiePole = new JTextField(10);
    private JTextField rasaPole = new JTextField(10);
    private JTextField gatunekPole = new JTextField(10);
    
    private PolaczenieOsobaGui polaczenie;
    
    private JCheckBox idKlientaBox = new JCheckBox();
    private JCheckBox imieBox = new JCheckBox();
    private JCheckBox rasaBox = new JCheckBox();
    private JCheckBox gatunekBox = new JCheckBox();
    private JCheckBox plecBox = new JCheckBox();
    private JCheckBox przybycieBox = new JCheckBox();
    private JCheckBox zwolninieBox = new JCheckBox();
    
    private JComboBox statusCombo = new JComboBox();
    private JComboBox przybycieCombo2 = new JComboBox();
    private JComboBox przybycieCombo3 = new JComboBox();
    private JComboBox przybycieCombo4 = new JComboBox();
    private JComboBox zwolnienieCombo = new JComboBox();
    private JComboBox zwolnienieCombo2 = new JComboBox();
    private JComboBox zwolnienieCombo3 = new JComboBox();
    
    
    private String data = "";
    private String data2 = "";
    private String[] dniPrzybycie = new String[31];
    private String[] dniZwolnienie = new String[31];
    private String[] rokPrzybycie = new String[80];
    private String[] rokZwolnienie = new String[80];
    private String[] miesiacePrzybycie = new String[12];
    private String[] miesiaceZwolnienie = new String[12];
    
    public PanelEdytujZwierzaka(){ 
        Dimension dim = getPreferredSize();
        dim.width = 300;
        setPreferredSize (dim);   
        
        idKlientaEtykieta.setEnabled(false);
        idKlientaPole.setEnabled(false);
        imieEtykieta.setEnabled(false);
        imiePole.setEnabled(false);
        rasaEtykieta.setEnabled(false);
        rasaPole.setEnabled(false);
        gatunekEtykieta.setEnabled(false);
        gatunekPole.setEnabled(false);
        plecEtykieta.setEnabled(false);
        statusCombo.setEnabled(false);
        przybycieEtykieta.setEnabled(false);
        przybycieCombo2.setEnabled(false);
        przybycieCombo3.setEnabled(false);
        przybycieCombo4.setEnabled(false);
        zwolnienieCombo.setEnabled(false);
        zwolnienieCombo2.setEnabled(false);
        zwolnienieCombo3.setEnabled(false);
        zwolnienieEtykieta.setEnabled(false);
        
        
        DefaultComboBoxModel zaznaczBox = new DefaultComboBoxModel();
        zaznaczBox.addElement("Męska");
        zaznaczBox.addElement("Żeńska");
        statusCombo.setModel(zaznaczBox);
        
        // Wybor dni
        DefaultComboBoxModel przybycieBox2 = new DefaultComboBoxModel();
        for (int i = 0 ; i < 31; i ++){
            for (int j = 1 ; j < 32 ; j++){
                String tmp = String.valueOf(j);
                dniPrzybycie[j-1] = tmp;
            }
        przybycieBox2.addElement(dniPrzybycie[i]);
        }
        przybycieCombo2.setModel(przybycieBox2);
        
        // Wybor roku
        DefaultComboBoxModel przybycieBox3 = new DefaultComboBoxModel();
        for (int i = 0 ; i < 80; i ++){
            for (int j = 1 ; j < 81 ; j++){
                int itmp = j + 2019;
                String tmp = String.valueOf(itmp);
                rokPrzybycie[j-1] = tmp;
            }
        przybycieBox3.addElement(rokPrzybycie[i]);
        }
        przybycieCombo3.setModel(przybycieBox3);
        
        //Wybor miesiaca
        DefaultComboBoxModel przybycieBox4 = new DefaultComboBoxModel();
        for (int i = 0 ; i < 12; i ++){
            for (int j = 1 ; j < 13 ; j++){
                String tmp = String.valueOf(j);
                miesiacePrzybycie[j-1] = tmp;
            }
        przybycieBox4.addElement(miesiacePrzybycie[i]);
        }
        przybycieCombo4.setModel(przybycieBox4);
        
        // Wybor dni
        DefaultComboBoxModel zwolnienieBox = new DefaultComboBoxModel();
        for (int i = 0 ; i < 31; i ++){
            for (int j = 1 ; j < 32 ; j++){
                String tmp = String.valueOf(j);
                dniZwolnienie[j-1] = tmp;
            }
        zwolnienieBox.addElement(dniZwolnienie[i]);
        }
        zwolnienieCombo.setModel(zwolnienieBox);
        
        // Wybor roku
        DefaultComboBoxModel zwolnienieBox2 = new DefaultComboBoxModel();
        for (int i = 0 ; i < 80; i ++){
            for (int j = 1 ; j < 81 ; j++){
                int itmp = j + 2019;
                String tmp = String.valueOf(itmp);
                rokZwolnienie[j-1] = tmp;
            }
        zwolnienieBox2.addElement(rokZwolnienie[i]);
        }
        zwolnienieCombo2.setModel(zwolnienieBox2);
        
        //Wybor miesiaca
        DefaultComboBoxModel zwolnienieBox4 = new DefaultComboBoxModel();
        for (int i = 0 ; i < 12; i ++){
            for (int j = 1 ; j < 13 ; j++){
                String tmp = String.valueOf(j);
                miesiaceZwolnienie[j-1] = tmp;
            }
        zwolnienieBox4.addElement(miesiaceZwolnienie[i]);
        }
        zwolnienieCombo3.setModel(zwolnienieBox4);
        
        
        idKlientaBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                boolean zaznaczone = idKlientaBox.isSelected();
                idKlientaEtykieta.setEnabled(zaznaczone);
                idKlientaPole.setEnabled(zaznaczone);
            }
        });
        
        imieBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                boolean zaznaczone = imieBox.isSelected();
                imieEtykieta.setEnabled(zaznaczone);
                imiePole.setEnabled(zaznaczone);
            }
        });
        
        rasaBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                boolean zaznaczone = rasaBox.isSelected();
                rasaEtykieta.setEnabled(zaznaczone);
                rasaPole.setEnabled(zaznaczone);
            }
        });
        
        gatunekBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                boolean zaznaczone = gatunekBox.isSelected();
                gatunekEtykieta.setEnabled(zaznaczone);
                gatunekPole.setEnabled(zaznaczone);
            }
        });
        
        plecBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                boolean zaznaczone = plecBox.isSelected();
                plecEtykieta.setEnabled(zaznaczone);
                statusCombo.setEnabled(zaznaczone);
            }
        });
        
        przybycieBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                boolean zaznaczone = przybycieBox.isSelected();
                przybycieEtykieta.setEnabled(zaznaczone);
                przybycieCombo2.setEnabled(zaznaczone);
                przybycieCombo3.setEnabled(zaznaczone);
                przybycieCombo4.setEnabled(zaznaczone);
            }
        });
        
        zwolninieBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                boolean zaznaczone = zwolninieBox.isSelected();
                zwolnienieEtykieta.setEnabled(zaznaczone);
                zwolnienieCombo.setEnabled(zaznaczone);
                zwolnienieCombo2.setEnabled(zaznaczone);
                zwolnienieCombo3.setEnabled(zaznaczone);
            }
        });
        
        // ustawienie skrotow klawiszowych
        
        idKlientaEtykieta.setDisplayedMnemonic(KeyEvent.VK_K);
        idKlientaEtykieta.setLabelFor(idKlientaPole);
        imieEtykieta.setDisplayedMnemonic(KeyEvent.VK_I);
        imieEtykieta.setLabelFor(imiePole);
        rasaEtykieta.setDisplayedMnemonic(KeyEvent.VK_R);
        rasaEtykieta.setLabelFor(rasaPole);
        gatunekEtykieta.setDisplayedMnemonic(KeyEvent.VK_G);
        gatunekEtykieta.setLabelFor(gatunekPole);
      
        Border wewGranica = BorderFactory.createTitledBorder("Formularz");
        Border zewGranica = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(zewGranica, wewGranica));
        panelGraficzny();
        
        
    }  

    public String getIdKlientaPole() {
        return idKlientaPole.getText();
    }

    public String getImiePole() {
        return imiePole.getText();
    }

    public String getRasaPole() {
        return rasaPole.getText();
    }

    public String getGatunekPole() {
        return gatunekPole.getText();
    }
    
    public String getPlecPole(){
        if(plecBox.isSelected()){
        String wybor = (String) statusCombo.getSelectedItem();
        return wybor;
        }
        else return "";
    
    }
    
    public String getPrzybyciePole(){
        
        if (przybycieBox.isSelected()){
        int rk = przybycieCombo3.getSelectedIndex();
        String Rok = rokPrzybycie[rk];
        data = Rok;
        
        int miech = przybycieCombo4.getSelectedIndex();
        String Miech = miesiacePrzybycie[miech];
        data = data + "-" + Miech;
        
        int dzn = przybycieCombo2.getSelectedIndex();
        String Dzn = dniPrzybycie[dzn];
        data = data + "-" + Dzn;
        return data;}else return "";
    }
    
    public String getZwolnieniePole(){
        if (zwolninieBox.isSelected()){
        int rk = zwolnienieCombo2.getSelectedIndex();
        String Rok = rokZwolnienie[rk];
        data2 = Rok;
        
        int miech = zwolnienieCombo3.getSelectedIndex();
        String Miech = miesiaceZwolnienie[miech];
        data2 = data2 + "-" + Miech;
        
        int dzn = zwolnienieCombo.getSelectedIndex();
        String Dzn = dniZwolnienie[dzn];
        data2 = data2 + "-" + Dzn;
        return data2;}else return "";
    }
   

    
    public void pokazOsobe(PolaczenieOsobaGui Formularz){
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
        add(idKlientaBox,gc);

        gc.gridx = 0;    
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(idKlientaEtykieta, gc);
        
        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(idKlientaPole, gc);
        
        ////////////Drugi rzad///////////
        
        gc.gridy++;
        
        gc.weightx = 1;
        gc.weighty = 0.1;
        
        gc.gridx = -1;
        add(imieBox, gc);
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(imieEtykieta, gc);
        
        gc.gridx = 1;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(imiePole, gc);
        
                ////////////Drugi rzad///////////
        
        gc.gridy++;
        
        gc.weightx = 1;
        gc.weighty = 0.1;
        
        gc.gridx = -1;
        add(rasaBox,gc);
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(rasaEtykieta, gc);
        
        gc.gridx = 1;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(rasaPole, gc);
        
        //////////////// NASTEPNY RZAD ///////////////////
        
        gc.gridy++;
        
        gc.weightx = 1;
        gc.weighty = 0.1;
        
        gc.gridx = -1;
        add(gatunekBox,gc);
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(gatunekEtykieta, gc);
        
        gc.gridx = 1;
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,5);
        add(gatunekPole, gc);
        
        
        /////////////// NASTEPNY RZAD ////////////////
        
        gc.gridy ++;
        
        gc.weightx = 1;
        gc.weighty = 0.1;
        
        gc.gridx = -1;
        add(plecBox,gc);
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(plecEtykieta ,gc);
        
        gc.gridx = 1;
        gc.gridy = 4;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,0);
        add(statusCombo,gc);
        
        /////////////// NASTEPNY RZAD ///////
        
        gc.gridy++;
        
        gc.weightx = 1;
        gc.weighty = 0.1;
        
        gc.gridx = -1;
        add(przybycieBox,gc);
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(przybycieEtykieta,gc);
        
        gc.gridx = 1;
        gc.gridy = 5;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(przybycieCombo3, gc);
        
        gc.gridx = 1;
        gc.gridy = 5;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,0);
        add(przybycieCombo4,gc);
        
        gc.gridx = 2;
        gc.gridy = 5;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,0);
        add(przybycieCombo2,gc);
        
        ////////////// NASTEPNY RZAD //////////////
        
        gc.gridy++;
        
        gc.weightx = 1;
        gc.weighty = 0.1;
        
        gc.gridx = -1;
        add(zwolninieBox,gc);
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(zwolnienieEtykieta,gc);
        
        gc.gridx = 1;
        gc.gridy = 6;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(zwolnienieCombo2, gc);
        
        gc.gridx = 1;
        gc.gridy = 6;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,0);
        add(zwolnienieCombo3,gc);
        
        gc.gridx = 2;
        gc.gridy = 6;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,0);
        add(zwolnienieCombo,gc);
        
     
    }

}

