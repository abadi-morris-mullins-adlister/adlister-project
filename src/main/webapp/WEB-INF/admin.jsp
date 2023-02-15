<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Admin Console"/>
    </jsp:include>
</head>
<body>

    <jsp:include page="/WEB-INF/partials/navbar.jsp"/>

    <div class="container">
        <h1>Users</h1>
        <div class="d-flex flex-wrap justify-content-center">
            <c:forEach var="user" items="${users}">
                <div class="card p-0 me-1 mt-1 mb-1" style="width: 18rem; height: 25rem;">
                    <img src="${user.imgURL}" class="card-img-top img-100" style="object-fit: fill; height: 17rem;" alt="${user.username}">
                    <div class="card-body bottom" style="height: 8rem;">
                        <h5 class="card-title">${user.username}</h5>
                        <h6 class="card-subtitle mb-2 text-muted">${user.email}</h6>
                        <a href="/edit_profile?id=${user.id}" class="btn btn-primary">Edit</a>
                        <a href="/delete_user?id=${user.id}" class="btn btn-danger">Delete</a>
                    </div>
                </div>
            </c:forEach>
        </div>
        <hr>
        <h1>Ads</h1>
        <div class="d-flex flex-wrap justify-content-center">
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