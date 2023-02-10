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

<div class="row flex-column">
    <h1 class="text-center">Showing search results for ${param.searchTerm} (${searchResult})</h1>

    <c:forEach var="ad" items="${ads}">
        <div class="col-4 d-flex flex-column">
            <h2>${ad.title}</h2>
            <p>${ad.description}</p>
        </div>
    </c:forEach>
</div>






<jsp:include page="/WEB-INF/partials/footer.jsp" />

</body>
</html>
