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

public class PanelEdytujOsobe extends JPanel {
        
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
    private JCheckBox imieBox = new JCheckBox();
    private JCheckBox nazwiskoBox = new JCheckBox();
    private JCheckBox nr_domuBox = new JCheckBox();
    private JCheckBox nr_lokaluBox = new JCheckBox();
    private JCheckBox miastoBox = new JCheckBox();
    private JCheckBox kod_pocztowyBox = new JCheckBox();
    private JCheckBox peselBox = new JCheckBox();
    
    
    
    //private JRadioButton mezczyznaRadio = new JRadioButton("Mezczyzna");
    //private JRadioButton kobietaRadio = new JRadioButton("Kobieta");
    //private ButtonGroup plecGrupa = new ButtonGroup();
    
    public PanelEdytujOsobe(){ 
        Dimension dim = getPreferredSize();
        dim.width = 300;
        setPreferredSize (dim);   
        
        imieEtykieta.setEnabled(false);
        imiePole.setEnabled(false);
        nazwiskoEtykieta.setEnabled(false);
        nazwiskoPole.setEnabled(false);
        nr_domuEtykieta.setEnabled(false);
        nr_domuPole.setEnabled(false);
        nr_lokaluEtykieta.setEnabled(false);
        nr_lokaluPole.setEnabled(false);
        miastoEtykieta.setEnabled(false);
        miastoPole.setEnabled(false);
        kod_pocztowyEtykieta.setEnabled(false);
        kod_pocztowyPole.setEnabled(false);
        peselEtykieta.setEnabled(false);
        peselPole.setEnabled(false);
        
        imieBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                boolean zaznaczone = imieBox.isSelected();
                imieEtykieta.setEnabled(zaznaczone);
                imiePole.setEnabled(zaznaczone);
            }
        });
        
        nazwiskoBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                boolean zaznaczone = nazwiskoBox.isSelected();
                nazwiskoEtykieta.setEnabled(zaznaczone);
                nazwiskoPole.setEnabled(zaznaczone);
            }
        });
        
        nr_domuBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                boolean zaznaczone = nr_domuBox.isSelected();
                nr_domuEtykieta.setEnabled(zaznaczone);
                nr_domuPole.setEnabled(zaznaczone);
            }
        });
        
        nr_lokaluBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                boolean zaznaczone = nr_lokaluBox.isSelected();
                nr_lokaluEtykieta.setEnabled(zaznaczone);
                nr_lokaluPole.setEnabled(zaznaczone);
            }
        });
        
        miastoBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                boolean zaznaczone = miastoBox.isSelected();
                miastoEtykieta.setEnabled(zaznaczone);
                miastoPole.setEnabled(zaznaczone);
            }
        });
        
        kod_pocztowyBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                boolean zaznaczone = kod_pocztowyBox.isSelected();
                kod_pocztowyEtykieta.setEnabled(zaznaczone);
                kod_pocztowyPole.setEnabled(zaznaczone);
            }
        });
        
        peselBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                boolean zaznaczone = peselBox.isSelected();
                peselEtykieta.setEnabled(zaznaczone);
                peselPole.setEnabled(zaznaczone);
            }
        });
        
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
        add(imieBox,gc);

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
        gc.gridx = -1;
        add(nazwiskoBox, gc);
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
        
        gc.gridx = -1;
        add(nr_domuBox,gc);
        
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
        
        gc.gridx = -1;
        add(nr_lokaluBox,gc);
        
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
        
        gc.gridx = -1;
        add(miastoBox,gc);
        
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
        
        gc.gridx = -1;
        add(kod_pocztowyBox,gc);
        
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
        
        gc.gridx = -1;
        add(peselBox,gc);
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(peselEtykieta,gc);
        
        gc.gridx = 1;
        gc.gridy = 6;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,5);
        add(peselPole,gc);
        
     
    }

}

