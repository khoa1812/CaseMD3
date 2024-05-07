<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>List of Students</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .action-buttons a {
            margin-right: 5px;
        }
    </style>
</head>
<body>
<div class="container mt-5">
    <h1>List of Students</h1>
    <div class="my-4">
        <a href="students?action=create" class="btn btn-primary">Create New Student</a>
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
