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
    <h1 class="margin-auto">Welcome, ${sessionScope.user.username}!</h1>
    <img src="${sessionScope.user.imgURL}" class="rounded img-thumbnail float-start w-25 me-2" alt="user profile picture">
    <div class="card" style="width: 70%; height: 279px;">
        <div class="card-header">
            User Details
        </div>
        <div class="card-body">
            <h5 class="card-title">Bio & Contact Info</h5>
            <p class="card-text">
                <strong>Bio: </strong> Write a little about yourself here! :)<br>
                <strong>Email: </strong> ${sessionScope.user.email}<br>
            </p>
        </div>
    </div>
    <div class="mt-1">
        <a class="btn btn-primary" href="ads/create" style="color: white;">Create a listing</a>
        <a class="btn btn-primary" href="/edit_profile" style="color: white;">Edit Profile</a>
    </div>
    <h3 class="mt-3">Open Listings</h3>
    <div class="d-flex">
        <c:forEach var="ad" items="${ads}">
            <div class="card p-0 me-1 mt-1 mb-1" style="width: 18rem; height: 25rem;">
                <img src="${ad.imgURL}" class="card-img-top img-100" style="object-fit: fill; height: 17rem;" alt="${ad.title}">
                <div class="card-body bottom" style="height: 8rem;">
                    <h5 class="card-title">${ad.title}</h5>
                    <h6 class="card-subtitle mb-2 text-muted">$${ad.price}0</h6>
                    <a href="/product?id=${ad.id}" class="btn btn-primary">More Info</a>
                    <a href="/ads/edit?id=${ad.id}" class="btn btn-primary">Edit</a>

                </div>
            </div>
        </c:forEach>
    </div>
</div>

<jsp:include page="/WEB-INF/partials/footer.jsp"/>

</body>
</html>