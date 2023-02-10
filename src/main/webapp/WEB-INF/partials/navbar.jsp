<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/">Adlister</a>
        </div>
        <ul class="nav navbar-nav navbar-left">
            <li><a href="ads">Browse All</a></li>
            <li><a href="${sessionScope.user == null ? "login" : "ads/create"}">Create a Listing</a></li>
        </ul>
        <form class="navbar-form navbar-left">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Search">
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
        </form>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="${sessionScope.user == null ? "login" : "logout"}">${sessionScope.user == null ? "Log In" : "Log Out"}</a></li>
        </ul>
    </div><!-- /.navbar-collapse -->
</nav>