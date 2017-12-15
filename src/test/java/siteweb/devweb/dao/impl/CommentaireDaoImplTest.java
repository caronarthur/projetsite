package siteweb.devweb.dao.impl;

import org.junit.Test;
import siteweb.devweb.daos.CommentaireDao;
import siteweb.devweb.models.Commentaire;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.assertj.core.api.Assertions.assertThat;

public class CommentaireDaoImplTest {
    private CommentaireDao commentaireDao = new CommentaireDaoImpl();

    @Test
    public void shouldAddCommentaire() {
        // GIVEN
        Commentaire commentaireToAdd = new Commentaire("Arthur Caron", "arthur.caron@hei.yncrea.fr", "Test");
        // WHEN
        commentaireDao.addCommentaire(commentaireToAdd);
        // THEN
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM messages WHERE user='Arthur Caron'");) {
            assertThat(resultSet.next()).isTrue();
            assertThat(resultSet.getInt("idmessage")).isNotNull();
            assertThat(resultSet.getString("user")).isEqualTo("Arthur Caron");
            assertThat(resultSet.getString("user_email")).isEqualTo("arthur.caron@hei.yncrea.fr");
            assertThat(resultSet.getString("user_message")).isEqualTo("Test");
            assertThat(resultSet.next()).isFalse();
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

}
