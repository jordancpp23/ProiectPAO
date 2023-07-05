import java.util.TreeSet;
public class Client extends Persoana{
    private Integer idClient;
    private String email;
    private String telefon;
    private String adresa;
    private TreeSet<Articol> articole_imprumutate = new TreeSet<>();
    public Client(String nume, int varsta, String nationalitate, String gen, Integer idClient, String email, String telefon, String adresa) {
        super(nume, varsta, nationalitate, gen);
        this.idClient = idClient;
        this.email = email;
        this.telefon = telefon;
        this.adresa = adresa;
    }

    public Integer getIdClient() {
        return idClient;
    }
    public String getEmail() {
        return email;
    }
    public String getTelefon() {
        return telefon;
    }
    public String getAdresa() {
        return adresa;
    }
    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
    public TreeSet<Articol> getArticole_imprumutate() {
        return articole_imprumutate;
    }
    public void setArticole_imprumutate(TreeSet<Articol> articole_imprumutate) {
        this.articole_imprumutate = articole_imprumutate;
    }
    public String toString() {
        return super.toString() + "\nID Client: " + idClient + "\nEmail: " + email + "\nTelefon: " + telefon + "\nAdresa: " + adresa
                + "\nNr. articole imprumutate: " + articole_imprumutate.size();
    }
    @Override
    public int compareTo(Client client) {
        if (client.getNume() == null)
            return 0;
        return articole_imprumutate.size() - client.articole_imprumutate.size();
    }
}
