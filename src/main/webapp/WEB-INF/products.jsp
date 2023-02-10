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
  <h1 id="product-title">Product Overview</h1>
  <p class="flex-column d-flex">
    <span id="seller">Default Content</span>
    <span id="price">Default Content</span>
    <span id="category">Default Content</span>
    <span id="description">Default Content</span>
    <span id="contact">Default Content</span>
  </p>
</div>

<jsp:include page="/WEB-INF/partials/footer.jsp"/>

</body>
</html>