import com.forensic.configuration.MainSpringConfigClass;

import com.forensic.dbmanager.datasource.DataSourceConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        GenericApplicationContext context = new AnnotationConfigApplicationContext(MainSpringConfigClass.class);

        DataSourceConfig config = context.getBean("dataSourceHikariConfig", DataSourceConfig.class);

        DataSource dataSource = config.configDataSource();

        try {
            dataSource.getConnection();
            System.out.printf("Connection!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        DataSource dataSource1 = context.getBean("hikariDataSource", DataSource.class);

        try {
            dataSource1.getConnection();
            System.out.printf("Connection!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
