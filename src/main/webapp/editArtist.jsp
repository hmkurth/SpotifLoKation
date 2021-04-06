<%@ page import="com.shk.entity.Artist" %>
<%@include file="taglib.jsp" %>
<html>
<%@include file="head.jsp"%>
<body>
<div class="container-md">

    <h2>This you? </h2>


    <h3>${artist.artist_name}</h3>
    <h4>${artist.id}</h4>

    <c:forEach var="location" items="${artist.locations}">
        <h4>${location.country}, ${location.region}, ${location.city}</h4>
    </c:forEach>

    <p>${message}</p>

</div>

<script>document.title = "Edit"</script>
</body>
</html>

