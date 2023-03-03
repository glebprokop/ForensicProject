package com.forensic.repository.crime;

import com.forensic.dbmanager.parser.CrimeParser;
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
    CrimeParser parser;

    @Override
    public List<Crime> foundAll() {
        String query = "select * from crime";
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
    public Optional<Crime> foundById(long id) {
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
    public boolean deleteById(long id) {
        int changedValues = 0;
        String query = "delete from crime where id=?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query))
        {
            statement.setLong(1, id);
            changedValues = statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return changedValues > 0;
    }


    @Override
    public boolean add(Crime crime) {
        int changedValues = 0;
        String query = "insert into crime (police_reg_number, case_investigation_number, criminal_code_article_number, description, crime_date) values (?, ?, ?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query))
        {

            statement.setLong(1, crime.getPoliceRegNumber());
            statement.setLong(2, crime.getCaseInvestigationNumber());
            statement.setLong(3, crime.getCriminalCodeArticleNumber());
            statement.setString(4, crime.getDescription());
            statement.setTimestamp(5, crime.getCrimeDate());

            changedValues = statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return changedValues > 0;
    }

    @Override
    public Optional<Crime> update(long id, Crime newCrime) {
        int changedValues = 0;
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

            changedValues = statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return this.foundById(id);
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
    public List<Crime> getCrimesForMonth(int year, int month) {
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
    public List<Crime> getCrimesForArticle(long criminalCodeArticle) {
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
}
