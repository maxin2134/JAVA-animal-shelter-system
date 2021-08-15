package kwak;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class GuiMenuGlowne extends JFrame {
    
    private JButton FormularzKlient = new JButton("Formularz Klienta");
    private JButton FormularzPracownik = new JButton("Formularz Pracownika");
    private JButton FormularzOsoby = new JButton("Formularz Osoby");
    private JButton FormularzZwierzaka = new JButton ("Formularz Zwierzaka");
    private JButton Magazyn = new JButton ("Magazyn");
    private JButton Dokumentacja = new JButton ("Dokumentacja");
    private JButton Operacja = new JButton ("Operacja");
    private JFrame okno = new JFrame("Menu Glowne");
    
    JPanel listPane = new JPanel();
    JPanel buttonPane = new JPanel();
    JLabel label = new JLabel("b");

    
   GuiMenuGlowne(){

   buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.Y_AXIS));
   buttonPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
   buttonPane.add(Box.createHorizontalBox());
   buttonPane.add(FormularzOsoby);
   buttonPane.add(Box.createRigidArea(new Dimension(0, 10)));
   buttonPane.add(FormularzPracownik);
   buttonPane.add(Box.createRigidArea(new Dimension(0, 10)));
   buttonPane.add(FormularzKlient);
   buttonPane.add(Box.createRigidArea(new Dimension(0, 10)));
   buttonPane.add(FormularzZwierzaka);
   buttonPane.add(Box.createRigidArea(new Dimension(0,10)));
   buttonPane.add(Magazyn);
   buttonPane.add(Box.createRigidArea(new Dimension(0,10)));
   buttonPane.add(Dokumentacja);
   buttonPane.add(Box.createRigidArea(new Dimension(0,10)));
   buttonPane.add(Operacja);
   Container contentPane = getContentPane();
   contentPane.add(buttonPane, BorderLayout.BEFORE_FIRST_LINE);
   
   
   okno.add(contentPane);
   okno.setJMenuBar(stworzPasekMenu());
   okno.setMinimumSize(new Dimension(400,400));
   okno.setSize(400,400); 
   okno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   okno.setVisible(true);
   
   //ustawienie przyciskow po kliknieciu//
   
   FormularzOsoby.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e) {
           GuiOsoba formularzOsoby = new GuiOsoba();
       }
   });
   
    FormularzPracownik.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e) {
            GuiPracownik formularzPracownik = new GuiPracownik();
       }
   });
   FormularzKlient.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e) {
           GuiKlienta formularzKlienta = new GuiKlienta();
       }
   });   
   FormularzZwierzaka.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e) {
           GuiZwierzaka formularzZwierzaka = new GuiZwierzaka();
       }
   });
   
   Magazyn.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e) {
           GuiMagazyn magazyn = new GuiMagazyn();
       }
   });
   
   Dokumentacja.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e) {
           GuiDokumentacja dokument = new GuiDokumentacja();
       }
   });
   
   Operacja.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e) {
           GuiOperacja operacja = new GuiOperacja();
       }
   });
   }

   
   private JMenuBar stworzPasekMenu(){
       JMenuBar pasekMenu = new JMenuBar();
       
       JMenu menuPlikow = new JMenu("Okno");
       JMenuItem zakoncz = new JMenuItem("Zakoncz");
       
       menuPlikow.add(zakoncz);
   
       pasekMenu.add(menuPlikow);

       // ustawienie skrotow klawiszowych
       
       menuPlikow.setMnemonic(KeyEvent.VK_P);
       zakoncz.setMnemonic(KeyEvent.VK_Z);
       zakoncz.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
       
       zakoncz.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e) {
                int akcja = JOptionPane.showConfirmDialog(pasekMenu, 
                       "Czy chcesz zakonczyc?", "Potwierdz", JOptionPane.OK_CANCEL_OPTION );
               if (akcja == JOptionPane.OK_OPTION) 
               System.exit(0);
           }     
        });
       
       return pasekMenu;
   }
}