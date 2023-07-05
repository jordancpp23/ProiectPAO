public abstract class Articol implements Comparable<Articol>{
    public String titlu;
    public Integer an_publicare;
    public String nume_autor;

    public Integer zile_ramase;
    public Boolean disponibil;

    public Articol(String titlu, Integer an_publicare, String nume_autor, Integer zile_ramase, Boolean disponibil) {
        this.titlu = titlu;
        this.an_publicare = an_publicare;
        this.nume_autor = nume_autor;
        this.zile_ramase = zile_ramase;
        this.disponibil = disponibil;
    }

    public String getTitlu() {
        return titlu;
    }
    public Integer getAn_publicare() {
        return an_publicare;
    }
    public String getNume_autor() {
        return nume_autor;
    }
    public Integer getZile_ramase() {
        return zile_ramase;
    }
    public Boolean getDisponibil() {
        return disponibil;
    }
    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }
    public void setAn_publicare(Integer an_publicare) {
        this.an_publicare = an_publicare;
    }
    public void setNume_autor(String nume_autor) {
        this.nume_autor = nume_autor;
    }
    public void setZile_ramase(Integer zile_ramase) {
        this.zile_ramase = zile_ramase;
    }
    public void setDisponibil(Boolean disponibil) {
        this.disponibil = disponibil;
    }
    public int compareTo(Articol other){
        return this.zile_ramase.compareTo(other.getZile_ramase());
    }
    public String toString() {
        return "Titlu: " + titlu + "\nAn publicare: " + an_publicare + "\nNume autor: " + nume_autor + "\nZile ramase: " + zile_ramase + "\nDisponibil: " + disponibil;
    }
}
