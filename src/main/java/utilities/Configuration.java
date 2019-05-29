package utilities;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;


@Sources({"classpath:Configuration.properties"})
public interface Configuration extends Config{
    String url();
    String login();
    String password();
    String logo();
    String href();
    String mainDriverTitle();
    String pageTitle();
    String subheader();
    String iconSize();
    String dropdownCollectionSize();
    String invalidUserName();

}


