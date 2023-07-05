import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private static Biblioteca instance = null;
    private List<Articol> articole = new ArrayList<Articol>();
    private List<Client> clienti = new ArrayList<Client>();
    private List<Bibliotecar> bibliotecari = new ArrayList<Bibliotecar>();
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
    public List<Client> getClienti() {
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
}
