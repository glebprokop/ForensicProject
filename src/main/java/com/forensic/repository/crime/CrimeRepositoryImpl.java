package com.forensic.repository.crime;

import com.forensic.dbmanager.converter.basemapper.CrimeMapper;
import com.forensic.entity.crime.Crime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CrimeRepositoryImpl implements CrimeRepository{

    @Autowired
    DataSource dataSource;

    @Autowired
    CrimeMapper parser;

    @Override
    public List<Crime> findAll() {
        String query = "select * from crime order by id";
        List<Crime> crimes = new ArrayList<>();


        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet rs = statement.executeQuery())
        {
            while (rs.next()) {
                crimes.add(parser.parseResultSet(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return crimes;
    }

    @Override
    public Crime findById(Long id) {
        String query = "select * from crime where id=?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query))
        {
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();

            Crime object;

            if (rs.next()) {
                object = parser.parseResultSet(rs);

                return object;
            } else {
                throw new SQLException("No such object with id = " + id);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Crime> findOne(Long id) {
        Optional<Crime> optionalCrime = null;

        String query = "select * from crime where id=?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query))
        {
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                optionalCrime = Optional.of(parser.parseResultSet(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return optionalCrime;
    }

    @Override
    public Crime delete(Long id) {
        Crime object = findById(id);

        final String query = "delete from crime where id=?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query))
        {
            statement.setLong(1, id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return object;
    }

    @Override
    public Crime add(Crime crime) {
        final String query = "insert into crime (police_reg_number, case_investigation_number, " +
                "criminal_code_article_number, description, crime_date) values (?, ?, ?, ?, ?)";

        final String getLastId = "select id from crime order by id desc limit 1";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query))
        {

            statement.setLong(1, crime.getPoliceRegNumber());
            statement.setLong(2, crime.getCaseInvestigationNumber());
            statement.setLong(3, crime.getCriminalCodeArticleNumber());
            statement.setString(4, crime.getDescription());
            statement.setTimestamp(5, crime.getCrimeDate());
            statement.executeUpdate();

            PreparedStatement lastIdStatement = connection.prepareStatement(getLastId);
            ResultSet rs = lastIdStatement.executeQuery();

            if(rs.next()){
                crime.setId(rs.getLong("id"));
            }

            return crime;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Crime> update(Long id, Crime newCrime) {
        String query = "update crime set " +
                        "police_reg_number = ?," +
                        "case_investigation_number = ?," +
                        "criminal_code_article_number = ?," +
                        "description = ?," +
                        "crime_date = ?" +
                        "where id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query))
        {

            statement.setLong(1, newCrime.getPoliceRegNumber());
            statement.setLong(2, newCrime.getCaseInvestigationNumber());
            statement.setLong(3, newCrime.getCriminalCodeArticleNumber());
            statement.setString(4, newCrime.getDescription());
            statement.setTimestamp(5, newCrime.getCrimeDate());
            statement.setLong(6, id);
            statement.executeUpdate();

            return this.findOne(id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Long> getAllId() {
        String query = "select * from crime";
        List<Long> allId = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet rs = statement.executeQuery())
        {
            while (rs.next()) {
                allId.add(parser.parseResultSet(rs).getId());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return allId;
    }

    @Override
    public List<Crime> getCrimesForMonth(Integer year, Integer month) {
        List<Crime> crimes = new ArrayList<>();

        String query = "select * from crime " +
                "where date_part('year', crime_date) = ? and " +
                "date_part('month', crime_date) = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query))
        {

            statement.setLong(1, year);
            statement.setLong(2, month);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                crimes.add(parser.parseResultSet(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return crimes;
    }

    @Override
    public List<Crime> getCrimesForArticle(Long criminalCodeArticle) {
        List<Crime> crimes = new ArrayList<>();

        String query = "select * from crime " +
                "where criminal_code_article_number = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query))
        {
            statement.setLong(1, criminalCodeArticle);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                crimes.add(parser.parseResultSet(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return crimes;
    }

//    public Crime searchByObject(Crime crime){
//        String query = "select * from crime " +
//                "where criminal_code_article_number = %?%";
//
//
//    }

}
