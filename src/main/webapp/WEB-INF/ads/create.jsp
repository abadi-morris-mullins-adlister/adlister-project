<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="container">
    <h1>Create a new Ad</h1>
    <form action="/ads/create" method="post">
        <div class="form-group">
            <label for="title">Title</label>
            <input id="title" name="title" class="form-control" type="text" required>
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea id="description" name="description" class="form-control" type="text" required></textarea>
        </div>
        <div class="form-group">
            <label for="imgURL">Image URL</label>
            <input id="imgURL" name="imgURL" class="form-control" type="text" required>
        </div>
        <div class="form-group">
            <label for="price">Price</label>
            <input id="price" name="price" class="form-control" type="text" required>
        </div>
        <div class="d-flex justify-content-between">
            <div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="1" id="antique">
                    <label class="form-check-label" for="antique">
                        Antiques
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="3" id="arts-crafts">
                    <label class="form-check-label" for="arts-crafts">
                        Arts-Crafts
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="4" id="atv-utv-sno">
                    <label class="form-check-label" for="atv-utv-sno">
                        ATV-UTV-SNO
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="5" id="autoparts">
                    <label class="form-check-label" for="autoparts">
                        Auto Parts
                    </label>
                </div>

                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="6" id="aviation">
                    <label class="form-check-label" for="aviation">
                        Aviaton
                    </label>
                </div>
            </div>
            <div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="7" id="baby-kid">
                    <label class="form-check-label" for="baby-kid">
                        Baby/Kid
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="8" id="barter">
                    <label class="form-check-label" for="barter">
                        Barter
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="9" id="beauty-health">
                    <label class="form-check-label" for="beauty-health">
                        Beauty/Health
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="10" id="bikes">
                    <label class="form-check-label" for="bikes">
                        Bikes
                    </label>
                </div>

                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="11" id="boats">
                    <label class="form-check-label" for="boats">
                        Boats
                    </label>
                </div>
            </div>
            <div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="12" id="books">
                    <label class="form-check-label" for="books">
                        Books
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="13" id="business">
                    <label class="form-check-label" for="business">
                        Business
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="14" id="vehicles">
                    <label class="form-check-label" for="vehicles">
                        Vehicles
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="15" id="cds-dvd-vhs">
                    <label class="form-check-label" for="cds-dvd-vhs">
                        Cds-DvD-VHS
                    </label>
                </div>

                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="16" id="cellphones">
                    <label class="form-check-label" for="cellphones">
                        Cellphones
                    </label>
                </div>
            </div>
            <div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="17" id="clothes">
                    <label class="form-check-label" for="clothes">
                        Clothes
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="18" id="collectables">
                    <label class="form-check-label" for="collectables">
                        Collectables
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="19" id="computers">
                    <label class="form-check-label" for="computers">
                        Computers
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="20" id="electronics">
                    <label class="form-check-label" for="electronics">
                        Electronics
                    </label>
                </div>
                4:05

                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="21" id="farm-garden">
                    <label class="form-check-label" for="farm-garden">
                        Farm/Garden
                    </label>
                </div>
            </div>
            <div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="22" id="free">
                    <label class="form-check-label" for="free">
                        Free
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="23" id="furniture">
                    <label class="form-check-label" for="furniture">
                        Furniture
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="24" id="garage-sale">
                    <label class="form-check-label" for="garage-sale">
                        Garage Sale
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="25" id="general">
                    <label class="form-check-label" for="general">
                        General
                    </label>
                </div>

                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="26" id="heavy-equip">
                    <label class="form-check-label" for="heavy-equip">
                        Heavy Equipment
                    </label>
                </div>
            </div>
            <div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="27" id="household">
                    <label class="form-check-label" for="household">
                        Household
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="28" id="jewelry">
                    <label class="form-check-label" for="jewelry">
                        Jewelry
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="29" id="materials">
                    <label class="form-check-label" for="materials">
                        Materials
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="30" id="motorcycles">
                    <label class="form-check-label" for="motorcycles">
                        Motorcycles
                    </label>
                </div>

                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="31" id="music instr">
                    <label class="form-check-label" for="music instr">
                        Musical Instrument
                    </label>
                </div>
            </div>
            <div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="32" id="photo-video">
                    <label class="form-check-label" for="photo-video">
                        Photo/Video
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="33" id="rvs-camp">
                    <label class="form-check-label" for="rvs-camp">
                        RVs/Camper
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="34" id="sporting">
                    <label class="form-check-label" for="sporting">
                        Sporting
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="35" id="tickets">
                    <label class="form-check-label" for="tickets">
                        Tickets
                    </label>
                </div>

                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="36" id="tools">
                    <label class="form-check-label" for="tools">
                        Tools
                    </label>
                </div>
            </div>
            <div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="37" id="toys-games">
                    <label class="form-check-label" for="toys-games">
                        Toys/Games
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="38" id="trailers">
                    <label class="form-check-label" for="trailers">
                        Trailers
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="39" id="video-gaming">
                    <label class="form-check-label" for="video-gaming">
                        Video Gaming
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="40" id="wanted">
                    <label class="form-check-label" for="wanted">
                        Wanted
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="41" id="wheels">
                    <label class="form-check-label" for="wheels">
                        Wheels
                    </label>
                </div>
            </div>
        </div>
        <input type="submit" class="btn btn-block btn-primary">
    </form>
</div>


<jsp:include page="/WEB-INF/partials/footer.jsp"/>

</body>
</html>









