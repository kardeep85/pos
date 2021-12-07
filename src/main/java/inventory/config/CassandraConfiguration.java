package inventory.config;


import com.datastax.driver.core.PlainTextAuthProvider;
import com.datastax.driver.core.AuthProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;



@Configuration
@EnableCassandraRepositories
public class CassandraConfiguration  extends AbstractCassandraConfiguration {

    private final CassandraConfigValue cassandraConfigValue;

    public CassandraConfiguration(CassandraConfigValue cassandraConfigValue)
    {
        this.cassandraConfigValue =cassandraConfigValue;
    }


    protected AuthProvider getAuthProvider(){
        return new PlainTextAuthProvider(cassandraConfigValue.getUser(),cassandraConfigValue.getPassword());
    }

    @Override
    protected String getContactPoints() {
        return String.join(",", cassandraConfigValue.getContactPoint());
    }

    @Override
    protected String getKeyspaceName() {
        return "store";
    }

    @Override
    protected int getPort() {
        return 9042;
    }
//    public String[] getEntityBasePackages(){
//        return new String[]{"table entity"};
//    }
}