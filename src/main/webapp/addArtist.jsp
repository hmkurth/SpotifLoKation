<!-- add artist-->
<%@include file="taglib.jsp" %>
<section class="about-section text-center" id="addArtist">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 mx-auto">
                <h2 class="text-white mb-4">Add the location of your favorite artists!</h2>
                <h3 class="text-white mb-4">How do I find the artist id?</h3>
                <p class="text-white-50">
                   We use the Spotify artist id to ensure we have the correct artist. (Did you mean "Dearhunter" or "The Dear Hunter"?) Luckily, finding the artist id is easy! Simply copy and paste the string following 'artist' on any artist's profile page.</p>
                <img src="assets/img/artistIdExample.png" alt="example highlighting the artist id in a spotify url">
                </p>
                <form class="form" id="confirmId" action="confirm-artist" method="get">
                    <label for="spotifyId">
                    <input class="form-control" id="spotifyId" placeholder="Spotify Artist Id" >
                    </label>

                    <input class="btn btn-primary" type="submit" value="confirm artist" >
                </form>

            </div>
        </div>
        <img class="img-fluid" src="assets/img/ipad.png" alt="" />
    </div>
</section>