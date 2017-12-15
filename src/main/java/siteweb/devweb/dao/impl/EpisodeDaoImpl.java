package siteweb.devweb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import siteweb.devweb.daos.EpisodeDao;
import siteweb.devweb.models.Episode;
import siteweb.devweb.models.Personage;

public class EpisodeDaoImpl implements EpisodeDao {

    @Override
    public List<Episode> listEpisodes(Personage personnage) {
        List<Episode> episodes = new ArrayList<Episode>();
        try (Connection connection = DataSourceProvider.getDataSource().getConnection()) {
            try (PreparedStatement statement = connection
                    .prepareStatement("SELECT * FROM episode WHERE personnage_id=? ORDER BY episode_id;")) {
                statement.setInt(1, personnage.getPersonnage_id());
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Episode episode = new Episode(resultSet.getInt("episode_id"), resultSet.getInt("parution"), resultSet.getInt("avis"), resultSet.getString("resume"), resultSet.getInt("personnage_id"));
                        episodes.add(episode);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return episodes;
    }

    @Override
    public Episode getEpisode(Integer id) {
        try (Connection connection = DataSourceProvider.getDataSource().getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM episode WHERE episode_id=?")) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return new Episode(resultSet.getInt("episode_id"),
                                resultSet.getInt("parution"), resultSet.getInt("avis"),
                                resultSet.getString("resume"), resultSet.getInt("personnage_id")
                        );
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Episode addEpisode(Episode newEpisode) {
        try (Connection connection = DataSourceProvider.getDataSource().getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO livre(titre`,`parution`,`avis`,`resume`,`personnage_id`) VALUES(?,?,?,?,?);",
                    Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, newEpisode.getTitre());
                statement.setInt(2, newEpisode.getParution());
                statement.setInt(3, newEpisode.getAvis());
                statement.setString(4, "http://www.game-of-thrones.fr");
                statement.setInt(5, newEpisode.getPersonnage_id());
                statement.executeUpdate();
                return newEpisode;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer deleteEpisode(Integer episode_id) {
        try (Connection connection = DataSourceProvider.getDataSource().getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement("DELETE FROM episode WHERE episode_id=?;")) {
                statement.setInt(1, episode_id);
                statement.executeUpdate();
                return episode_id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Episode> listeDerniersEpisodesAjoutés() {
        List<Episode> episodes = new ArrayList<Episode>();
        try (Connection connection = DataSourceProvider.getDataSource().getConnection()) {
            try (PreparedStatement statement = connection
                    .prepareStatement("SELECT * FROM episode ORDER BY episode_id DESC LIMIT 7;")) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Episode episode = new Episode(resultSet.getInt("episode_id"),
                                resultSet.getInt("parution"), resultSet.getInt("avis"),
                                resultSet.getString("resume"), resultSet.getInt("personnage_id"));
                        episodes.add(episode);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return episodes;
    }

    @Override
    public List<Episode> episodesMieuxNotés() {
        List<Episode> episodes=new ArrayList<Episode>();
        try (Connection connection = DataSourceProvider.getDataSource().getConnection()) {
            try (PreparedStatement statement = connection
                    .prepareStatement("SELECT * FROM episode WHERE avis>=4 ORDER BY avis DESC;")) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()){
                        Episode episode = new Episode(resultSet.getInt("episode_id"),
                                resultSet.getInt("parution"), resultSet.getInt("avis"),
                                resultSet.getString("resume"), resultSet.getInt("personnage_id")
                        );
                        episodes.add(episode);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return episodes;
    }

    @Override
    public Integer modifierEpisode(Integer id, String titre, Integer parution, Integer avis) {
        try (Connection connection = DataSourceProvider.getDataSource().getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement("UPDATE episode SET titre=?,parution=?,avis=? WHERE episode_id=?")) {

                statement.setString(1, titre);
                statement.setInt(2, parution);
                statement.setInt(3, avis);
                statement.setInt(4, id);
                statement.executeUpdate();



            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

}
