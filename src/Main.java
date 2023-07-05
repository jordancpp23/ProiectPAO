import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = Biblioteca.getInstance();
        ConexiuneBD conexiuneBD = new ConexiuneBD();
        Connection conn = conexiuneBD.connect();
        conexiuneBD.creeazaTabelCarti();
        Carte c1 = new Carte("Ion", 2010, "Liviu Rebreanu", 10, true, "Roman", "Humanitas", 1, "Ion da cu parul in cap");
        conexiuneBD.adaugaCarte(c1);
        biblioteca.addCarte(c1);
        conexiuneBD.afiseazaCartiDisponibile();
        biblioteca.addCarte(new Carte("Enigma Otiliei", 2010, "George Calinescu", 10, true, "Roman", "Humanitas", 2, "Otilia e o..."));
        biblioteca.addCarte(new Carte("Morometii", 2010, "Marin Preda", 10, true, "Roman", "Humanitas", 3, "Cea mai functionala familie din romania"));
        biblioteca.addCarte(new Carte("Baltagul", 2010, "Mihail Sadoveanu", 10, true, "Roman", "Humanitas", 4, "Miorita cu extra steps"));
        biblioteca.addCarte(new Carte("Ultima noapte de dragoste, intaia noapte de razboi", 2010, "Camil Petrescu", 10, true, "Roman", "Humanitas", 5, "plagiat clar dupa Marcel Proust"));
        biblioteca.addClient(new Client("Popescu Ion", 15, "Romana", "Barbat", 1, "test@gmail.com", "07n-amcartela", "independentei 204"));
        biblioteca.addBibliotecar(new Bibliotecar("Jordan", 21, "Romana", "Barbat adevarat", 1, 250, 8));
        biblioteca.addDVD(new DVD("The Godfather", 1972, "Francis Ford Coppola", 10, true, "Drama", "Paramount Pictures", 1));
        biblioteca.addDVD(new DVD("The Shawshank Redemption", 1994, "Frank Darabont", 10, true, "Drama", "Castle Rock Entertainment", 2));
        biblioteca.addDVD(new DVD("The Dark Knight", 2008, "Christopher Nolan", 10, true, "Action", "Warner Bros", 3));
        Menu meniu = new Menu();
        meniu.afiseazaMainMenu();
    }
}