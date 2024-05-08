package service;

import model.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/casestudy";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "khoatrinh18122001";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
            System.out.println("THANH CONG");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Connection error: " + e.getMessage());
        }
        return connection;
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM student";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Student student = new Student();
                student.setStudentId(rs.getInt("studentId"));
                student.setNameStudent(rs.getString("nameStudent"));
                student.setDob(rs.getDate("dob"));

                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public Student getStudentById(int studentId) {
        Student student = null;
        String query = "SELECT * FROM allstudent WHERE studentId = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, studentId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    student = new Student();
                    student.setStudentId(rs.getInt("studentID"));
                    student.setNameStudent(rs.getString("nameStudent"));
                    student.setDob(rs.getDate("dob"));
                    student.setGradeToan(rs.getDouble("gradeToan"));
                    student.setGradeVan(rs.getDouble("gradeVan"));
                    student.setGradeAnh(rs.getDouble("gradeAnh"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    public void createStudent(Student student) {
        String query = "INSERT INTO Student (nameStudent, dob, gradeToan, gradeVan, gradeAnh) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, student.getNameStudent());
            stmt.setDate(2, new java.sql.Date(student.getDob().getTime()));
            stmt.setDouble(3, student.getGradeToan());
            stmt.setDouble(4, student.getGradeVan());
            stmt.setDouble(5, student.getGradeAnh());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void updateStudent(Student student) {
        String query = "UPDATE student SET nameStudent = ?, dob = ?, gradeToan = ?, gradeVan = ?, gradeAnh = ? WHERE studentId = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, student.getNameStudent());
            stmt.setDate(2, new java.sql.Date(student.getDob().getTime()));
            stmt.setDouble(3, student.getGradeToan());
            stmt.setDouble(4, student.getGradeVan());
            stmt.setDouble(5, student.getGradeAnh());
            stmt.setInt(6, student.getStudentId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int studentId) {
        deleteStudentGrades(studentId);
        String query = "DELETE FROM Student WHERE studentId = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, studentId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudentGrades(int studentId) {
        String sql = "DELETE FROM Grade WHERE id_student = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, studentId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



