package siteweb.devweb.services;


import java.util.List;


import siteweb.devweb.dao.impl.PersonnageDaoImpl;
import siteweb.devweb.daos.PersonnageDao;
import siteweb.devweb.models.Personage;


public class PersonnageService {
    private PersonnageDao personnageDao= new PersonnageDaoImpl();
    private static class PersonnageServiceHolder{
        private static PersonnageService instance=new PersonnageService();
    }

    public static PersonnageService getInstance() { return PersonnageServiceHolder.instance; }

    private PersonnageService(){

    }

    public List<Personage> listPersonnage(){
        return personnageDao.listPersonnage();
    }

    public Personage getPersonnage(Integer id) { return personnageDao.getPersonnage(id); }

    public Personage getPersonnageWithName(String name) { return personnageDao.getPersonnageWithName(name); }
}
