package kwak;

import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ToolbarKlienta extends JPanel implements ActionListener {
    
    private JButton przyciskDodaj = new JButton ("Dodaj");
    private JButton przyciskUsun = new JButton ("Usun");
    private JButton przyciskEdytuj = new JButton ("Edytuj");
    private JButton przyciskWyszukajKlienta = new JButton ("Wyszukaj klienta");
    private JButton przyciskWyszukajOsobe = new JButton ("Wyszukaj osobe");
    private PolaczenieToolbarOs1 polaczenie;
    private PolaczenieToolbarOs2 polaczenie2;
    private PolaczenieToolbarOs3 polaczenie3;
    private PolaczenieToolbarOs4 polaczenie4;
    private PolaczenieToolbarOs4 polaczenie5;
    private JTextField ID;
    
    public ToolbarKlienta(){
        setBorder(BorderFactory.createEtchedBorder());
        przyciskDodaj.addActionListener(this);
        przyciskUsun.addActionListener(this);
        setLayout(new FlowLayout(FlowLayout.LEFT));
        ID = new JTextField(3);
        
        
        add(przyciskDodaj);
        add(przyciskUsun);
        add(ID);
        add(przyciskEdytuj);
        add(przyciskWyszukajKlienta);
        add(przyciskWyszukajOsobe);
        
        przyciskEdytuj.addActionListener(new ActionListener (){
            public void actionPerformed(ActionEvent e) {                
                if (polaczenie != null){
                    polaczenie.formEventOccured();
                }
            }
        });
        
        przyciskDodaj.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (polaczenie2 != null){
                    polaczenie2.formEventOccured();
                
                }
            }
        });
        
        przyciskUsun.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if (polaczenie3 != null){ 
                    String k = ID.getText();
                    polaczenie3.formEventOccurred(k);
                }
            }
        });
        
        przyciskWyszukajKlienta.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            
                if (polaczenie4 != null){
                    polaczenie4.formEventOccured();
                }
            
            }
        });
        
        przyciskWyszukajOsobe.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            
                if (polaczenie5 != null){
                    polaczenie5.formEventOccured();
                }
            
            }
        });
        
    }
    
    public void polToolbarOs1 ( PolaczenieToolbarOs1 pol){
        this.polaczenie = pol;
    }    
    public void polTooblarOs2 ( PolaczenieToolbarOs2 pol){
        this.polaczenie2 = pol;
    }
    public void polToolbarOs3 ( PolaczenieToolbarOs3 pol){
        this.polaczenie3 = pol;
    }
    
    public void polToolbarOs4 ( PolaczenieToolbarOs4 pol){
        this.polaczenie4 = pol;
    }
    
    public void polToolbarOs5 ( PolaczenieToolbarOs4 pol){
        this.polaczenie5 = pol;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        JButton nacisniety = (JButton)e.getSource();
        }
      
    }