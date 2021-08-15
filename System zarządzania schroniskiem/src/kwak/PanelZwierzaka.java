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

public class PanelZwierzaka extends JPanel {
    
    private JLabel idKlientaEtykieta = new JLabel ("ID Klienta");
    private JLabel imieEtykieta = new JLabel("Imie ");;
    private JLabel rasaEtykieta = new JLabel ("Rasa: ");
    private JLabel gatunekEtykieta = new JLabel ("Gatunek: ");
    private JLabel plecEtykieta = new JLabel ("Płeć: ");
    private JLabel przybycieEtykieta = new JLabel ("Data przybycia: ");
    
    
    private JTextField idKlientaPole = new JTextField(10);
    private JTextField imiePole = new JTextField(10);
    private JTextField rasaPole = new JTextField(10);
    private JTextField gatunekPole = new JTextField(10);
    private PolaczenieZwierzakGui polaczenie;
    private JComboBox statusCombo = new JComboBox();
    
    private JComboBox statusCombo2 = new JComboBox();
    private JComboBox statusCombo3 = new JComboBox();
    private JComboBox statusCombo4 = new JComboBox();
    
    private String data = "";
    private String[] dni = new String[31];
    private String[] rok = new String[80];
    private String[] miesiace = new String[12];
    
    public PanelZwierzaka(){ 
        Dimension dim = getPreferredSize();
        dim.width = 300;
        setPreferredSize (dim);        
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
        
        DefaultComboBoxModel zaznaczBox = new DefaultComboBoxModel();
        zaznaczBox.addElement("Męska");
        zaznaczBox.addElement("Żeńska");
        statusCombo.setModel(zaznaczBox);
        
        // Wybor dni
        DefaultComboBoxModel zaznaczBox2 = new DefaultComboBoxModel();
        for (int i = 0 ; i < 31; i ++){
            for (int j = 1 ; j < 32 ; j++){
                String tmp = String.valueOf(j);
                dni[j-1] = tmp;
            }
        zaznaczBox2.addElement(dni[i]);
        }
        statusCombo2.setModel(zaznaczBox2);
        
        // Wybor roku
        DefaultComboBoxModel zaznaczBox3 = new DefaultComboBoxModel();
        for (int i = 0 ; i < 80; i ++){
            for (int j = 1 ; j < 81 ; j++){
                int itmp = j + 2019;
                String tmp = String.valueOf(itmp);
                rok[j-1] = tmp;
            }
        zaznaczBox3.addElement(rok[i]);
        }
        statusCombo3.setModel(zaznaczBox3);
        
        //Wybor miesiaca
        DefaultComboBoxModel zaznaczBox4 = new DefaultComboBoxModel();
        for (int i = 0 ; i < 12; i ++){
            for (int j = 1 ; j < 13 ; j++){
                String tmp = String.valueOf(j);
                miesiace[j-1] = tmp;
            }
        zaznaczBox4.addElement(miesiace[i]);
        }
        statusCombo4.setModel(zaznaczBox4);
        
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

    public String getPlecPole() {
    String wybor = (String) statusCombo.getSelectedItem();
        return wybor;
    }

    public String getPrzybyciePole() {
        
        int rk = statusCombo3.getSelectedIndex();
        String Rok = rok[rk];
        data = Rok;
        
        int miech = statusCombo4.getSelectedIndex();
        String Miech = miesiace[miech];
        data = data + "-" + Miech;
        
        int dzn = statusCombo2.getSelectedIndex();
        String Dzn = dni[dzn];
        data = data + "-" + Dzn;
        return data;
    }

    

    

    public FormularzZwierzaka ZwrocZwierzaka (){
        int ID = 0;     
        String idklienta = idKlientaPole.getText();
        if ("".equals(idklienta))idklienta="0";
        int ID_klienta = Integer.parseInt(idklienta);
        String imie = imiePole.getText();
        String rasa = rasaPole.getText();
        String gatunek = gatunekPole.getText();
        String wybor = (String) statusCombo.getSelectedItem();
        
        int rk = statusCombo3.getSelectedIndex();
        String Rok = rok[rk];
        data = Rok;
        
        int miech = statusCombo4.getSelectedIndex();
        String Miech = miesiace[miech];
        data = data + "-" + Miech;
        
        int dzn = statusCombo2.getSelectedIndex();
        String Dzn = dni[dzn];
        data = data + "-" + Dzn;
        
        String zwolnienie = "";
        String opis = "";
                        
        FormularzZwierzaka FO = new FormularzZwierzaka(this,ID, ID_klienta ,imie,rasa,gatunek,wybor,data,zwolnienie,opis);
       
        return FO;
    }
    
    public void pokazOsobe(PolaczenieZwierzakGui Formularz){
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
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(gatunekEtykieta, gc);
        
        gc.gridx = 1;
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(gatunekPole, gc);
        
        
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
        gc.insets = new Insets (0,0,0,0);
        add(statusCombo, gc);
        
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
        gc.insets = new Insets (0,0,0,0);
        add(statusCombo3, gc);
        
        gc.gridx = 1;
        gc.gridy = 5;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,0);
        add(statusCombo4,gc);
        
        gc.gridx = 2;
        gc.gridy = 5;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,0);
        add(statusCombo2,gc);
        
        
        
    }

}

