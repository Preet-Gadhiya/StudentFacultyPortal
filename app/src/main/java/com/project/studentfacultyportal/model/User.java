package com.project.studentfacultyportal.model;

public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private String mobile_no;
    private String total_quiz;
    private String score;
    private String top_scorer;
    private String branch;
    private String semester;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) { this.mobile_no = mobile_no; }

    public String getTotal_quiz() {
        return total_quiz;
    }

    public void setTotal_quiz(String total_quiz) {
        this.total_quiz = total_quiz;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) { this.score = score; }

    public String getTop_scorer() { return top_scorer; }

    public void setTop_scorer(String top_scorer) { this.top_scorer = top_scorer; }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester= semester;
    }

}
