

var latitude =$(".latitude").text();
var longitude = $(".longitude").text();


function initialize()
{
   alert(latitude, longitude );
    var myLatLng = new google.maps.LatLng(latitude,longitude);
    var map = new google.maps.Map(document.getElementById("map-canvas"),
    {
        zoom: 15,
        center: myLatLng,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    });

    var marker = new google.maps.Marker(
    {
        position: myLatLng,
        map: map,
    });
};

initialize();