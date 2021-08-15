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

public class GuiOsoba extends JFrame {
   
    private ToolbarOsoba toolbar = new ToolbarOsoba();
    private PanelOsoby panelOsoby = new PanelOsoby();
    private JFileChooser plikWybierz = new JFileChooser();
    private TabelaOsoba tabela = new TabelaOsoba();
    private BazaDanych db = new BazaDanych();
    private FormularzOsoba osoba;
    private FormularzOsoba wOsoba;
    private ArrayList<FormularzOsoba> e = new ArrayList();
    private JFrame okno = new JFrame("Formularz Osoby");

   GuiOsoba(){
   tabela.wstawDane(db.WyswietlOsoby());
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
            osoba = db.ZwrocKonkretnaOsobe(wiersz);
            
            String imie = osoba.Imie;
            String nazwisko = osoba.Nazwisko;
            int dom = osoba.Nr_domu;
            int lokal = osoba.Nr_lokalu;
            String miasto = osoba.miasto;
            int kod = osoba.Kod_pocztowy;
            long PESEL = osoba.PESEL;
            AktualizujOsobe update = new AktualizujOsobe(osoba);
            
       update.polAktualizuj(new PolaczenieAktualizujOsoba(){
       public void AktualizujOsobe(FormularzOsoba e) {
           db.ZaktualizujOsobe(osoba);
           tabela.wstawDane(db.WyswietlOsoby());
           JOptionPane.showOptionDialog(okno,
           "Stare dane: " + "               Nowe dane:      " + "\n" + 
           "Imie:  " + imie+ "      ->      " + "Imie:  " + e.Imie + "\n" +
           "Nazwisko:  " + nazwisko + "      ->      " + "Nazwisko:  " + e.Nazwisko + "\n" +
           "Nr domu:  " + dom + "      ->      " + "Nr domu:  " + e.Nr_domu + "\n" +
           "Nr lokalu:  " + lokal + "      ->      " + "Nr lokalu:  " + e.Nr_lokalu + "\n" +
           "Miasto:  " + miasto + "      ->      " + "Miasto:  " + e.miasto + "\n" +
           "Kod pocztowy:  " + kod + "      ->      " + "Kod pocztowy:  " + e.Kod_pocztowy + "\n" + 
           "PESEL: " + PESEL + "      ->      " + "PESEL" + e.PESEL  ,
           "Zmiana", JOptionPane.OK_OPTION,
           JOptionPane.INFORMATION_MESSAGE, null, null, null);

        }
   });
        }
   });
   
    toolbar.polTooblarOs2( new PolaczenieToolbarOs2(){
        public void formEventOccured() {
            osoba = panelOsoby.ZwrocOsobe();
                int rozmiar = db.ZwrocOstatniOsoba() + 1;
                osoba.ID = rozmiar;
                String cos = "VALUES ('" + osoba.ID + "','" + osoba.Imie + "','" + osoba.Nazwisko + "','" + osoba.Nr_domu + "','" + osoba.Nr_lokalu + 
                        "','" + osoba.miasto + "','" + osoba.Kod_pocztowy + "','" + osoba.PESEL + "')";  
                String Osoba = "INSERT INTO Osoba " + cos;
                db.DodajOsobe(Osoba);
                tabela.wstawDane(db.WyswietlOsoby());
       }
   });
   // USUN
    toolbar.polToolbarOs3 (new PolaczenieToolbarOs3() {
       public void formEventOccurred(String k) {
            db.UsunOsobe(k); 
            tabela.wstawDane(db.WyswietlOsoby());
       }
   });
   // WYSZUKAJ
    toolbar.polToolbarOs4(new PolaczenieToolbarOs4(){
         public void formEventOccured() {
           PanelWyszukajOsoba wOsobe = new PanelWyszukajOsoba();
           
    wOsobe.pokazOsobe(new PolaczenieToolbarOs3(){
        public void formEventOccurred(String PESEL) {
            e = db.WyszukajOsobe(PESEL);
            PodgladTabelaOsoba PTO = new PodgladTabelaOsoba(e);
            
    PTO.polToolbarOs3(new PolaczenieToolbarOs3(){
                public void formEventOccurred(String k) {
                    db.UsunOsobe(k); 
                    tabela.wstawDane(db.WyswietlOsoby());
                }
            });
            
        }
   });
       }
   });
   
   tabela.usunOsoba(new PolaczenieTabelaGui(){
       public void usun(int wiersz){
           String indeks = Integer.toString(wiersz);
           db.UsunTabelaOsoba(indeks);
           tabela.wstawDane(db.WyswietlOsoby());
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
               if (plikWybierz.showOpenDialog(GuiOsoba.this) == JFileChooser.APPROVE_OPTION){
                   try {
                       db.zapiszDoPliku(plikWybierz.getSelectedFile());
                   } catch (IOException ex) {
                       System.out.println(ex);
                       JOptionPane.showMessageDialog(GuiOsoba.this, "Wczytanie bazy nie powiodlo sie.", "Blad", JOptionPane.ERROR_MESSAGE);
                   }
               }
               
           }
       
       });
       
       eksportuj.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e) {
               if (plikWybierz.showSaveDialog(GuiOsoba.this) == JFileChooser.APPROVE_OPTION){
                   try {
                       db.wczytajPlik(plikWybierz.getSelectedFile());
                   } catch (IOException ex) {
                       System.out.println(ex);
                       JOptionPane.showMessageDialog(GuiOsoba.this, "Zapisanie bazy nie powiodlo sie.", "Blad", JOptionPane.ERROR_MESSAGE);
                   }
               }
               
           }
       
       });       
       
       zakoncz.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e) {
                int akcja = JOptionPane.showConfirmDialog(GuiOsoba.this, 
                       "Czy chcesz zakonczyc?", "Potwierdz", JOptionPane.OK_CANCEL_OPTION );
               if (akcja == JOptionPane.OK_OPTION) 
               System.exit(0);
           }     
        });
      
      return pasekMenu;
      
    }
}
