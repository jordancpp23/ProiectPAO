public class bibliotecaService {
    Biblioteca biblioteca = Biblioteca.getInstance();
    ConexiuneBD conexiuneBD = new ConexiuneBD();
    public void showCartiDisponibile() {
        boolean ok = false;
        for (Carte carte : biblioteca.getCarti()) {
            if (carte.getDisponibil()) {
                ok = true;
                System.out.println(carte);
            }
        }
        if (!ok)
            System.out.println("Nu exista carti disponibile");
    }
    public void showDVDsDisponibile() {
        boolean ok = false;
        for (DVD dvd : biblioteca.getDVDs()) {
            if (dvd.getDisponibil()) {
                ok = true;
                System.out.println(dvd);
            }
        }
        if (!ok)
            System.out.println("Nu exista DVD-uri disponibile");
    }
    public void AdaugaCarte(Carte carte) {
        for (Carte c : biblioteca.getCarti()) {
            if (c.getTitlu().equals(carte.getTitlu())) {
                System.out.println("Cartea exista deja");
                return;
            }
            biblioteca.addCarte(carte);
        }
    }
    public void AdaugaDVD(DVD dvd) {
        for (DVD d : biblioteca.getDVDs()) {
            if (d.getTitlu().equals(dvd.getTitlu())) {
                System.out.println("DVD-ul exista deja");
                return;
            }
            biblioteca.addDVD(dvd);
        }
    }

    public void StergeCarte(Carte carte) {
        for (Carte c : biblioteca.getCarti()) {
            if (c.getTitlu().equals(carte.getTitlu())) {
                biblioteca.removeArticol(carte);
                return;
            }
        }
        System.out.println("Cartea nu exista");
    }
    public void StergeDVD(DVD dvd) {
        for (DVD d : biblioteca.getDVDs()) {
            if (d.getTitlu().equals(dvd.getTitlu())) {
                biblioteca.removeArticol(dvd);
                return;
            }
        }
        System.out.println("DVD-ul nu exista");
    }
    public void ImprumutaCarte(String nume_carte, String nume_client)
    {
        for (Carte c : biblioteca.getCarti()) {
            if (c.getTitlu().equals(nume_carte)){
                if (c.getDisponibil()) {
                    for (Client client : biblioteca.getClienti()) {
                        if (client.getNume().equals(nume_client)) {
                            client.getArticole_imprumutate().add(c);
                            c.setDisponibil(false);
                            c.setZile_ramase(14);
                            return;
                        }
                    }
                    System.out.println("Clientul nu exista");

                }
                System.out.println("Cartea nu este disponibila");
                return;
            }
        }
        System.out.println("Cartea nu exista");
    }
    public void ImprumutaDVD(String nume_dvd, String nume_client)
    {
        for (DVD d : biblioteca.getDVDs()) {
            if (d.getTitlu().equals(nume_dvd)) {
                if (d.getDisponibil()) {
                    for (Client client : biblioteca.getClienti()) {
                        if (client.getNume().equals(nume_client)) {
                            client.getArticole_imprumutate().add(d);
                            d.setDisponibil(false);
                            d.setZile_ramase(14);
                            return;
                        }
                    }
                    System.out.println("Clientul nu exista");

                }
                System.out.println("DVD-ul nu este disponibil");
                return;
            }
        }
        System.out.println("DVD-ul nu exista");
    }
    public void ReturneazaCarte(String nume_carte, String nume_client)
    {
        for (Carte c : biblioteca.getCarti()) {
            if (c.getTitlu().equals(nume_carte)) {
                if (!c.getDisponibil()) {
                    for (Client client : biblioteca.getClienti()) {
                        if (client.getNume().equals(nume_client)) {
                            client.getArticole_imprumutate().remove(c);
                            c.setDisponibil(true);
                            return;
                        }
                    }
                    System.out.println("Clientul nu exista");

                }
                System.out.println("Cartea nu este imprumutata");
                return;
            }
        }
        System.out.println("Cartea nu exista");
    }
    public void ReturneazaDVD(String nume_dvd, String nume_client)
    {
        for (DVD d : biblioteca.getDVDs()) {
            if (d.getTitlu().equals(nume_dvd)) {
                if (!d.getDisponibil()) {
                    for (Client client : biblioteca.getClienti()) {
                        if (client.getNume().equals(nume_client)) {
                            client.getArticole_imprumutate().remove(d);
                            d.setDisponibil(true);
                            return;
                        }
                    }
                    System.out.println("Clientul nu exista");

                }
                System.out.println("DVD-ul nu este imprumutat");
                return;
            }
        }
        System.out.println("DVD-ul nu exista");
    }
    public void stergeArticol(String nume)
    {
        for (Carte c : biblioteca.getCarti()) {
            if (c.getTitlu().equals(nume)) {
                biblioteca.removeArticol(c);
                return;
            }
        }
        for (DVD d : biblioteca.getDVDs()) {
            if (d.getTitlu().equals(nume)) {
                biblioteca.removeArticol(d);
                return;
            }
        }
        System.out.println("Articolul nu exista");
    }
    public void AdaugaAutor(Autor autor)
    {
        for (Autor a : biblioteca.getAutori()) {
            if (a.getNume().equals(autor.getNume())) {
                System.out.println("Autorul exista deja");
                return;
            }
            biblioteca.addAutor(autor);
        }
    }
    public void AdaugaClient(Client client)
    {
        for (Client c : biblioteca.getClienti()) {
            if (c.getNume().equals(client.getNume())) {
                System.out.println("Clientul exista deja");
                return;
            }
            biblioteca.addClient(client);
        }
    }
    public void ModificaDescrierea(String nume, String descriere)
    {
        for (Carte c : biblioteca.getCarti()) {
            if (c.getTitlu().equals(nume)) {
                c.setDescriere(descriere);
                return;
            }
        }
        System.out.println("Articolul nu exista");
    }
}
