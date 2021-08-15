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

public class PanelEdytujPracownika extends JPanel {
        
    private JLabel loginEtykieta = new JLabel("Login: ");;

    private JTextField loginPole = new JTextField(10);

    private PolaczenieOsobaGui polaczenie;

    private JCheckBox loginBox = new JCheckBox();

    
    public PanelEdytujPracownika(){ 
        Dimension dim = getPreferredSize();
        dim.width = 300;
        setPreferredSize (dim);   
        
        loginEtykieta.setEnabled(false);
        loginPole.setEnabled(false);
        
        
        loginBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                boolean zaznaczone = loginBox.isSelected();
                loginEtykieta.setEnabled(zaznaczone);
                loginPole.setEnabled(zaznaczone);
            }
        });
        
        
        // ustawienie skrotow klawiszowych
        
        loginEtykieta.setDisplayedMnemonic(KeyEvent.VK_L);
        loginEtykieta.setLabelFor(loginPole);
      
        Border wewGranica = BorderFactory.createTitledBorder("Formularz");
        Border zewGranica = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(zewGranica, wewGranica));
        panelGraficzny();
        
        
    }  

    public String getLoginPole() {
        return loginPole.getText();
    }
    
    public void pokazPracownika(PolaczenieOsobaGui Formularz){
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
        add(loginBox,gc);

        gc.gridx = 0;    
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(loginEtykieta, gc);
        
        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(loginPole, gc);
        
        
    }

}

