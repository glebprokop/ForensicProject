//package com.forensic.repository.crime;
//
//import com.forensic.dbmanager.converter.rowmapper.CrimeRowMapper;
//import com.forensic.entity.crime.Crime;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Primary;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//@Primary
//public class CrimeRepositoryJDBCTemplateImpl implements CrimeRepository{
//
//    @Autowired
//    JdbcTemplate dataManager;
//
//    @Autowired
//    CrimeRowMapper rowMapper;
//
//    @Override
//    public List<Crime> findAll() {
//        String query = "select * from crime";
//
//        return dataManager.query(query, rowMapper);
//    }
//
//    @Override
//    public Crime findById(Long id) {
//        String query = "select * from crime where id=?";
//
//        Optional<Crime> result = Optional.of(dataManager.queryForObject(query, rowMapper, new Object[]{id, id}));
//
//        return result;
//    }
//
//    @Override
//    public Optional<Crime> findOne(Long id) {
//        return Optional.empty();
//    }
//
//    @Override
//    public Crime delete(Long id) {
//        String query = "delete from crime where id=?";
//
//        int changedValues = dataManager.update(query, new Object[]{id});
//
//        return changedValues > 0;
//    }
//
//    @Override
//    public Crime add(Crime crime) {
//        String query = "insert into crime (police_reg_number, " +
//                "case_investigation_number, criminal_code_article_number, " +
//                "description, crime_date) values (?, ?, ?, ?, ?)";
//
//        int changedValues = dataManager.update(query, crime.getPoliceRegNumber(),
//                crime.getCaseInvestigationNumber(),
//                crime.getCriminalCodeArticleNumber(),
//                crime.getDescription(),
//                crime.getCrimeDate());
//
//        return changedValues > 0;
//    }
//
//    @Override
//    public Optional<Crime> update(Long id, Crime newCrime) {
//        return Optional.empty();
//    }
//
//    @Override
//    public List<Long> getAllId() {
//        String query = "select * from crime";
//
//        List<Long> allId = dataManager.query(query, rowMapper)
//                .stream()
//                .map(c -> c.getId())
//                .toList();
//
//        return allId;
//    }
//
//    @Override
//    public List<Crime> getCrimesForMonth(Integer year, Integer month) {
//        return null;
//    }
//
//    @Override
//    public List<Crime> getCrimesForArticle(Long criminalCodeArticle) {
//        return null;
//    }
//}
