public class Autor extends Persoana{
    private Integer idAutor;
    private String gen_principal;
    private String magnum_opus;
    private String ani_activitate;

    public Autor(String nume, int varsta, String nationalitate, String gen, Integer idAutor, String gen_principal, String magnum_opus, String ani_activitate) {
        super(nume, varsta, nationalitate, gen);
        this.idAutor = idAutor;
        this.gen_principal = gen_principal;
        this.magnum_opus = magnum_opus;
        this.ani_activitate = ani_activitate;
    }

    public Integer getIdAutor() {
        return idAutor;
    }
    public String getGen_principal() {
        return gen_principal;
    }
    public String getMagnum_opus() {
        return magnum_opus;
    }
    public String getAni_activitate() {
        return ani_activitate;
    }
    public void setIdAutor(Integer idAutor) {
        this.idAutor = idAutor;
    }
    public void setGen_principal(String gen_principal) {
        this.gen_principal = gen_principal;
    }
    public void setMagnum_opus(String magnum_opus) {
        this.magnum_opus = magnum_opus;
    }
    public void setAni_activitate(String ani_activitate) {
        this.ani_activitate = ani_activitate;
    }
    public String toString() {
        return super.toString() + "\nID Autor: " + idAutor + "\nGen principal: " + gen_principal + "\nMagnum opus: " + magnum_opus + "\nAni activitate: " + ani_activitate;
    }
    public int compareTo(Client client) {
        return 0;
    }
}
