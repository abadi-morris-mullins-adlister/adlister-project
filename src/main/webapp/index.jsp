<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="CodysList" />
    </jsp:include>

</head>
<body>

    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1 class="text-center my-5">CodysList</h1>
        <div class="row">
            <div class="col-md-4">
                <h2>For Sale</h2>
                <ul class="list-unstyled">
                    <li><a href="/ads/browse?category=1"> Antiques</a></li>
                    <li><a href="/ads/browse?category=2"> Appliances</a></li>
                    <li><a href="/ads/browse?category=4"> ATV, UTV, SNOv</a></li>
                    <li><a href="/ads/browse?category=5"> Auto Parts</a></li>
                    <li><a href="/ads/browse?category=6"> Aviation</a></li>
                    <li><a href="/ads/browse?category=7"> Baby &amp; Children</a></li>
                    <li><a href="/ads/browse?category=8"> Barter</a></li>
                    <li><a href="/ads/browse?category=9"> Beauty &amp; Health</a></li>
                    <li><a href="/ads/browse?category=10"> Bicycles</a></li>
                    <li><a href="/ads/browse?category=11"> Boats</a></li>
                    <li><a href="/ads/browse?category=12"> Books</a></li>
                    <li><a href="/ads/browse?category=13"> Business</a></li>
                    <li><a href="/ads/browse?category=14"> Vehicles</a></li>
                    <li><a href="/ads/browse?category=15"> CDs, DVDs, VHS</a></li>
                </ul>
            </div>
            <div class="col-md-4">
                <h2>Services</h2>
                <ul class="list-unstyled">
                    <li><a href="/ads/browse?category=16"> Cellphones</a></li>
                    <li><a href="/ads/browse?category=17"> Clothing</a></li>
                    <li><a href="/ads/browse?category=18"> Collectables</a></li>
                    <li><a href="/ads/browse?category=19"> Computers</a></li>
                    <li><a href="/ads/browse?category=20"> Electronics</a></li>
                    <li><a href="/ads/browse?category=21"> Farm &amp; Garden</a></li>
                    <li><a href="/ads/browse?category=22"> Free Stuff</a></li>
                    <li><a href="/ads/browse?category=23"> Furniture</a></li>
                    <li><a href="/ads/browse?category=24"> Garage Sales</a></li>
                    <li><a href="/ads/browse?category=25"> General</a></li>
                    <li><a href="/ads/browse?category=26"> Heavy Equipment</a></li>
                    <li><a href="/ads/browse?category=27"> Household Items</a></li>
                </ul>
            </div>
            <div class="col-md-4">
                <h2>Community</h2>
                <ul class="list-unstyled">
                    <li><a href="/ads/browse?category=28"> Jewelry</a></li>
                    <li><a href="/ads/browse?category=29"> Materials</a></li>
                    <li><a href="/ads/browse?category=30"> Motorcycles</a></li>
                    <li><a href="/ads/browse?category=31"> Musical Instruments</a></li>
                    <li><a href="/ads/browse?category=32"> Photo &amp; Video</a></li>
                    <li><a href="/ads/browse?category=33"> RVs &amp; Campers</a></li>
                    <li><a href="/ads/browse?category=34"> Sporting Goods</a></li>
                    <li><a href="/ads/browse?category=35"> Tickets</a></li>
                    <li><a href="/ads/browse?category=36"> Tools</a></li>
                    <li><a href="/ads/browse?category=37"> Toys &amp; Games</a></li>
                    <li><a href="/ads/browse?category=39"> Video Gaming</a></li>
                    <li><a href="/ads/browse?category=40"> Wanted</a></li>
                    <li><a href="/ads/browse?category=41"> Wheels</a></li>
                </ul>
            </div>
        </div>
    </div>

    <jsp:include page="/WEB-INF/partials/footer.jsp" />

</body>
</html>
