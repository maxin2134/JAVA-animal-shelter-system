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

public class GuiOperacja extends JFrame {
    private BazaDanych db = new BazaDanych();
    private PanelOperacja panelOperacja = new PanelOperacja();
    private JFrame okno = new JFrame("Operacja");
    private JFileChooser plikWybierz = new JFileChooser();
    private ToolbarOperacja toolbar = new ToolbarOperacja();
    private TabelaOperacja tabelaOperacja = new TabelaOperacja();
    
    private FormularzZwierzaka zwierzak;
    private FormularzKlienta klient;
    private FormularzPracownik pracownik;
    private FormularzOperacja operacja;
    
    private ArrayList<FormularzKlienta> ListaKlientow = new ArrayList();
    private ArrayList<FormularzZwierzaka> ListaZwierzakow = new ArrayList();
    private ArrayList<FormularzPracownik> ListaPracownikow = new ArrayList();
    private ArrayList<FormularzOperacja> ListaOperacji = new ArrayList();

GuiOperacja(){
    tabelaOperacja.wstawDane(db.WyswietlOperacje());
    okno.setSize(new Dimension(750,750));
    okno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    okno.setMaximumSize(new Dimension(500,500));
    okno.setJMenuBar(PasekMenu());
    okno.add(panelOperacja, BorderLayout.WEST);
    okno.add(toolbar, BorderLayout.NORTH);
    okno.add(tabelaOperacja, BorderLayout.CENTER);
    okno.addWindowListener(Zamkniecie());
    okno.setVisible(true);
    
    
    
    //edytuj
    toolbar.polToolbarOs1( new PolaczenieToolbarOs1(){
       public void formEventOccured() { 
            int wiersz = tabelaOperacja.zwrocZaznaczenie();
            operacja = db.ZwrocKonkretnaOperacje(wiersz);
            int id_zwierzaka = operacja.ID_Zwierzak;
            int id_klienta = operacja.ID_Klient;
            int id_pracownika = operacja.ID_Pracownik;
            String rodzaj = operacja.Rodzaj_Operacja;
            String dodanie = operacja.Dodanie;
            String zakonczenie = operacja.Zakonczenie;
            AktualizujOperacje update = new AktualizujOperacje(operacja);
            
       update.polAktualizuj(new PolaczenieAktualizujOperacje(){
       public void aktualizujOperacje(FormularzOperacja operacja) {
           db.ZaktualizujOperacje(operacja);
           tabelaOperacja.wstawDane(db.WyswietlOperacje());
           JOptionPane.showConfirmDialog(okno,
           "Stare dane: " + "               Nowe dane:      " + "\n" + 
           "ID Zwierzaka: " + id_zwierzaka + "      ->      " + "ID Zwierzaka: " + operacja.ID_Zwierzak + "\n" +      
           "ID Klienta:  " + id_klienta + "      ->      " + "ID Klienta:  " + operacja.ID_Klient + "\n" +
           "ID Pracownika:  " + id_pracownika + "      ->      " + "ID Pracownika:  " + operacja.ID_Pracownik + "\n" +
           "Rodzaj operacji:  " + rodzaj + "      ->      " + "Rodzaj operacji:  " + operacja.Rodzaj_Operacja + "\n" +
           "Data dodania:  " + dodanie + "      ->      " + "Data dodania:  " + operacja.Dodanie+ "\n" +
           "Data zakonczenia:  " + zakonczenie + "      ->      " + "Data zakonczenia:  " + operacja.Zakonczenie ,"Zmiana" 
           ,JOptionPane.OK_OPTION,
           JOptionPane.INFORMATION_MESSAGE);

        }
   });
        }
   });
    toolbar.polTooblarOs2( new PolaczenieToolbarOs2(){
        public void formEventOccured() {
               operacja = panelOperacja.ZwrocOperacje();
               int rozmiar = db.ZwrocOstatniaOperacje()+ 1;
               operacja.ID = rozmiar;
               String cos = "VALUES ('" + operacja.ID + "','" + operacja.ID_Zwierzak + "','"+ operacja.ID_Klient + "','"+ operacja.ID_Pracownik +
                       "','"+ operacja.Rodzaj_Operacja + "','" + operacja.Dodanie + "','"+ operacja.Zakonczenie + "')";  
               String opera = "INSERT INTO Operacja " + cos;
               db.DodajOperacje(opera);
               tabelaOperacja.wstawDane(db.WyswietlOperacje());
        }
   });
   //usuwanie
    toolbar.polToolbarOs3 (new PolaczenieToolbarOs3() {
       public void formEventOccurred(String k) {
            db.UsunOperacje(k); 
            tabelaOperacja.wstawDane(db.WyswietlOperacje());
       }
   });
   //wyszukaj
    toolbar.polToolbarOs4(new PolaczenieToolbarOs4(){
         public void formEventOccured() {
           PanelWyszukajOperacje wOperacja = new PanelWyszukajOperacje();
           
    wOperacja.pokazOperacje(new PolaczenieToolbarOs3(){
        public void formEventOccurred(String operaca) {
            ListaOperacji = db.WyszukajOperacje(operaca);
            PodgladTabelaOperacji PTO = new PodgladTabelaOperacji(ListaOperacji);
    PTO.usunOperacje(new PolaczenieToolbarOs3(){          
        public void formEventOccurred(String k) {
                    int K = Integer.parseInt(k);
                    operacja = db.ZwrocKonkretnaOperacje(K);
                    db.UsunTabelaOperacja(k); 
                    tabelaOperacja.wstawDane(db.WyswietlOperacje());
                }
            });
        }
   });
       }
   });
   // usuwanie prawym przyciskiem myszy
   tabelaOperacja.usunZwierzaka(new PolaczenieTabelaGui(){
       public void usun(int wiersz){
           String cos = Integer.toString(wiersz);
           db.UsunTabelaOperacja(cos);
           tabelaOperacja.wstawDane(db.WyswietlOperacje());

       }
   }); 
   
  // DODAWANIE KLIENTA DO OPERACJI
  
   toolbar.polToolbarOs5(new PolaczenieToolbarOs5(){
        public void formEventOccurred() {
            ListaKlientow = db.WyswietlKlientow();
            int zaznaczenie = tabelaOperacja.zwrocZaznaczenie();
            operacja = db.ZwrocKonkretnaOperacje(zaznaczenie);
            PodgladTabelaKlient podglad = new PodgladTabelaKlient(ListaKlientow);
            
        podglad.polToolbarOs3(new PolaczenieToolbarOs3(){
                public void formEventOccurred(String k) {
                   int K = Integer.valueOf(k);
                   klient = db.ZwrocKonkretnegoKlienta(K);
                   operacja.ID_Klient = klient.ID_Osoby;
                   db.ZaktualizujOperacje(operacja);
                   tabelaOperacja.wstawDane(db.WyswietlOperacje());
                }
            });
        
        }
    });
   
   // DODANIE ZWIERZAKA DO OPERACJI
   
   toolbar.polToolbarOs6(new PolaczenieToolbarOs6(){
        public void formEventOccurred() {
            
            ListaZwierzakow = db.WyswietlZwierzaki();
            int zaznaczenie = tabelaOperacja.zwrocZaznaczenie();
            operacja = db.ZwrocKonkretnaOperacje(zaznaczenie);
            PodgladTabelaZwierzak podglad = new PodgladTabelaZwierzak(ListaZwierzakow);
            
        podglad.polToolbarOs3(new PolaczenieToolbarOs3(){
                public void formEventOccurred(String k) {
                   int K = Integer.valueOf(k);
                   zwierzak = db.ZwrocKonkretnegoZwierzaka(K);
                   operacja.ID_Zwierzak = zwierzak.ID;
                   db.ZaktualizujOperacje(operacja);
                   tabelaOperacja.wstawDane(db.WyswietlOperacje());
                }
            });
        
        }
    });
  
   //DODANIE PRACOWNIKA DO OPERACJI
   
   toolbar.polToolbarOs7(new PolaczenieToolbarOs7(){
        public void formEventOccurred() {
            
            ListaPracownikow = db.WyswietlPracownikow();
            int zaznaczenie = tabelaOperacja.zwrocZaznaczenie();
            operacja = db.ZwrocKonkretnaOperacje(zaznaczenie);
            PodgladTabelaPracownik podglad = new PodgladTabelaPracownik(ListaPracownikow);
            
        podglad.polToolbarOs3(new PolaczenieToolbarOs3(){
                public void formEventOccurred(String k) {
                   int K = Integer.valueOf(k);
                   pracownik = db.ZwrocKonkretnegoPracownika(K);
                   operacja.ID_Pracownik = pracownik.ID;
                   db.ZaktualizujOperacje(operacja);
                   tabelaOperacja.wstawDane(db.WyswietlOperacje());
                }
            });
        
        }
    });
   
}

private WindowListener Zamkniecie(){
    WindowListener exitListener = new WindowAdapter(){
    public void windowClosing(WindowEvent e){
        int opcja = JOptionPane.showConfirmDialog(GuiOperacja.this, "Opuszczasz formularz", "Opuszczenie formularza", JOptionPane.OK_CANCEL_OPTION);
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
               panelOperacja.setVisible(menuPlikow.isSelected());
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
               if (plikWybierz.showOpenDialog(GuiOperacja.this) == JFileChooser.APPROVE_OPTION){
                   try {
                       db.zapiszDoPliku(plikWybierz.getSelectedFile());
                   } catch (IOException ex) {
                       System.out.println(ex);
                       JOptionPane.showMessageDialog(GuiOperacja.this, "Wczytanie bazy nie powiodlo sie.", "Blad", JOptionPane.ERROR_MESSAGE);
                   }
               }
               
           }
       
       });
       
       eksportuj.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e) {
               if (plikWybierz.showSaveDialog(GuiOperacja.this) == JFileChooser.APPROVE_OPTION){
                   try {
                       db.wczytajPlik(plikWybierz.getSelectedFile());
                   } catch (IOException ex) {
                       System.out.println(ex);
                       JOptionPane.showMessageDialog(GuiOperacja.this, "Zapisanie bazy nie powiodlo sie.", "Blad", JOptionPane.ERROR_MESSAGE);
                   }
               }
               
           }
       
       });       
       
       zakoncz.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e) {
                int akcja = JOptionPane.showConfirmDialog(GuiOperacja.this, 
                       "Czy chcesz zakonczyc?", "Potwierdz", JOptionPane.OK_CANCEL_OPTION );
               if (akcja == JOptionPane.OK_OPTION) 
               System.exit(0);
           }     
        });
      
      return pasekMenu;
}
}