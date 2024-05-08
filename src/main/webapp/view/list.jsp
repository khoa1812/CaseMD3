<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>List of Students</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            margin: 0;
            padding: 0;
            background-image: url('https://png.pngtree.com/background/20230401/original/pngtree-heavens-gate-beautiful-background-picture-image_2248817.jpg'); /* Thay 'link-ảnh-học-tập.jpg' bằng đường dẫn đến hình ảnh thích hợp */
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
            height: 100vh; /* Đặt chiều cao của body bằng chiều cao của màn hình */
        }

        .container {
            background-color: rgba(255, 255, 255, 0.4); /* Độ mờ của background */
            padding: 20px;
            margin-top: 20px;
            border-radius: 10px;
        }

        h1 {
            text-align: center;
            /*position: absolute;*/
            /*top: 0;*/
            /*left: 0;*/
            /*padding: 10px;*/
        }

        table {
            width: 100%;
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #007bff;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        .btn-primary {
            margin-top: 20px;
            display: block;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>List of Students</h1>
    <table class="table">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Date of Birth</th>
            <th>Class Name</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="student" items="${students}">
            <tr>
                <td><c:out value="${student.studentId}"/></td>
                <td><c:out value="${student.nameStudent}"/></td>
                <td><c:out value="${student.dob}"/></td>
<%--                <td><c:out value="${student.nameClass}"/></td>--%>
                <td>
                    <a href="students?action=view&id=${student.studentId}">View</a>
                    <a href="students?action=edit&id=${student.studentId}">Edit</a>
                    <a href="students?action=delete&id=${student.studentId}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>

        <a href="students?action=create" class="btn btn-primary">Create New Student</a>

</div>
</body>
</html>
