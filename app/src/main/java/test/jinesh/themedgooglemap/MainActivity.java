package test.jinesh.themedgooglemap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

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
                boolean success = googleMap.setMapStyle(googleMapStyler.getMapStyleOptions());
            }
        });

    }
}
