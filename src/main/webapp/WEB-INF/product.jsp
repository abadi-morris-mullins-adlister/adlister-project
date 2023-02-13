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

    <div class="container m-2">
        <h1>${ad.title}</h1>

        <img src="${ad.imgURL}" class="rounded float-start img-thumbnail me-3 w-50" alt="${ad.title}">

        <div>
            <h3>Product Overview</h3>
            <p>Title: <span id="product-title">${ad.title}</span></p>
            <p>Date Listed: <span id="date-created">${ad.date_created}</span></p>
            <p>Price: <span id="price">$${ad.price}0</span></p>
            <p>Description: <span id="description">${ad.description}</span></p>
        </div>
        <div class="mt-3">
            <h3>Interested?</h3>
            <p>Seller: <span id="seller">${user.getUsername()}</span></p>
            <p>Contact Info: <span id="contact">${user.getEmail()}</span></p>
        </div>
    </div>

    <jsp:include page="/WEB-INF/partials/footer.jsp"/>

</body>
</html>