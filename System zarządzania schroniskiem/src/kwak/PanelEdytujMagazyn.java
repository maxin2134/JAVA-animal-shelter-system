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

public class PanelEdytujMagazyn extends JPanel {
        
    private JLabel idPracownikaEtykieta = new JLabel ("ID Pracownika");
    private JLabel nazwaEtykieta = new JLabel("Nazwa ");;
    private JLabel iloscEtykieta = new JLabel ("Ilosc: ");
    private JLabel waznoscEtykieta = new JLabel ("Data wazności: ");
    private JLabel gramaturaEtykieta = new JLabel ("Gramatura: ");
    private JLabel pojemnikEtykieta = new JLabel ("Pojemnik: ");
    private JLabel polozenieEtykieta = new JLabel ("Polozenie: ");
    
    private JTextField idPracownikaPole = new JTextField(10);
    private JTextField nazwaPole = new JTextField(10);
    private JTextField iloscPole = new JTextField(10);
    private JTextField gramaturaPole = new JTextField (10);
    private JTextField pojemnikPole = new JTextField (10);
    private JTextField polozeniePole = new JTextField (10);
    
    private PolaczenieOsobaGui polaczenie;
    
    private JCheckBox idPracownikaBox = new JCheckBox();
    private JCheckBox nazwaBox = new JCheckBox();
    private JCheckBox iloscBox = new JCheckBox();
    private JCheckBox waznoscBox = new JCheckBox();
    private JCheckBox gramaturaBox = new JCheckBox();
    private JCheckBox pojemnikBox = new JCheckBox();
    private JCheckBox polozenieBox = new JCheckBox();
    
    private JComboBox statusCombo = new JComboBox();
    private JComboBox statusCombo2 = new JComboBox();
    private JComboBox statusCombo3 = new JComboBox();
    
    private String data = "";
    private String[] dni = new String[31];
    private String[] rok = new String[80];
    private String[] miesiace = new String[12];
    
    public PanelEdytujMagazyn(){ 
        Dimension dim = getPreferredSize();
        dim.width = 350;
        setPreferredSize (dim);   
        
        idPracownikaEtykieta.setEnabled(false);
        idPracownikaPole.setEnabled(false);
        nazwaEtykieta.setEnabled(false);
        nazwaPole.setEnabled(false);
        iloscEtykieta.setEnabled(false);
        iloscPole.setEnabled(false);
        waznoscEtykieta.setEnabled(false);
        statusCombo.setEnabled(false);
        statusCombo2.setEnabled(false);
        statusCombo3.setEnabled(false);
        gramaturaEtykieta.setEnabled(false);
        gramaturaPole.setEnabled(false);
        pojemnikEtykieta.setEnabled(false);
        pojemnikPole.setEnabled(false);
        polozenieEtykieta.setEnabled(false);
        polozeniePole.setEnabled(false);
        
        
        
        
        // Wybor dni
        DefaultComboBoxModel zaznaczBox = new DefaultComboBoxModel();
        for (int i = 0 ; i < 31; i ++){
            for (int j = 1 ; j < 32 ; j++){
                String tmp = String.valueOf(j);
                dni[j-1] = tmp;
            }
        zaznaczBox.addElement(dni[i]);
        }
        statusCombo.setModel(zaznaczBox);
        
        // Wybor roku
        DefaultComboBoxModel zaznaczBox2 = new DefaultComboBoxModel();
        for (int i = 0 ; i < 80; i ++){
            for (int j = 1 ; j < 81 ; j++){
                int itmp = j + 2019;
                String tmp = String.valueOf(itmp);
                rok[j-1] = tmp;
            }
        zaznaczBox2.addElement(rok[i]);
        }
        statusCombo2.setModel(zaznaczBox2);
        
        //Wybor miesiaca
        DefaultComboBoxModel zaznaczBox3 = new DefaultComboBoxModel();
        for (int i = 0 ; i < 12; i ++){
            for (int j = 1 ; j < 13 ; j++){
                String tmp = String.valueOf(j);
                miesiace[j-1] = tmp;
            }
        zaznaczBox3.addElement(miesiace[i]);
        }
        statusCombo3.setModel(zaznaczBox3);
        
        idPracownikaBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                boolean zaznaczone = idPracownikaBox.isSelected();
                idPracownikaEtykieta.setEnabled(zaznaczone);
                idPracownikaPole.setEnabled(zaznaczone);
            }
        });
        
        nazwaBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                boolean zaznaczone = waznoscBox.isSelected();
                nazwaEtykieta.setEnabled(zaznaczone);
                nazwaPole.setEnabled(zaznaczone);
            }
        });
        
        iloscBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                boolean zaznaczone = iloscBox.isSelected();
                iloscEtykieta.setEnabled(zaznaczone);
                iloscPole.setEnabled(zaznaczone);
            }
        });      
        
        waznoscBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                boolean zaznaczone = waznoscBox.isSelected();
                waznoscEtykieta.setEnabled(zaznaczone);
                statusCombo.setEnabled(zaznaczone);
                statusCombo2.setEnabled(zaznaczone);
                statusCombo3.setEnabled(zaznaczone);
            }
        });
        
        gramaturaBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                boolean zaznaczone = gramaturaBox.isSelected();
                gramaturaEtykieta.setEnabled(zaznaczone);
                gramaturaPole.setEnabled(zaznaczone);
            }
        });
        
        pojemnikBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                boolean zaznaczone = pojemnikBox.isSelected();
                pojemnikEtykieta.setEnabled(zaznaczone);
                pojemnikPole.setEnabled(zaznaczone);
            }
        });
        
       polozenieBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                boolean zaznaczone = polozenieBox.isSelected();
                polozenieEtykieta.setEnabled(zaznaczone);
                polozeniePole.setEnabled(zaznaczone);
            }
        });
        
        // ustawienie skrotow klawiszowych
        
        idPracownikaEtykieta.setDisplayedMnemonic(KeyEvent.VK_P);
        idPracownikaEtykieta.setLabelFor(idPracownikaPole);
        nazwaEtykieta.setDisplayedMnemonic(KeyEvent.VK_N);
        nazwaEtykieta.setLabelFor(nazwaPole);
        iloscEtykieta.setDisplayedMnemonic(KeyEvent.VK_I);
        iloscEtykieta.setLabelFor(iloscPole);
        gramaturaEtykieta.setDisplayedMnemonic(KeyEvent.VK_G);
        gramaturaEtykieta.setLabelFor(gramaturaPole);
        pojemnikEtykieta.setDisplayedMnemonic(KeyEvent.VK_O);
        pojemnikEtykieta.setLabelFor(pojemnikPole);
        polozenieEtykieta.setDisplayedMnemonic(KeyEvent.VK_P);
        polozenieEtykieta.setLabelFor(polozeniePole);
      
        Border wewGranica = BorderFactory.createTitledBorder("Formularz");
        Border zewGranica = BorderFactory.createEmptyBorder(15,15,15,15);
        setBorder(BorderFactory.createCompoundBorder(zewGranica, wewGranica));
        panelGraficzny();
        
        
    }  

    public String getIdPracownikaPole() {
        return idPracownikaPole.getText();
    }

    public String getNazwaPole() {
        return nazwaPole.getText();
    }

    public String getIloscPole() {
        return iloscPole.getText();
    }

    public String getGramaturaPole() {
        return gramaturaPole.getText();
    }

    public String getPojemnikPole() {
        return pojemnikPole.getText();
    }

    public String getPolozeniePole() {
        return polozeniePole.getText();
    }


    
    public String getWaznoscPole(){
        
        if (waznoscBox.isSelected()){
        int rk = statusCombo2.getSelectedIndex();
        String Rok = rok[rk];
        data = Rok;
        
        int miech = statusCombo3.getSelectedIndex();
        String Miech = miesiace[miech];
        data = data + "-" + Miech;
        
        int dzn = statusCombo.getSelectedIndex();
        String Dzn = dni[dzn];
        data = data + "-" + Dzn;
        return data;}else return "";
    }


    
    public void pokazTowar(PolaczenieOsobaGui Formularz){
    this.polaczenie = Formularz;
    }
    
    
    
    public void panelGraficzny(){
        
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        
        //////////Pierwszy rzad///////
        gc.gridy = 0;
        
        gc.weightx = 1;
        gc.weighty = 0.1;
        
        gc.gridx = 2;
        add(idPracownikaBox,gc);

        gc.gridx = 0;    
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(idPracownikaEtykieta, gc);
        
        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(idPracownikaPole, gc);
        
        ////////////Drugi rzad///////////
        
        gc.gridy++;
        
        gc.weightx = 1;
        gc.weighty = 0.1;
        
        gc.gridx = 2;
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
        
        gc.gridx = 2;
        add(iloscBox,gc);
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(iloscEtykieta, gc);
        
        gc.gridx = 1;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(iloscPole, gc);
        
        //////////////// NASTEPNY RZAD ///////////////////
        
        gc.gridy++;
        
        gc.weightx = 1;
        gc.weighty = 0.1;
        
        gc.gridx = 4;
        add(waznoscBox,gc);
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(waznoscEtykieta, gc);
        
        gc.gridx = 1;
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,5);
        add(statusCombo2, gc);
        
        gc.gridx = 2;
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,5);
        add(statusCombo3, gc);
        
        gc.gridx = 3;
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,5);
        add(statusCombo, gc);
        
        /////////////// NASTEPNY RZAD ////////////////
        
        gc.gridy ++;
        
        gc.weightx = 1;
        gc.weighty = 0.1;
        
        gc.gridx = 2;
        add(gramaturaBox,gc);
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(gramaturaEtykieta ,gc);
        
        gc.gridx = 1;
        gc.gridy = 4;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,0);
        add(gramaturaPole,gc);
        
        /////////////// NASTEPNY RZAD ///////
        
        gc.gridy++;
        
        gc.weightx = 1;
        gc.weighty = 0.1;
        
        gc.gridx = 2;
        add(pojemnikBox,gc);
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(pojemnikEtykieta,gc);
        
        gc.gridx = 1;
        gc.gridy = 5;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(pojemnikPole, gc);
       
        
        ////////////// NASTEPNY RZAD //////////////
        
        gc.gridy++;
        
        gc.weightx = 1;
        gc.weighty = 0.1;
        
        gc.gridx = 2;
        add(polozenieBox,gc);
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(polozenieEtykieta,gc);
        
        gc.gridx = 1;
        gc.gridy = 6;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(polozeniePole, gc);

    }

}

