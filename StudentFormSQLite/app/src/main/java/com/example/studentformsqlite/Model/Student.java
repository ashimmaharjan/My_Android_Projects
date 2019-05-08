package com.example.studentformsqlite.Model;

public class Student {
    private String student_id;
    private String student_name;
    private String phoneNumber;
    private String email;
    private String image;



    public Student(String student_id, String student_name, String phoneNumber, String email, String image) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.image = image;
    }

    public final static  String TABLE_NAME="Students";
    public final static String TBL_QUERY="CREATE TABLE "+ TABLE_NAME +
        " (ID INTEGER PRIMARY KEY, STUDENT_NAME TEXT, CONTACT_NUMBER TEXT , EMAIL TEXT, IMAGE TEXT)";


    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image=image;
    }
}
