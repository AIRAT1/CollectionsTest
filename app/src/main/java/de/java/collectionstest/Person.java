package de.java.collectionstest;

public class Person { //POJO
    private String name;
    private long birth;
    private String telephone;
    private String email;
    private boolean avatarExist;
    private boolean favourite;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getBirth() {
        return birth;
    }

    public void setBirth(long birth) {
        this.birth = birth;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAvatarExist() {
        return avatarExist;
    }

    public void setAvatarExist(boolean avatarExist) {
        this.avatarExist = avatarExist;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }
}
