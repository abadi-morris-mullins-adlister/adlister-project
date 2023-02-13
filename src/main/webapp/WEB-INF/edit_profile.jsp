<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Profile</title>
</head>
<body>
<h1>Update Profile</h1>
<form action="/edit_profile" method="POST">
    <table>
        <tr>
            <td>Username:</td>
            <td><input type="text" name="username" value="${sessionScope.user.username}" /></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="text" name="email" value="${sessionScope.user.email}"  /></td>
        </tr>
        <tr>
            <td>Profile Image URL:</td>
            <td><input type="text" name="imgURL" value="${sessionScope.user.imgURL}" /></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Update" /></td>
        </tr>
    </table>
</form>
</body>
</html>