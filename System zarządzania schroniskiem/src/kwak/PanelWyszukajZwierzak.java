
package kwak;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class PanelWyszukajZwierzak extends JFrame{
    
    private JLabel idEtykieta = new JLabel("ID Klienta");
    private JTextField idPole = new JTextField(11);
    private PolaczenieToolbarOs3 polaczenie;
    private JFrame okno = new JFrame("Wyszukiwanie zwierzaka");
    private JButton przyciskWyszukaj = new JButton("Wyszukaj");
    JPanel buttonPane = new JPanel();
    JPanel fieldPane = new JPanel();

    
    PanelWyszukajZwierzak(){
    buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.Y_AXIS));
    buttonPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    buttonPane.add(Box.createHorizontalBox());
    buttonPane.add(przyciskWyszukaj);
    Container contentPane = getContentPane();
    contentPane.add(buttonPane, BorderLayout.SOUTH);
    
    Border zewGranica = BorderFactory.createEmptyBorder(5,5,5,5);
    fieldPane.setLayout(new BorderLayout());
    fieldPane.setBorder(zewGranica);
    fieldPane.add(idEtykieta, BorderLayout.BEFORE_FIRST_LINE);
    fieldPane.add(idPole,BorderLayout.BEFORE_LINE_BEGINS);
    contentPane.add(fieldPane, BorderLayout.PAGE_START);
    
    okno.add(contentPane, BorderLayout.SOUTH);
    okno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    okno.setSize(150, 150);
    okno.setMinimumSize(new Dimension(150,150));
    okno.setMaximumSize(new Dimension(200,200));
    okno.pack();
    okno.setVisible(true);
        
        
    przyciskWyszukaj.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            String pesel = idPole.getText();            
            
            okno.dispose();
            if (polaczenie != null){
                polaczenie.formEventOccurred(pesel);
                
            }
        }
    });
        
    }
    
    
    
    public void pokazZwierzaka(PolaczenieToolbarOs3 Formularz){
    this.polaczenie = Formularz;
    }

    public String getIDPole() {
        return idPole.getText();
    }
    
    
    public void panelGraficzny(){
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        
        gc.gridy = 0;
        gc.gridx = 0;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets (0,0,0,0);
        add(idEtykieta,gc);
        
        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets (0,0,0,0);
        add(idPole,gc);

    }
}
