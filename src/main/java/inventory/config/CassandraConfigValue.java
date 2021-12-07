package inventory.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "cassandra")
//@PropertySource("classpath:cassandra.properties")  -> need separate file
public class CassandraConfigValue {
    private String user;
    private String password;
    private List<String> contactPoint;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getContactPoint() {
        return contactPoint;
    }

    public void setContactPoint(List<String> contactPoint) {
        this.contactPoint = contactPoint;
    }
}
