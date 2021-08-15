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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class GuiMagazyn extends JFrame {
    private BazaDanych db = new BazaDanych();
    private PanelMagazyn panelMagazyn = new PanelMagazyn();
    private JFrame okno = new JFrame("Magazyn");
    private JFileChooser plikWybierz = new JFileChooser();
    private ToolbarMagazyn toolbar = new ToolbarMagazyn();
    private TabelaPracownik tabelaPracownik = new TabelaPracownik();
    private TabelaMagazyn tabelaMagazyn = new TabelaMagazyn();
    private FormularzMagazyn magazyn;
    private FormularzPracownik pracownik;
    private ArrayList<FormularzPracownik> ListaPracownikow = new ArrayList();
    private ArrayList<FormularzMagazyn> ListaMagazyn = new ArrayList();

GuiMagazyn(){
    tabelaPracownik.wstawDane(db.WyswietlPracownikow());
    tabelaMagazyn.wstawDane(db.WyswietlTowary());
    okno.setSize(new Dimension(750,750));
    okno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    okno.setMaximumSize(new Dimension(500,500));
    okno.setJMenuBar(PasekMenu());
    okno.add(panelMagazyn, BorderLayout.WEST);
    okno.add(toolbar, BorderLayout.NORTH);
    okno.add(tabelaMagazyn, BorderLayout.CENTER);
    okno.add(tabelaPracownik, BorderLayout.SOUTH);
    okno.addWindowListener(Zamkniecie());
    okno.setVisible(true);
    
    
    
       //edytuj
    toolbar.polToolbarOs1( new PolaczenieToolbarOs1(){
       public void formEventOccured() { 
            int wiersz = tabelaMagazyn.zwrocZaznaczenie();
            magazyn = db.ZwrocKonkretnyTowar(wiersz);
            int id = magazyn.ID_Pracownika;
            String nazwa = magazyn.produkt;
            int ilosc = magazyn.ilosc;
            String waznosc = magazyn.waznosc;
            String gramatura = magazyn.gramatura;
            String pojemnik = magazyn.pojemnik;
            String polozenie = magazyn.polozenie;
            AktualizujTowar update = new AktualizujTowar(magazyn);
            
       update.polAktualizuj(new PolaczenieAktualizujTowar(){
       public void aktualizuj(FormularzMagazyn towar) {
           db.ZaktualizujTowar(towar);
           tabelaMagazyn.wstawDane(db.WyswietlTowary());
           JOptionPane.showConfirmDialog(okno,
           "Stare dane: " + "               Nowe dane:      " + "\n" + 
           "ID Pracownika: " + id + "      ->      " + "ID Pracownika: " + towar.ID_Pracownika + "\n" +      
           "Nazwa produktu:  " + nazwa + "      ->      " + "Nazwa produktu:  " + towar.produkt + "\n" +
           "Ilość:  " + ilosc + "      ->      " + "Ilość:  " + towar.ilosc + "\n" +
           "Ważność:  " + waznosc + "      ->      " + "Ważność:  " + towar.waznosc + "\n" +
           "Gramatura:  " + gramatura + "      ->      " + "Gramatura:  " + towar.gramatura + "\n" +
           "Pojemnik:  " + pojemnik + "      ->      " + "Pojemnik:  " + towar.pojemnik + "\n" +
           "Położenie: " + polozenie + "      ->      " + "Położenie: " + towar.polozenie ,"Zmiana" 
           ,JOptionPane.OK_OPTION,
           JOptionPane.INFORMATION_MESSAGE);

        }
   });
        }
   });
    toolbar.polTooblarOs2( new PolaczenieToolbarOs2(){
        public void formEventOccured() {
               magazyn = panelMagazyn.ZwrocTowar();
               int rozmiar = db.ZwrocOstatniTowar()+ 1;
               magazyn.ID = rozmiar;
               String cos = "VALUES ('" + magazyn.ID + "','" + magazyn.ID_Pracownika + "','"+ magazyn.produkt + "','"+ magazyn.ilosc +
                       "','"+ magazyn.waznosc + "','" + magazyn.gramatura + "','"+ magazyn.pojemnik + "','" + magazyn.polozenie + "')";  
               String towar = "INSERT INTO Magazyn " + cos;
               db.DodajTowar(towar);
               tabelaMagazyn.wstawDane(db.WyswietlTowary());
        }
   });
   //usuwanie
    toolbar.polToolbarOs3 (new PolaczenieToolbarOs3() {
       public void formEventOccurred(String k) {
            db.UsunTowar(k); 
            tabelaMagazyn.wstawDane(db.WyswietlTowary());
       }
   });
   //wyszukaj
    toolbar.polToolbarOs4(new PolaczenieToolbarOs4(){
         public void formEventOccured() {
           PanelWyszukajTowar wmagazyn = new PanelWyszukajTowar();
           
    wmagazyn.pokazTowar(new PolaczenieToolbarOs3(){
        public void formEventOccurred(String towar) {
            ListaMagazyn = db.WyszukajTowar(towar);
            PodgladTabelaTowar PTT = new PodgladTabelaTowar(ListaMagazyn);
            
    PTT.usunTowar(new PolaczenieToolbarOs3(){
                public void formEventOccurred(String k) {
                    int K = Integer.parseInt(k);
                    magazyn = db.ZwrocKonkretnyTowar(K);
                    db.UsunTabelaTowar(k); 
                    tabelaMagazyn.wstawDane(db.WyswietlTowary());
                }
            });
        }
   });
       }
   });
   // usuwanie prawym przyciskiem myszy
   tabelaMagazyn.usunTowar(new PolaczenieTabelaGui(){
       public void usun(int wiersz){
           String cos = Integer.toString(wiersz);
           db.UsunTabelaTowar(cos);
           tabelaMagazyn.wstawDane(db.WyswietlTowary());
       }
   });
   
  // DODAWANIE KLIENTA DO ZWIERZAKA
  
   toolbar.polToolbarOs5(new PolaczenieToolbarOs5(){
        public void formEventOccurred() {
            int polePracownika = tabelaPracownik.zwrocZaznaczenie();
            int poleMagazyn = tabelaMagazyn.zwrocZaznaczenie();
            pracownik = db.ZwrocKonkretnegoPracownika(polePracownika);
            magazyn = db.ZwrocKonkretnyTowar(poleMagazyn);
            magazyn.ID_Pracownika = pracownik.ID;
            db.DodajPracownikowiTowar(magazyn);
            tabelaMagazyn.wstawDane(db.WyswietlTowary());
            tabelaPracownik.wstawDane(db.WyswietlPracownikow());
        }
    });
   
   // WYSWIETLANIE PRZETERMINOWANYCH PRODUKTOW
   toolbar.polToolbarOs6(new PolaczenieToolbarOs6(){
        public void formEventOccurred() {
            SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
            long millis=System.currentTimeMillis();  
            java.sql.Date date=new java.sql.Date(millis);  
            String data = date.toString();
            ListaMagazyn = db.WyswietlPrzedawnioneTowary();
            try {
                Date d1 = sdformat.parse(data);
                for (int i = 0 ; i < ListaMagazyn.size(); i++){
                    magazyn = ListaMagazyn.get(i);
                    Date tmp = sdformat.parse(magazyn.waznosc);
                        if(d1.compareTo(tmp) > 0) {
                        } else if(d1.compareTo(tmp) < 0) {
                            ListaMagazyn.remove(i);
                        } else if(d1.compareTo(tmp) == 0) {
                            ListaMagazyn.remove(i);
                        }
                }
            } catch (ParseException ex) {
                Logger.getLogger(GuiMagazyn.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            WyszukajPrzedawnionyTowar WPT = new WyszukajPrzedawnionyTowar(ListaMagazyn);
        }
    });
   
   
}

private WindowListener Zamkniecie(){
    WindowListener exitListener = new WindowAdapter(){
    public void windowClosing(WindowEvent e){
        int opcja = JOptionPane.showConfirmDialog(GuiMagazyn.this, "Opuszczasz formularz", "Opuszczenie formularza", JOptionPane.OK_CANCEL_OPTION);
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
               panelMagazyn.setVisible(menuPlikow.isSelected());
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
               if (plikWybierz.showOpenDialog(GuiMagazyn.this) == JFileChooser.APPROVE_OPTION){
                   try {
                       db.zapiszDoPliku(plikWybierz.getSelectedFile());
                   } catch (IOException ex) {
                       System.out.println(ex);
                       JOptionPane.showMessageDialog(GuiMagazyn.this, "Wczytanie bazy nie powiodlo sie.", "Blad", JOptionPane.ERROR_MESSAGE);
                   }
               }
               
           }
       
       });
       
       eksportuj.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e) {
               if (plikWybierz.showSaveDialog(GuiMagazyn.this) == JFileChooser.APPROVE_OPTION){
                   try {
                       db.wczytajPlik(plikWybierz.getSelectedFile());
                   } catch (IOException ex) {
                       System.out.println(ex);
                       JOptionPane.showMessageDialog(GuiMagazyn.this, "Zapisanie bazy nie powiodlo sie.", "Blad", JOptionPane.ERROR_MESSAGE);
                   }
               }
               
           }
       
       });       
       
       zakoncz.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e) {
                int akcja = JOptionPane.showConfirmDialog(GuiMagazyn.this, 
                       "Czy chcesz zakonczyc?", "Potwierdz", JOptionPane.OK_CANCEL_OPTION );
               if (akcja == JOptionPane.OK_OPTION) 
               System.exit(0);
           }     
        });
      
      return pasekMenu;
}
}