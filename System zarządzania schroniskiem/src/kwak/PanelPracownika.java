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

public class PanelPracownika extends JPanel {
    
    private JLabel LoginEtykieta;
    private JLabel HasloEtykieta;
    
    private JTextField LoginPole;
    private JTextField HasloPole;
    private JButton Dodaj;
    private PolaczeniePracownikGui NowyFormularz;
    //private JList listaOsob;
   // private JComboBox statusCombo;
    private JCheckBox zaznaczBox;
    //private JTextField podatekPole;
    //private JLabel podatekEtykieta;
    
    //private JRadioButton mezczyznaRadio;
    //private JRadioButton kobietaRadio;
    //private ButtonGroup plecGrupa;
    
    public PanelPracownika(){ 
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize (dim);
        
        LoginEtykieta = new JLabel("Login: ");
        HasloEtykieta = new JLabel ("Haslo: ");
         
        LoginPole = new JTextField(10);
        HasloPole = new JTextField(10);

        
        
        Dodaj = new JButton ("Dodaj");
       // listaOsob = new JList();
       // statusCombo = new JComboBox();
        zaznaczBox = new JCheckBox();
       // podatekPole = new JTextField(10);
       // podatekEtykieta = new JLabel("Podatek ID: ");
        
        // ustawienie skrotow klawiszowych
        
        
        LoginEtykieta.setDisplayedMnemonic(KeyEvent.VK_L);
        LoginEtykieta.setLabelFor(LoginPole);
        HasloEtykieta.setDisplayedMnemonic(KeyEvent.VK_H);
        HasloEtykieta.setLabelFor(HasloPole);
        
       /* 
        mezczyznaRadio = new JRadioButton("Mezczyzna");
        kobietaRadio = new JRadioButton("Kobieta");
        plecGrupa = new ButtonGroup();
        mezczyznaRadio.setActionCommand("Mezczyzna");
        kobietaRadio.setActionCommand("Kobieta");
        mezczyznaRadio.setSelected(true);
        /*
        // ustawienie plci
        
       // plecGrupa.add(mezczyznaRadio);
       // plecGrupa.add(kobietaRadio);
        
        // ustawienia podatku
        
       // podatekEtykieta.setEnabled(false);
       // podatekPole.setEnabled(false);
        
        /*zaznaczBox.addActionListener(new ActionListener(){
        
            public void actionPerformed (ActionEvent e){
                boolean zaznaczenie = zaznaczBox.isSelected();
                
            podatekEtykieta.setEnabled(zaznaczenie);
            podatekPole.setEnabled(zaznaczenie);
            }
            
        });/*
        
        
        /* ustawienia listy
        
        DefaultListModel modelOsob = new DefaultListModel();
        modelOsob.addElement(new ListaOsob(0, "Osoba"));
        modelOsob.addElement(new ListaOsob(1, "Pracownik"));        
        modelOsob.addElement(new ListaOsob(2, "Klient"));
        listaOsob.setModel(modelOsob);
        listaOsob.setPreferredSize(new Dimension(150, 60));
        listaOsob.setBorder(BorderFactory.createEtchedBorder());
        listaOsob.setSelectedIndex(1);
        
        // ustawienia status combo
        
        DefaultComboBoxModel modelStatus = new DefaultComboBoxModel();
        modelStatus.addElement("Kwak0");
        modelStatus.addElement("Kwak1");
        modelStatus.addElement("Kwak2");
        statusCombo.setModel(modelStatus);
        statusCombo.setSelectedIndex(0);
        statusCombo.setEditable(true);
        
        Dodaj.addActionListener(new ActionListener() {
        
            public void actionPerformed(ActionEvent e){
                String Login = LoginPole.getText();
                String Haslo = HasloPole.getText();
                
                System.out.println("Zczytane z pol " + Login);
                System.out.println("Zczytane z pol " + Haslo);
                
                FormularzOsoba formularz = new FormularzOsoba(this, Login, Haslo);
                
                if(NowyFormularz != null ){
                    NowyFormularz.formEventOccurred(formularz);
                }
            }
            
        }); <--------------------------------- PACZ */
        
        Border wewGranica = BorderFactory.createTitledBorder("Formularz");
        Border zewGranica = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(zewGranica, wewGranica));
        
        panelGraficzny();
    }

    public String getLoginPole() {
        return LoginPole.getText();
    }

    public String getHasloPole() {
        return HasloPole.getText();
    }

    public void pokazOsobe(PolaczeniePracownikGui Formularz){
    this.NowyFormularz = Formularz;
    }
    
    public FormularzPracownik ZwrocPracownika (){
        int ID = 0;     
        String Login = LoginPole.getText();
        String Haslo = HasloPole.getText();
                        
        FormularzPracownik FO = new FormularzPracownik(this,ID,Login,Haslo);
       
        return FO;
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
        add(LoginEtykieta, gc);
        
        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(LoginPole, gc);
        
        ////////////Drugi rzad///////////
        
        gc.gridy++;
        
        gc.weightx = 1;
        gc.weighty = 5;
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(HasloEtykieta, gc);
        
        gc.gridx = 1;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(HasloPole, gc);
        
        
    }
}



/*class ListaOsob {
    private int id;
    private String text;
    public ListaOsob(int id, String text){
        this.id = id;
        this.text = text;
        
    }
    
    public String toString(){
        return text;
    }
    
    public int getID(){
        return id;
    }
}*/