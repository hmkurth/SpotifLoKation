<%@ page import="com.shk.entity.Artist" %>
<%@include file="taglib.jsp" %>
<html>
<%@include file="head.jsp"%>
<body>
<div class="container-md">

    <h2>${message}</h2>

    <h3>${artist.artist_name}</h3>
    <h4>${artist.id}</h4>

    <form class="form" id="removeLocationForm" action="remove-location" method="post">

        <c:if test="${fn:length(artist.locations) > 0}">
        <h4>Locations</h4>
         <c:forEach var="location" items="${artist.locations}">
             <input type="radio" id="${location.id}" name="location" value="${location.id}">
             <label for="${location.id}"><h5>${location.country}, ${location.region}, ${location.city} </h5></label>
         </c:forEach>
        <input type="hidden" name="artistId" value="${artist.id}">
        <input type="submit" value="remove location" name="removeLocation">
        </c:if>

    </form>

    <form class="form" id="addLocationForm" action="add-location" method="post">
        <h4>Add new Location</h4>
        <input type="text" placeholder="Country" name="country">
        <input type="text" placeholder="State/ Providence" name="region">
        <input type="text" placeholder="City" name="city">
        <input type="hidden" name="artistId" value="${artist.id}">
        <input type="submit" value="add location" name="addLocation">
    </form>


</div>

<script>document.title = "Edit"</script>
</body>
</html>

