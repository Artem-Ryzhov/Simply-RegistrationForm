package model;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 09.03.16
 * Time: 0:09
 * To change this template use File | Settings | File Templates.
 */
public class User {
    private int userid;
    private String name;
    private String lastname;
    private String email;
    private String country;
    private String city;

    public User() {
    }

    public User(String name, String lastname, String email,String country,String city) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.country = country;
        this.city = city;
    }

    public User(int userid, String name, String lastname, String email, String country, String city) {
        this.userid = userid;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.country = country;
        this.city = city;
    }



    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLastname() {
        return lastname;
    }

    public int getUserid() {
        return userid;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }


    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
