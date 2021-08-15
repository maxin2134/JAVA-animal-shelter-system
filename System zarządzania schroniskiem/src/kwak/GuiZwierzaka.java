package kwak;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.nio.file.Files;
import java.nio.file.Path;


public class GuiZwierzaka extends JFrame {

    private BazaDanych db = new BazaDanych();
    private PanelZwierzaka panelZwierzaka = new PanelZwierzaka();
    private JFrame okno = new JFrame("Formularz Zwierzaka");
    private JFileChooser plikWybierz = new JFileChooser();
    private ToolbarZwierzak toolbar = new ToolbarZwierzak();
    private TabelaKlient tabelaKlient = new TabelaKlient();
    private TabelaZwierzak tabelaZwierzakow = new TabelaZwierzak();
    
    private String sciezka;

    private FormularzZwierzaka zwierzak;
    private FormularzKlienta klient;
    private ArrayList<FormularzKlienta> ListaKlientow = new ArrayList();
    private ArrayList<FormularzZwierzaka> ListaZwierzakow = new ArrayList();

GuiZwierzaka(){
    tabelaKlient.wstawDane(db.WyswietlKlientow());
    tabelaZwierzakow.wstawDane(db.WyswietlZwierzaki());
    okno.setSize(new Dimension(750,750));
    okno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    okno.setMaximumSize(new Dimension(500,500));
    okno.setJMenuBar(PasekMenu());
    okno.add(panelZwierzaka, BorderLayout.WEST);
    okno.add(toolbar, BorderLayout.NORTH);
    okno.add(tabelaZwierzakow, BorderLayout.CENTER);
    okno.add(tabelaKlient, BorderLayout.EAST);
    okno.addWindowListener(Zamkniecie());

    okno.setVisible(true);
       //edytuj
    toolbar.polToolbarOs1( new PolaczenieToolbarOs1(){
       public void formEventOccured() { 
            int wiersz = tabelaZwierzakow.zwrocZaznaczenie();
            zwierzak = db.ZwrocKonkretnegoZwierzaka(wiersz);
            int id = zwierzak.ID_Klient;
            String Imie = zwierzak.imie;
            String Rasa = zwierzak.rasa;
            String gatunek = zwierzak.gatunek;
            String plec = zwierzak.plec;
            String przybyl = zwierzak.Data_przybycia;
            String zwolnienie = zwierzak.Data_zwolnienia;
            AktualizujZwierzaka update = new AktualizujZwierzaka(zwierzak);
            
       update.polAktualizuj(new PolaczenieAktualizujZwierzaka(){
       public void aktualizujZwierze(FormularzZwierzaka zwierzak) {
           db.ZaktualizujZwierzaka(zwierzak);
           tabelaZwierzakow.wstawDane(db.WyswietlZwierzaki());
           JOptionPane.showConfirmDialog(okno,
           "Stare dane: " + "               Nowe dane:      " + "\n" + 
           "ID Klienta: " + id + "      ->      " + "ID Klienta: " + zwierzak.ID_Klient + "\n" +      
           "Imie:  " + Imie + "      ->      " + "Imie:  " + zwierzak.imie + "\n" +
           "Rasa:  " + Rasa + "      ->      " + "Rasa:  " + zwierzak.rasa + "\n" +
           "Gatunek:  " + gatunek + "      ->      " + "Gatunek:  " + zwierzak.gatunek + "\n" +
           "Plec:  " + plec + "      ->      " + "Plec:  " + zwierzak.plec+ "\n" +
           "Data przybycia:  " + przybyl + "      ->      " + "Data przybycia:  " + zwierzak.Data_przybycia + "\n" +
           "Data zwolnienia:  " + zwolnienie + "      ->      " + "Data zwolnienia:  " + zwierzak.Data_zwolnienia,"Zmiana" 
           ,JOptionPane.OK_OPTION,
           JOptionPane.INFORMATION_MESSAGE);

        }
   });
        }
   });
    toolbar.polTooblarOs2( new PolaczenieToolbarOs2(){
        public void formEventOccured() {
                zwierzak = panelZwierzaka.ZwrocZwierzaka();
                int rozmiar = db.ZwrocOstatniegoZwierzaka()+ 1;
                zwierzak.ID = rozmiar;
                String sciezka = "C:\\Users\\USER\\Desktop\\kwak2\\Zdjęcia_zwierzat\\" + zwierzak.imie + "\\Profilowe";
                String cos = "VALUES ('" + zwierzak.ID + "','" + zwierzak.ID_Klient + "','"+ zwierzak.imie + "','"+ zwierzak.rasa +
                       "','"+ zwierzak.gatunek + "','" + zwierzak.plec + "','"+ zwierzak.Data_przybycia + "','"+ zwierzak.Data_zwolnienia + 
                       "','" + zwierzak.opis + "')";  
                String zwierzak = "INSERT INTO Zwierzak " + cos;
                db.DodajZwierzaka(zwierzak);
                tabelaZwierzakow.wstawDane(db.WyswietlZwierzaki());
                File file = new File(sciezka);
                try{
                file.mkdirs();
                }catch(Exception e){}
        }
   });
   //usuwanie
    toolbar.polToolbarOs3 (new PolaczenieToolbarOs3() {
       public void formEventOccurred(String k) {
        String imie = db.UsunZwierzaka(k);
        int K = Integer.parseInt(k);
        zwierzak = db.ZwrocKonkretnegoZwierzaka(K);
        String sciezka = "C:\\Users\\USER\\Desktop\\kwak2\\Zdjęcia_zwierzat\\" + zwierzak.imie;
        File file = new File(sciezka);
        deleteFolder(file);
        tabelaZwierzakow.wstawDane(db.WyswietlZwierzaki());
       }
   });
   //wyszukaj
    toolbar.polToolbarOs4(new PolaczenieToolbarOs4(){
         public void formEventOccured() {
            PanelWyszukajZwierzak wZwierzak = new PanelWyszukajZwierzak();

           
    wZwierzak.pokazZwierzaka(new PolaczenieToolbarOs3(){
        public void formEventOccurred(String zwierzk) {
            ListaZwierzakow = db.WyszukajZwierzaka(zwierzk);
            PodgladTabelaZwierzak PTZ = new PodgladTabelaZwierzak(ListaZwierzakow);
            
    PTZ.usunZwierzaka(new PolaczenieToolbarOs3(){
                public void formEventOccurred(String k) {
                    int K = Integer.parseInt(k);
                    zwierzak = db.ZwrocKonkretnegoZwierzaka(K);
                    String sciezka = "C:\\Users\\USER\\Desktop\\kwak2\\Zdjęcia_zwierzat\\" + zwierzak.imie;
                    File file = new File(sciezka);
                    deleteFolder(file);
                    db.UsunTabelaZwierzak(k); 
                    tabelaZwierzakow.wstawDane(db.WyswietlZwierzaki());
                }
            });
        }
   });
       }
   });
    
   // usuwanie prawym przyciskiem myszy
   tabelaZwierzakow.usunZwierzaka(new PolaczenieTabelaGui(){
       public void usun(int wiersz){
            String indeks = Integer.toString(wiersz);
            zwierzak = db.ZwrocKonkretnegoZwierzaka(wiersz);
            String imie = db.UsunTabelaZwierzak(indeks);
            String sciezka = "C:\\Users\\USER\\Desktop\\kwak2\\Zdjęcia_zwierzat\\" + zwierzak.imie;
            File file = new File(sciezka);
            deleteFolder(file);
            tabelaZwierzakow.wstawDane(db.WyswietlZwierzaki());
       }
   });
   
  // DODAWANIE KLIENTA DO ZWIERZAKA
  
   toolbar.polToolbarOs5(new PolaczenieToolbarOs5(){
        public void formEventOccurred() {
            int poleKlienta = tabelaKlient.zwrocZaznaczenie();
            int poleZwierzaka = tabelaZwierzakow.zwrocZaznaczenie();
            klient = db.ZwrocKonkretnegoKlienta(poleKlienta);
            zwierzak = db.ZwrocKonkretnegoZwierzaka(poleZwierzaka);
            zwierzak.ID_Klient = klient.ID_Osoby;
            
            db.DodajZwierzakowiKlienta(zwierzak);
            tabelaZwierzakow.wstawDane(db.WyswietlZwierzaki());
            tabelaKlient.wstawDane(db.WyswietlKlientow());
        }
    });
   
   // WYSWIETL ZDJECIE
   
   toolbar.polToolbarOs6(new PolaczenieToolbarOs6(){
        public void formEventOccurred() {
            int poleZwierzaka = tabelaZwierzakow.zwrocZaznaczenie();
            zwierzak = db.ZwrocKonkretnegoZwierzaka(poleZwierzaka);
            sciezka = "C:\\Users\\USER\\Desktop\\kwak2\\Zdjęcia_zwierzat\\"+ zwierzak.imie +"\\Profilowe";
            File file = new File(sciezka);
            try{
            String[] list = file.list();
            System.out.println("PLIK W KATALOGU PROFILOWE NA MIEJSCU 0 " + list[0]);
            sciezka += "\\" + (String)list[0];
            }catch(Exception e){}
            System.out.println("Sciezka przekazana do wywolania: " + sciezka);
            ZdjecieZwierzak zdjecia = new ZdjecieZwierzak(sciezka);
            
        }
    });
   
   
}

private WindowListener Zamkniecie(){
    WindowListener exitListener = new WindowAdapter(){
    public void windowClosing(WindowEvent e){
        int opcja = JOptionPane.showConfirmDialog(GuiZwierzaka.this, "Opuszczasz formularz", "Opuszczenie formularza", JOptionPane.OK_CANCEL_OPTION);
        if (opcja == JOptionPane.OK_OPTION){
            okno.dispose();
            db.ZamknijPolaczenie();}
        else
            okno.notify();
    }
    };
    return exitListener;
}

private JMenuBar PasekMenu(){
    
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
               panelZwierzaka.setVisible(menuPlikow.isSelected());
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
               if (plikWybierz.showOpenDialog(GuiZwierzaka.this) == JFileChooser.APPROVE_OPTION){
                   try {
                       db.zapiszDoPliku(plikWybierz.getSelectedFile());
                   } catch (IOException ex) {
                       System.out.println(ex);
                       JOptionPane.showMessageDialog(GuiZwierzaka.this, "Wczytanie bazy nie powiodlo sie.", "Blad", JOptionPane.ERROR_MESSAGE);
                   }
               }
               
           }
       
       });
       
       eksportuj.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e) {
               if (plikWybierz.showSaveDialog(GuiZwierzaka.this) == JFileChooser.APPROVE_OPTION){
                   try {
                       db.wczytajPlik(plikWybierz.getSelectedFile());
                   } catch (IOException ex) {
                       System.out.println(ex);
                       JOptionPane.showMessageDialog(GuiZwierzaka.this, "Zapisanie bazy nie powiodlo sie.", "Blad", JOptionPane.ERROR_MESSAGE);
                   }
               }
               
           }
       
       });       
       
       zakoncz.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e) {
                int akcja = JOptionPane.showConfirmDialog(GuiZwierzaka.this, 
                       "Czy chcesz zakonczyc?", "Potwierdz", JOptionPane.OK_CANCEL_OPTION );
               if (akcja == JOptionPane.OK_OPTION) 
               System.exit(0);
           }     
        });
      
      return pasekMenu;
}


   static void deleteFolder(File file){
      for (File subFile : file.listFiles()) {
         if(subFile.isDirectory()) {
            deleteFolder(subFile);
         } else {
            subFile.delete();
         }
      }
      file.delete();
   }

}