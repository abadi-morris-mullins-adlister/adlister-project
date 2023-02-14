<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Register For Our Site!" />
    </jsp:include>
</head>
<body>

<jsp:include page="partials/navbar.jsp" />

<div class="container">
    <h1>User Registration</h1><hr>
    <form action="/register" method="post" class="needs-validation" novalidate>
        <div class="form-group mt-2">
            <label for="username">Username</label>
            <input id="username" name="username" class="field form-control form-validation" type="text" required>
            <span class="small muted d-none" style="color: red;">Username taken, please choose another.</span>
            <div id="username-feedback" class="invalid-feedback">
                Username taken, please choose another.
            </div>
        </div>
        <div class="form-group mt-2">
            <label for="email">Email</label>
            <input id="email" name="email" class="field form-control" type="text" required>
            <div id="email-feedback" class="invalid-feedback">
                Enter a valid email address.
            </div>
        </div>
        <div class="form-group mt-2">
            <label for="password">Password</label>
            <input id="password" name="password" class="field form-control" type="password" required>
        </div>
        <div class="form-group mt-2">
            <label for="confirm_password">Confirm Password</label>
            <input id="confirm_password" name="confirm_password" class="form-control" type="password" required>
            <div id="password-feedback" class="invalid-feedback">
                Passwords do not match, please try again.
            </div>
        </div>
        <input type="submit" id="submit" class="btn btn-primary btn-block mt-2">
    </form>
</div>

<script>
    (() => {
        'use strict'
        // Bootstrap Form Validation
        const forms = document.querySelectorAll('.needs-validation')
        Array.from(forms).forEach(form => {
            form.addEventListener('submit', event => {
                if (!form.checkValidity()) {
                    event.preventDefault()
                    event.stopPropagation()
                }

                form.classList.add('was-validated')
            }, false)
        })
        // Username Validation
        // Password Validation
        let password = document.getElementById("password")
            , confirm_password = document.getElementById("confirm_password");
        function validatePassword(){
            if(password.value != confirm_password.value) {
                confirm_password.setCustomValidity("Passwords Don't Match");
            } else {
                confirm_password.setCustomValidity('');
            }
        }
        password.onchange = validatePassword;
        confirm_password.onkeyup = validatePassword;
    })()
</script>

<jsp:include page="/WEB-INF/partials/footer.jsp" />

</body>
</html>