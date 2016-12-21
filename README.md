# ThemedGoogleMap
Utility class to make GoogleMap with custom theme.

<img src="https://github.com/jineshfrancs/ThemedGoogleMap/blob/master/screens/screen1.png" width="360" height="640">  <img src="https://github.com/jineshfrancs/ThemedGoogleMap/blob/master/screens/screen2.png" width="360" height="640">

Create your own theme like this

```
 GoogleMapStyler googleMapStyler = new GoogleMapStyler.Builder()
                        .setMainGeometryColor(ContextCompat.getColor(MainActivity.this, R.color.maingeometrycolor))
                        .setAllPlaceTextStrokeAlpha(-80)
                        .setAllPlaceTextColor(ContextCompat.getColor(MainActivity.this, R.color.adminstartivelabel))
                        .setAllMainTownTextColor(ContextCompat.getColor(MainActivity.this, R.color.administativelocality))
                        .setAllPoiTextColor(ContextCompat.getColor(MainActivity.this, R.color.poitext))
                        .setAllPoiParkBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.poiparkbackground))
                        .setAllPoiParkTextColor(ContextCompat.getColor(MainActivity.this, R.color.poilabel))
                        .setAllRoadBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.roadbackground))
                        .setAllRoadTextColor(ContextCompat.getColor(MainActivity.this, R.color.roadlabel))
                        .setAllRoadArterialBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.roadarterialbackground))
                        .setAllRoadArterialStrokeColor(ContextCompat.getColor(MainActivity.this, R.color.roadarterialstroke))
                        .setAllRoadHighwayBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.roadhighway))
                        .setAllRoadHighwayStrokeColor(ContextCompat.getColor(MainActivity.this, R.color.roadhighwaystroke))
                        .setAllRoadHighwayTextColor(ContextCompat.getColor(MainActivity.this, R.color.roadhighwaylabel))
                        .setAllRoadLocalBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.roadlocal))
                        .setAllRoadLocalStrokeColor(ContextCompat.getColor(MainActivity.this, R.color.roadlocalstroke))
                        .setAllTransitStationTextColor(ContextCompat.getColor(MainActivity.this, R.color.transitstationtext))
                        .setAllTransitBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.transit))
                        .setAllWaterTextColor(ContextCompat.getColor(MainActivity.this, R.color.waterlabel))
                        .setAllWaterBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.water))
                        .setAllWaterTextStrokeAlpha(-20)
                        .build();
```
Apply generated style to google map

```
 googleMap.setMapStyle(googleMapStyler.getMapStyleOptions());
```
