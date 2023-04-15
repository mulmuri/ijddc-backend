package uos.urbanscience.ijddc.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:.env")
public class EnvConfig {

    public EnvConfig() {
        Dotenv.configure().load();
    }
}
