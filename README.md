# ThemedGoogleMap
Utility class to make GoogleMap with custom theme.

<img src="https://github.com/jineshfrancs/ThemedGoogleMap/blob/master/screens/screen1.png" width="240" height="400">  <img src="https://github.com/jineshfrancs/ThemedGoogleMap/blob/master/screens/screen4.png" width="240" height="400">  <img src="https://github.com/jineshfrancs/ThemedGoogleMap/blob/master/screens/screen3.png" width="240" height="400">

Create your own theme like this

```
GoogleMapStyler googleMapStyler = new GoogleMapStyler.Builder(MainActivity.this)
                        .setMainGeometryColorRes(R.color.maingeometrycolor)
                        .setAllPlaceTextStrokeAlpha(-80)
                        .setAllPlaceTextColorRes(R.color.adminstartivelabel)
                        .setAllMainTownTextColorRes(R.color.administativelocality)
                        .setAllPoiTextColorRes(R.color.poitext)
                        .setAllPoiParkBackgroundColorRes(R.color.poiparkbackground)
                        .setAllPoiParkTextColorRes(R.color.poilabel)
                        .setAllRoadBackgroundColorRes(R.color.roadbackground)
                        .setAllRoadTextColorRes(R.color.roadlabel)
                        .setAllRoadArterialBackgroundColorRes(R.color.roadarterialbackground)
                        .setAllRoadArterialStrokeColorRes(R.color.roadarterialstroke)
                        .setAllRoadHighwayBackgroundColorRes(R.color.roadhighway)
                        .setAllRoadHighwayStrokeColorRes(R.color.roadhighwaystroke)
                        .setAllRoadHighwayTextColorRes(R.color.roadhighwaylabel)
                        .setAllRoadLocalBackgroundColorRes(R.color.roadlocal)
                        .setAllRoadLocalStrokeColorRes(R.color.roadlocalstroke)
                        .setAllTransitStationTextColorRes(R.color.transitstationtext)
                        .setAllTransitBackgroundColorRes(R.color.transit)
                        .setAllWaterTextColorRes(R.color.waterlabel)
                        .setAllWaterBackgroundColorRes(R.color.water)
                        .setAllWaterTextStrokeAlpha(-20)
                        .build();

// Alternatively to use a Color int, remove the Res from the method name
// Example:
// setMainGeometryColorRes(Color.BLACK)
                        
```
Apply generated style to google map

```
 googleMap.setMapStyle(googleMapStyler.getMapStyleOptions());
```

