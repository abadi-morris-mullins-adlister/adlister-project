<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Edit Profile"/>
    </jsp:include>
</head>
<body>

<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<h1>Update Profile</h1>
<form action="/edit_profile?id=${user.id}" method="POST">
    <div class="input-group mb-3">
        <label>
            Username:
            <input type="text" class="form-control" name="username" value="${user.username}">
        </label>
    </div>
    <div class="input-group mb-3">
        <label>
            Email:
            <input type="text" name="email" class="form-control" value="${user.email}">
        </label>
    </div>
    <div class="input-group mb-3">
        <label>
            Profile Image URL:
            <input type="text" name="imgURL" class="form-control" value="${user.imgURL}">
        </label>
    </div>
    <input type="submit" value="Update">

</form>


<jsp:include page="/WEB-INF/partials/footer.jsp"/>

</body>
</html>