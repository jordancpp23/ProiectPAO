public class Bibliotecar extends Persoana{
    private Integer idBibliotecar;
    private Integer salariu;
    private Integer ore_lucrate;
    public Bibliotecar (String nume, int varsta, String nationalitate, String gen, Integer idBibliotecar, Integer salariu, Integer ore_lucrate) {
        super(nume, varsta, nationalitate, gen);
        this.idBibliotecar = idBibliotecar;
        this.salariu = salariu;
        this.ore_lucrate = ore_lucrate;
    }
    public Integer getIdBibliotecar() {
        return idBibliotecar;
    }
    public Integer getSalariu() {
        return salariu;
    }
    public Integer getOre_lucrate() {
        return ore_lucrate;
    }
    public void setIdBibliotecar(Integer idBibliotecar) {
        this.idBibliotecar = idBibliotecar;
    }
    public void setSalariu(Integer salariu) {
        this.salariu = salariu;
    }
    public void setOre_lucrate(Integer ore_lucrate) {
        this.ore_lucrate = ore_lucrate;
    }
}
