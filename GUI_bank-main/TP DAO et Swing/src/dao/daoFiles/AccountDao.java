package dao.daoFiles;

import dao.IDao;
import model.Client;
import model.Compte;
import model.Sexe;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class AccountDao implements IDao<Compte, Long> {
    @Override
    public List<Compte> findAll() {
        List<Compte> comptes = new ArrayList<>();


        try {
            List<String> lines = Files.readAllLines(FileBasePaths.ACCOUNT_TABLE, StandardCharsets.UTF_8);
            lines.remove(0);

            if(!lines.isEmpty())
                comptes=
                        lines
                                .stream()
                                .map(line->{
                                    Compte cl = null;
                                    StringTokenizer st = new StringTokenizer(line, "\t");

                                    long     id              =   Long.parseLong(st.nextToken());

                                    LocalDate dateCreation          = LocalDate.parse(st.nextToken());
                                    Double   solde           = Double.valueOf(st.nextToken());
                                    String propriétaire            =   st.nextToken();








                                    cl = new Compte(id, dateCreation, solde,propriétaire);
                                    cl.setId(id);
                                    return cl;
                                })
                                .collect(Collectors.toList());


        } catch (IOException e) {
            e.printStackTrace();
        }

        return comptes;
    }
    @Override
    public Compte findById(Long idCompte) {
        return findAll().stream()
                .filter(compte -> compte.getId() == idCompte)
                .findFirst()
                .orElse(null);

    }
    private long getIncrementedId(){

        var compteList = findAll();

        var maxId = 1L;

        if(!compteList.isEmpty())
        {
            maxId = findAll().stream().map(compte -> compte.getId()).max((id1,id2)-> id1.compareTo(id2)).get();
            maxId++;
        }

        return maxId;
    }

    private long getIncrementedIdByIndexFile(Path path){
        String idStr = null;
        Long id = 1L;
        try {
            idStr =  Files.readString(path);
            id = Long.parseLong(idStr);
            id ++;
        } catch (IOException e) {id = 1L;}

        try {
            Files.writeString(path, id.toString());
        }
        catch (IOException e) { e.printStackTrace();}

        return id;
    }
    @Override
    public Compte save(Compte compte) {
        // Solution D'incrémentation 1
        Long id = getIncrementedId();
        // Solution D'incrémentation 2
        //   id = getIncrementedIdByIndexFile(FileBasePaths.INDEX_CLIENT);
        String comptestr =  id + "\t\t\t" +
                compte.getId()+ "\t" +
                compte.getSolde()+ "\t" +
                compte.getPropriétaire()+ "\t\t" +
                compte.getDateCreation()+ "\t\t" ;

        try {
            Files.writeString(FileBasePaths.ACCOUNT_TABLE, comptestr, StandardOpenOption.APPEND);
            System.out.println("Client n ° "+ id + " a été ajouté avec succès ^_^");
            compte.setId(id);
        }
        catch (IOException e) { e.printStackTrace();}

        return compte;
    }


    public Compte saveWithID(Compte compte) {

        String comptestr =  compte.getId() + "\t\t\t" +
                compte.getId()+ "\t" +
                compte.getSolde()+ "\t" +
                compte.getPropriétaire()+ "\t\t" +
                compte.getDateCreation()+ "\t\t" ;

        try {
            Files.writeString(FileBasePaths.ACCOUNT_TABLE, comptestr, StandardOpenOption.APPEND);
            System.out.println("Client n ° "+ compte.getId() + " a été ajouté avec succès ^_^");
        }
        catch (IOException e) { e.printStackTrace();}

        return compte;
    }
    @Override
    public List<Compte> saveAll(List<Compte> listeComptes) {
        return
                listeComptes
                        .stream()
                        .map(compte -> save(compte))
                        .collect(Collectors.toList());
    }

    public List<Compte> saveAllWithIds(List<Compte> listeComptes) {
        return
                listeComptes
                        .stream()
                        .map(compte -> saveWithID(compte))
                        .collect(Collectors.toList());
    }
    @Override
    public Compte update(Compte newCompte) {

        List<Compte> ComptesUpdated =
                findAll()
                        .stream()
                        .map(compte -> {
                            if(compte.getId() == newCompte.getId())
                                return newCompte;
                            else
                                return compte;
                        })
                        .collect(Collectors.toList());


        try { Files.deleteIfExists(FileBasePaths.INDEX_CLIENT);} catch (IOException e) {e.printStackTrace();}
        FileBasePaths.changeFile(FileBasePaths.ACCOUNT_TABLE, FileBasePaths.ACCOUNT_TABLE_HEADER);

        saveAll(ComptesUpdated);

        return newCompte;
    }

    @Override
    public Boolean delete(Compte compteToDelete) {

        var comptes = findAll();
        boolean deleted  =
                comptes.remove(compteToDelete);

        if(deleted) {
            /*
                        try {
                            Files.deleteIfExists(FileBasePaths.INDEX_CLIENT);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

             */
            FileBasePaths.changeFile(FileBasePaths.ACCOUNT_TABLE, FileBasePaths.ACCOUNT_TABLE_HEADER);
            saveAllWithIds(comptes);
        }

        return deleted;
    }

    @Override
    public Boolean deleteById(Long idCompte) {

        var comptes = findAll();
        boolean deleted  =
                comptes.remove(findById(idCompte));

        if(deleted) {
           /* try {
                Files.deleteIfExists(FileBasePaths.INDEX_CLIENT);
            } catch (IOException e) {
                e.printStackTrace();
            }

            */
            FileBasePaths.changeFile(FileBasePaths.ACCOUNT_TABLE, FileBasePaths.ACCOUNT_TABLE_HEADER);
            saveAllWithIds(comptes);
        }

        return deleted;

    }
    public List<Compte> findByKeywordLike(String keyWord){

        List<Compte> comptes = findAll();

        return
                comptes
                        .stream()
                        .filter(compte ->
                                compte.getId().toString().equals(keyWord) |
                                        compte.getDateCreation().toString().toLowerCase().contains(keyWord.toLowerCase())    ||
                                        compte.getLogs().toString().toLowerCase().contains(keyWord.toLowerCase())    ||
                                        compte.getPropriétaire().toString().toLowerCase().contains(keyWord.toLowerCase())    ||
                                        compte.getSolde().toString().toLowerCase().contains(keyWord.toLowerCase())
                        )
                        .collect(Collectors.toList());

    }

}
