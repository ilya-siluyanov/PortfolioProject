package org.ilyasiluyanov.models;


import javax.persistence.*;
import java.util.Objects;

/**
 * Account type  without any privileges
 */
@Entity
public class ClassicAccount extends Account {

    public ClassicAccount() {
        super();
    }

    public ClassicAccount(String login, String password, String name, String surname){
        super(login,password,name,surname);
    }


    @Override
    public String toString() {
        return "ClassicAccount{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", balance=" + balance +
                '}';
    }
}

