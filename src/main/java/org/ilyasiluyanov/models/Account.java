package org.ilyasiluyanov.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Account{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;

    protected String login;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    protected String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected String surname;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    protected BigDecimal balance;

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    protected Account() {
    }

    public Account(String login, String password, String name, String surname) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }



    @Override
    public boolean equals(Object o) {
        if (o == null) return true;
        if (this.getClass() != o.getClass()) return false;
        ClassicAccount account = (ClassicAccount) o;
        return id == account.id;
    }


    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
