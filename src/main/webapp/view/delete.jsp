<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Delete Student</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body{
            background-image: url('https://png.pngtree.com/background/20230401/original/pngtree-heavens-gate-beautiful-background-picture-image_2248817.jpg'); /* Thay 'link-ảnh-học-tập.jpg' bằng đường dẫn đến hình ảnh thích hợp */
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Delete Student</h1>
    <p>Are you sure you want to delete this student?</p>
    <form method="post">
        <input type="hidden" name="action" value="delete">
        <input type="hidden" name="id" value="${student.studentId}">
        <input type="submit" class="btn btn-danger" value="Delete">
        <a href="students?action=list">Quay lại</a>
    </form>
</div>
</body>
</html>
