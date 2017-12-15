package siteweb.devweb.daos;

import java.util.List;

import siteweb.devweb.models.Personage;


public interface PersonnageDao {
    List<Personage> listPersonnage();
    public Personage getPersonnage(Integer id);
    public Personage getPersonnageWithName(String name);

}
