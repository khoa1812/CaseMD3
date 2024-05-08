<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>List of Students</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa; /* Màu nền nhẹ nhàng cho trang */
            font-family: 'Arial', sans-serif; /* Phông chữ */
        }
        .container {
            background-color: #ffffff; /* Màu nền cho container */
            box-shadow: 0 4px 8px rgba(0,0,0,0.1); /* Bóng đổ */
            border-radius: 8px; /* Bo tròn góc */
            padding: 20px;
            margin-top: 40px; /* Khoảng cách từ top */
        }
        h1 {
            color: #333; /* Màu chữ cho tiêu đề */
            text-align: center; /* Căn giữa tiêu đề */
            margin-bottom: 30px; /* Khoảng cách dưới tiêu đề */
        }
        .table {
            margin-top: 20px; /* Khoảng cách từ nút tạo mới đến bảng */
            text-align: center; /* Căn giữa chữ trong bảng */
        }
        .table-bordered th, .table-bordered td {
            border-color: #dee2e6 !important; /* Màu viền cho bảng */
            text-align: center; /* Thêm dòng này để căn giữa chữ trong các ô */
        }
        .table-dark {
            background-color: #343a40; /* Màu nền cho header bảng */
        }
        .table-dark th {
            color: #ffffff; /* Màu chữ cho header bảng */
        }
        .action-buttons a {
            margin-right: 5px;
            text-decoration: none; /* Gỡ bỏ gạch chân */
        }
        .btn-primary, .btn-info, .btn-warning, .btn-danger {
            color: #fff; /* Màu chữ cho nút */
            border: none; /* Gỡ bỏ viền */
        }
        .btn-info {
            background-color: #17a2b8;
        }
        .btn-warning {
            background-color: #ffc107;
        }
        .btn-danger {
            background-color: #dc3545;
        }
        .posi {
            position: sticky;
            top: 0;
            background-color: #ffffff;
            border: 2px solid #ffffff;
        }
        .search-container form {
            display: flex;
            justify-content: center;
            gap: 10px; /* Khoảng cách giữa input và button */
        }

        .search-container input[type="text"] {
            width: 240px; /* Chiều rộng của trường nhập */
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px; /* Bo tròn góc */
        }

        .search-container button {
            padding: 10px 20px;
            background-color: #28a745; /* Màu nền cho nút */
            color: white;
            border: none;
            border-radius: 5px; /* Bo tròn góc */
            cursor: pointer; /* Hiệu ứng con trỏ khi di chuyển qua nút */
        }

        .search-container button:hover {
            background-color: #218838; /* Màu nền khi hover */
        }

    </style>

    </style>
</head>
<body>

<div class="container mt-5">
    <div class="posi"> <h1>LIST OF STUDENTS</h1></div>
    <div class="my-4">
        <a href="students?action=create" class="btn btn-primary">Create New Student</a>
    </div>
    <!-- Thêm form tìm kiếm vào đây -->
    <div class="search-container my-4">
        <form action="/students" method="GET">
            <input type="text" placeholder="Search for students.." name="search" required>
            <button type="submit" class="btn btn-success">Search</button>
        </form>
    </div>
    <table class="table table-bordered table-hover">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Date of Birth</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="student" items="${students}">
            <tr>
                <td><c:out value="${student.studentId}"/></td>
                <td><c:out value="${student.nameStudent}"/></td>
                <td><c:out value="${student.dob}"/></td>

                <td class="action-buttons">
                    <a href="students?action=view&id=${student.studentId}" class="btn btn-info btn-sm">View</a>
                    <a href="students?action=edit&id=${student.studentId}" class="btn btn-warning btn-sm">Edit</a>
                    <a href="students?action=delete&id=${student.studentId}" class="btn btn-danger btn-sm">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
