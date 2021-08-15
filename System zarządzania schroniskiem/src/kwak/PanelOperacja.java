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

public class PanelOperacja extends JPanel {
    
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
    private PolaczenieOperacjaGui polaczenie;
    private JCheckBox zaznaczBox;
    
    private JComboBox statusCombo2 = new JComboBox();
    private JComboBox statusCombo3 = new JComboBox();
    private JComboBox statusCombo4 = new JComboBox();
    
    private String data = "";
    private String[] dni = new String[31];
    private String[] rok = new String[80];
    private String[] miesiace = new String[12];
    
    public PanelOperacja(){ 
        Dimension dim = getPreferredSize();
        dim.width = 350;
        setPreferredSize (dim);        
        
        // ustawienie skrotow klawiszowych
        
        idZwierzakaEtykieta.setDisplayedMnemonic(KeyEvent.VK_Z);
        idZwierzakaEtykieta.setLabelFor(idZwierzakaPole);
        idKlientaEtykieta.setDisplayedMnemonic(KeyEvent.VK_K);
        idKlientaEtykieta.setLabelFor(idKlientaPole);
        idPracownikaEtykieta.setDisplayedMnemonic(KeyEvent.VK_P);
        idPracownikaEtykieta.setLabelFor(idPracownikaPole);
        
        
        DefaultComboBoxModel zaznaczBox = new DefaultComboBoxModel();
        zaznaczBox.addElement("Adopcja");
        zaznaczBox.addElement("Opłata");
        zaznaczBox.addElement("Kwarantanna");
        zaznaczBox.addElement("Szczepienie");
        statusCombo.setModel(zaznaczBox);
        
        Border wewGranica = BorderFactory.createTitledBorder("Formularz");
        Border zewGranica = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(zewGranica, wewGranica));
        panelGraficzny();
        
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

    public String getZakonczeniePole() {
        return zakonczeniePole.getText();
    }


    public FormularzOperacja ZwrocOperacje (){
        String nic = "";
        String idZwierzaka;
        String idKlienta;
        String idpracownika;
        int nUl = 0;
        String nul = Integer.toString(nUl);
        int ID = 0; 
        
        if (idZwierzakaPole.getText().equals(nic))idZwierzaka = nul;
        else idZwierzaka = idZwierzakaPole.getText();
        int id_Zwierzaka = Integer.parseInt(idZwierzaka);
        
        if (idKlientaPole.getText().equals(nic))idKlienta = nul;
        else idKlienta = idKlientaPole.getText();
        int idklienta = Integer.parseInt(idKlienta);
        
        if(idPracownikaPole.getText().equals(nic))idpracownika = nul;
        else idpracownika = idPracownikaPole.getText();
        int idPracwonika = Integer.parseInt(idpracownika);
        
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
        
        //String zakonczenie = zakonczeniePole.getText();
        String zakonczenie = "";    
        
        FormularzOperacja FO = new FormularzOperacja(this,ID, id_Zwierzaka ,idklienta,idPracwonika,wybor,data,zakonczenie);
       
        return FO;
    }
    
    public void pokazOperacje(PolaczenieOperacjaGui Formularz){
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
        add(idKlientaEtykieta, gc);
        
        gc.gridx = 1;
        gc.gridy = 1;
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
        add(idPracownikaEtykieta, gc);
        
        gc.gridx = 1;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(idPracownikaPole, gc);
        
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
        gc.insets = new Insets (0,0,0,0);
        add(statusCombo, gc);
        
        
        /////////////// NASTEPNY RZAD ////////////////
        
        gc.gridy ++;
        
        gc.weightx = 1;
        gc.weighty = 0.1;
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,5);
        add(dodanieEtykieta ,gc);
        
        gc.gridx = 1;
        gc.gridy = 4;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(statusCombo3, gc);
        gc.gridx = 2;
        gc.gridy = 4;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,0);
        add(statusCombo4, gc);
        gc.gridx = 3;
        gc.gridy = 4;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(statusCombo2, gc);

         /////////////// NASTEPNY RZAD ////////////////
        
        gc.gridy ++;
        
        gc.weightx = 1;
        gc.weighty = 0.1;
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(zakonczenieEtykieta ,gc);
        
        gc.gridx = 1;
        gc.gridy = 5;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(zakonczeniePole, gc);
        
    }

}

