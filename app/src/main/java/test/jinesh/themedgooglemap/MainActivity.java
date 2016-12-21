package test.jinesh.themedgooglemap;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((MapFragment) getFragmentManager().findFragmentById(
                R.id.vM_apnrm_map)).getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
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
                boolean success = googleMap.setMapStyle(googleMapStyler.getMapStyleOptions());
            }
        });

    }
}
