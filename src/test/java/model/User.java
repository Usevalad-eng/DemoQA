package model;

public class User {

    private String name;
    private String lastname;
    private String email;
    private String phone;
    private String gender;
    private String month;
    private String year;
    private String day;
    private String subject;
    private String hobby;
    private String file;
    private String address;
    private String state;
    private String city;

    public User(String name, String lastname, String email, String phone, String gender,
                String month, String year, String day, String subject, String hobby, String file,
                String address, String state, String city) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.month = month;
        this.year = year;
        this.day = day;
        this.subject = subject;
        this.hobby = hobby;
        this.file = file;
        this.address = address;
        this.state = state;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getGender() {
        return gender;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public String getDay() {
        return day;
    }

    public String getSubject() {
        return subject;
    }

    public String getHobby() {
        return hobby;
    }

    public String getFile() {
        return file;
    }

    public String getAddress() {
        return address;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }
}
