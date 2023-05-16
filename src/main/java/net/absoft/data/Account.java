package net.absoft.data;

public enum Account {
    STANDARD_USER("standard_user", "secret_sauce"),
    PROBLEM_USER("problem_user", "secret_sauce");

// Other accounts might be placed here

    public String login;
    public String password;

    Account(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Account{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
