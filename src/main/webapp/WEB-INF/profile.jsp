<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="container">
    <h1>Welcome, ${sessionScope.user.username}!</h1>
</div>

<%--    <div class="container">--%>
<%--       <img src="${sessionScope.user.imgURL}" alt="test">--%>
<%--    </div>--%>

<div>
    <div>
        <a class="btn btn-primary" href="ads/create" style="color: white;">Create a listing</a>
        <a class="btn btn-primary" href="/edit_profile" style="color: white;">Edit Profile</a>
    </div>
</div>


<jsp:include page="/WEB-INF/partials/footer.jsp"/>

</body>
</html>
