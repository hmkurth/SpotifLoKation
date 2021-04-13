# Spotiflokation Api

All URIs are relative to *http://18.223.165.204:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**shkTeamProjectServiceAllGet**](spotiflokationApi.md#shkTeamProjectServiceAllGet) | **GET** /shk-team-project/service/all | This method will return all of the artists and their locations from our database. This service call will return a JSON array containing the aritsts spotify Id, name, and, if locations are found for the artist, the country, region, and city.|
[**shkTeamProjectServiceLocationsSpotifyArtistIdGet**](spotiflokationApi.md#shkTeamProjectServiceLocationsSpotifyArtistIdGet) | **GET** /shk-team-project/service/locations/{spotifyArtistId} | A user must find the artistist's spotify id, and append it on the path /shk-team-project/service/locations/ . The service will verify that the id exists through the spotify api, and if so, return a json array with the location id, the country, the region, and the city.|


<a name="shkTeamProjectServiceAllGet"></a>
# **shkTeamProjectServiceAllGet**
> String shkTeamProjectServiceAllGet()



This method will return all of the artists and their locations from our database

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
try {
    String result = apiInstance.shkTeamProjectServiceAllGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#shkTeamProjectServiceAllGet");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: json/application data

<a name="shkTeamProjectServiceLocationsSpotifyArtistIdGet"></a>
# **shkTeamProjectServiceLocationsSpotifyArtistIdGet**
> InlineResponse200 shkTeamProjectServiceLocationsSpotifyArtistIdGet(spotifyArtistId)



This method will return the location data for a selected spotify artist id

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String spotifyArtistId = "spotifyArtistId_example"; // String | the spotify artist id
try {
    InlineResponse200 result = apiInstance.shkTeamProjectServiceLocationsSpotifyArtistIdGet(spotifyArtistId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#shkTeamProjectServiceLocationsSpotifyArtistIdGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **spotifyArtistId** | **String**| the spotify artist id |

### Return type

[**InlineResponse200**](InlineResponse200.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: json/application data, text/html;charset=utf-8

