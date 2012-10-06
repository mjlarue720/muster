<html>
    <head>
        <title>Welcome to GeoTwitter!</title>
        <meta name="layout" content="main" />

        <script src="http://www.google.com/jsapi?key=YOUR_GOOGLE_MAPS_API_KEY" type="text/javascript"></script>

        <script type="text/javascript">
            google.load("maps", "3.x", {'other_params':'sensor=true'});
            google.load("jquery", "1.3.1");
        
            google.setOnLoadCallback(function() {
                $(document).ready(function() {
                    var latlng = new google.maps.LatLng(49.2325477, 28.4744695);
                    var myOptions = {zoom:16, center:latlng, mapTypeId: google.maps.MapTypeId.ROADMAP};
                    var map = new google.maps.Map(document.getElementById('map'),myOptions);
                    
                    var image = '/alpha/images/school.png';
                    var myLatLng = new google.maps.LatLng(49.2325477, 28.4744695);
                    var beachMarker = new google.maps.Marker({
                        position: myLatLng,
                        map: map,
                        icon: image
                    });
                    
                    //map.setCenter(vinnitsa, 8);
                    //map.addControl(new GLargeMapControl());

//                    form.submit(function() {
//                        $.getJSON(form.attr("action") + "?" + form.serialize(), function (data) {
//                            // Clear all markers
//                            map.clearOverlays();
//                            // Loop through friends list and add markers to map
//                            $.each(data, function (i, item) {
//                                if (item.coords) {
//                                    var marker = new GMarker(new GLatLng(item.coords.latitude, item.coords.longitude));
//                                    map.addOverlay(marker);
//                                    var popup = '<img style="width: 48px; height:48px;" src="' + item.pictureUrl + '">' + 
//                                        item.name + ' (' + item.screenName + ') <br>' + 
//                                        item.bio + '<br>' + item.status;
//                                    GEvent.addListener(marker, "click", function() {
//                                        marker.openInfoWindowHtml(popup);
//                                    });
//                                }
//                            });
//                        });
//                        // Indicate that form should not actually be submitted
//                        return false;
//                    });

                });
            });
        </script>
    </head>
    <body>
        <div class="form">
            <form action="${createLink(controller: 'twitter', action: 'friendsJson')}" id="twitter">
                <p>
                    <label>twitter id:</label>
                    <input type="text" id="name" name="name" value=""/>
                </p>
                <p class="submit">
                    <input type="submit" value="Map my friends!">
                </p>
            </form>
        </div>
        <div id="map" style="width:800px; height:600px">
        </div>
    </body>
</html>
