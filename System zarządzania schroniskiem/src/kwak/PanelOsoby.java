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

public class PanelOsoby extends JPanel {
        
    private JLabel imieEtykieta = new JLabel("Imie: ");;
    private JLabel nazwiskoEtykieta = new JLabel ("Nazwisko: ");
    private JLabel nr_domuEtykieta = new JLabel ("Nr domu: ");
    private JLabel nr_lokaluEtykieta = new JLabel ("Nr lokalu: ");
    private JLabel miastoEtykieta = new JLabel ("Miasto: ");
    private JLabel kod_pocztowyEtykieta = new JLabel ("Kod pocztowy: ");
    private JLabel peselEtykieta = new JLabel("PESEL");

    private JTextField imiePole = new JTextField(10);
    private JTextField nazwiskoPole = new JTextField(10);
    private JTextField nr_domuPole = new JTextField(10);
    private JTextField nr_lokaluPole = new JTextField (10);
    private JTextField miastoPole = new JTextField (10);
    private JTextField kod_pocztowyPole = new JTextField (5);
    private JTextField peselPole = new JTextField(11);
    private PolaczenieOsobaGui polaczenie;
    //private JList listaOsob = new JList();
   // private JComboBox statusCombo = new JComboBox();
    private JCheckBox zaznaczBox;
    //private JTextField podatekPole = new JTextField(10);
    //private JLabel podatekEtykieta = new JLabel("Podatek ID: ");
    
    //private JRadioButton mezczyznaRadio = new JRadioButton("Mezczyzna");
    //private JRadioButton kobietaRadio = new JRadioButton("Kobieta");
    //private ButtonGroup plecGrupa = new ButtonGroup();
    
    public PanelOsoby(){ 
        Dimension dim = getPreferredSize();
        dim.width = 300;
        setPreferredSize (dim);        
        zaznaczBox = new JCheckBox();
        
        // ustawienie skrotow klawiszowych
        
        imieEtykieta.setDisplayedMnemonic(KeyEvent.VK_I);
        imieEtykieta.setLabelFor(imiePole);
        nazwiskoEtykieta.setDisplayedMnemonic(KeyEvent.VK_N);
        nazwiskoEtykieta.setLabelFor(nazwiskoPole);
        nr_domuEtykieta.setDisplayedMnemonic(KeyEvent.VK_D);
        nr_domuEtykieta.setLabelFor(nr_domuPole);
        nr_lokaluEtykieta.setDisplayedMnemonic(KeyEvent.VK_L);
        nr_lokaluEtykieta.setLabelFor(nr_lokaluPole);
        miastoEtykieta.setDisplayedMnemonic(KeyEvent.VK_M);
        miastoEtykieta.setLabelFor(miastoPole);
        kod_pocztowyEtykieta.setDisplayedMnemonic(KeyEvent.VK_K);
        kod_pocztowyEtykieta.setLabelFor(kod_pocztowyPole);
        peselEtykieta.setDisplayedMnemonic(KeyEvent.VK_P);
        peselEtykieta.setLabelFor(peselPole);
        
        Border wewGranica = BorderFactory.createTitledBorder("Formularz");
        Border zewGranica = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(zewGranica, wewGranica));
        panelGraficzny();
        
        
    }  

    public String getPeselPole() {
        return peselPole.getText();
    }

    public String getImiePole() {
        return imiePole.getText();
    }

    public String getNazwiskoPole() {
        return nazwiskoPole.getText();
    }

    public String getNr_domuPole() {
        return nr_domuPole.getText();
    }

    public String getNr_lokaluPole() {
        return nr_lokaluPole.getText();
    }

    public String getMiastoPole() {
        return miastoPole.getText();
    }

    public String getKod_pocztowyPole() {
        return kod_pocztowyPole.getText();
    }

    public FormularzOsoba ZwrocOsobe (){
        int ID = 0;     
        String Imie = imiePole.getText();
        String Nazwisko = nazwiskoPole.getText();
        String dom = nr_domuPole.getText();
        int Nr_Domu = Integer.parseInt(dom);
        String lokal = nr_lokaluPole.getText();
        int Nr_lokalu = Integer.parseInt(lokal);
        String miasto = miastoPole.getText();
        String kod = kod_pocztowyPole.getText();
        int Kod_pocztowy = Integer.parseInt(kod);
        String PESEL = peselPole.getText();
        long pesel = Long.parseLong(PESEL);
                        
        FormularzOsoba FO = new FormularzOsoba(this,ID,Imie,Nazwisko,Nr_Domu,Nr_lokalu,miasto,Kod_pocztowy,pesel);
       
        return FO;
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
        
        gc.gridx = 0;    
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(imieEtykieta, gc);
        
        gc.gridx = 1;
        gc.gridy = 0;
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
        add(nazwiskoEtykieta, gc);
        
        gc.gridx = 1;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(nazwiskoPole, gc);
        
                ////////////Drugi rzad///////////
        
        gc.gridy++;
        
        gc.weightx = 1;
        gc.weighty = 0.1;
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(nr_domuEtykieta, gc);
        
        gc.gridx = 1;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(nr_domuPole, gc);
        
        //////////////// NASTEPNY RZAD ///////////////////
        
        gc.gridy++;
        
        gc.weightx = 1;
        gc.weighty = 0.1;
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(nr_lokaluEtykieta, gc);
        
        gc.gridx = 1;
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,5);
        add(nr_lokaluPole, gc);
        
        
        /////////////// NASTEPNY RZAD ////////////////
        
        gc.gridy ++;
        
        gc.weightx = 1;
        gc.weighty = 0.1;
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(miastoEtykieta ,gc);
        
        gc.gridx = 1;
        gc.gridy = 4;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,5);
        add(miastoPole, gc);
        
        /////////////// NASTEPNY RZAD ///////
        
        gc.gridy++;
        
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(kod_pocztowyEtykieta,gc);
        
        gc.gridx = 1;
        gc.gridy = 5;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,5);
        add(kod_pocztowyPole,gc);
        
        ////////////// NASTEPNY RZAD //////////////
        
        gc.gridy++;
        
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(peselEtykieta,gc);
        
        gc.gridx = 1;
        gc.gridy = 6;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,5);
        add(peselPole,gc);
        
        
       /* ////////////// Nastepny rzad//////////
        
        gc.gridy++;
        
        gc.weightx = 1;
        gc.weighty = 0.2;   
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(new JLabel("Kategoria: "), gc);
       
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(listaOsob, gc);
        
        ////////////// Nastepny rzad//////////
        
        gc.gridy++;
        
        gc.weightx = 1;
        gc.weighty = 0.2;        
       
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(new JLabel("Cos: "), gc);
        
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(statusCombo, gc);
        
        ////////////// Nastepny rzad//////////
        
        gc.gridy++;
        
        gc.weightx = 1;
        gc.weighty = 0.2;        
       
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(new JLabel("Zaznacz: "), gc);
        
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(zaznaczBox, gc);

        ////////////// Nastepny rzad//////////
        
        gc.gridy++;
        
        gc.weightx = 1;
        gc.weighty = 0.2;        
       
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(podatekEtykieta, gc);
        
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(podatekPole, gc);

        ////////////// Nastepny rzad//////////
        
        gc.gridy++;
        
        gc.weightx = 1;
        gc.weighty = 0.05;        
       
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(new JLabel("Plec "), gc);
        
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(mezczyznaRadio, gc);
        
        ////////////// Nastepny rzad//////////
        gc.gridy++;
        
        gc.weightx = 1;
        gc.weighty = 0.2;        
              
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(kobietaRadio, gc);
        
        //////////////Nastepny rzad//////////
        gc.gridy++;
        
        gc.weightx = 1;
        gc.weighty = 2;        
       
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(Dodaj, gc);*/
        
       
       
    }

}

