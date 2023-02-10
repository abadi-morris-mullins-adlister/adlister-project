<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid align-items-center">
        <a class="navbar-brand" href="/">Adlister</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav md-lg-0">
                <li class="nav-item"><a class="nav-link" href="ads">Browse All</a></li>
                <li class="nav-item"><a class="nav-link" href="${sessionScope.user == null ? "login" : "ads/create"}">Create a Listing</a></li>
            </ul>
            <div class="navbar-nav ms-auto me-auto align-items-center">
                <form method="POST" action="/search" class="d-flex mb-0" role="search">
                    <input class="form-control me-2" name="searchTerm" type="search" placeholder="Search..." aria-label="Search" style="width: 500px;">
                    <button class="btn btn-primary" type="submit"><i class="bi bi-search"></i></button>
                </form>
            </div>
            <ul class="navbar-nav justify-content-end ms-5 md-lg-0">
                <li class="nav-item"><a class="nav-link btn btn-primary" style="color: white;" href="${sessionScope.user == null ? "login" : "logout"}">${sessionScope.user == null ? "Log In" : "Log Out"}</a></li>
            </ul>
        </div>
    </div>
</nav>