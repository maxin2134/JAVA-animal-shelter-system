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

public class GuiKlienta extends JFrame {
   
    private ToolbarKlienta toolbar = new ToolbarKlienta();
    private JFileChooser plikWybierz = new JFileChooser();
    private TabelaOsoba tabelaOsoba = new TabelaOsoba();
    private TabelaKlient tabelaKlient = new TabelaKlient();
    private BazaDanych db = new BazaDanych();
    private FormularzKlienta klient;
    private FormularzOsoba osoba;
    private ArrayList<FormularzOsoba> ListaOsob = new ArrayList();
    private ArrayList<FormularzKlienta> ListaKlientow = new ArrayList();
    private JFrame okno = new JFrame("Formularz klienta");

   GuiKlienta(){
   tabelaOsoba.wstawDane(db.WyswietlOsoby());
   tabelaKlient.wstawDane(db.WyswietlKlientow());
   okno.add(toolbar, BorderLayout.NORTH);
   okno.add(tabelaOsoba, BorderLayout.CENTER);
   okno.add(tabelaKlient, BorderLayout.EAST);
   okno.setMinimumSize(new Dimension(600,500));
   okno.setSize(800,600); 
   okno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   okno.setVisible(true);
   okno.setJMenuBar(stworzPasekMenu());
   okno.addWindowListener(cos());   
   plikWybierz.addChoosableFileFilter(new FiltrPrzeszukiwan());
   //edytuj
    toolbar.polToolbarOs1( new PolaczenieToolbarOs1(){
       public void formEventOccured() { 
            int wiersz = tabelaKlient.zwrocZaznaczenie();
            klient = db.ZwrocKonkretnegoKlienta(wiersz);
            int id = klient.ID_Osoby;
            long pesel = klient.PESEL;
            AktualizujKlienta update = new AktualizujKlienta(klient);
            
       update.polAktualizuj(new PolaczenieAktualizujKlienta(){
       public void AktualizujKlienta(FormularzKlienta e) {
           db.ZaktualizujKlienta(e);
           tabelaKlient.wstawDane(db.WyswietlKlientow());
           JOptionPane.showOptionDialog(okno,
           "Stare dane: " + "               Nowe dane:      " + "\n" + 
           "ID:  " + id + "      ->      " + "ID:  " + e.ID_Osoby + "\n" +
           "PESEL: " + pesel + "      ->      " + "PESEL: " + e.PESEL,
           "Zmiana", JOptionPane.OK_OPTION,
           JOptionPane.INFORMATION_MESSAGE, null, null, null);

        }
   });
        }
   });
   ////////// DODAWANIE
    toolbar.polTooblarOs2( new PolaczenieToolbarOs2(){
        public void formEventOccured() {
                int id = tabelaOsoba.zwrocZaznaczenie();
                osoba = db.ZwrocKonkretnaOsobe(id);
                int rozmiar = db.ZwrocOstatniKlient() + 1;
                String cos = "VALUES ('" + rozmiar + "','" + osoba.ID + "','" + osoba.PESEL + "')";  
                String klient = "INSERT INTO Klient " + cos;
                db.DodajKlienta(klient);
                tabelaKlient.wstawDane(db.WyswietlKlientow());
       }
   });
   //usuwanie
    toolbar.polToolbarOs3 (new PolaczenieToolbarOs3() {
       public void formEventOccurred(String k) {
            db.UsunKlienta(k); 
            tabelaKlient.wstawDane(db.WyswietlKlientow());
       }
   });
   //wyszukaj
    toolbar.polToolbarOs4(new PolaczenieToolbarOs4(){
         public void formEventOccured() {
            PanelWyszukajKlienta wKlient = new PanelWyszukajKlienta();
           
    wKlient.pokazKlienta(new PolaczenieToolbarOs3(){
        public void formEventOccurred(String klient) {
            ListaKlientow = db.WyszukajKlienta(klient);
            PodgladTabelaKlient PTK = new PodgladTabelaKlient(ListaKlientow);
            
        }

   });
       }
   });
    
    toolbar.polToolbarOs5(new PolaczenieToolbarOs4(){
       public void formEventOccured() {
           PanelWyszukajOsoba wOsobe = new PanelWyszukajOsoba();
           
    wOsobe.pokazOsobe(new PolaczenieToolbarOs3(){
        public void formEventOccurred(String PESEL) {
            ListaOsob = db.WyszukajOsobe(PESEL);
            PodgladTabelaOsoba PTO = new PodgladTabelaOsoba(ListaOsob);
            
    
            
        }
   });
       }
   });
   
   tabelaKlient.usunKlienta(new PolaczenieTabelaGui(){
       public void usun(int wiersz){
           String cos = Integer.toString(wiersz);
           db.UsunTabelaKlient(cos);
           tabelaKlient.wstawDane(db.WyswietlKlientow());

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
          
            ////////////// PASEK MENU ////////////////
       
       menuPlikow.add(eksportuj);
       menuPlikow.add(importuj);
       menuPlikow.addSeparator();
       menuPlikow.add(zakoncz);
       
       pasekMenu.add(menuPlikow);
       
       // ustawienie skrotow klawiszowych
       
       menuPlikow.setMnemonic(KeyEvent.VK_P);
       eksportuj.setMnemonic(KeyEvent.VK_E);
       eksportuj.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
       importuj.setMnemonic(KeyEvent.VK_I);
       importuj.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
       zakoncz.setMnemonic(KeyEvent.VK_Z);
       zakoncz.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
       
       importuj.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e) {
               if (plikWybierz.showOpenDialog(GuiKlienta.this) == JFileChooser.APPROVE_OPTION){
                   try {
                       db.zapiszDoPliku(plikWybierz.getSelectedFile());
                   } catch (IOException ex) {
                       System.out.println(ex);
                       JOptionPane.showMessageDialog(GuiKlienta.this, "Wczytanie bazy nie powiodlo sie.", "Blad", JOptionPane.ERROR_MESSAGE);
                   }
               }
               
           }
       
       });
       
       eksportuj.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e) {
               if (plikWybierz.showSaveDialog(GuiKlienta.this) == JFileChooser.APPROVE_OPTION){
                   try {
                       db.wczytajPlik(plikWybierz.getSelectedFile());
                   } catch (IOException ex) {
                       System.out.println(ex);
                       JOptionPane.showMessageDialog(GuiKlienta.this, "Zapisanie bazy nie powiodlo sie.", "Blad", JOptionPane.ERROR_MESSAGE);
                   }
               }
               
           }
       
       });       
       
       zakoncz.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e) {
                int akcja = JOptionPane.showConfirmDialog(GuiKlienta.this, 
                       "Czy chcesz zakonczyc?", "Potwierdz", JOptionPane.OK_CANCEL_OPTION );
               if (akcja == JOptionPane.OK_OPTION) 
               System.exit(0);
           }     
        });
      
      return pasekMenu;
      
    }
}