<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Listing</title>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Edit Listing" />
    </jsp:include>
</head>
<body>
<h1>Edit Listing:</h1>

<form action="/ads/edit" method="POST">
    <div class="mb-3">
        <label for="title" class="form-label">Title: </label>
        <input type="text" class="form-control" name="title" id="title" aria-describedby="title" value="${ad.title}">
    </div>
    <div class="mb-3">
        <label for="description" class="form-label">Description: </label>
        <input type="text" class="form-control" name="description" id="description" value="${ad.description}">
    </div>
    <div class="mb-3">
        <label for="imgURL" class="form-label">Image URL: </label>
        <input type="text" class="form-control" name="imgURL" id="imgURL" value="${ad.imgURL}">
    </div>
    <div class="mb-3">
        <label for="price" class="form-label">Price: </label>
        <input type="text" class="form-control" name="price" id="price" value="${ad.price}">
    </div>
    <div class="d-none">
        <label for="price" class="form-label">id </label>
        <input type="text" name="id" value="${ad.id}">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
    <a href="/ads/delete?id=${ad.id}" class="btn btn-danger">Delete</a>

</form>

</body>
</html>