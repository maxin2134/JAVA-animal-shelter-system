/////////////////////////////////////////////////////////////////////////
////////////////////////////////UWAGA////////////////////////////////////
/////////////////////////////////////////////////////////////////////////
// WSZĘDZIE POWINIEN BYĆ PREPAREDSTATEMENT W CELU UNIKNIĘCIA MODYFIKACJI POLECEŃ PRZEZ ZŁOŚLIWE OPROGRAMOWANIE!!!
// Aktualnie nie jest zrobione, ze względów rozszerzenia funkcjonalności projektu, ale prędzej czy później należy to niezwłocznie zrobić
// ze względu na bezpieczeństwo danych. Pewnie jeszcze kilka rzeczy by rzuciło się w oczy, ale na ten moment to, aż tyle.
package kwak;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BazaDanych {
    private Statement stmt;
    private Connection c;
    private PreparedStatement pstmt;
    private int ile;
    private boolean Zaloguj;
    private String zwierzuk;
    private String nazwa;

    
    private ArrayList<FormularzOsoba> ListaOsob;
    private ArrayList<FormularzOsoba> ListaOsop;
    private ArrayList<FormularzPracownik> ListaPracownikow;
    private ArrayList<FormularzKlienta> ListaKlientow;
    private ArrayList<FormularzZwierzaka> ListaZwierzakow;
    private ArrayList<FormularzMagazyn> ListaTowarow;
    private ArrayList<FormularzDokumentacja> ListaDokumentow;
    private ArrayList<FormularzOperacja> ListaOperacji;
    
    
    private FormularzKlienta klient;
    private FormularzZwierzaka zwierzak;
    private FormularzOsoba osoba;
    private FormularzPracownik pracownik;
    private FormularzMagazyn towar;
    private FormularzDokumentacja dokument;
    private FormularzOperacja operacja;
        

    /////////////////// BAZA DANYCH //////////////////////
    
    BazaDanych(){
        try {
            c = null;
            stmt = null;
            c = DriverManager.getConnection("jdbc:sqlite:Kwak.db");
            System.out.println("Podlaczono");
        } catch (SQLException ex) {
            Logger.getLogger(BazaDanych.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean Logowanie(String Login, String Haslo){
    
        try {
            this.stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Login, Haslo FROM Pracownik");
            while (rs.next()){
                String login = rs.getString("Login");
                String haslo = rs.getString("Haslo");
                
                boolean cos = login.equals(Login);
                boolean cos2 = haslo.equals(Haslo);
                
                if (cos && cos2){
                System.out.println("Zalogowano");
                Zaloguj = true;
                stmt.close();
                break;
                }
                else {
                Zaloguj = false;
                }
            }
            
            
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
        return Zaloguj;
    }
    
public void ZamknijPolaczenie(){
    try {
        c.close();
        System.out.println("Rozłączono");
    }catch(Exception e){
    }
}

public void wyczyscBaze(ArrayList osoby){
osoby.clear();
}

public boolean equals(Object obj){
    return(this == obj);
}
//////////////////////////////////////////////////////////
////////////////////// OSOBA ////////////////////////////

    public ArrayList WyswietlOsoby(){
        try {
            ListaOsob = new ArrayList();
            this.stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Osoba");
            while (rs.next()){
                int ID = rs.getInt("ID");
                String Imie = rs.getString("Imie");
                String Nazwisko = rs.getString("Nazwisko");
                int Nr_domu = rs.getInt("Nr_domu");
                int Nr_lokalu = rs.getInt("Nr_lokalu");
                String Miasto = rs.getString("Miasto");
                int Kod_pocztowy = rs.getInt("Kod_pocztowy");
                long PESEL = rs.getLong("PESEL");
                FormularzOsoba osoba = new FormularzOsoba (this,ID,Imie,Nazwisko,Nr_domu,Nr_lokalu,Miasto,Kod_pocztowy,PESEL);
                ListaOsob.add(osoba);
            }                
            stmt.close();
        } catch (Exception e) {
            System.out.println("Error1: " + e.getMessage());
        }
        
        return ListaOsob;
}
    

public FormularzOsoba ZwrocKonkretnaOsobe(int k){
        ListaOsob = new ArrayList();
        try {
            this.stmt = c.createStatement();
            String sql = "SELECT * FROM Osoba ";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
            int ID = rs.getInt("ID");
            String Imie = rs.getString("Imie");
            String Nazwisko = rs.getString("Nazwisko");
            int Nr_domu = rs.getInt("Nr_domu");
            int Nr_lokalu = rs.getInt("Nr_lokalu");
            String Miasto = rs.getString("Miasto");
            int Kod_pocztowy = rs.getInt("Kod_pocztowy");
            long PESEL = rs.getLong("PESEL");
            FormularzOsoba osoba = new FormularzOsoba (this,ID,Imie,Nazwisko,Nr_domu,Nr_lokalu,Miasto,Kod_pocztowy,PESEL);
            ListaOsob.add(osoba);
            }
            osoba = ListaOsob.get(k);
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return osoba;
        
}
public ArrayList WyszukajOsobe(String Pesel){
    
            String sql = " SELECT * FROM Osoba "
                    + "WHERE " + "PESEL = " + Pesel + ";";
        try {
            ListaOsob = new ArrayList();
            this.stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                int ID = rs.getInt("ID");
                String Imie = rs.getString("Imie");
                String Nazwisko = rs.getString("Nazwisko");
                int Nr_domu = rs.getInt("Nr_domu");
                int Nr_lokalu = rs.getInt("Nr_lokalu");
                String Miasto = rs.getString("Miasto");
                int Kod_pocztowy = rs.getInt("Kod_pocztowy");
                long PESEL = rs.getLong("PESEL");
                FormularzOsoba wOsoba = new FormularzOsoba (this,ID,Imie,Nazwisko,Nr_domu,Nr_lokalu,Miasto,Kod_pocztowy,PESEL);
                ListaOsob.add(wOsoba);
                }
        } catch (SQLException ex) {
            System.out.println("Error3: " + ex.getMessage());
        }
        return ListaOsob;
}

public void ZaktualizujOsobe(FormularzOsoba osoba){
        String sql = "UPDATE Osoba SET Imie = ?," 
                + "Nazwisko = ? ," 
                + "Nr_domu = ? ,"
                + "Nr_lokalu = ? ," 
                + "Miasto = ? ,"
                + "Kod_pocztowy = ? ,"
                + "PESEL = ? "
                + "WHERE ID = ?";
        try {
            this.pstmt = c.prepareStatement(sql);
            pstmt.setString(1, osoba.Imie);
            pstmt.setString(2, osoba.Nazwisko);
            pstmt.setInt(3, osoba.Nr_domu);
            pstmt.setInt(4, osoba.Nr_lokalu);
            pstmt.setString(5, osoba.miasto);
            pstmt.setInt(6, osoba.Kod_pocztowy);
            pstmt.setLong(7, osoba.PESEL);
            pstmt.setInt(8, osoba.ID);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
        System.out.println("Error4: " + ex.getMessage());

        }

}

public void DodajOsobe(String Osoba){
    try{
        this.stmt = c.createStatement();
        stmt.executeQuery(Osoba);
        stmt.close();
    }catch(Exception e){
        System.out.println("Error5: " + e.getMessage());
    }

}

public void UsunOsobe(String Osoba){
    String sql = " SELECT ID FROM Osoba "
        + "WHERE ID = " + Osoba + ";";
    try{
        this.stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
        int ID = rs.getInt("ID");
        nazwa = "DELETE FROM Osoba WHERE ID = " + ID;
        }
        stmt.executeQuery(nazwa);
        stmt.close();
    }catch(Exception e){
        System.out.println("Error: " + e.getMessage());
    }
    
}

public void UsunTabelaOsoba (String indeks){
    String sql = "SELECT ID FROM Osoba";
    int index = Integer.parseInt(indeks);
    ListaOsob = new ArrayList();
    
    try{
    ResultSet rs = stmt.executeQuery(sql);
    while (rs.next()){
    int ID = rs.getInt("ID");
    FormularzOsoba osoba = new FormularzOsoba (this,ID);
    ListaOsob.add(osoba);
    }
    osoba = ListaOsob.get(index);
    String sql2 = "DELETE FROM Osoba WHERE ID = " + osoba.ID;
    stmt.execute(sql2);
    
    }catch(Exception e){
        System.out.println("Error: " + e.getMessage());
}
}



public int ZwrocOstatniOsoba(){
    
        try {
            this.stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT ID FROM Osoba");
            while(rs.next()){
            ile = rs.getInt("ID");
            }            
            stmt.close();
            return ile;
        } catch (SQLException ex) {
            System.out.println("Error7: " + ex.getMessage());
            return 0;
        }
}
/////////////////////////////////////////////////////
////////////////PLIKI///////////////////

public void zapiszDoPliku(File plik) throws IOException {
    
    FileOutputStream fos = new FileOutputStream(plik);
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    ListaOsob = new ArrayList();
    ListaOsob = WyswietlOsoby();
    FormularzOsoba[] Osoby = ListaOsob.toArray(new FormularzOsoba[ListaOsob.size()] );
    oos.writeObject(Osoby);
    oos.close();
    
}

public void wczytajPlik(File plik) throws IOException {

        try {
            FileInputStream fis = new FileInputStream(plik);
            ObjectInputStream ois = new ObjectInputStream(fis);
            FormularzOsoba[] Osoby = (FormularzOsoba[]) ois.readObject();
            ListaOsob = new ArrayList();
            ListaOsob.addAll(Arrays.asList(Osoby));
            ois.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BazaDanych.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}

///////////////////////////////////////////////////////////////
///////////////////////////PRACOWNIK/////////////////////////////

public int ZwrocOstatniPracownik(){
    
        try {
            this.stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT ID FROM Pracownik");
            while(rs.next()){
            ile = rs.getInt("ID");
            }            
            stmt.close();
            return ile;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            return 0;
        }
}

public void DodajPracownika(String Pracownik){
    try{
        this.stmt = c.createStatement();
        stmt.executeQuery(Pracownik);
        stmt.close();
    }catch(Exception e){
        System.out.println("Error: " + e.getMessage());
    }
}

public void UsunPracownika (String Pracownik){
String sql = " SELECT ID FROM Pracownik "
        + "WHERE ID = " + Pracownik + ";";
    try{
        this.stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
        int ID = rs.getInt("ID");
        nazwa = "DELETE FROM Pracownik WHERE ID = " + ID;
        }
        stmt.executeQuery(nazwa);
        stmt.close();
    }catch(Exception e){
        System.out.println("Error Pracownik: " + e.getMessage());
    }
}

public void UsunTabelaPracownik (String indeks){
    String sql = "SELECT ID FROM Pracownik";
    int index = Integer.parseInt(indeks);
    ListaPracownikow = new ArrayList();
    
    try{
    ResultSet rs = stmt.executeQuery(sql);
    while (rs.next()){
    int ID = rs.getInt("ID");
    FormularzPracownik pracownik = new FormularzPracownik (this,ID);
    ListaPracownikow.add(pracownik);
    }
    pracownik = ListaPracownikow.get(index);
    String sql2 = "DELETE FROM Pracownik WHERE ID = " + pracownik.ID;
    stmt.execute(sql2);
    
    }catch(Exception e){
        System.out.println("Error: " + e.getMessage());
}
}

public ArrayList WyswietlPracownikow(){
        try {
            ListaPracownikow = new ArrayList();
            this.stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT ID,Login FROM Pracownik");
            while (rs.next()){
                int ID = rs.getInt("ID");
                String Login = rs.getString("Login");
                FormularzPracownik pracownik = new FormularzPracownik (this,ID,Login);
                ListaPracownikow.add(pracownik);
            }                
            stmt.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        return ListaPracownikow;
}

public FormularzPracownik ZwrocKonkretnegoPracownika(int k){

        ListaPracownikow = new ArrayList();
        try {
            this.stmt = c.createStatement();
            String sql = "SELECT * FROM Pracownik ";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
            int ID = rs.getInt("ID");
            String Login = rs.getString("Login");
            String Haslo = rs.getString("Haslo");
            FormularzPracownik pracownik = new FormularzPracownik (this,ID,Login,Haslo);
            ListaPracownikow.add(pracownik);
            }
            pracownik = ListaPracownikow.get(k);
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return pracownik;
        
}

public ArrayList WyszukajPracownika(String id){
            FormularzPracownik wPracownik;
            String sql = " SELECT * FROM Pracownik "
                    + "WHERE ID = " + id +  "; ";
        try {
            ListaPracownikow = new ArrayList();
            this.stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                int ID = rs.getInt("ID");
                String login = rs.getString("Login");
                String haslo = rs.getString("Haslo");
                wPracownik = new FormularzPracownik (this,ID,login,haslo);
                ListaPracownikow.add(wPracownik);
                }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return ListaPracownikow;
}

public void ZaktualizujPracownika(FormularzPracownik pracownik){
        String sql = "UPDATE Pracownik SET Login = ?," 
                + "Haslo = ? " 
                + "WHERE ID = ?";
        try {
            this.pstmt = c.prepareStatement(sql);
            pstmt.setString(1, pracownik.Login);
            pstmt.setString(2, pracownik.Haslo);
            pstmt.setInt(3, pracownik.ID);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
        System.out.println("Error: " + ex.getMessage());

        }

}

///////////////////////////////////////////////
///////////////////KLIENT//////////////////////

public int ZwrocOstatniKlient(){
    
        try {
            this.stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT ID FROM Klient");
            while(rs.next()){
            ile = rs.getInt("ID");
            }            
            stmt.close();
            return ile;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            return 0;
        }
}

public void DodajKlienta(String Klient){
    try{
        this.stmt = c.createStatement();
        stmt.executeQuery(Klient);
        stmt.close();
    }catch(Exception e){
        System.out.println("Error: " + e.getMessage());
    }
}

public void UsunKlienta (String Klient){
String sql = " SELECT ID FROM Klient "
        + "WHERE ID = " + Klient + ";";
    try{
        this.stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
        int ID = rs.getInt("ID");
        nazwa = "DELETE FROM Klient WHERE ID = " + ID;
        }
        stmt.executeQuery(nazwa);
        stmt.close();
    }catch(Exception e){
        System.out.println("Error Klient: " + e.getMessage());
    } 
}

public void UsunTabelaKlient (String indeks){
    String sql = "SELECT ID FROM Klient";
    int index = Integer.parseInt(indeks);
    ListaKlientow = new ArrayList();
    
    try{
    ResultSet rs = stmt.executeQuery(sql);
    while (rs.next()){
    int ID = rs.getInt("ID");
    FormularzKlienta klient = new FormularzKlienta (this,ID);
    ListaKlientow.add(klient);
    }
    klient = ListaKlientow.get(index);
    String sql2 = "DELETE FROM Klient WHERE ID = " + klient.ID;
    stmt.execute(sql2);
    
    }catch(Exception e){
        System.out.println("Error: " + e.getMessage());
}
}

public ArrayList WyswietlKlientow(){
        try {
            ListaKlientow = new ArrayList();
            this.stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Klient");
            while (rs.next()){
                int ID = rs.getInt("ID");
                int ID_Osoba = rs.getInt("ID_Osoba");
                long PESEL = rs.getLong("PESEL");
                FormularzKlienta klient = new FormularzKlienta (this,ID,ID_Osoba,PESEL);
                ListaKlientow.add(klient);
            }                
            stmt.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        return ListaKlientow;
}

public FormularzKlienta ZwrocKonkretnegoKlienta(int k){
        ListaKlientow = new ArrayList();
        try {
            this.stmt = c.createStatement();
            String sql = "SELECT * FROM Klient ";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
            int ID = rs.getInt("ID");
            int ID_Osoba = rs.getInt("ID_Osoba");
            long PESEL = rs.getLong("PESEL");
            klient = new FormularzKlienta (this,ID,ID_Osoba,PESEL);
            ListaKlientow.add(klient);
            }
            klient = ListaKlientow.get(k);
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return klient;
        
}

public ArrayList WyszukajKlienta(String klient){
            FormularzKlienta wKlient;
            String sql = " SELECT * FROM Klient "
                    + "WHERE ID_Osoba = " + klient + ";";
        try {
            ListaKlientow = new ArrayList();
            this.stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                int ID = rs.getInt("ID");
                int id_klient = rs.getInt("ID_Osoba");
                long PESEL = rs.getLong("PESEL");
                wKlient = new FormularzKlienta (this,ID,id_klient,PESEL);
                ListaKlientow.add(wKlient);
                }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return ListaKlientow;
}

public void ZaktualizujKlienta(FormularzKlienta klient){
        String sql = "UPDATE Klient SET ID_Osoba = ?," 
                + "PESEL = ? "
                + "WHERE ID = ?";
        try {
            this.pstmt = c.prepareStatement(sql);
            pstmt.setInt(1, klient.ID_Osoby);
            pstmt.setLong(2, klient.PESEL);
            pstmt.setInt(3, klient.ID);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
        System.out.println("Error: " + ex.getMessage());

        }

}

/////////////////////ZWIERZAK/////////////////////////
//////////////////////////////////////////////////////

public int ZwrocOstatniegoZwierzaka(){
    
        try {
            this.stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT ID FROM Zwierzak");
            while(rs.next()){
            ile = rs.getInt("ID");
            }            
            stmt.close();
            return ile;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            return 0;
        }
}

public void DodajZwierzaka(String zwierzak){
    try{
        this.stmt = c.createStatement();
        stmt.executeQuery(zwierzak);
        stmt.close();
    }catch(Exception e){
        System.out.println("Error: " + e.getMessage());
    }
}

public String UsunZwierzaka (String indeks){
        String sql = " SELECT ID,Imie FROM Zwierzak "
        + "WHERE ID = " + indeks + ";";
    try{
        this.stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
        int ID = rs.getInt("ID");
        String imie = rs.getString("Imie");
        zwierzuk = "DELETE FROM Zwierzak WHERE ID = " + ID;
        nazwa = imie;
        }
        stmt.executeQuery(zwierzuk);
        stmt.close();
    }catch(Exception e){
        System.out.println("Error: " + e.getMessage());
    }
    return nazwa;
}

public String UsunTabelaZwierzak (String indeks){
    String sql = "SELECT ID,Imie FROM ZWIERZAK";
    int index = Integer.parseInt(indeks);
    ListaZwierzakow = new ArrayList();
    
    try{
    ResultSet rs = stmt.executeQuery(sql);
    while (rs.next()){
    int ID = rs.getInt("ID");
    String imie = rs.getString("Imie");
    FormularzZwierzaka zwierzak = new FormularzZwierzaka (this,ID,imie);
    ListaZwierzakow.add(zwierzak);
    }
    zwierzak = ListaZwierzakow.get(index);
    nazwa = zwierzak.imie;
    String sql2 = "DELETE FROM Zwierzak WHERE ID = " + zwierzak.ID;
    stmt.execute(sql2);
    
    }catch(Exception e){
        System.out.println("Error: " + e.getMessage());
}
    return nazwa;
}

public ArrayList WyswietlZwierzaki(){
        try {
            ListaZwierzakow = new ArrayList();
            this.stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Zwierzak");
            while (rs.next()){
                int ID = rs.getInt("ID");
                int ID_klient = rs.getInt("ID_Klient");
                String imie = rs.getString("Imie");
                String Rasa = rs.getString("Rasa");
                String Gatunek = rs.getString("Gatunek");
                String Plec = rs.getString("Płeć");
                String Data_przybycia = rs.getString("Data_przybycia");
                String Data_zwolnienia = rs.getString("Data_zwolnienia");
                String opis = rs.getString("Opis");
                
                zwierzak = new FormularzZwierzaka (this,ID,ID_klient,imie,Rasa,Gatunek,Plec,Data_przybycia,Data_zwolnienia,opis);
                ListaZwierzakow.add(zwierzak);
            }                
            stmt.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        return ListaZwierzakow;
}

public FormularzZwierzaka ZwrocKonkretnegoZwierzaka(int k){
        ListaZwierzakow = new ArrayList();
        try {
            this.stmt = c.createStatement();
            String sql = "SELECT * FROM Zwierzak ";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
            int ID = rs.getInt("ID");
            int ID_klient = rs.getInt("ID_Klient");
            String imie = rs.getString("Imie");
            String Rasa = rs.getString("Rasa");
            String Gatunek = rs.getString("Gatunek");
            String Plec = rs.getString("Płeć");
            String Data_przybycia = rs.getString("Data_przybycia");
            String Data_zwolnienia = rs.getString("Data_zwolnienia");
            String opis = rs.getString("Opis");
            zwierzak = new FormularzZwierzaka (this,ID,ID_klient,imie,Rasa,Gatunek,Plec,Data_przybycia,Data_zwolnienia,opis);
            ListaZwierzakow.add(zwierzak);
            }
            zwierzak = ListaZwierzakow.get(k);
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return zwierzak;
        
}

public ArrayList WyszukajZwierzaka(String zwierz){
            String sql = " SELECT * FROM Zwierzak "
                    + "WHERE ID_Klient = " + zwierz + ";";
        try {
            ListaZwierzakow = new ArrayList();
            this.stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
                int ID = rs.getInt("ID");
                int ID_klient = rs.getInt("ID_Klient");
                String imie = rs.getString("Imie");
                String Rasa = rs.getString("Rasa");
                String Gatunek = rs.getString("Gatunek");
                String Plec = rs.getString("Płeć");
                String Data_przybycia = rs.getString("Data_przybycia");
                String Data_zwolnienia = rs.getString("Data_zwolnienia");
                String opis = rs.getString("Opis");
                zwierzak = new FormularzZwierzaka (this,ID,ID_klient,imie,Rasa,Gatunek,Plec,Data_przybycia,Data_zwolnienia,opis);
                ListaZwierzakow.add(zwierzak);
        }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return ListaZwierzakow;
}

public void ZaktualizujZwierzaka(FormularzZwierzaka zwierzak){
        String sql = "UPDATE Zwierzak SET ID_Klient = ?," 
                + "Imie = ? ," 
                + "Rasa = ? ,"
                + "Gatunek = ? ," 
                + "Płeć = ? ,"
                + "Data_przybycia = ? ,"
                + "Data_zwolnienia = ? ,"
                + "Opis = ? "
                + "WHERE ID = ?";
        try {
            this.pstmt = c.prepareStatement(sql);
            pstmt.setInt(1, zwierzak.ID_Klient);
            pstmt.setString(2, zwierzak.imie);
            pstmt.setString(3, zwierzak.rasa);
            pstmt.setString(4, zwierzak.gatunek);
            pstmt.setString(5, zwierzak.plec);
            pstmt.setString(6, zwierzak.Data_przybycia);
            pstmt.setString(7, zwierzak.Data_zwolnienia);
            pstmt.setString(8, zwierzak.opis);
            pstmt.setInt(9, zwierzak.ID);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
        System.out.println("Error4: " + ex.getMessage());

        }

        }

public void DodajZwierzakowiKlienta(FormularzZwierzaka zwierzak){
String sql = "UPDATE Zwierzak SET ID_Klient = ?" 
                + "WHERE ID = ?";
        try {
            this.pstmt = c.prepareStatement(sql);
            pstmt.setInt(1, zwierzak.ID_Klient);
            pstmt.setInt(2, zwierzak.ID);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
        System.out.println("Error4: " + ex.getMessage());

        }
}

////////////////////MAGAZYN///////////////////////////
//////////////////////////////////////////////////////

public int ZwrocOstatniTowar(){
    
        try {
            this.stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT ID FROM Magazyn");
            while(rs.next()){
            ile = rs.getInt("ID");
            }            
            stmt.close();
            return ile;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            return 0;
        }
}

public void DodajTowar(String towar){
    try{
        this.stmt = c.createStatement();
        stmt.executeQuery(towar);
        stmt.close();
    }catch(Exception e){
        System.out.println("Error: " + e.getMessage());
    }
}

public void UsunTowar (String towar){
String sql = " SELECT ID FROM Magazyn "
        + "WHERE ID = " + towar + ";";
    try{
        this.stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
        int ID = rs.getInt("ID");
        nazwa = "DELETE FROM Magazyn WHERE ID = " + ID;
        }
        stmt.executeQuery(nazwa);
        stmt.close();
    }catch(Exception e){
        System.out.println("Error Magazyn: " + e.getMessage());
    }
}

public void UsunTabelaTowar (String indeks){
    String sql = "SELECT ID FROM Magazyn";
    int index = Integer.parseInt(indeks);
    ListaTowarow = new ArrayList();
    
    try{
    ResultSet rs = stmt.executeQuery(sql);
    while (rs.next()){
    int ID = rs.getInt("ID");
    FormularzMagazyn towa = new FormularzMagazyn (this,ID);
    ListaTowarow.add(towa);
    }
    towar = ListaTowarow.get(index);
    String sql2 = "DELETE FROM Magazyn WHERE ID = " + towar.ID;
    stmt.execute(sql2);
    
    }catch(Exception e){
        System.out.println("Error: " + e.getMessage());
}
}

public ArrayList WyswietlPrzedawnioneTowary(){
        try {
            ListaTowarow = new ArrayList();
            this.stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT ID,Nazwa_produktu,Ilość,Ważność,Pojemnik,Polozenie  FROM Magazyn");
            while (rs.next()){
                int ID = rs.getInt("ID");
                String produkt = rs.getString("Nazwa_produktu");
                String Ilosc = rs.getString("Ilość");
                int ilosc = Integer.parseInt(Ilosc);
                String waznosc = rs.getString("Ważność");
                String pojemnik = rs.getString("Pojemnik");
                String polozenie = rs.getString("Polozenie");

                FormularzMagazyn towar = new FormularzMagazyn (this,ID,produkt,ilosc,waznosc,pojemnik,polozenie);
                ListaTowarow.add(towar);
            }                
            stmt.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        return ListaTowarow;
}

public ArrayList WyswietlTowary(){
        try {
            ListaTowarow = new ArrayList();
            this.stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Magazyn");
            while (rs.next()){
                int ID = rs.getInt("ID");
                int ID_Pracownik = rs.getInt("ID_Pracownik");
                String produkt = rs.getString("Nazwa_produktu");
                String Ilosc = rs.getString("Ilość");
                int ilosc = Integer.parseInt(Ilosc);
                String waznosc = rs.getString("Ważność");
                String gramatura = rs.getString("Gramatura");
                String pojemnik = rs.getString("Pojemnik");
                String polozenie = rs.getString("Polozenie");
                FormularzMagazyn towar = new FormularzMagazyn (this,ID,ID_Pracownik,produkt,ilosc,waznosc,gramatura,pojemnik,polozenie);
                ListaTowarow.add(towar);
            }                
            stmt.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        return ListaTowarow;
}

public FormularzMagazyn ZwrocKonkretnyTowar(int k){
        ListaTowarow = new ArrayList();
        try {
            this.stmt = c.createStatement();
            String sql = "SELECT * FROM Magazyn ";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
            int ID = rs.getInt("ID");
            int ID_Pracownik = rs.getInt("ID_Pracownik");
            String produkt = rs.getString("Nazwa_produktu");
            String Ilosc = rs.getString("Ilość");
            int ilosc = Integer.parseInt(Ilosc);
            String waznosc = rs.getString("Ważność");
            String gramatura = rs.getString("Gramatura");
            String pojemnik = rs.getString("Pojemnik");
            String polozenie = rs.getString("Polozenie");
            towar = new FormularzMagazyn (this,ID,ID_Pracownik,produkt,ilosc,waznosc,gramatura,pojemnik,polozenie);
            ListaTowarow.add(towar);
            }
            towar = ListaTowarow.get(k);
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return towar;
        
}

public ArrayList WyszukajTowar(String towr){
            String sql = " SELECT * FROM Magazyn "
                    + "WHERE Nazwa_produktu = '" + towr + "';";
        try {
            ListaTowarow = new ArrayList();
            this.stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            int ID = rs.getInt("ID");
            int ID_Pracownik = rs.getInt("ID_Pracownik");
            String produkt = rs.getString("Nazwa_produktu");
            String Ilosc = rs.getString("Ilość");
            int ilosc = Integer.parseInt(Ilosc);
            String waznosc = rs.getString("Ważność");
            String gramatura = rs.getString("Gramatura");
            String pojemnik = rs.getString("Pojemnik");
            String polozenie = rs.getString("Polozenie");
            towar = new FormularzMagazyn (this,ID,ID_Pracownik,produkt,ilosc,waznosc,gramatura,pojemnik,polozenie);
            ListaTowarow.add(towar);
        }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return ListaTowarow;
}

public void ZaktualizujTowar(FormularzMagazyn towar){
        String sql = "UPDATE Magazyn SET ID_Pracownik= ?," 
                + "Nazwa_produktu = ? ," 
                + "Ilość = ? ,"
                + "Ważność = ? ," 
                + "Gramatura = ? ,"
                + "Pojemnik = ? "
                + "WHERE ID = ?";
        try {
            this.pstmt = c.prepareStatement(sql);
            pstmt.setInt(1, towar.ID_Pracownika);
            pstmt.setString(2, towar.produkt);
            pstmt.setInt(3, towar.ilosc);
            pstmt.setString(4, towar.waznosc);
            pstmt.setString(5, towar.gramatura);
            pstmt.setString(6, towar.pojemnik);
            pstmt.setInt(7, towar.ID);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
        System.out.println("Error4: " + ex.getMessage());

        }

        }

public void DodajPracownikowiTowar(FormularzMagazyn towar){
String sql = "UPDATE Magazyn SET ID_Pracownik= ?" 
                + "WHERE ID = ?";
        try {
            this.pstmt = c.prepareStatement(sql);
            pstmt.setInt(1, towar.ID_Pracownika);
            pstmt.setInt(2, towar.ID);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
        System.out.println("Error4: " + ex.getMessage());

        }
}
/////////////////////////////////////////////////////////////////
///////////////////////DOKUMENTACJA//////////////////////////////
/////////////////////////////////////////////////////////////////

public int ZwrocOstatniDokument(){
    
        try {
            this.stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT ID FROM Dokumentacja");
            while(rs.next()){
            ile = rs.getInt("ID");
            }            
            stmt.close();
            return ile;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            return 0;
        }
}

public void DodajDokument(String dokument){
    try{
        this.stmt = c.createStatement();
        stmt.executeQuery(dokument);
        stmt.close();
    }catch(Exception e){
        System.out.println("Error: " + e.getMessage());
    }
}

public void UsunDokument (String dokument){
String sql = " SELECT ID FROM Dokumentacja "
        + "WHERE ID = " + dokument + ";";
    try{
        this.stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
        int ID = rs.getInt("ID");
        zwierzuk = "DELETE FROM Dokumentacja WHERE ID = " + ID;
        }
        stmt.executeQuery(zwierzuk);
        stmt.close();
    }catch(Exception e){
        System.out.println("Error Dokumentacja: " + e.getMessage());
    } 
}

public void UsunTabelaDokument (String indeks){
    String sql = "SELECT ID FROM Dokumentacja";
    int index = Integer.parseInt(indeks);
    ListaDokumentow = new ArrayList();
    
    try{
    ResultSet rs = stmt.executeQuery(sql);
    while (rs.next()){
    int ID = rs.getInt("ID");
    FormularzDokumentacja dokumen = new FormularzDokumentacja (this,ID);
    ListaDokumentow.add(dokumen);
    }
    dokument = ListaDokumentow.get(index);
    String sql2 = "DELETE FROM Dokumentacja WHERE ID = " + dokument.ID;
    stmt.execute(sql2);
    
    }catch(Exception e){
        System.out.println("Error: " + e.getMessage());
}
}

public ArrayList WyswietlDokumenty(){
        try {
            ListaDokumentow = new ArrayList();
            this.stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Dokumentacja");
            while (rs.next()){
                int ID = rs.getInt("ID");
                int ID_Zwierzak = rs.getInt("ID_Zwierzak");
                String nazwa = rs.getString("Nazwa_dokumentu");
                String rodzaj = rs.getString("Rodzaj");
                String miejsce = rs.getString("Miejsce");

                FormularzDokumentacja dokument = new FormularzDokumentacja (this,ID,ID_Zwierzak,nazwa,rodzaj,miejsce);
                ListaDokumentow.add(dokument);
            }                
            stmt.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        return ListaDokumentow;
}

public FormularzDokumentacja ZwrocKonkretnyDokument(int k){
        ListaDokumentow = new ArrayList();
        try {
            this.stmt = c.createStatement();
            String sql = "SELECT * FROM Dokumentacja ";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
            int ID = rs.getInt("ID");
            int ID_Zwierzak = rs.getInt("ID_Zwierzak");
            String nazwa = rs.getString("Nazwa_dokumentu");
            String rodzaj = rs.getString("Rodzaj");
            String miejsce = rs.getString("Miejsce");

            FormularzDokumentacja dokument = new FormularzDokumentacja (this,ID,ID_Zwierzak,nazwa,rodzaj,miejsce);
            ListaDokumentow.add(dokument);
            }
            dokument = ListaDokumentow.get(k);
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return dokument;
        
}

public ArrayList WyszukajDokument(String dokumnt){
            String sql = " SELECT * FROM Dokumentacja "
                    + "WHERE ID_Zwierzak = " + dokumnt + ";";
        try {
            ListaDokumentow = new ArrayList();
            this.stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                int ID = rs.getInt("ID");
                int ID_Zwierzak = rs.getInt("ID_Zwierzak");
                String nazwa = rs.getString("Nazwa_dokumentu");
                String rodzaj = rs.getString("Rodzaj");
                String miejsce = rs.getString("Miejsce");
                dokument = new FormularzDokumentacja (this,ID,ID_Zwierzak,nazwa,rodzaj,miejsce);
                ListaDokumentow.add(dokument);
                }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return ListaDokumentow;
}

public void ZaktualizujDokument(FormularzDokumentacja dokument){
        String sql = "UPDATE Dokumentacja SET ID_Zwierzak = ?," 
                + "Nazwa_dokumentu = ? ," 
                + "Rodzaj = ? ,"
                + "Miejsce = ? "
                + "WHERE ID = ?";
        try {
            this.pstmt = c.prepareStatement(sql);
            pstmt.setInt(1, dokument.ID_Zwierzak);
            pstmt.setString(2, dokument.nazwa);
            pstmt.setString(3, dokument.rodzaj);
            pstmt.setString(4, dokument.miejsce);
            pstmt.setInt(5, dokument.ID);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
        System.out.println("Error4: " + ex.getMessage());

        }

        }

public void DodajZwierzakowiDokumentacje(FormularzDokumentacja dokument){
String sql = "UPDATE Dokumentacja SET ID_Zwierzak= ?" 
                + "WHERE ID = ?";
        try {
            this.pstmt = c.prepareStatement(sql);
            pstmt.setInt(1, dokument.ID_Zwierzak);
            pstmt.setInt(2, dokument.ID);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
        System.out.println("Error4: " + ex.getMessage());

        }
}

/////////////////////////////////////////////////////////////////
///////////////////////OPERACJA//////////////////////////////////
/////////////////////////////////////////////////////////////////

public int ZwrocOstatniaOperacje(){
    
        try {
            this.stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT ID FROM Operacja");
            while(rs.next()){
            ile = rs.getInt("ID");
            }            
            stmt.close();
            return ile;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            return 0;
        }
}

public void DodajOperacje(String operacja){
    try{
        this.stmt = c.createStatement();
        stmt.executeQuery(operacja);
        stmt.close();
    }catch(Exception e){
        System.out.println("Error: " + e.getMessage());
    }
}

public void UsunOperacje (String operacja){
String sql = " SELECT ID FROM Operacja "
        + "WHERE ID = " + operacja + ";";
    try{
        this.stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
        int ID = rs.getInt("ID");
        nazwa = "DELETE FROM Operacja WHERE ID = " + ID;
        }
        stmt.executeQuery(nazwa);
        stmt.close();
    }catch(Exception e){
        System.out.println("Error Operacja: " + e.getMessage());
    } 
    
}

public void UsunTabelaOperacja (String indeks){
    String sql = "SELECT ID FROM Operacja";
    int index = Integer.parseInt(indeks);
    ListaOperacji = new ArrayList();
    
    try{
    ResultSet rs = stmt.executeQuery(sql);
    while (rs.next()){
    int ID = rs.getInt("ID");
    FormularzOperacja operacj = new FormularzOperacja (this,ID);
    ListaOperacji.add(operacj);
    }
    operacja = ListaOperacji.get(index);
    String sql2 = "DELETE FROM Operacja WHERE ID = " + operacja.ID;
    stmt.execute(sql2);
    
    }catch(Exception e){
        System.out.println("Error: " + e.getMessage());
}
}

public ArrayList WyswietlOperacje(){
        try {
            ListaOperacji = new ArrayList();
            this.stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Operacja");
            while (rs.next()){
                int ID = rs.getInt("ID");
                int ID_Zwierzak = rs.getInt("ID_Zwierzak");
                int ID_Klient = rs.getInt("ID_KLient");
                int ID_Pracownik = rs.getInt("ID_Pracownik");
                String Opera = rs.getString("Rodzaj_operacji");
                String dodanie = rs.getString("Data_dodania");
                String zakonczenie = rs.getString("Data_zakończenia");

                FormularzOperacja operacja = new FormularzOperacja (this,ID,ID_Zwierzak,ID_Klient,ID_Pracownik,Opera,dodanie,zakonczenie);
                ListaOperacji.add(operacja);
            }                
            stmt.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        return ListaOperacji;
}

public FormularzOperacja ZwrocKonkretnaOperacje(int k){
        ListaOperacji = new ArrayList();
        try {
            this.stmt = c.createStatement();
            String sql = "SELECT * FROM Operacja ";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
            int ID = rs.getInt("ID");
            int ID_Zwierzak = rs.getInt("ID_Zwierzak");
            int ID_Klient = rs.getInt("ID_KLient");
            int ID_Pracownik = rs.getInt("ID_Pracownik");
            String Opera = rs.getString("Rodzaj_operacji");
            String dodanie = rs.getString("Data_dodania");
            String zakonczenie = rs.getString("Data_zakończenia");
            FormularzOperacja operacja = new FormularzOperacja (this,ID,ID_Zwierzak,ID_Klient,ID_Pracownik,Opera,dodanie,zakonczenie);
            ListaOperacji.add(operacja);
            }
            operacja = ListaOperacji.get(k);
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return operacja;
        
}

public ArrayList WyszukajOperacje(String operaca){
            String sql = " SELECT * FROM Operacja "
                    + "WHERE ID_Zwierzak = " + operaca + ";";
        try {
            ListaOperacji = new ArrayList();
            this.stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                int ID = rs.getInt("ID");
                int ID_Zwierzak = rs.getInt("ID_Zwierzak");
                int ID_Klient = rs.getInt("ID_KLient");
                int ID_Pracownik = rs.getInt("ID_Pracownik");
                String Opera = rs.getString("Rodzaj_operacji");
                String dodanie = rs.getString("Data_dodania");
                String zakonczenie = rs.getString("Data_zakończenia");
                operacja = new FormularzOperacja (this,ID,ID_Zwierzak,ID_Klient,ID_Pracownik,Opera,dodanie,zakonczenie);
                ListaOperacji.add(operacja);
                }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return ListaOperacji;
}

public void ZaktualizujOperacje(FormularzOperacja operacja){
        String sql = "UPDATE Operacja SET ID_Zwierzak= ?," 
                + "ID_KLient = ? ," 
                + "ID_Pracownik = ? ,"
                + "Rodzaj_operacji = ? ," 
                + "Data_dodania = ? ,"
                + "Data_zakończenia = ? "
                + "WHERE ID = ?";
        try {
            this.pstmt = c.prepareStatement(sql);
            pstmt.setInt(1, operacja.ID_Zwierzak);
            pstmt.setInt(2, operacja.ID_Klient);
            pstmt.setInt(3, operacja.ID_Pracownik);
            pstmt.setString(4, operacja.Rodzaj_Operacja);
            pstmt.setString(5, operacja.Dodanie);
            pstmt.setString(6, operacja.Zakonczenie);
            pstmt.setInt(7, operacja.ID);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
        System.out.println("Error4: " + ex.getMessage());

        }

        }



}