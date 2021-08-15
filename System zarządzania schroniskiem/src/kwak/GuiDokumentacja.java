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

public class GuiDokumentacja extends JFrame {
    private BazaDanych db = new BazaDanych();
    private PanelDokumentacja panelDokumentacji = new PanelDokumentacja();
    private JFrame okno = new JFrame("Dokumentacja");
    private JFileChooser plikWybierz = new JFileChooser();
    private ToolbarDokumentacja toolbar = new ToolbarDokumentacja();
    private TabelaDokumentacja tabelaDokumentacja = new TabelaDokumentacja();
    private TabelaZwierzak tabelaZwierzakow = new TabelaZwierzak();
    private FormularzZwierzaka zwierzak;
    private FormularzDokumentacja dokumentacja;
    private ArrayList<FormularzDokumentacja> ListaDokumentow = new ArrayList();
    private ArrayList<FormularzZwierzaka> ListaZwierzakow = new ArrayList();

GuiDokumentacja(){
    tabelaDokumentacja.wstawDane(db.WyswietlDokumenty());
    tabelaZwierzakow.wstawDane(db.WyswietlZwierzaki());
    okno.setSize(new Dimension(750,750));
    okno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    okno.setMaximumSize(new Dimension(500,500));
    okno.setJMenuBar(PasekMenu());
    okno.add(panelDokumentacji, BorderLayout.WEST);
    okno.add(toolbar, BorderLayout.NORTH);
    okno.add(tabelaZwierzakow, BorderLayout.SOUTH);
    okno.add(tabelaDokumentacja, BorderLayout.CENTER);
    okno.addWindowListener(Zamkniecie());
    okno.setVisible(true);
    
    
    
    //edytuj
    toolbar.polToolbarOs1( new PolaczenieToolbarOs1(){
       public void formEventOccured() { 
            int wiersz = tabelaDokumentacja.zwrocZaznaczenie();
            dokumentacja = db.ZwrocKonkretnyDokument(wiersz);
            int id = dokumentacja.ID_Zwierzak;
            String nazwa = dokumentacja.nazwa;
            String rodzaj = dokumentacja.rodzaj;
            String miejsce = dokumentacja.miejsce;
            AktualizujDokument update = new AktualizujDokument(dokumentacja);
            
       update.polAktualizuj(new PolaczenieAktualizujDokument(){
       public void atkualizujDokument(FormularzDokumentacja dokument) {
           db.ZaktualizujDokument(dokument);
           tabelaDokumentacja.wstawDane(db.WyswietlDokumenty());
           JOptionPane.showConfirmDialog(okno,
           "Stare dane: " + "               Nowe dane:      " + "\n" + 
           "ID Zwierzaka: " + id + "      ->      " + "ID Zwierzaka: " + dokument.ID_Zwierzak + "\n" +      
           "Nazwa dokumentu:  " + nazwa + "      ->      " + "Nazwa dokumentu:  " + dokument.nazwa + "\n" +
           "Rodzaj:  " + rodzaj + "      ->      " + "Rodzaj:  " + dokument.rodzaj + "\n" +
           "Miejsce:  " + miejsce + "      ->      " + "Miejsce:  " + dokument.miejsce ,"Zmiana" 
           ,JOptionPane.OK_OPTION,
           JOptionPane.INFORMATION_MESSAGE);

        }
   });
        }
   });
    toolbar.polTooblarOs2( new PolaczenieToolbarOs2(){
        public void formEventOccured() {
               dokumentacja = panelDokumentacji.ZwrocDokument();
               int rozmiar = db.ZwrocOstatniDokument()+ 1;
               dokumentacja.ID = rozmiar;
               String cos = "VALUES ('" + dokumentacja.ID + "','" + dokumentacja.ID_Zwierzak + "','"+ dokumentacja.nazwa + "','"+ dokumentacja.rodzaj +
                       "','"+ dokumentacja.miejsce + "')";  
               String dokument = "INSERT INTO Dokumentacja " + cos;
               db.DodajDokument(dokument);
               tabelaDokumentacja.wstawDane(db.WyswietlDokumenty());
        }
   });
   //usuwanie
    toolbar.polToolbarOs3 (new PolaczenieToolbarOs3() {
       public void formEventOccurred(String k) {
            String cos = k;
            db.UsunDokument(k); 
            tabelaDokumentacja.wstawDane(db.WyswietlDokumenty());
       }
   });
   //wyszukaj
    toolbar.polToolbarOs4(new PolaczenieToolbarOs4(){
         public void formEventOccured() {
           PanelWyszukajDokument wdokument = new PanelWyszukajDokument();
           
    wdokument.pokazDokument(new PolaczenieToolbarOs3(){
        public void formEventOccurred(String dokument) {
            ListaDokumentow = db.WyszukajDokument(dokument);
            PodgladTabelaDokument PTD = new PodgladTabelaDokument(ListaDokumentow);
    PTD.usunDokument(new PolaczenieToolbarOs3(){
                public void formEventOccurred(String k) {
                    int K = Integer.parseInt(k);
                    dokumentacja = db.ZwrocKonkretnyDokument(K);
                    db.UsunTabelaDokument(k); 
                    tabelaDokumentacja.wstawDane(db.WyswietlDokumenty());
                }
            });
        }
   });
       }
   });
   // usuwanie prawym przyciskiem myszy
   tabelaDokumentacja.usunDokument(new PolaczenieTabelaGui(){
       public void usun(int wiersz){
           String cos = Integer.toString(wiersz);
           db.UsunTabelaDokument(cos);
           tabelaDokumentacja.wstawDane(db.WyswietlDokumenty());
       }
   });
   
  // DODAWANIE KLIENTA DO ZWIERZAKA
  
   toolbar.polToolbarOs5(new PolaczenieToolbarOs5(){
        public void formEventOccurred() {
            int poleDokumentu = tabelaDokumentacja.zwrocZaznaczenie();
            int poleZwierzaka = tabelaZwierzakow.zwrocZaznaczenie();
            dokumentacja = db.ZwrocKonkretnyDokument(poleDokumentu);
            zwierzak = db.ZwrocKonkretnegoZwierzaka(poleZwierzaka);
            dokumentacja.ID_Zwierzak = zwierzak.ID;
            db.DodajZwierzakowiDokumentacje(dokumentacja);
            tabelaZwierzakow.wstawDane(db.WyswietlZwierzaki());
            tabelaDokumentacja.wstawDane(db.WyswietlDokumenty());
        }
    });
   
}

private WindowListener Zamkniecie(){
    WindowListener exitListener = new WindowAdapter(){
    public void windowClosing(WindowEvent e){
        int opcja = JOptionPane.showConfirmDialog(GuiDokumentacja.this, "Opuszczasz formularz", "Opuszczenie formularza", JOptionPane.OK_CANCEL_OPTION);
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
               panelDokumentacji.setVisible(menuPlikow.isSelected());
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
               if (plikWybierz.showOpenDialog(GuiDokumentacja.this) == JFileChooser.APPROVE_OPTION){
                   try {
                       db.zapiszDoPliku(plikWybierz.getSelectedFile());
                   } catch (IOException ex) {
                       System.out.println(ex);
                       JOptionPane.showMessageDialog(GuiDokumentacja.this, "Wczytanie bazy nie powiodlo sie.", "Blad", JOptionPane.ERROR_MESSAGE);
                   }
               }
               
           }
       
       });
       
       eksportuj.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e) {
               if (plikWybierz.showSaveDialog(GuiDokumentacja.this) == JFileChooser.APPROVE_OPTION){
                   try {
                       db.wczytajPlik(plikWybierz.getSelectedFile());
                   } catch (IOException ex) {
                       System.out.println(ex);
                       JOptionPane.showMessageDialog(GuiDokumentacja.this, "Zapisanie bazy nie powiodlo sie.", "Blad", JOptionPane.ERROR_MESSAGE);
                   }
               }
               
           }
       
       });       
       
       zakoncz.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e) {
                int akcja = JOptionPane.showConfirmDialog(GuiDokumentacja.this, 
                       "Czy chcesz zakonczyc?", "Potwierdz", JOptionPane.OK_CANCEL_OPTION );
               if (akcja == JOptionPane.OK_OPTION) 
               System.exit(0);
           }     
        });
      
      return pasekMenu;
}
}