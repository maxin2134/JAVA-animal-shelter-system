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

public class PanelKlienta extends JPanel {
    
    private JLabel idEtykieta = new JLabel("ID Klienta: ");;    
    private JLabel peselEtykieta = new JLabel("PESEL: ");    
    private JTextField idPole = new JTextField(10);
    private JTextField peselPole = new JTextField(11);
    private JButton Dodaj;
    private PolaczenieKlientGui NowyFormularz;
    private JCheckBox zaznaczBox;

    
    public PanelKlienta(){ 
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize (dim);
       
        Dodaj = new JButton ("Dodaj");
        zaznaczBox = new JCheckBox();
        
        Border wewGranica = BorderFactory.createTitledBorder("Formularz");
        Border zewGranica = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(zewGranica, wewGranica));
        
        panelGraficzny();
    }

    public String getPeselPole() {
        return peselPole.getText();
    }

    public String getIdPole() {
        return idPole.getText();
    }

    public FormularzKlienta ZwrocKlienta (){
        int ID = 0;     
        String id = idPole.getText();
        int iD = Integer.parseInt(id);
        String pesel = peselPole.getText();
        long PESEL = Long.parseLong(pesel);
                        
        FormularzKlienta FO = new FormularzKlienta(this,ID,iD,PESEL);
       
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
        add(idEtykieta, gc);
        
        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(idPole, gc);
        //////////Pierwszy rzad///////
        gc.gridy++;
        
        gc.weightx = 1;
        gc.weighty = 0.1;
        
        gc.gridx = 0;    
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets (0,0,0,5);
        add(peselEtykieta, gc);
        
        gc.gridx = 1;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(peselPole, gc);

    }
}
