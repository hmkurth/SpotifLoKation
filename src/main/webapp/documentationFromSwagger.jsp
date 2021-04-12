
<!doctype html>
<html>
<head>
    <title>SpotIfLoKation API Documentation</title>
    <style type="text/css">
        body {
            font-family: Trebuchet MS, sans-serif;
            font-size: 15px;
            color: #444;
            margin-right: 24px;
        }

        h1	{
            font-size: 25px;
        }
        h2	{
            font-size: 20px;
        }
        h3	{
            font-size: 16px;
            font-weight: bold;
        }
        hr	{
            height: 1px;
            border: 0;
            color: #ddd;
            background-color: #ddd;
        }

        .app-desc {
            clear: both;
            margin-left: 20px;
        }
        .param-name {
            width: 100%;
        }
        .license-info {
            margin-left: 20px;
        }

        .license-url {
            margin-left: 20px;
        }

        .model {
            margin: 0 0 0px 20px;
        }

        .method {
            margin-left: 20px;
        }

        .method-notes	{
            margin: 10px 0 20px 0;
            font-size: 90%;
            color: #555;
        }

        pre {
            padding: 10px;
            margin-bottom: 2px;
        }

        .http-method {
            text-transform: uppercase;
        }

        pre.get {
            background-color: #0f6ab4;
        }

        pre.post {
            background-color: #10a54a;
        }

        pre.put {
            background-color: #c5862b;
        }

        pre.delete {
            background-color: #a41e22;
        }

        .huge	{
            color: #fff;
        }

        pre.example {
            background-color: #f3f3f3;
            padding: 10px;
            border: 1px solid #ddd;
        }

        code {
            white-space: pre;
        }

        .nickname {
            font-weight: bold;
        }

        .method-path {
            font-size: 1.5em;
            background-color: #0f6ab4;
        }

        .up {
            float:right;
        }

        .parameter {
            width: 500px;
        }

        .param {
            width: 500px;
            padding: 10px 0 0 20px;
            font-weight: bold;
        }

        .param-desc {
            width: 700px;
            padding: 0 0 0 20px;
            color: #777;
        }

        .param-type {
            font-style: italic;
        }

        .param-enum-header {
            width: 700px;
            padding: 0 0 0 60px;
            color: #777;
            font-weight: bold;
        }

        .param-enum {
            width: 700px;
            padding: 0 0 0 80px;
            color: #777;
            font-style: italic;
        }

        .field-label {
            padding: 0;
            margin: 0;
            clear: both;
        }

        .field-items	{
            padding: 0 0 15px 0;
            margin-bottom: 15px;
        }

        .return-type {
            clear: both;
            padding-bottom: 10px;
        }

        .param-header {
            font-weight: bold;
        }

        .method-tags {
            text-align: right;
        }

        .method-tag {
            background: none repeat scroll 0% 0% #24A600;
            border-radius: 3px;
            padding: 2px 10px;
            margin: 2px;
            color: #FFF;
            display: inline-block;
            text-decoration: none;
        }
    </style>
</head>
<body>
<h1>SpotIfLoKation API Documentation</h1>
<div class="app-desc">The goal is to associate Spotify artists with a geolocation. The current Spotify API does not provide the location for their artist data. This application seeks to crowdsource this information and provide an API service for artist location information.</div>
<div class="app-desc">More information: <a href="https://helloreverb.com">https://helloreverb.com</a></div>
<div class="app-desc">Contact Info: <a href="hmkurth@madisoncollege.edu">hmkurth@madisoncollege.edu</a></div>
<div class="app-desc">Version: 0.1</div>

<div class="license-info">All rights reserved</div>
<div class="license-url">http://apache.org/licenses/LICENSE-2.0.html</div>
<h2>Access</h2>

<h2><a name="__Methods">Methods</a></h2>
[ Jump to <a href="#__Models">Models</a> ]

<h3>Table of Contents </h3>
<div class="method-summary"></div>
<h4><a href="#Default">Default</a></h4>
<ul>
    <li><a href="#shkTeamProjectServiceAllGet"><code><span class="http-method">get</span> /shk-team-project/service/all</code></a></li>
    <li><a href="#shkTeamProjectServiceLocationsGet"><code><span class="http-method">get</span> /shk-team-project/service/locations/</code></a></li>
</ul>

<h1><a name="Default">Default</a></h1>
<div class="method"><a name="shkTeamProjectServiceAllGet"></a>
    <div class="method-path">
        <a class="up" href="#__Methods">Up</a>
        <pre class="get"><code class="huge"><span class="http-method">get</span> /shk-team-project/service/all</code></pre></div>
    <div class="method-summary"> (<span class="nickname">shkTeamProjectServiceAllGet</span>)</div>
    <div class="method-notes">This method will return all of the artists and their locations from our database</div>







    <h3 class="field-label">Return type</h3>
    <div class="return-type">

        String
    </div>

    <!--Todo: process Response Object and its headers, schema, examples -->

    <h3 class="field-label">Example data</h3>
    <div class="example-data-content-type">Content-Type: application/json</div>
    <pre class="example"><code>""</code></pre>

    <h3 class="field-label">Produces</h3>
    This API call produces the following media types according to the <span class="header">Accept</span> request header;
    the media type will be conveyed by the <span class="header">Content-Type</span> response header.
    <ul>
        <li><code>json/application data</code></li>
    </ul>

    <h3 class="field-label">Responses</h3>
    <h4 class="field-label">200</h4>
    Everything looks good, here are your results!
    <a href="#String">String</a>
    <h3 class="field-label">Example data</h3>
    <div class="example-data-content-type">Content-Type: 0</div>
    <pre class="example"><code>[{&quot;id&quot;:&quot;1f0MVS6tmwuV6j1uwbriC9&quot;,&quot;artist_name&quot;:&quot;Heavy Looks&quot;},{&quot;id&quot;:&quot;3KDhIfgNvDwSVflsZR42jD&quot;,&quot;artist_name&quot;:&quot;Holly and the Nice Lions&quot;},{&quot;id&quot;:&quot;5L3STwlqP4cN3E9rMWES48&quot;,&quot;artist_name&quot;:&quot;Good Grief&quot;},{&quot;id&quot;:&quot;74ASZWbe4lXaubB36ztrGX&quot;,&quot;artist_name&quot;:&quot;Bob Dylan&quot;}][{&quot;id&quot;:1,&quot;country&quot;:&quot;US&quot;,&quot;region&quot;:&quot;WI&quot;,&quot;city&quot;:&quot;Madison&quot;},{&quot;id&quot;:2,&quot;country&quot;:&quot;US&quot;,&quot;region&quot;:&quot;WI&quot;,&quot;city&quot;:&quot;Stevens Point&quot;},{&quot;id&quot;:3,&quot;country&quot;:&quot;US&quot;,&quot;region&quot;:&quot;WI&quot;,&quot;city&quot;:&quot;Green Bay&quot;},{&quot;id&quot;:4,&quot;country&quot;:&quot;United States&quot;,&quot;region&quot;:&quot;Wisconsin&quot;,&quot;city&quot;:&quot;MADISON&quot;}]</code></pre>
</div> <!-- method -->
<hr/>
<div class="method"><a name="shkTeamProjectServiceLocationsGet"></a>
    <div class="method-path">
        <a class="up" href="#__Methods">Up</a>
        <pre class="get"><code class="huge"><span class="http-method">get</span> /shk-team-project/service/locations/</code></pre></div>
    <div class="method-summary"> (<span class="nickname">shkTeamProjectServiceLocationsGet</span>)</div>
    <div class="method-notes">This method will return the location data for a selected spotify artist id</div>





    <h3 class="field-label">Query parameters</h3>
    <div class="field-items">
        <div class="param">spotifyArtistId (optional)</div>

        <div class="param-desc"><span class="param-type">Query Parameter</span> &mdash;  </div>    </div>  <!-- field-items -->



    <!--Todo: process Response Object and its headers, schema, examples -->


    <h3 class="field-label">Produces</h3>
    This API call produces the following media types according to the <span class="header">Accept</span> request header;
    the media type will be conveyed by the <span class="header">Content-Type</span> response header.
    <ul>
        <li><code>text/html;charset=utf-8</code></li>
    </ul>

    <h3 class="field-label">Responses</h3>
    <h4 class="field-label">404</h4>
    Auto generated using Swagger Inspector
    <a href="#String">String</a>
</div> <!-- method -->
<hr/>

<h2><a name="__Models">Models</a></h2>
[ Jump to <a href="#__Methods">Methods</a> ]

<h3>Table of Contents</h3>
<ol>
</ol>

</body>
</html>
