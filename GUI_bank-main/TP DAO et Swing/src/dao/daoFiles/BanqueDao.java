package dao.daoFiles;

import dao.IDao;
import model.Banque;
import model.Client;

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

public class BanqueDao implements IDao<Banque, Long> {
    @Override
    public List<Banque> findAll() {
        List<Banque> banques = new ArrayList<>();


        try {
            List<String> lines = Files.readAllLines(FileBasePaths.BANK_AGENCIES_TABLE, StandardCharsets.UTF_8);
            lines.remove(0);

            if(!lines.isEmpty())
                banques=
                        lines
                                .stream()
                                .map(line->{
                                    Banque cl = null;
                                    StringTokenizer st = new StringTokenizer(line, "\t");

                                    long     id              =   Long.parseLong(st.nextToken());
                                    String   nom             =   st.nextToken();
                                    String   email           =   st.nextToken();
                                    String   tel             =   st.nextToken();
                                    String   adresse             =   st.nextToken();


                                    if(email.equalsIgnoreCase("NULL")) email ="";
                                    if(tel.equalsIgnoreCase("NULL")) tel ="";




                                    cl = new Banque(nom,adresse,tel,email);
                                    cl.setIdBanque(id);
                                    return cl;
                                })
                                .collect(Collectors.toList());


        } catch (IOException e) {
            e.printStackTrace();
        }

        return banques;
    }
    @Override
    public Banque findById(Long idBanque) {
        return findAll().stream()
                .filter(banque -> banque.getIdBanque() == idBanque)
                .findFirst()
                .orElse(null);

    }
    private long getIncrementedId(){

        var banqueList = findAll();

        var maxId = 1L;

        if(!banqueList.isEmpty())
        {
            maxId = findAll().stream().map(banque -> banque.getIdBanque()).max((id1,id2)-> id1.compareTo(id2)).get();
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
    public Banque save(Banque banque) {
        // Solution D'incrémentation 1
        Long id = getIncrementedId();
        // Solution D'incrémentation 2
           id = getIncrementedIdByIndexFile(FileBasePaths.BANK_AGENCIES_TABLE);
        String banquestr =  id + "\t\t\t" +
                banque.getNomBanque()+ "\t" +
                banque.getAdresseBanque()+ "\t" +
                (banque.getEmailBanque()!=null&&banque.getEmailBanque().trim().length()!=0?banque.getEmailBanque():"NULL")+ "\t" +
                (banque.getTelBanque()!=null&&banque.getTelBanque().trim().length()!=0?banque.getTelBanque():"NULL")+ "\t\t" ;

        try {
            Files.writeString(FileBasePaths.BANK_AGENCIES_TABLE, banquestr, StandardOpenOption.APPEND);
            System.out.println("Banque n ° "+ id + " a été ajouté avec succès ^_^");
            banque.setIdBanque(id);
        }
        catch (IOException e) { e.printStackTrace();}

        return banque;
    }


    public Banque saveWithID(Banque banque) {

        String banquestr =  banque.getIdBanque() + "\t\t\t" +
                banque.getNomBanque()+ "\t" +
                banque.getAdresseBanque()+ "\t" +
                banque.getTelBanque()+ "\t\t" +
                banque.getEmailBanque()+ "\t\t" ;

        try {
            Files.writeString(FileBasePaths.BANK_AGENCIES_TABLE, banquestr, StandardOpenOption.APPEND);
            System.out.println("Banque n ° "+ banque.getIdBanque() + " a été ajouté avec succès ^_^");
        }
        catch (IOException e) { e.printStackTrace();}

        return banque;
    }
    @Override
    public List<Banque> saveAll(List<Banque> listeBanques) {
        return
                listeBanques
                        .stream()
                        .map(banque -> save(banque))
                        .collect(Collectors.toList());
    }

    public List<Banque> saveAllWithIds(List<Banque> banqueList) {
        return
                banqueList
                        .stream()
                        .map(banque -> saveWithID(banque))
                        .collect(Collectors.toList());
    }
    @Override
    public Banque update(Banque newBanque) {

        List<Banque> BanquesUpdated =
                findAll()
                        .stream()
                        .map(banque -> {
                            if(banque.getIdBanque() == newBanque.getIdBanque())
                                return newBanque;
                            else
                                return banque;
                        })
                        .collect(Collectors.toList());


        try { Files.deleteIfExists(FileBasePaths.INDEX_BANQUE);} catch (IOException e) {e.printStackTrace();}
        FileBasePaths.changeFile(FileBasePaths.BANK_AGENCIES_TABLE, FileBasePaths.AGENCY_TABLE_HEADER);

        saveAll(BanquesUpdated);

        return newBanque;
    }

    @Override
    public Boolean delete(Banque banqueToDelete) {

        var banques = findAll();
        boolean deleted  =
                banques.remove(banqueToDelete);

        if(deleted) {
            /*
                        try {
                            Files.deleteIfExists(FileBasePaths.INDEX_CLIENT);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

             */
            FileBasePaths.changeFile(FileBasePaths.BANK_AGENCIES_TABLE, FileBasePaths.AGENCY_TABLE_HEADER);
            saveAllWithIds(banques);
        }

        return deleted;
    }

    @Override
    public Boolean deleteById(Long idbanque) {

        var banques = findAll();
        boolean deleted  =
                banques.remove(findById(idbanque));

        if(deleted) {
           /* try {
                Files.deleteIfExists(FileBasePaths.INDEX_CLIENT);
            } catch (IOException e) {
                e.printStackTrace();
            }

            */
            FileBasePaths.changeFile(FileBasePaths.BANK_AGENCIES_TABLE, FileBasePaths.AGENCY_TABLE_HEADER);
            saveAllWithIds(banques);
        }

        return deleted;

    }
    public List<Banque> findByKeywordLike(String keyWord){

        List<Banque> banques = findAll();

        return
                banques
                        .stream()
                        .filter(banque ->
                                banque.getTelBanque().toString().equals(keyWord) ||
                                        banque.getNomBanque().toLowerCase().contains(keyWord.toLowerCase())    ||
                                        banque.getAdresseBanque().equalsIgnoreCase(keyWord)    ||
                                        banque.getEmailBanque().equalsIgnoreCase(keyWord)    ||
                                        banque.getTelBanque().equals(keyWord)
                        )
                        .collect(Collectors.toList());

    }

}
