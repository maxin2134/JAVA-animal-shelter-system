package kwak;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GuiLogowanie extends JFrame {
    
    private JButton Zaloguj;
    private JLabel LoginEtykieta;
    private JLabel HasloEtykieta;
    private JTextField LoginPole;
    private BazaDanych baza;
    private GuiMenuGlowne Glowne;
    JPasswordField HasloPole = new JPasswordField(10);

    
   GuiLogowanie(){
   super("Logowanie");
   
  
    LoginEtykieta = new JLabel("Login: ");
    HasloEtykieta = new JLabel ("Haslo: ");
    LoginPole = new JTextField(10);
    HasloPole.setEchoChar('*');
    LoginEtykieta.setDisplayedMnemonic(KeyEvent.VK_L);
    LoginEtykieta.setLabelFor(LoginPole);
    HasloEtykieta.setDisplayedMnemonic(KeyEvent.VK_H);
    HasloEtykieta.setLabelFor(HasloPole);
   
   
    
   Zaloguj = new JButton("Zaloguj");
   Zaloguj.setMnemonic(KeyEvent.VK_Z);
   Zaloguj.setPreferredSize(new Dimension(100, 50));
       
   setMinimumSize(new Dimension(150,100));
   setSize(200,150); 
   setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   setVisible(true);
   panelGraficzny();
   
    Zaloguj.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e) {
           baza = new BazaDanych();
           char[] haslo = HasloPole.getPassword();
           String Haslo = String.valueOf(haslo);
           String Login = LoginPole.getText();
//           boolean Status = baza.Logowanie(Login, Haslo);
           boolean Status = true;
           if (Status){
           Glowne = new GuiMenuGlowne();
           }
           else{
               
           }
           baza.ZamknijPolaczenie();
       }
    
    });
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
        gc.weighty = 0.1;
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(HasloEtykieta, gc);
        
        gc.gridx = 1;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(HasloPole, gc);

        //////////////Nastepny rzad//////////
        gc.gridy++;
        
        gc.weightx = 1;
        gc.weighty = 2;        
       
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(Zaloguj, gc);
   }
}