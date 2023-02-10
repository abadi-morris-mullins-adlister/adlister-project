<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="ads">Adlister</a>
        </div>
        <ul class="nav navbar-nav navbar-left">
            <li><a href="ads">Browse All</a></li>
            <li><a href="${sessionScope.user == null ? "login" : "ads/create"}">Create a Listing</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="${sessionScope.user == null ? "login" : "logout"}">${sessionScope.user == null ? "Log In" : "Log Out"}</a></li>
        </ul>
    </div><!-- /.navbar-collapse -->
</nav>