package model;

import java.util.Date;

public class Student implements GradeAVG {
    private int studentId;
    private String nameStudent;
    private String dob;

    private double gradeToan;
    private double gradeVan;
    private double gradeAnh;
    private String nameClass;

    public Student() {
    }

    public Student(int studentId, String nameStudent, String dob, double gradeToan, double gradeVan, double gradeAnh, String nameClass) {
        this.studentId = studentId;
        this.nameStudent = nameStudent;
        this.dob = dob;
        this.gradeToan = gradeToan;
        this.gradeVan = gradeVan;
        this.gradeAnh = gradeAnh;
        this.nameClass = nameClass;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public double getGradeToan() {
        return gradeToan;
    }

    public void setGradeToan(double gradeToan) {
        this.gradeToan = gradeToan;
    }

    public double getGradeVan() {
        return gradeVan;
    }

    public void setGradeVan(double gradeVan) {
        this.gradeVan = gradeVan;
    }

    public double getGradeAnh() {
        return gradeAnh;
    }

    public void setGradeAnh(double gradeAnh) {
        this.gradeAnh = gradeAnh;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    @Override
    public double scoreAVG() {
        return (getGradeToan()+getGradeVan()+getGradeAnh())/3;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", nameStudent='" + nameStudent + '\'' +
                ", dob=" + dob +
                ", gradeToan=" + gradeToan +
                ", gradeVan=" + gradeVan +
                ", gradeAnh=" + gradeAnh +
                ", nameClass='" + nameClass + '\'' +
                '}';
    }
}

