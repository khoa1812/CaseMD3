package controller;

import model.Student;
import service.IStudentService;
import service.StudentService;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = "/students")
public class StudentServlet extends HttpServlet {

    private final StudentService studentService = new StudentService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String action = req.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                createStudent(req, resp);
                break;
            case "edit":
                updateStudent(req, resp);
                break;
            case "delete":
                deleteStudent(req, resp);
                break;
            default:
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(req, resp);
                break;
            case "edit":
                showEditForm(req, resp);
                break;
            case "delete":
                showDeleteForm(req, resp);
                break;
            case "view":
                viewStudent(req, resp);
                break;
            default:
                listStudents(req, resp);
                break;
        }
    }

    private void viewStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int studentId = Integer.parseInt(req.getParameter("id"));
        Student student = this.studentService.searchById(studentId);
        RequestDispatcher dispatcher;

        if (student == null) {
            dispatcher = req.getRequestDispatcher("view/error-404.jsp");
        } else {
            req.setAttribute("student", student);
            dispatcher = req.getRequestDispatcher("view/view.jsp");
            dispatcher.forward(req,resp);
        }
    }

    private void listStudents(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = this.studentService.showAll();
        for (Student student: students){
            System.out.println(student.toString());
        }
        req.setAttribute("students", students);

        req.getRequestDispatcher("view/list.jsp").forward(req,resp);
    }

    private void createStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nameStudent = req.getParameter("nameStudent");
        String dob = req.getParameter("dob");

        double gradeToan = Double.parseDouble(req.getParameter("gradeToan"));
        double gradeVan = Double.parseDouble(req.getParameter("gradeVan"));
        double gradeAnh = Double.parseDouble(req.getParameter("gradeAnh"));
        String nameClass = req.getParameter("nameClass");

        Student student = new Student(0,nameStudent, dob, gradeToan, gradeVan, gradeAnh, nameClass); // studentId được đặt là 0 vì nó sẽ được tự động tạo
        studentService.saveList(student); // Gọi service để lưu sinh viên

        resp.sendRedirect("students"); // Chuyển hướng người dùng về danh sách sinh viên
    }



    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/create.jsp");
        dispatcher.forward(req,resp);
    }

    private void updateStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            int studentId = Integer.parseInt(req.getParameter("id"));
            String nameStudent = req.getParameter("nameStudent");
            String dob = req.getParameter("dob");
            double gradeToan = Double.parseDouble(req.getParameter("gradeToan"));
            double gradeVan = Double.parseDouble(req.getParameter("gradeVan"));
            double gradeAnh = Double.parseDouble(req.getParameter("gradeAnh"));
            Student student = this.studentService.searchById(studentId);
            RequestDispatcher dispatcher;
            if (student == null) {
                dispatcher = req.getRequestDispatcher("error.jsp");
            } else {
                student.setStudentId(studentId);
                student.setNameStudent(nameStudent);
                student.setDob(dob);
                student.setGradeToan(gradeToan);
                student.setGradeVan(gradeVan);
                student.setGradeAnh(gradeAnh);
                this.studentService.update(studentId, student);
                req.setAttribute("student", student);
                req.setAttribute("message", "Student information was updated successfully.");
                dispatcher = req.getRequestDispatcher("view/edit.jsp");
                dispatcher.forward(req, resp);
            }
    }


    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int studentId = Integer.parseInt(req.getParameter("id"));
        Student student = this.studentService.searchById(studentId);
        RequestDispatcher dispatcher;
        if (student == null) {
            dispatcher = req.getRequestDispatcher("error.jsp");
        } else {
            req.setAttribute("student", student);
            dispatcher = req.getRequestDispatcher("view/edit.jsp");
            dispatcher.forward(req,resp);
        }
    }

    private void deleteStudent(HttpServletRequest req, HttpServletResponse resp) {
        int studentId = Integer.parseInt(req.getParameter("id"));
        Student student = this.studentService.searchById(studentId);
        RequestDispatcher dispatcher;
        if (student == null) {
            dispatcher = req.getRequestDispatcher("error.jsp");
        } else {
            this.studentService.delete(studentId);
            try {
                resp.sendRedirect("/students");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void showDeleteForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int studentId = Integer.parseInt(req.getParameter("id"));
        Student student = this.studentService.searchById(studentId);
        RequestDispatcher dispatcher;
        if (student == null) {
            dispatcher = req.getRequestDispatcher("error.jsp");
        } else {
            req.setAttribute("student", student);
            dispatcher = req.getRequestDispatcher("view/delete.jsp");
            dispatcher.forward(req,resp);
        }
    }
}

