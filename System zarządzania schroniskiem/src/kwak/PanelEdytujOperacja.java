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

public class PanelEdytujOperacja extends JPanel {
        
    private JLabel idZwierzakaEtykieta = new JLabel ("ID Zwierzaka");
    private JLabel idKlientaEtykieta = new JLabel("ID Klienta ");;
    private JLabel idPracownikaEtykieta = new JLabel ("ID Pracownika: ");
    private JLabel rodzajOperacjiEtykieta = new JLabel ("Rodzaj operacji: ");
    private JLabel dodanieEtykieta = new JLabel ("Data dodania: ");
    private JLabel zakonczenieEtykieta = new JLabel ("Data zakonczenia: ");
    private JComboBox statusCombo = new JComboBox();

    
    private JTextField idZwierzakaPole = new JTextField(10);
    private JTextField idKlientaPole = new JTextField(10);
    private JTextField idPracownikaPole = new JTextField(10);
    private JTextField zakonczeniePole = new JTextField (10);
    private JCheckBox zaznaczBox;
    
    private PolaczenieOsobaGui polaczenie;
    
    private JCheckBox idZwierzakaBox = new JCheckBox();
    private JCheckBox idKlientaBox = new JCheckBox();
    private JCheckBox idPracownikaBox = new JCheckBox();
    private JCheckBox rodzajOperacjiBox = new JCheckBox();
    private JCheckBox dodanieBox = new JCheckBox();
    private JCheckBox zakonczenieBox = new JCheckBox();
    
    
    private JComboBox statusCombo2 = new JComboBox();
    private JComboBox statusCombo3 = new JComboBox();
    private JComboBox statusCombo4 = new JComboBox();
    
    private JComboBox zakonczCombo2 = new JComboBox();
    private JComboBox zakonczCombo3 = new JComboBox();
    private JComboBox zakonczCombo4 = new JComboBox();
    
    private String data = "";
    private String data2 = "";
    private String[] dniPrzybycie = new String[31];
    private String[] dniZwolnienie = new String[31];
    private String[] rokPrzybycie = new String[80];
    private String[] rokZwolnienie = new String[80];
    private String[] miesiacePrzybycie = new String[12];
    private String[] miesiaceZwolnienie = new String[12];
    
    public PanelEdytujOperacja(){ 
        Dimension dim = getPreferredSize();
        dim.width = 400;
        setPreferredSize (dim);   
        
        idZwierzakaEtykieta.setEnabled(false);
        idZwierzakaPole.setEnabled(false);
        idKlientaEtykieta.setEnabled(false);
        idKlientaPole.setEnabled(false);
        idPracownikaEtykieta.setEnabled(false);
        idPracownikaPole.setEnabled(false);
        rodzajOperacjiEtykieta.setEnabled(false);
        statusCombo.setEnabled(false);
        dodanieEtykieta.setEnabled(false);
        zakonczenieEtykieta.setEnabled(false);
        zakonczeniePole.setEnabled(false);
        statusCombo2.setEnabled(false);
        statusCombo3.setEnabled(false);
        statusCombo4.setEnabled(false);
        zakonczCombo2.setEnabled(false);
        zakonczCombo3.setEnabled(false);
        zakonczCombo4.setEnabled(false);
        
        DefaultComboBoxModel zaznaczBox = new DefaultComboBoxModel();
        zaznaczBox.addElement("Adopcja");
        zaznaczBox.addElement("Opłata");
        zaznaczBox.addElement("Kwarantanna");
        zaznaczBox.addElement("Szczepienie");
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
        statusCombo2.setModel(przybycieBox2);
        
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
        statusCombo3.setModel(przybycieBox3);
        
        //Wybor miesiaca
        DefaultComboBoxModel przybycieBox4 = new DefaultComboBoxModel();
        for (int i = 0 ; i < 12; i ++){
            for (int j = 1 ; j < 13 ; j++){
                String tmp = String.valueOf(j);
                miesiacePrzybycie[j-1] = tmp;
            }
        przybycieBox4.addElement(miesiacePrzybycie[i]);
        }
        statusCombo4.setModel(przybycieBox4);
        
        // Wybor dni
        DefaultComboBoxModel zwolnienieBox = new DefaultComboBoxModel();
        for (int i = 0 ; i < 31; i ++){
            for (int j = 1 ; j < 32 ; j++){
                String tmp = String.valueOf(j);
                dniZwolnienie[j-1] = tmp;
            }
        zwolnienieBox.addElement(dniZwolnienie[i]);
        }
        zakonczCombo2.setModel(zwolnienieBox);
        
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
        zakonczCombo3.setModel(zwolnienieBox2);
        
        //Wybor miesiaca
        DefaultComboBoxModel zwolnienieBox4 = new DefaultComboBoxModel();
        for (int i = 0 ; i < 12; i ++){
            for (int j = 1 ; j < 13 ; j++){
                String tmp = String.valueOf(j);
                miesiaceZwolnienie[j-1] = tmp;
            }
        zwolnienieBox4.addElement(miesiaceZwolnienie[i]);
        }
        zakonczCombo4.setModel(zwolnienieBox4);
        
        
        idZwierzakaBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                boolean zaznaczone = idZwierzakaBox.isSelected();
                idZwierzakaEtykieta.setEnabled(zaznaczone);
                idZwierzakaPole.setEnabled(zaznaczone);
            }
        });
        
        idKlientaBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                boolean zaznaczone = idKlientaBox.isSelected();
                idKlientaEtykieta.setEnabled(zaznaczone);
                idKlientaPole.setEnabled(zaznaczone);
            }
        });
        
        idPracownikaBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                boolean zaznaczone = idPracownikaBox.isSelected();
                idPracownikaEtykieta.setEnabled(zaznaczone);
                idPracownikaPole.setEnabled(zaznaczone);
            }
        });
        
        rodzajOperacjiBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                boolean zaznaczone = rodzajOperacjiBox.isSelected();
                rodzajOperacjiEtykieta.setEnabled(zaznaczone);
                statusCombo.setEnabled(zaznaczone);
            }
        });
        
        dodanieBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                boolean zaznaczone = dodanieBox.isSelected();
                dodanieEtykieta.setEnabled(zaznaczone);
                statusCombo2.setEnabled(zaznaczone);
                statusCombo3.setEnabled(zaznaczone);
                statusCombo4.setEnabled(zaznaczone);
            }
        });
        
        zakonczenieBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                boolean zaznaczone = zakonczenieBox.isSelected();
                zakonczenieEtykieta.setEnabled(zaznaczone);
                zakonczCombo2.setEnabled(zaznaczone);
                zakonczCombo3.setEnabled(zaznaczone);
                zakonczCombo4.setEnabled(zaznaczone);
            }
        });
        
        // ustawienie skrotow klawiszowych
        
        idZwierzakaEtykieta.setDisplayedMnemonic(KeyEvent.VK_Z);
        idZwierzakaEtykieta.setLabelFor(idZwierzakaPole);
        idKlientaEtykieta.setDisplayedMnemonic(KeyEvent.VK_K);
        idKlientaEtykieta.setLabelFor(idKlientaPole);
        idPracownikaEtykieta.setDisplayedMnemonic(KeyEvent.VK_P);
        idPracownikaEtykieta.setLabelFor(idPracownikaPole);
      
        Border wewGranica = BorderFactory.createTitledBorder("Formularz");
        Border zewGranica = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(zewGranica, wewGranica));
        panelGraficzny();
        
        
    }  

    public String getIdZwierzakaPole() {
        String nic = "";
        int nUl = 0;
        String nul = Integer.toString(nUl);
        if (idZwierzakaPole.getText().equals(nic))return nul;else return idZwierzakaPole.getText();
    }

    public String getIdKlientaPole() {
        String nic = "";
        int nUl = 0;
        String nul = Integer.toString(nUl);
        if (idKlientaPole.getText().equals(nic))return nul;else return idKlientaPole.getText();
    }

    public String getIdPracownikaPole() {
        String nic = "";
        int nUl = 0;
        String nul = Integer.toString(nUl);
        if (idPracownikaPole.getText().equals(nic))return nul; else return idPracownikaPole.getText();
    }

    public String getRodzajOperacjiPole() {
        String wybor = (String) statusCombo.getSelectedItem();
        return wybor;
    }

    public String getDodaniePole() {
        int rk = statusCombo3.getSelectedIndex();
        String Rok = rokPrzybycie[rk];
        data = Rok;
        
        int miech = statusCombo4.getSelectedIndex();
        String Miech = miesiacePrzybycie[miech];
        data = data + "-" + Miech;
        
        int dzn = statusCombo2.getSelectedIndex();
        String Dzn = dniPrzybycie[dzn];
        data = data + "-" + Dzn;
        return data;
    }

    public String getZakonczeniePole() {
        int rk = statusCombo3.getSelectedIndex();
        String Rok = rokZwolnienie[rk];
        data2 = Rok;
        
        int miech = statusCombo4.getSelectedIndex();
        String Miech = miesiaceZwolnienie[miech];
        data2 = data2 + "-" + Miech;
        
        int dzn = statusCombo2.getSelectedIndex();
        String Dzn = dniZwolnienie[dzn];
        data2 = data2 + "-" + Dzn;
        return data2;
    }
   

    
    public void pokazOperacje(PolaczenieOsobaGui Formularz){
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
        add(idZwierzakaBox, gc);
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(idZwierzakaEtykieta, gc);
        
        gc.gridx = 1;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(idZwierzakaPole, gc);
        
                ////////////Drugi rzad///////////
        
        gc.gridy++;
        
        gc.weightx = 1;
        gc.weighty = 0.1;
        
        gc.gridx = -1;
        add(idKlientaBox,gc);
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(idKlientaEtykieta, gc);
        
        gc.gridx = 1;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(idKlientaPole, gc);
        
        //////////////// NASTEPNY RZAD ///////////////////
        
        gc.gridy++;
        
        gc.weightx = 1;
        gc.weighty = 0.1;
        
        gc.gridx = -1;
        add(idPracownikaBox,gc);
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(idPracownikaEtykieta, gc);
        
        gc.gridx = 1;
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,5);
        add(idPracownikaPole, gc);
        
        
        /////////////// NASTEPNY RZAD ////////////////
        
        gc.gridy ++;
        
        gc.weightx = 1;
        gc.weighty = 0.1;
        
        gc.gridx = -1;
        add(rodzajOperacjiBox,gc);
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(rodzajOperacjiEtykieta ,gc);
        
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
        add(dodanieBox,gc);
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(dodanieEtykieta,gc);
        
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
        
        ////////////// NASTEPNY RZAD //////////////
        
        gc.gridy++;
        
        gc.weightx = 1;
        gc.weighty = 0.1;
        
        gc.gridx = -1;
        add(zakonczenieBox,gc);
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(zakonczenieEtykieta,gc);
        
        gc.gridx = 1;
        gc.gridy = 6;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(zakonczCombo3, gc);
        
        gc.gridx = 1;
        gc.gridy = 6;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,0);
        add(zakonczCombo4,gc);
        
        gc.gridx = 2;
        gc.gridy = 6;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,0);
        add(zakonczCombo2,gc);
        
     
    }

}

