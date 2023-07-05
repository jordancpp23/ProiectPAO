public class DVD extends Articol{
    private String gen_film;
    private String studio;
    private Integer idDVD;

    public DVD(String titlu, Integer an_publicare, String nume_autor, Integer zile_ramase, Boolean disponibil, String gen_film, String studio, Integer idDVD) {
        super(titlu, an_publicare, nume_autor, zile_ramase, disponibil);
        this.gen_film = gen_film;
        this.studio = studio;
        this.idDVD = idDVD;
    }

    public String getGen_film() {
        return gen_film;
    }
    public String getStudio() {
        return studio;
    }
    public Integer getIdDVD() {
        return idDVD;
    }
    public void setGen_film(String gen_film) {
        this.gen_film = gen_film;
    }
    public void setStudio(String studio) {
        this.studio = studio;
    }
    public void setIdDVD(Integer idDVD) {
        this.idDVD = idDVD;
    }
    public String toString() {
        return super.toString() + "\nGen film: " + gen_film + "\nStudio: " + studio + "\nID DVD: " + idDVD;
    }

}
