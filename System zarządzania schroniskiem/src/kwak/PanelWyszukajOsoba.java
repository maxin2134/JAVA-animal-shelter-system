
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

public class PanelWyszukajOsoba extends JFrame{
    
    private JLabel peselEtykieta = new JLabel("PESEL");
    private JTextField peselPole = new JTextField(11);
    private PolaczenieToolbarOs3 polaczenie;
    private JFrame okno = new JFrame("Wyszukiwanie osoby");
    private JButton przyciskWyszukaj = new JButton("Wyszukaj");
    JPanel buttonPane = new JPanel();
    JPanel fieldPane = new JPanel();

    
    PanelWyszukajOsoba(){
    buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.Y_AXIS));
    buttonPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    buttonPane.add(Box.createHorizontalBox());
    buttonPane.add(przyciskWyszukaj);
    Container contentPane = getContentPane();
    contentPane.add(buttonPane, BorderLayout.SOUTH);
    
    Border zewGranica = BorderFactory.createEmptyBorder(5,5,5,5);
    fieldPane.setLayout(new BorderLayout());
    fieldPane.setBorder(zewGranica);
    fieldPane.add(peselEtykieta, BorderLayout.BEFORE_FIRST_LINE);
    fieldPane.add(peselPole,BorderLayout.BEFORE_LINE_BEGINS);
    contentPane.add(fieldPane, BorderLayout.PAGE_START);
    
    okno.setTitle("Wyszukaj Osobe");
    okno.add(contentPane, BorderLayout.SOUTH);
    okno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    okno.setSize(150, 150);
    okno.setMinimumSize(new Dimension(150,150));
    okno.setMaximumSize(new Dimension(200,200));
    okno.pack();
    okno.setVisible(true);
        
        
    przyciskWyszukaj.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            String pesel = peselPole.getText();            
            
            okno.dispose();
            if (polaczenie != null){
                polaczenie.formEventOccurred(pesel);
                
            }
        }
    });
        
    }
    
    
    
    public void pokazOsobe(PolaczenieToolbarOs3 Formularz){
    this.polaczenie = Formularz;
    }

    public String getPeselPole() {
        return peselPole.getText();
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
        add(peselEtykieta,gc);
        
        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets (0,0,0,0);
        add(peselPole,gc);

    }
}
