<%@include file="taglib.jsp" %>
<%@ page import="com.shk.entity.Artist" %>


<%@include file="head.jsp"%>
<%@include file="nav.jsp"%>

<section class="projects-section bg-dark" id="editArtist">
    <div class="container">
        <!-- Featured Project Row-->
        <div class="row align-items-center no-gutters mb-4 mb-lg-5">
            <div class="col-xl-6 col-lg-6"><img class="img-fluid " src="assets/img/black-and-white-music-headphones-life.jpg" alt="black and white photo of headphones" /></div>
            <div class="col-xl-6 col-lg-6">
                <div class="featured-text text-center text-lg-left">
                    <h4 class="text-white">${message}</h4>
                    <h3 class="text-white">Artist Name: ${artist.artist_name}</h3>
                    <h4 class="text-white">Artist Id: ${artist.id}</h4>
                    <p class="text-white-50 mb-0">If there are already locations found for this artist, they will appear here. Please be careful before deleting known locations.</p>
                    <h4 class="text-white">Locations</h4>
                    <form class="form" id="removeLocationForm" action="remove-location" method="post">
                         <c:forEach var="location" items="${artist.locations}">
                             <input type="radio" id="${location.id}" name="location" value="${location.id}">
                             <label for="${location.id}"><h5>${location.country}, ${location.region}, ${location.city} </h5></label>
                             </c:forEach>

                             <input class="form-control"type="hidden" name="artistId" value="${artist.id}">
                                <input class="form-control"type="submit" value="remove location" name="removeLocation">
                    </form>
                    <p class="text-white-50 mb-0">Add a new location for this artist here.</p>
    <form class="form" id="addLocationForm" action="add-location" method="post">
        <h4 class="text-white">Add new Location</h4>
        <input class="form-control" type="text" placeholder="Country" name="country">
        <input class="form-control" type="text" placeholder="State/ Providence" name="region">
        <input class="form-control" type="text" placeholder="City" name="city">
        <input class="form-control" type="hidden" name="artistId" value="${artist.id}">
        <input class="" type="submit" value="add location" name="addLocation">
    </form>

                </div>
            </div>
        </div>

<script>document.title = "Edit"</script>
<%@include file="footer.jsp"%>