<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="User Log In" />
    </jsp:include>
</head>
<body>

    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1>User Log In</h1><hr>
        <form action="/login" method="POST">
            <div class="form-group mt-2">
                <label for="username">Username</label>
                <input id="username" name="username" class="form-control" type="text">
            </div>
            <div class="form-group mt-2">
                <label for="password">Password</label>
                <input id="password" name="password" class="form-control" type="password">
            </div>
            <input type="submit" class="btn btn-primary btn-block mt-2" value="Log In">
        </form>
        <form action="/register" method="GET">
            <h5>Don't have an account yet?</h5>
            <input type="submit" class="btn btn-primary btn-block" value="Register">
        </form>
    </div>

    <jsp:include page="/WEB-INF/partials/footer.jsp" />

</body>
</html>