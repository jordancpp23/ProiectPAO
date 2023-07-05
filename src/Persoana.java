public abstract class Persoana implements Comparable<Client>{
    protected String nume;
    protected int varsta;
    protected String nationalitate;
    protected String gen;

    public Persoana(String nume, int varsta, String nationalitate, String gen) {
        this.nume = nume;
        this.varsta = varsta;
        this.nationalitate = nationalitate;
        this.gen = gen;
    }

    public String getNume() {
        return nume;
    }
    public int getVarsta() {
        return varsta;
    }
    public String getNationalitate() {
        return nationalitate;
    }
    public String getGen() {
        return gen;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }
    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }
    public void setNationalitate(String nationalitate) {
        this.nationalitate = nationalitate;
    }
    public void setGen(String gen) {
        this.gen = gen;
    }

    public String toString() {
        return "Persoana:\n" + "Nume: " + nume + "\nVarsta: " + varsta + "\nNationalitate: " + nationalitate + "\nGen: " + gen;
    }

    public abstract int compareTo(Client client);
}
