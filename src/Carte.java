public class Carte extends Articol{
    public String gen_literar;
    public String editura;
    public Integer idCarte;
    public Carte (String titlu, Integer an_publicare, String nume_autor, Integer zile_ramase, Boolean disponibil, String gen_literar, String editura, Integer idCarte) {
        super(titlu, an_publicare, nume_autor, zile_ramase, disponibil);
        this.gen_literar = gen_literar;
        this.editura = editura;
        this.idCarte = idCarte;
    }
    public String getGen_literar() {
        return gen_literar;
    }
    public String getEditura() {
        return editura;
    }
    public Integer getIdCarte() {
        return idCarte;
    }
    public void setGen_literar(String gen_literar) {
        this.gen_literar = gen_literar;
    }
    public void setEditura(String editura) {
        this.editura = editura;
    }
    public void setIdCarte(Integer idCarte) {
        this.idCarte = idCarte;
    }

}
