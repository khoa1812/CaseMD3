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
        String query = "SELECT * FROM allstudent";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Student student = new Student();
                student.setStudentId(rs.getInt("studentId"));
                student.setNameStudent(rs.getString("nameStudent"));
                student.setDob(rs.getString("dob"));
                student.setGradeToan(rs.getDouble("gradeToan"));
                student.setGradeVan(rs.getDouble("gradeVan"));
                student.setGradeAnh(rs.getDouble("gradeAnh"));
                student.setNameClass(rs.getString("nameClass"));
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
                    student.setDob(rs.getString("dob"));
                    student.setGradeToan(rs.getDouble("gradeToan"));
                    student.setGradeVan(rs.getDouble("gradeVan"));
                    student.setGradeAnh(rs.getDouble("gradeAnh"));
                    student.setNameClass(rs.getString("nameClass"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    public void createStudent(Student student) {
        String query = "INSERT INTO allstudent (nameStudent, nameClass, dob, gradeToan, gradeVan, gradeAnh) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, student.getNameStudent());
            stmt.setString(2, student.getNameClass());
            stmt.setString(3, student.getDob());
            stmt.setDouble(4, student.getGradeToan());
            stmt.setDouble(5, student.getGradeVan());
            stmt.setDouble(6, student.getGradeAnh());


            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(Student student) {
        String query = "UPDATE allStudent SET nameStudent = ?, dob = ?, nameClass = ?, gradeToan = ?, gradeVan = ?, gradeAnh = ? WHERE studentId = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, student.getNameStudent());
            stmt.setString(2, student.getDob());
            stmt.setString(3, student.getNameClass());
            stmt.setDouble(4, student.getGradeToan());
            stmt.setDouble(5, student.getGradeVan());
            stmt.setDouble(6, student.getGradeAnh());
            stmt.setInt(7, student.getStudentId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int studentId) {
        String query = "DELETE FROM allStudent WHERE studentId = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, studentId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



