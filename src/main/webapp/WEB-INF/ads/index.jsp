<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">

    <h1>Here are all the ads!</h1>

    <div class="row justify-content-evenly">
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

</div>

<jsp:include page="/WEB-INF/partials/footer.jsp" />

</body>
</html>