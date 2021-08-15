package kwak;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class GuiPracownik extends JFrame {
   
    private ToolbarPracownik toolbar = new ToolbarPracownik();
    private PanelPracownika panelOsoby = new PanelPracownika();
    private JFileChooser plikWybierz = new JFileChooser();
    private TabelaPracownik tabela = new TabelaPracownik();
    private BazaDanych db = new BazaDanych();
    private FormularzPracownik pracownik;
    private ArrayList<FormularzPracownik> e = new ArrayList();
    private JFrame okno = new JFrame("Formularz Pracownika");

   GuiPracownik(){
   tabela.wstawDane(db.WyswietlPracownikow());
   okno.add(panelOsoby, BorderLayout.WEST);
   okno.add(toolbar, BorderLayout.NORTH);
   okno.add(tabela, BorderLayout.CENTER);
   okno.setMinimumSize(new Dimension(600,500));
   okno.setSize(800,600); 
   okno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   okno.setVisible(true);
   okno.setJMenuBar(stworzPasekMenu());
   okno.addWindowListener(cos());   
   plikWybierz.addChoosableFileFilter(new FiltrPrzeszukiwan());
   
    toolbar.polToolbarOs1( new PolaczenieToolbarOs1(){
       public void formEventOccured() { 
            int wiersz = tabela.zwrocZaznaczenie();
            pracownik = db.ZwrocKonkretnegoPracownika(wiersz);
            
            String Login = pracownik.Login;
            
            AktualizujPracownika update = new AktualizujPracownika(pracownik);
            
       update.polAktualizuj(new PolaczenieAktualizujPracownik(){
       public void AktualizujPracownika(FormularzPracownik e) {
           db.ZaktualizujPracownika(pracownik);
           tabela.wstawDane(db.WyswietlPracownikow());
           JOptionPane.showOptionDialog(okno,
           "Stare dane: " + "               Nowe dane:      " + "\n" + 
           "Login:  " + Login+ "      ->      " + "Login:  " + e.Login ,
           "Zmiana", JOptionPane.OK_OPTION,
           JOptionPane.INFORMATION_MESSAGE, null, null, null);
        }
   });
        }
   });
   
    toolbar.polTooblarOs2( new PolaczenieToolbarOs2(){
        public void formEventOccured() {
            pracownik = panelOsoby.ZwrocPracownika();
                int rozmiar = db.ZwrocOstatniPracownik() + 1;
                pracownik.ID = rozmiar;
                String cos = "VALUES ('" + pracownik.ID + "','" + pracownik.Login + "','" + pracownik.Haslo + "')";
                String Pracownik = "INSERT INTO Pracownik " + cos;
                db.DodajPracownika(Pracownik);
                tabela.wstawDane(db.WyswietlPracownikow());
       }
   });
   
    toolbar.polToolbarOs3 (new PolaczenieToolbarOs3() {
       public void formEventOccurred(String k) {
            db.UsunPracownika(k); 
            tabela.wstawDane(db.WyswietlPracownikow());
       }
   });
   
    toolbar.polToolbarOs4(new PolaczenieToolbarOs4(){
         public void formEventOccured() {
            PanelWyszukajPracownika wPracownik = new PanelWyszukajPracownika();

           
    wPracownik.pokazPracownika(new PolaczenieToolbarOs3(){
        public void formEventOccurred(String id) {
            e = db.WyszukajPracownika(id); 
            PodgladTabelaPracownik PTP = new PodgladTabelaPracownik(e); 
            
    PTP.usunPracownika(new PolaczenieToolbarOs3(){
                public void formEventOccurred(String k) {
                    db.UsunTabelaPracownik(k); 
                    tabela.wstawDane(db.WyswietlPracownikow());
                }
            });
            
        }
   });
       }
   });
   
   tabela.usunPracownika(new PolaczenieTabelaGui(){
       public void usun(int wiersz){
           String cos = Integer.toString(wiersz);
           db.UsunTabelaPracownik(cos);
           tabela.wstawDane(db.WyswietlPracownikow());
       }
   });
      
   }
   
    private WindowListener cos(){
        WindowListener exitListener = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int confirm = JOptionPane.showOptionDialog(okno,
                        "Opuszczasz formularz",
                        "Opuszczenie", JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (confirm == JOptionPane.OK_OPTION) {
                    okno.dispose();
                    db.ZamknijPolaczenie();
                }
                else{
                    okno.notify();
                }
            }
        };
        return exitListener;
}
   
      private JMenuBar stworzPasekMenu(){
     
     JMenuBar pasekMenu = new JMenuBar();
     JMenu menuPlikow = new JMenu("Plik");
     JMenuItem eksportuj = new JMenuItem("Eksportuj...");
     JMenuItem importuj = new JMenuItem("Importuj...");
     JMenuItem zakoncz = new JMenuItem("Zakoncz");
     JMenu menuOkno = new JMenu("Okno");
     JMenu pokazMenuOkno = new JMenu("Pokaz");
     JCheckBoxMenuItem pokazOsoby = new JCheckBoxMenuItem("Formularz");
          
          
            ////////////// PASEK MENU ////////////////
       
       menuPlikow.add(eksportuj);
       menuPlikow.add(importuj);
       menuPlikow.addSeparator();
       menuPlikow.add(zakoncz);
       

       pokazOsoby.setSelected(true);
       
       pokazMenuOkno.add(pokazOsoby);
       menuOkno.add(pokazMenuOkno);
       
       pasekMenu.add(menuPlikow);
       pasekMenu.add(menuOkno);
       
       pokazOsoby.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent ev) {
               JCheckBoxMenuItem menuPlikow = (JCheckBoxMenuItem)ev.getSource();
               panelOsoby.setVisible(menuPlikow.isSelected());
           }
       });
       
       // ustawienie skrotow klawiszowych
       
       menuPlikow.setMnemonic(KeyEvent.VK_P);
       menuOkno.setMnemonic(KeyEvent.VK_O);
       eksportuj.setMnemonic(KeyEvent.VK_E);
       eksportuj.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
       importuj.setMnemonic(KeyEvent.VK_I);
       importuj.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
       zakoncz.setMnemonic(KeyEvent.VK_Z);
       zakoncz.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
       
       importuj.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e) {
               if (plikWybierz.showOpenDialog(GuiPracownik.this) == JFileChooser.APPROVE_OPTION){
                   try {
                       db.zapiszDoPliku(plikWybierz.getSelectedFile());
                   } catch (IOException ex) {
                       System.out.println(ex);
                       JOptionPane.showMessageDialog(GuiPracownik.this, "Wczytanie bazy nie powiodlo sie.", "Blad", JOptionPane.ERROR_MESSAGE);
                   }
               }
               
           }
       
       });
       
       eksportuj.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e) {
               if (plikWybierz.showSaveDialog(GuiPracownik.this) == JFileChooser.APPROVE_OPTION){
                   try {
                       db.wczytajPlik(plikWybierz.getSelectedFile());
                   } catch (IOException ex) {
                       System.out.println(ex);
                       JOptionPane.showMessageDialog(GuiPracownik.this, "Zapisanie bazy nie powiodlo sie.", "Blad", JOptionPane.ERROR_MESSAGE);
                   }
               }
               
           }
       
       });       
       
       zakoncz.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e) {
                int akcja = JOptionPane.showConfirmDialog(GuiPracownik.this, 
                       "Czy chcesz zakonczyc?", "Potwierdz", JOptionPane.OK_CANCEL_OPTION );
               if (akcja == JOptionPane.OK_OPTION) 
               System.exit(0);
           }     
        });
      
      return pasekMenu;
      
    }
}

 