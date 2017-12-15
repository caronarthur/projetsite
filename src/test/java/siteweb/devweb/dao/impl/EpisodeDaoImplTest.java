package siteweb.devweb.dao.impl;

import org.junit.Test;
import siteweb.devweb.daos.PersonnageDao;

import org.assertj.core.internal.cglib.core.Local;
import org.junit.Before;
import org.junit.Test;


import java.sql.*;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;
import siteweb.devweb.dao.impl.EpisodeDaoImpl;
import siteweb.devweb.dao.impl.PersonnageDaoImpl;
import siteweb.devweb.daos.EpisodeDao;
import siteweb.devweb.daos.PersonnageDao;
import siteweb.devweb.models.Episode;
import siteweb.devweb.models.Personage;

import java.util.List;

public class EpisodeDaoImplTest {

    private PersonnageDao personnageDao=new PersonnageDaoImpl();

    @Test
    public void shouldListPersonnage(){
        //WHEN
        List<Personage> personages=personnageDao.listPersonnage();
        //THEN
        assertThat(personages).hasSize(5);

        assertThat(personages).extracting("personnage_id","personnage_name").containsOnly(tuple(5,"Jon"),tuple(4,"Cersey"),tuple(3,"Daenerys"),tuple(2,"Tyrion"),tuple(1,"Jaime"));

    }
    @Test
    public void shouldGetPersonnage() {
        // WHEN
        Personage personage = personnageDao.getPersonnage(1);
        // THEN
        assertThat(personage).isNotNull();
        assertThat(personage.getPersonnage_id()).isEqualTo(1);
        assertThat(personage.getPersonnage_name()).isEqualTo("Jon Snow");
    }



}


