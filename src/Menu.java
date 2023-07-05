import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    Biblioteca biblioteca = Biblioteca.getInstance();
    bibliotecaService bibliotecaService = new bibliotecaService();
    public Menu() {
        scanner = new Scanner(System.in);
    }

    public void afiseazaMainMenu() {
        System.out.println("Bine ati venit la biblioteca! Selectati ce fel de utilizator sunteti:");
        System.out.println("1. Bibliotecar");
        System.out.println("2. Client");
        System.out.println("0. Iesire");

        int choice = getUserChoice();
        switch (choice) {
            case 1:
                System.out.println("Introduceti-va numele si codul de bibliotecar:");
                String nume = scanner.nextLine();
                Integer cod = Integer.parseInt(scanner.nextLine());
                if (biblioteca.esteBibliotecar(nume, cod)) {
                    afiseazaMeniuAngajat();
                } else {
                    System.out.println("Nume sau cod incorect!");
                    delay(2000);
                    afiseazaMainMenu();
                }
                afiseazaMeniuAngajat();
                break;
            case 2:
                afiseazaMeniuClient();
                break;
            case 0:
                System.out.println("Iesind...");
                delay(2000);
                System.exit(0);
                break;
            default:
                System.out.println(".Alegere invalida. Va rugam incercati din nou");
                delay(2000);
                afiseazaMainMenu();
        }
    }

    public void afiseazaMeniuAngajat() {
        System.out.println("Meniu angajat");
        System.out.println("1. Adauga o carte");
        System.out.println("2. Adauga un DVD");
        System.out.println("3. Adauga un autor");
        System.out.println("4. Sterge un articol");
        System.out.println("5. Modifica descrierea unei carti");
        System.out.println("6. Afiseaza clientii care au imprumutat ceva");
        System.out.println("0. Intoarce-te la main menu");

        int choice = getUserChoice();
        switch (choice) {
            case 1:
                System.out.println("Introdu titlul cartii:");
                String titlu = scanner.nextLine();
                System.out.println("Introdu anul publicarii:");
                Integer anPublicatie = Integer.parseInt(scanner.nextLine());
                System.out.println("Introdu numele autorului:");
                String numeAutor = scanner.nextLine();
                System.out.println("Introdu genul literar:");
                String genLiterar = scanner.nextLine();
                System.out.println("Introdu editura:");
                String editura = scanner.nextLine();
                System.out.println("Introdu descrierea:");
                String descriere = scanner.nextLine();
                Carte carte = new Carte(titlu, anPublicatie, numeAutor, 0, true, genLiterar, editura,
                        biblioteca.getCarti().size() + 1, descriere);
                bibliotecaService.AdaugaCarte(carte);
                delay(2000);
                afiseazaMeniuAngajat();
                break;
            case 2:
                System.out.println("Introdu titlul DVD-ului:");
                titlu = scanner.nextLine();
                System.out.println("Introdu anul publicarii:");
                anPublicatie = Integer.parseInt(scanner.nextLine());
                System.out.println("Introdu numele autorului:");
                numeAutor = scanner.nextLine();
                System.out.println("Introdu genul filmului:");
                String gen_film = scanner.nextLine();
                System.out.println("Introdu studioul:");
                String studio = scanner.nextLine();
                DVD dvd = new DVD(titlu, anPublicatie, numeAutor, 0, true, gen_film, studio,
                        biblioteca.getDVDs().size() + 1);
                bibliotecaService.AdaugaDVD(dvd);
                delay(2000);
                afiseazaMeniuAngajat();
                break;
            case 3:
                System.out.println("Introdu numele autorului:");
                numeAutor = scanner.nextLine();
                System.out.println("Introdu varsta:");
                Integer varsta = Integer.parseInt(scanner.nextLine());
                System.out.println("Introdu nationalitatea:");
                String nationalitate = scanner.nextLine();
                System.out.println("Introdu genul:");
                String gen = scanner.nextLine();
                System.out.println("Introdu gen principal:");
                String gen_principal = scanner.nextLine();
                System.out.println("Introdu opera cea mai semnificativa:");
                String opera = scanner.nextLine();
                System.out.println("Introdu anii de activitate:");
                String anii_activitate = scanner.nextLine();
                Autor autor = new Autor(numeAutor, varsta, nationalitate, gen, biblioteca.getAutori().size() + 1,
                        gen_principal, opera, anii_activitate);
                bibliotecaService.AdaugaAutor(autor);
                delay(2000);
                afiseazaMeniuAngajat();
                break;
            case 4:
                System.out.println("Introdu numele articolului:");
                String numeArticol = scanner.nextLine();
                bibliotecaService.stergeArticol(numeArticol);
                delay(2000);
                afiseazaMeniuAngajat();
                break;
            case 5:
                System.out.println("Introdu numele cartii:");
                titlu = scanner.nextLine();
                System.out.println("Introdu descrierea:");
                descriere = scanner.nextLine();
                bibliotecaService.ModificaDescrierea(titlu, descriere);
                delay(2000);
                afiseazaMeniuAngajat();
                break;
            case 6:
                System.out.println("Clientii care au imprumutat ceva sunt:");
                biblioteca.showClientiCuCevaImprumutat();
                delay(2000);
                afiseazaMeniuAngajat();
                break;
            case 0:
                afiseazaMainMenu();
                break;
            default:
                System.out.println("Alegere invalida. Va rugam incercati din nou");
                delay(2000);
                afiseazaMeniuAngajat();
        }
    }

    public void afiseazaMeniuClient() {
        System.out.println("Meniu client");
        System.out.println("1. Inregistrare");
        System.out.println("2. Afiseaza cartile disponibile");
        System.out.println("3. Afiseaza DVD-urile disponibile");
        System.out.println("4. Imprumuta o carte");
        System.out.println("5. Imprumuta un DVD");
        System.out.println("6. Returneaza o carte");
        System.out.println("7. Returneaza un DVD");
        System.out.println("0. Intoarce-te la main menu");

        int choice = getUserChoice();
        switch (choice) {
            case 1:
                System.out.println("Introdu numele autorului:");
                String numeAutor = scanner.nextLine();
                System.out.println("Introdu varsta:");
                Integer varsta = Integer.parseInt(scanner.nextLine());
                System.out.println("Introdu nationalitatea:");
                String nationalitate = scanner.nextLine();
                System.out.println("Introdu genul:");
                String gen = scanner.nextLine();
                System.out.println("Introdu email:");
                String email = scanner.nextLine();
                System.out.println("Introdu numar de telefon:");
                String numarTelefon = scanner.nextLine();
                System.out.println("Introdu adresa:");
                String adresa = scanner.nextLine();
                Client client = new Client(numeAutor, varsta, nationalitate, gen, biblioteca.getClienti().size() + 1,
                        email, numarTelefon, adresa);
                bibliotecaService.AdaugaClient(client);
                delay(2000);
                afiseazaMeniuClient();
                break;
            case 2:
                System.out.println("Cartile disponibile sunt:");
                bibliotecaService.showCartiDisponibile();
                delay(2000);
                afiseazaMeniuClient();
                break;
            case 3:
                System.out.println("DVD-urile disponibile sunt:");
                bibliotecaService.showDVDsDisponibile();
                delay(2000);
                afiseazaMeniuClient();
                break;
            case 4:
                System.out.println("Introdu numele cartii:");
                String titlu = scanner.nextLine();
                System.out.println("Introdu numele clientului:");
                String numeClient = scanner.nextLine();
                bibliotecaService.ImprumutaCarte(titlu, numeClient);
                delay(2000);
                afiseazaMeniuClient();
                break;
            case 5:
                System.out.println("Introdu numele DVD-ului:");
                String titluDVD = scanner.nextLine();
                System.out.println("Introdu numele clientului:");
                String numeClientDVD = scanner.nextLine();
                bibliotecaService.ImprumutaDVD(titluDVD, numeClientDVD);
                delay(2000);
                afiseazaMeniuClient();
                break;
            case 6:
                System.out.println("Introdu numele cartii:");
                titlu = scanner.nextLine();
                System.out.println("Introdu numele clientului:");
                numeClient = scanner.nextLine();
                bibliotecaService.ReturneazaCarte(titlu, numeClient);
                delay(2000);
                afiseazaMeniuClient();
                break;
            case 7:
                System.out.println("Introdu numele DVD-ului:");
                titluDVD = scanner.nextLine();
                System.out.println("Introdu numele clientului:");
                numeClientDVD = scanner.nextLine();
                bibliotecaService.ReturneazaDVD(titluDVD, numeClientDVD);
                delay(2000);
                afiseazaMeniuClient();
                break;
            case 0:
                afiseazaMainMenu();
                break;
            default:
                System.out.println("Selectie invalida. Va rugam incercati din nou");
                delay(2000);
                afiseazaMeniuClient();
        }
    }

    private int getUserChoice() {
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    private void delay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}