package enums;

public enum Credentials {
    PETER_CHAILOVSKII("epam", "1234", "PETER_CHAILOVSKII"),
    PETER_CHAILOVSK("epam1", "12341", "PETER_CHAILOVSKII");

    private final String login;
    private final String password;
    private final String userName;

    Credentials(String login, String password, String userName) {
        this.login = login;
        this.password = password;
        this.userName = userName;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getuserName() {
        return userName;
    }

}
