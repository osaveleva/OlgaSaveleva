package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
    private static PropertyManager instance;
    private static String propertyFilePath = "src/main/resources/config.properties";
    private static String url;
    private static String login;
    private static String password;
    private static String mainDriverTitle;
    private static String pageTitle;
    private static String logo;
    private static String href;
    private static String subheader;
    private static String leftSidemenuSize;
    private static String subTextSize;
    private static String iconSize;
    private static String menuService;
    private static String menuDiffElements;
    private static String checkBoxCollectionSize;
    private static String radioButtonCollectionSize;
    private static String dropdownCollectionSize;
    private static String buttonsCollectionSize;


    public static PropertyManager getInstance() {
        instance = new PropertyManager();
        instance.loadData();

        return instance;
    }


    private void loadData() {

        Properties prop = new Properties();


        try {
            prop.load(new FileInputStream(propertyFilePath));

        } catch (IOException e) {
            System.out.println("Configuration properties file cannot be found");
        }

        url = prop.getProperty("url");
        login = prop.getProperty("login");
        password = prop.getProperty("password");
        mainDriverTitle = prop.getProperty("mainDriverTitle");
        pageTitle = prop.getProperty("pageTitle");
        logo = prop.getProperty("logo");
        href = prop.getProperty("href");
        subheader = prop.getProperty("subheader");
        leftSidemenuSize = prop.getProperty("leftSidemenuSize");
        subTextSize = prop.getProperty("subTextSize");
        iconSize = prop.getProperty("iconSize");
        checkBoxCollectionSize = prop.getProperty("checkBoxCollectionSize");
        radioButtonCollectionSize = prop.getProperty("radioButtonCollectionSize");
        dropdownCollectionSize = prop.getProperty("dropdownCollectionSize");
        buttonsCollectionSize = prop.getProperty("buttonsCollectionSize");
    }

    public String getURL() {
        return url;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getMainDriverTitle() {
        return mainDriverTitle;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public String getLogo() {
        return logo;
    }

    public String getHref() {
        return href;
    }

    public String getSubHeader() {
        return subheader;
    }

    public String getLeftSidemenuSize() {
        return leftSidemenuSize;
    }

    public String getSubTextSize() {
        return subTextSize;
    }

    public String getIconSize() {
        return iconSize;
    }

    public String getCheckBoxCollectionSize() {
        return checkBoxCollectionSize;
    }

    public String getRadioButtonCollectionSize() {
        return radioButtonCollectionSize;
    }

    public String getDropdownCollectionSize() {
        return dropdownCollectionSize;
    }

    public String getButtonsCollectionSize() {
        return buttonsCollectionSize;
    }

}
