package data;

import org.bson.types.ObjectId;

import java.util.Set;

public class User {
    private ObjectId id;
    private String name;
    private String surname;
    private String phone;
    private Set<UserAccount> account;

    public User() {
    }

    public User(ObjectId id, String name, String surname, String phone, Set<UserAccount> account) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.account = account;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<UserAccount> getAccount() {
        return account;
    }

    public void setAccount(Set<UserAccount> account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", account=" + account +
                '}';
    }
}




