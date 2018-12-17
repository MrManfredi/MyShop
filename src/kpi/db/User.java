package kpi.db;

public class User {
    private static User ourInstance = new User();

    public static User getUser() {
        return ourInstance;
    }

    private String url;
    private String login;
    private String password;

    public User() {
        url = "jdbc:mysql://localhost:3306/MyShopDB?useSSL=false";
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
