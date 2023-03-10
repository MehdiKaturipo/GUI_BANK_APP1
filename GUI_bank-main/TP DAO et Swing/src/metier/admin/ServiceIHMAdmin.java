package metier.admin;


import model.Banque;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

import static controleur.MaBanque.loginService;

public class ServiceIHMAdmin implements IServiceIHMAdmin{


    private Banque maBanque;
    private ServiceAdmin admin;
    private Scanner clavier;

    public ServiceIHMAdmin(Banque maBanque, Scanner clavier) {
        this.maBanque = maBanque;
        this.clavier = clavier;
        this.admin = new ServiceAdmin(maBanque, clavier);
    }


    public int menuGlobal() {
        // menu
        System.out.println("\n=============================================");
        System.out.println("Bienvenue dans l'application de gestion de la banque "+maBanque.getNomBanque());
        System.out.println("=============================================");
        System.out.println("0- Quitter");
        System.out.println("1- Modification");
        System.out.println("2- Recherche");
        System.out.println("3- Informations");
        System.out.println("4- Ajout");
        System.out.println("5- Suppression");
        System.out.println("6- Trie");
        System.out.println("7- Comptabilit√©");
        System.out.println("8- Logout");
        System.out.println("=============================================");
        System.out.println("Votre choix : ");
        int choix = clavier.nextInt();

        // cas
        switch (choix) {
            case 0:
                System.out.println("Au revoir");
                break;
            case 1:
                menuModification();
                menuGlobal();
                break;
            case 2:
                menuRecherche();
                menuGlobal();
                break;
            case 3:
                menuInformations();
                menuGlobal();
                break;
            case 4:
                menuAjout();
                menuGlobal();
                break;
            case 5:
                menuSuppression();
                menuGlobal();
                break;
            case 6:
                menuTrie();
                menuGlobal();
                break;
            case 7:
                menuComptabilite();
                menuGlobal();
                break;
            case 8:
                loginService.SeD√©connecter();
                break;
            default:
                System.out.println("Choix invalide");
                menuGlobal();
                break;
        }




        return 0;
    }


    public int menuModification() {
        // menuModification
        System.out.println("\n=============================================");
        System.out.println("Modification");
        System.out.println("=============================================");
        System.out.println("0- Retour");
        System.out.println("1- Modifier un client");
        System.out.println("2- Modifier un compte");

        System.out.println("=============================================");
        System.out.println("Votre choix : ");
        int choix = clavier.nextInt();

        // cas
        switch (choix) {
            case 0:
                menuGlobal();
                break;
            case 1:
                //admin.modifierClient("");
                menuModification();
                break;
            case 2:
                //admin.modifierCompte("");
                menuModification();
                break;
            default:
                System.out.println("Choix invalide");
                menuModification();
                break;
        }

        return 0;
    }


    public int menuRecherche() {

        // menuRecherche
        System.out.println("\n=============================================");
        System.out.println("Recherche");
        System.out.println("=============================================");
        System.out.println("0- Retour");
        System.out.println("1- Rechercher un client par ID");
        System.out.println("2- Rechercher un client par nom");
        System.out.println("3- Rechercher un client par pr√©nom");
        System.out.println("4- Rechercher un client par Email");
        System.out.println("5- Rechercher un client par cin");
        System.out.println("6- Rechercher un compte par solde");
        System.out.println("7- Rechercher un compte par ID");
        System.out.println("8- Rechercher un compte par Date Creation");
        System.out.println("=============================================");
        System.out.println("Votre choix : ");
        int choix = clavier.nextInt();

        // cas

        switch (choix) {
            case 0:
                menuGlobal();
                break;
            case 1:
                // get id from scaner
                System.out.println("ID : ");
                long id = clavier.nextInt();
                System.out.println(admin.chercherClientParId(id).toString());;
                menuRecherche();
                break;
            case 2:
                System.out.println("\n=============================================");
                System.out.println("Chercher Client Par Nom");
                System.out.println("nomClient  : ");
                String nom=clavier.next();
                System.out.println(admin.chercherClientParNom(nom).toString());;
                menuRecherche();
                break;
            case 3:
                System.out.println("\n=============================================");
                System.out.println("Chercher Client Par Prenom");
                System.out.println("prenomClient  : ");
                String prenom=clavier.next();
                System.out.println(admin.chercherClientParPr√©nom(prenom).toString());;
                menuRecherche();
                break;
            case 4:
                System.out.println("\n=============================================");
                System.out.println("Chercher Client Par Email");
                System.out.println("emailClient  : ");
                String email=clavier.next();
                System.out.println(admin.chercherClientParEmail(email).toString());;
                menuRecherche();
                break;
            case 5:
                System.out.println("\n=============================================");
                System.out.println("Chercher Client Par CIN");
                System.out.println("cinClient  : ");
                String cin=clavier.next();
                System.out.println(admin.chercherClientParCin(cin).toString());;
                menuRecherche();
                break;
            case 6:
                System.out.println("\n=============================================");
                System.out.println("Chercher Compte Par Solde");
                System.out.println("Solde Compte  : ");
                double solde=clavier.nextDouble();
                System.out.println(admin.chercherCompteParSolde(solde).toString());;
                menuRecherche();
                break;
            case 7:
                System.out.println("\n=============================================");
                System.out.println("Chercher Compte Par Id");
                System.out.println("Numero Compte  : ");
                Long idCompte=clavier.nextLong();
                System.out.println(admin.chercherCompteParId(idCompte).toString());;
                menuRecherche();
                break;
            case 8:
                System.out.println("\n=============================================");
                System.out.println("Chercher Compte Par Date Creation");
                System.out.println("Date Creation Compte  : ");
                String date=clavier.next();
                try {
                    LocalDateTime dateCreation = LocalDateTime.parse(date);
                    admin.chercherCompteParDateCreation(dateCreation);
                    menuRecherche();
                } catch (Exception e) {
                    System.out.println("Date invalide");
                    menuRecherche();
                }

                break;
            default:
                System.out.println("Choix invalide");
                menuRecherche();
                break;
        }
        return 0;
    }


    public int menuInformations() {
        // menuInformations
        System.out.println("\n=============================================");
        System.out.println("Informations");
        System.out.println("=============================================");
        System.out.println("0- Retour");
        System.out.println("1- Afficher les clients");
        System.out.println("2- Afficher les comptes");
        System.out.println("3- Afficher les comptes d'un client");
        System.out.println("=============================================");
        System.out.println("Votre choix : ");
        int choix = clavier.nextInt();

        // cas

        switch (choix) {
            case 0:
                menuGlobal();
                break;
            case 1:
                //admin.afficherClients();
                menuInformations();
                break;
            case 2:
                //admin.afficherComptes();
                menuInformations();
                break;
            case 3:
                System.out.println("ID : ");
                long id = clavier.nextInt();
                //admin.afficherComptesClient(id);
                menuInformations();
                break;
            default:
                System.out.println("Choix invalide");
                menuInformations();
                break;
        }
        return 0;
    }


    public int menuAjout() {

        // menuAjout
        System.out.println("\n=============================================");
        System.out.println("Ajout");
        System.out.println("=============================================");
        System.out.println("0- Retour");
        System.out.println("1- Ajouter un client");
        System.out.println("2- Ajouter un compte au client");
        System.out.println("=============================================");
        System.out.println("Votre choix : ");
        int choix = clavier.nextInt();

        // cas

        switch (choix) {
            case 0:
                menuGlobal();
                break;
            case 1:
                admin.nouveauClient();
                menuAjout();
                break;
            case 2:
                admin.nouveauCompteClientExistant();
                menuAjout();
                break;
            default:
                System.out.println("Choix invalide");
                menuAjout();
                break;
        }

        return 0;
    }


    public int menuSuppression() {
        // menuSuppression

        System.out.println("\n=============================================");
        System.out.println("Suppression");
        System.out.println("=============================================");
        System.out.println("0- Retour");
        System.out.println("1- Supprimer un client");
        System.out.println("2- Supprimer un compte ");
        System.out.println("=============================================");
        System.out.println("Votre choix : ");
        int choix = clavier.nextInt();

        // cas

        switch (choix) {
            case 0:
                menuGlobal();
                break;
            case 1:
                System.out.println("ID : ");
                long id = clavier.nextInt();
                admin.supprimerClient(id);
                menuSuppression();
                break;
            case 2:
                System.out.println("ID : ");
                long idCompte = clavier.nextInt();
                admin.supprimerCompte(idCompte);
                menuSuppression();
                break;
            default:
                System.out.println("Choix invalide");
                menuSuppression();
                break;
        }

        return 0;
    }


    public int tableauDeBord() {
        // tableauDeBord
        System.out.println("\n=============================================");
        System.out.println("Tableau de bord");
        System.out.println("=============================================");
        System.out.println("0- Retour");
        System.out.println("1- Afficher le nombre de clients");
        System.out.println("2- Afficher le nombre de comptes");
        System.out.println("3- Afficher le nombre de comptes d'un client");
        System.out.println("4- Afficher le solde total des comptes");
        System.out.println("5- Afficher le solde total des comptes d'un client");

        System.out.println("=============================================");
        System.out.println("Votre choix : ");
        int choix = clavier.nextInt();

        // cas

        switch (choix) {
            case 0:
                menuGlobal();
                break;
            case 1:
                //admin.nombreClients();
                tableauDeBord();
                break;
            case 2:
                //admin.nombreComptes();
                tableauDeBord();
                break;
            case 3:
                System.out.println("ID : ");
                long id = clavier.nextInt();
                //admin.nombreComptesClient(id);
                tableauDeBord();
                break;
            case 4:
                //admin.soldeTotalComptes();
                tableauDeBord();
                break;
            case 5:
                System.out.println("ID : ");
                long idClient = clavier.nextInt();
                //admin.soldeTotalComptesClient(idClient);
                tableauDeBord();
                break;
            default:
                System.out.println("Choix invalide");
                tableauDeBord();
                break;
        }


        return 0;
    }


    public int menuTrie() {
        // menuTrie
        System.out.println("\n=============================================");
        System.out.println("Trie");
        System.out.println("=============================================");
        System.out.println("0- Retour");
        System.out.println("1- Trier les clients par Nom");
        System.out.println("2- Trier les clients par Cin");
        System.out.println("3- Trier les clients par Email");
        System.out.println("4- Trier les clients par Adresse");
        System.out.println("5- Trier les clients par Solde Comptes");
        System.out.println("6- Trier les comptes par Solde");
        System.out.println("7- Trier les comptes par Date");
        System.out.println("8- Trier les comptes par Nom Propri√©taire");
        System.out.println("=============================================");
        System.out.println("Votre choix : ");
        int choix = clavier.nextInt();

        // cas

        switch (choix) {
            case 0:
                menuGlobal();
                break;
            case 1:
                admin.trierClientParNom();
                menuTrie();
                break;
            case 2:
                admin.trierClientParCin();
                menuTrie();
                break;
            case 3:
                admin.trierClientParEmail();
                menuTrie();
                break;
            case 4:
                admin.trierClientParAdresse();
                menuTrie();
                break;
            case 5:
                admin.trierClientParSoldeCompte();
                menuTrie();
                break;
            case 6:
                admin.trierComptesParSolde();
                menuTrie();
                break;
            case 7:
                admin.trierComptesParDateDeCreation();
                menuTrie();
                break;
            case 8:
                admin.trierComptesParNomPropri√©taire();
                menuTrie();
                break;
            default:
                System.out.println("Choix invalide");
                menuTrie();
                break;
        }


        return 0;
    }

    @Override
    public int menuComptabilite() {
        // menuComptabilite
        System.out.println("\n=============================================");
        System.out.println("Comptabilit√©");
        System.out.println("=============================================");
        System.out.println("0- Retour");
        System.out.println("1- calculer Et Afficher Statistiques");

        System.out.println("=============================================");
        System.out.println("Votre choix : ");
        int choix = clavier.nextInt();

        // cas

        switch (choix) {
            case 0:
                menuGlobal();
                break;
            case 1:
                admin.calculerEtAfficherStatistiques();
                menuComptabilite();
                break;
            default:
                System.out.println("Choix invalide");
                menuComptabilite();
                break;
        }


        return 0;
    }





}
