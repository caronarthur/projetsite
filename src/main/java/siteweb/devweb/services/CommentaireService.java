package siteweb.devweb.services;

import siteweb.devweb.dao.impl.CommentaireDaoImpl;
import siteweb.devweb.daos.CommentaireDao;
import siteweb.devweb.models.Commentaire;

public class CommentaireService {
        private CommentaireDao commentaireDao= new CommentaireDaoImpl();
        private static class CommentaireServiceHolder{
            private static CommentaireService instance=new CommentaireService();
        }

        public static CommentaireService getInstance(){
            return CommentaireServiceHolder.instance;
        }

        private CommentaireService(){
        }

        public Commentaire addCommentaire(String user, String email, String message){
            Commentaire commentaire= new Commentaire(user, email, message);
            return commentaireDao.addCommentaire(commentaire);
        }
}

