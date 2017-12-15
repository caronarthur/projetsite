package siteweb.devweb.daos;

public interface PresentDao {

        public void deletePresent(int episode, int personnage);

        public void addPresent(int episode, int personnage);

        public boolean checkPresent(int episode, int personnage);
    }


