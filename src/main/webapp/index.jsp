<%@include file="taglib.jsp" %>
<html>
<%@include file="head.jsp"%>
<body>
<div class="container-md">
    <h2>Artist Location</h2>
    <p> Add location data to your favorite artists on Spotify </p>
    <p> Use our Rest API to get artist location data </p>


    <form class="form" id="confirmId" action="confirm-artist" method="get">
        <input class="form-control" id="spotifyId" placeholder="Spotify Artist Id" >
        <input class="btn btn-primary" type="submit" value="confirm artist" >
    </form>

    <div>
        <h3>How do I find the artist id?</h3>
        <p>We use the Spotify artist id to ensure we have the correct artist. (Did you mean "Dearhunter" or "The Dear Hunter"?) Luckily, finding the artist id is easy! Simply copy and paste the string following 'artist' on any artist's profile page.</p>
        <img src="images/artistIdExample.png" alt="example highlighting the artist id in a spotify url">
    </div>

</div>

<script>document.title = "Artist Location"</script>
</body>
</html>
