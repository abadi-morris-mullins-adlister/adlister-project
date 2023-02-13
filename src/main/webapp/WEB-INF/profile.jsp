<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <div class="container">
       <img src="${sessionScope.user.imgURL}" alt="test">
    </div>

<div>
    <div>
        <a class="btn btn-primary" href="ads/create" style="color: white;">Create a listing</a>
        <a class="btn btn-primary" href="/edit_profile" style="color: white;">Edit Profile</a>
    </div>
</div>

<div class="d-flex">
    <c:forEach var="ad" items="${ads}">
        <div class="card p-0" style="width: 18rem;">
            <img src="${ad.imgURL}" class="card-img-top" alt="${ad.title}">
            <div class="card-body">
                <h5 class="card-title">${ad.title}</h5>
                <p class="card-text">${ad.description}</p>
                <a href="/product?id=${ad.id}" class="btn btn-primary">More Info</a>
            </div>
        </div>
    </c:forEach>
</div>

<jsp:include page="/WEB-INF/partials/footer.jsp"/>

</body>
</html>
