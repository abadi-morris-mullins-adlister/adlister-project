
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
    <h1 class="text-center">Showing search results for ${param.searchTerm} (${searchResult})</h1>

    <div class="row">
        <c:forEach var="ad" items="${ads}">
            <div class="card p-0 m-1" style="width: 18rem; height: 25rem;">
                <img src="${ad.imgURL}" class="card-img-top img-100" style="object-fit: fill; height: 17rem;" alt="${ad.title}">
                <div class="card-body bottom" style="height: 8rem; border-top: 1px solid lightgrey;">
                    <h5 class="card-title">${ad.title}</h5>
                    <h6 class="card-subtitle mb-2 text-muted">$${ad.price}0</h6>
                    <a href="/product?id=${ad.id}" class="btn btn-primary">More Info</a>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<jsp:include page="/WEB-INF/partials/footer.jsp" />

</body>
</html>