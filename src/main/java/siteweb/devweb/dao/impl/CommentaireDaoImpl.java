package siteweb.devweb.dao.impl;

import siteweb.devweb.daos.CommentaireDao;
import siteweb.devweb.models.Commentaire;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CommentaireDaoImpl implements CommentaireDao {

    @Override
    public Commentaire addCommentaire(Commentaire commentaire) {
        try (Connection connection = DataSourceProvider.getDataSource().getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement("INSERT INTO messages(`user`,`user_email`,`user_message`) VALUES(?,?,?);", Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, commentaire.getUser());
                statement.setString(2, commentaire.getUser_email());
                statement.setString(3, commentaire.getMessage());
                statement.executeUpdate();
                return commentaire;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
