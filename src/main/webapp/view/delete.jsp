<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Delete Student</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1>Delete Student</h1>
    <!-- Thêm thông tin sinh viên để người dùng biết họ đang xóa ai -->
    <p>Are you sure you want to delete the student <strong>${student.nameStudent}</strong> with ID <strong>${student.studentId}</strong>?</p>
    <form method="post">
        <input type="hidden" name="action" value="delete">
        <input type="hidden" name="id" value="${student.studentId}">
        <input type="submit" class="btn btn-danger" value="Delete">
        <!-- Sử dụng nút Bootstrap cho liên kết "Quay lại" để giữ nhất quán về mặt giao diện -->
        <a href="students?action=list" class="btn btn-secondary">Quay lại</a>
    </form>
</div>
</body>
</html>
