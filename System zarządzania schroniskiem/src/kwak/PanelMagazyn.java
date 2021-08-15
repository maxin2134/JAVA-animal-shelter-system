package kwak;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.border.Border;

public class PanelMagazyn extends JPanel {
    
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
    private PolaczenieMagazynGui polaczenie;
    
    private JComboBox statusCombo = new JComboBox();
    private JComboBox statusCombo2 = new JComboBox();
    private JComboBox statusCombo3 = new JComboBox();
    
    private String data = "";
    private String[] dni = new String[31];
    private String[] rok = new String[80];
    private String[] miesiace = new String[12];
    

    
    public PanelMagazyn(){ 
        Dimension dim = getPreferredSize();
        dim.width = 300;
        setPreferredSize (dim);        
        
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
        Border zewGranica = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(zewGranica, wewGranica));
        panelGraficzny();
        
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
        
    }  

    public String getPolozeniePole() {
        return polozeniePole.getText();
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

    public String getWaznoscPole() {
        
        int rk = statusCombo2.getSelectedIndex();
        String Rok = rok[rk];
        data = Rok;
        
        int miech = statusCombo3.getSelectedIndex();
        String Miech = miesiace[miech];
        data = data + "-" + Miech;
        
        int dzn = statusCombo.getSelectedIndex();
        String Dzn = dni[dzn];
        data = data + "-" + Dzn;
        return data;
    }

    public String getGramaturaPole() {
        return gramaturaPole.getText();
    }

    public String getPojemnikPole() {
        return pojemnikPole.getText();
    }


    

    public FormularzMagazyn ZwrocTowar (){
        int ID = 0;     
        String idklienta = idPracownikaPole.getText();
        int ID_Pracownika = Integer.parseInt(idklienta);
        String nazwa = nazwaPole.getText();
        String ilosc = iloscPole.getText();
        int Ilosc = Integer.parseInt(ilosc);
        
        int rk = statusCombo2.getSelectedIndex();
        String Rok = rok[rk];
        data = Rok;
        
        int miech = statusCombo3.getSelectedIndex();
        String Miech = miesiace[miech];
        data = data + "-" + Miech;
        
        int dzn = statusCombo.getSelectedIndex();
        String Dzn = dni[dzn];
        data = data + "-" + Dzn;
        
        String gramatura = gramaturaPole.getText();
        String pojemnik = pojemnikPole.getText();
        String polozenie = polozeniePole.getText();
        FormularzMagazyn FO = new FormularzMagazyn(this,ID, ID_Pracownika ,nazwa,Ilosc,data,gramatura,pojemnik,polozenie);
       
        return FO;
    }
    
    public void event(PolaczenieMagazynGui Magazyn){
    this.polaczenie = Magazyn;
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
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(waznoscEtykieta, gc);
        
        gc.gridx = 1;
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(statusCombo2, gc);
        
        gc.gridx = 1;
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,0);
        add(statusCombo3,gc);
        
        gc.gridx = 2;
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,0);
        add(statusCombo,gc);
        
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
        gc.insets = new Insets (0,0,0,0);
        add(gramaturaPole, gc);
        
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
        gc.insets = new Insets (0,0,0,0);
        add(pojemnikPole,gc);
        
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
        gc.insets = new Insets (0,0,0,0);
        add(polozeniePole,gc);
    }

}

