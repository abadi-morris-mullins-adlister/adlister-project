<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Product Page"/>
    </jsp:include>
</head>
<body>

<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="container">
    <h1>${ad.title}</h1>

    <img src="${ad.imgURL}" class="rounded img-thumbnail float-start w-25 me-2" alt="${ad.title}">
    <div class="card" style="width: 70%;">
        <div class="card-header">
            Product Details
        </div>
        <div class="card-body">
            <p><strong>Title: </strong><span id="product-title">${ad.title}</span></p>
            <p><strong>Date Listed: </strong><span id="date-created">${ad.date_created}</span></p>
            <p><strong>Price: </strong><span id="price">$${ad.price}0</span></p>
            <p><strong>Description: </strong><span id="description">${ad.description}</span></p>
            <p><strong>Category:</strong><span id="category">
            <c:forEach var="category" items="${categories}">
                ${category}
            </c:forEach>
            </span></p>
        </div>
        <div class="card-header" style="border-top: 1px solid lightgrey;">
            Purchase Info
        </div>
        <div class="card-body">
            <p><strong>Seller: </strong><span id="seller">${user.getUsername()}</span></p>
            <p><strong>Contact Info: </strong><span id="contact">${user.getEmail()}</span></p>
        </div>
    </div>

</div>

<jsp:include page="/WEB-INF/partials/footer.jsp"/>

</body>
</html>