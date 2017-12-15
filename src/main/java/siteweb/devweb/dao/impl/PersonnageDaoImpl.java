package siteweb.devweb.dao.impl;
import siteweb.devweb.daos.PersonnageDao;
import siteweb.devweb.models.Personage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;





public class PersonnageDaoImpl implements PersonnageDao {

    @Override
    public List<Personage> listPersonnage() {
        String query="SELECT * FROM personnage ORDER BY personnage_name;";
        List<Personage> personnages=new ArrayList<Personage>();
        try (Connection connection=DataSourceProvider.getDataSource().getConnection()){
            try (java.sql.Statement statement=connection.createStatement()){
                try(ResultSet resultSet=statement.executeQuery(query)){
                    while (resultSet.next()){
                        Personage personnage=new Personage(resultSet.getInt("persoonage_id"),resultSet.getString("personnage_name"));
                        personnages.add(personnage);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personnages;
    }

    @Override
    public Personage getPersonnage(Integer id) {
        try (Connection connection=DataSourceProvider.getDataSource().getConnection()){
            try(PreparedStatement statement=connection.prepareStatement("SELECT * FROM personnage WHERE personage_id=?")){
                statement.setInt(1, id);
                try(ResultSet resultSet=statement.executeQuery()){
                    if (resultSet.next()){
                        return new Personage(resultSet.getInt("personnage_id"),resultSet.getString("personnage_name"));
                    }
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Personage getPersonnageWithName(String name) {
        try (Connection connection=DataSourceProvider.getDataSource().getConnection()){
            try(PreparedStatement statement=connection.prepareStatement("SELECT * FROM personnage WHERE personange_name=?")){
                statement.setString(1, name);
                try(ResultSet resultSet=statement.executeQuery()){
                    if (resultSet.next()){
                        return new Personage(resultSet.getInt("personnage_id"),resultSet.getString("personnage_name"));
                    }
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
