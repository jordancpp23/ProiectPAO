import java.util.*;

public class Biblioteca {
    private static Biblioteca instance = null;
    private List<Articol> articole = new ArrayList<Articol>();
    private TreeSet<Client> clienti = new TreeSet<Client>();

    private List<Bibliotecar> bibliotecari = new ArrayList<Bibliotecar>();

    private List<Autor> autori = new ArrayList<Autor>();
    private Biblioteca() {
    }
    public static Biblioteca getInstance() {
        if (instance == null)
            instance = new Biblioteca();
        return instance;
    }
    public List<Articol> getArticole() {
        return articole;
    }
    public TreeSet<Client> getClienti() {
        return clienti;
    }
    public List<Bibliotecar> getBibliotecari() {
        return bibliotecari;
    }
    public void addArticol(Articol articol) {
        articole.add(articol);
    }
    public void addClient(Client client) {
        clienti.add(client);
    }
    public void addBibliotecar(Bibliotecar bibliotecar) {
        bibliotecari.add(bibliotecar);
    }

    public List<Carte> getCarti() {
        List<Carte> carti = new ArrayList<Carte>();
        for (Articol articol : articole) {
            if (articol instanceof Carte)
                carti.add((Carte)articol);
        }
        return carti;
    }

    public List<DVD> getDVDs() {
        List<DVD> dvds = new ArrayList<DVD>();
        for (Articol articol : articole) {
            if (articol instanceof DVD)
                dvds.add((DVD)articol);
        }
        return dvds;
    }
    public void removeArticol(Articol articol) {
        articole.remove(articol);
    }
    public void showCarti() {
        for (Carte carte : getCarti()) {
            System.out.println(carte);
        }
    }
    public void addCarte(Carte carte) {
        articole.add(carte);
    }
    public void showDVDs() {
        for (DVD dvd : getDVDs()) {
            System.out.println(dvd);
        }
    }

    public Boolean esteBibliotecar(String username, Integer idBibliotecar) {
        for (Bibliotecar bibliotecar : bibliotecari) {
            if (bibliotecar.getNume().equals(username) && bibliotecar.getIdBibliotecar().equals(idBibliotecar))
                return true;
        }
        return false;
    }

    public void addDVD(DVD dvd) {
        articole.add(dvd);
    }

    public void showClientiCuCevaImprumutat() {
        boolean ok = false;
        for (Client client : clienti) {
            if (client.getArticole_imprumutate().size() > 0) {
                System.out.println(client);
                ok = true;
            }
        }
        if (!ok)
            System.out.println("Nu exista clienti cu ceva imprumutat");
    }

    public List<Autor> getAutori() {
        return autori;
    }
    public void addAutor(Autor autor) {
        autori.add(autor);
    }
}
