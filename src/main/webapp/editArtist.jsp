<%@include file="taglib.jsp" %>
<%@ page import="com.shk.entity.Artist" %>


<%@include file="head.jsp"%>
<%@include file="nav.jsp"%>

<section class="projects-section bg-light" id="editArtist">
    <div class="container">
        <!-- Featured Project Row-->
        <div class="row align-items-center no-gutters mb-4 mb-lg-5">
            <div class="col-xl-6 col-lg-6"><img class="img-fluid " src="assets/img/black-and-white-music-headphones-life.jpg" alt="black and white photo of headphones" /></div>
            <div class="col-xl-6 col-lg-6">
                <div class="featured-text text-center text-lg-left">
                    <c:if test="${isFound == 'true'}">
                        <h3>${artist.artist_name}</h3>
                        <p>${artist.id}</p>

                        <c:if test="${fn:length(artist.locations) > 0}">
                            <form class="form" id="removeLocationForm" action="remove-location" method="post">

                                <h4>Locations</h4>
                                <ul style="list-style-type:none;">
                                <c:forEach var="location" items="${artist.locations}">
                                    <li>
                                      <input type="radio" id="${location.id}" name="location" value="${location.id}">
                                      <label for="${location.id}"><h5>${location.country}, ${location.region}, ${location.city} </h5></label>
                                    </li>
                                </c:forEach>
                                </ul>
                            <input type="hidden" name="artistId" value="${artist.id}">
                            <!--
                            <input type="submit" value="remove location" name="removeLocation">
                            -->
                            <button type="button" onclick="confirmDelete()">Remove Location</button>
                            </form>
                         </c:if>

                        <form class="form" id="addLocationForm" action="add-location" method="post">
                            <h4>Add new Location</h4>
                            <input type="text" placeholder="Country" name="country">
                            <input type="text" placeholder="State/ Providence" name="region">
                            <input type="text" placeholder="City" name="city">
                            <input type="hidden" name="artistId" value="${artist.id}">
                            <input type="submit" value="add location" name="addLocation">
                        </form>
                    </c:if>

                    <c:if test="${isFound == 'false'}">
                        <h2>I'm sorry we could not locate that artist</h2>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</section>
<script>document.title = "Edit"</script>
<script>
    const confirmDelete = () => {
        let confirmation = confirm("Are you sure you want to delete this location?");
        if (confirmation) {
            document.forms["removeLocationForm"].submit();
        }
    }
</script>
<%@include file="footer.jsp"%>