package org.ilyasiluyanov.models;

/**
 * account type is used for logging in and registering
 */
public class RawAccount extends Account {

    private String rawLogin;

    private String rawPassword;

    private boolean isCorrect;

    public RawAccount() {
        super();
    }

    public RawAccount(String login, String password, String name, String surname) {
        super(login, password, name, surname);
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public String getRawLogin() {
        return rawLogin;
    }

    public String getRawPassword() {
        return rawPassword;
    }

    public void setRawLogin(String rawLogin) {
        this.rawLogin = rawLogin;
    }

    public void setRawPassword(String rawPassword) {
        this.rawPassword = rawPassword;
    }

    @Override
    public boolean equals(Object o) {
        boolean result;
        if (o == null) {
            result = false;
        } else if (!(o instanceof Account)) {
            return false;
        } else {
            Account account = (Account) o;
            boolean loginEquality = account.login.equals(this.rawLogin);
            boolean passwordEquality = account.password.equals(this.rawPassword);
            result = loginEquality && passwordEquality;

        }
        return result;
    }


    public boolean isEmpty() {
        return this.rawLogin == null && this.rawPassword == null;
    }

    public enum AccountType {
        CLASSIC, BUSINESS
    }
}
