package model;

import java.util.Date;

public class Student {
    private int student_id;
    private String full_name;
    private Date date_of_birth;
    private String email;

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Student() {
    }

    public Student(int student_id, String full_name, Date date_of_birth, String email) {
        this.student_id = student_id;
        this.full_name = full_name;
        this.date_of_birth = date_of_birth;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "student_id=" + student_id +
                ", full_name='" + full_name + '\'' +
                ", date_of_birth=" + date_of_birth +
                ", email='" + email + '\'' +
                '}';
    }
}
