import com.forensic.aspect.HomeworkAspect;
import com.forensic.configuration.MainSpringConfigClass;

import com.forensic.dbmanager.datasource.DataSourceConfig;
import com.forensic.repository.crime.CrimeRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        GenericApplicationContext context = new AnnotationConfigApplicationContext(MainSpringConfigClass.class);

        CrimeRepository repository = context.getBean("crimeRepositoryImpl", CrimeRepository.class);

        repository.findAll();
        repository.findAll();

        repository.getAllId();
        repository.getAllId();
        repository.getAllId();

        HomeworkAspect aspect = context.getBean("homeworkAspect", HomeworkAspect.class);
        System.out.println(aspect.getCountMethodsCall());



       //DataSourceConfig config = context.getBean("dataSourceHikariConfig", DataSourceConfig.class);




        //DataSource dataSource = config.configDataSource();


        //
//        try {
//            dataSource.getConnection();
//            System.out.printf("Connection!");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//
//        DataSource dataSource1 = context.getBean("hikariDataSource", DataSource.class);
//
//        try {
//            dataSource1.getConnection();
//            System.out.printf("Connection!");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }


    }
}
