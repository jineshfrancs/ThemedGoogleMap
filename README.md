# ThemedGoogleMap
<a target="_blank" href="https://www.paypal.me/javiersantos" title="Donate using PayPal"><img src="https://img.shields.io/badge/paypal-donate-yellow.svg" /></a>

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
// setMainGeometryColor(Color.BLACK)
                        
```
Apply generated style to google map

```
 googleMap.setMapStyle(googleMapStyler.getMapStyleOptions());
```
Use in your project
------

1.Add it in your root build.gradle at the end of repositories:
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

2.Add the dependency in your app build.gradle file:
```
dependencies {
	       compile 'com.github.jineshfrancs:ThemedGoogleMap:1.0'
}
```

