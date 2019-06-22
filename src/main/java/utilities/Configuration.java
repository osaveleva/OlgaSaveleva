package utilities;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;


@Sources({"classpath:Configuration.properties"})
public interface Configuration extends Config {
    String url();

    String login();

    String password();
}


