import com.forensic.configuration.MainSpringConfigClass;

import com.forensic.repository.crime.CrimeRepositoryJdbcTemplateImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(MainSpringConfigClass.class);
//
//        CrimeDBColumnMapper dbMapper = context.getBean("crimeDBColumnMapper", CrimeDBColumnMapper.class);
//
        Map<String, String> requestParam = new HashMap<>();

        requestParam.put("police_reg_number", "123");
        requestParam.put("crime_date", "01.01.1980");
        requestParam.put("id", "20");
//
//        QueryCreator queryCreator = new QueryCreator();
//
//        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
//        parameterSource.addValue("id", new Crime().getId());
//        parameterSource.addValue("police_reg_number", new Crime().getPoliceRegNumber());
//        parameterSource.addValue("case_number", new Crime().getCaseInvestigationNumber());
//        parameterSource.addValue("description", new Crime().getDescription());
//        parameterSource.addValue("criminal_code_article_number", new Crime().getCriminalCodeArticleNumber());
//        parameterSource.addValue("crime_date", new Crime().getCrimeDate());
//
//        String testQuery = queryCreator.createSelectQueryByParam("crime", requestParam, dbMapper.allColumns());
//
//        System.out.println(testQuery);



        CrimeRepositoryJdbcTemplateImpl repository =
                context.getBean("crimeRepositoryJdbcTemplateImpl", CrimeRepositoryJdbcTemplateImpl.class);

        System.out.println(repository.findAll());

        System.out.println(repository.searchByParams(requestParam));


//        System.out.println(repository.findOne(59L));
//
//        System.out.println(repository.delete(59L));

//        System.out.println(repository.create(Crime.builder().build()));

        //System.out.println(repository.update(Crime.builder().id(60L).caseNumber(123L).build()));

//        System.out.println(repository.findById(60L));

//        System.out.println(repository.getCrimesForArticle(139L));

       // repository.deleteAfterDate(Timestamp.valueOf("1978-01-01 00:00:00"));

    }
}
