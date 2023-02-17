package model;

import java.util.*;

public class Banque {

    private static long          compteur = 1;
    private Long                 idBanque;
    private String              nomBanque;
    private String              adresseBanque;
    private String              telBanque;
    private String              emailBanque;
    private List<Client>        clientsDeBanque = new ArrayList<>();

    public Banque(ArrayList<Client> clients)
    {
        this.clients = clients;
        idBanque = compteur++;
    }
    public Banque(String nom, String adresse, String tel, String mail)
    {
        idBanque        = compteur++;
        nomBanque       = nom;
        telBanque       = tel;
        adresseBanque   = adresse;
        emailBanque     = mail;
    }
     public Banque(){
        idBanque = compteur++;
        setIdBanque(idBanque);
        setAdresseBanque("adresse");
        setEmailBanque("email");
        setNomBanque("nom");
        setTelBanque("tel");

     }
    public Long             getIdBanque() {
        return idBanque;
    }
    public String           getNomBanque() {
        return nomBanque;
    }
    public String           getEmailBanque() {
        return emailBanque;
    }
    public String           getTelBanque() {
        return telBanque;
    }
    public String           getAdresseBanque() {
        return adresseBanque;
    }
    private int maxClients;
    private  ArrayList<Client> clients;
    public List<Client>     getClientsDeBanque() {
        return clientsDeBanque;
    }

    public void             setIdBanque(Long idBanque) {
        this.idBanque = idBanque;
    }
    public void             setNomBanque(String nomBanque) {
        this.nomBanque = nomBanque;
    }
    public void             setEmailBanque(String emailBanque) {
        this.emailBanque = emailBanque;
    }
    public void             setAdresseBanque(String adresseBanque) {
        this.adresseBanque = adresseBanque;
    }
    public void             setTelBanque(String telBanque) {
        this.telBanque = telBanque;
    }
    public void             setClientsDeBanque(List<Client> clientsDeBanque) {
        this.clientsDeBanque = clientsDeBanque;
    }

    public void ajouterClient(Client client){
        if (this.clients.size() < this.maxClients) {
            this.clients.add(client);
            System.out.println("Client " + client.getId() + " ajouté avec succès");

        } else {
            System.out.println("Impossible d'ajouter le client " + client.getId() + " : nombre max de clients atteint");
        }
    }

}