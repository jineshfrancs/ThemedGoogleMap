package test.jinesh.lib;

import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.v4.content.ContextCompat;

import com.google.android.gms.maps.model.MapStyleOptions;

/**
 * Utility class to create themed google map
 *
 * @author Jinesh Francis
 */
public class GoogleMapStyler {
    /**
     * map style to be applied
     */
    private MapStyleOptions mapStyleOptions;
    /**
     * proprty that will apply to whole map
     */
    private static final String ALL = "all";
    /**
     * proprty which changes color
     */
    private static final String COLOR = "color";
    /**
     * proprty which changes lightness
     */
    private static final String LIGHTNESS = "lightness";
    /**
     * body of the object
     */
    private static final String GEOMETRY = "geometry";
    /**
     * body filling of the object
     */
    private static final String GEOMETRY_FILL = "geometry.fill";
    /**
     * body stroke of the object
     */
    private static final String GEOMETRY_STROKE = "geometry.stroke";
    /**
     * hash symbol for color code generation
     */
    private static final String HASH_SYMBOL = "#";
    /**
     * property which will apply to road
     */
    private static final String ROAD = "road";
    /**
     * property which will apply to arterial road
     */
    private static final String ROAD_ARTERIAL = "road.arterial";
    /**
     * property which will apply to highway road
     */
    private static final String ROAD_HIGHWAY = "road.highway";
    /**
     * property which will apply to local road
     */
    private static final String ROAD_LOCAL = "road.local";
    /**
     * property which will apply to transit
     */
    private static final String TRANSIT = "transit";
    /**
     * property which will apply to transit station
     */
    private static final String TRANSIT_STATION = "transit.station";
    /**
     * property which will apply to water
     */
    private static final String WATER = "water";
    /**
     * label text background fill property
     */
    private static final String LABELS_TEXT_FILL = "labels.text.fill";
    /**
     * label text stroke property
     */
    private static final String LABELS_TEXT_STROKE = "labels.text.stroke";
    /**
     * property which will apply to administrative areas
     */
    private static final String ADMINISTRATIVE = "administrative";
    /**
     * property which will apply to administrative locality
     */
    private static final String ADMINISTRATIVE_LOCALITY = "administrative.locality";
    /**
     * property which will apply to poi
     */
    private static final String POI = "poi";
    /**
     * property which will apply to poi park
     */
    private static final String POI_PARK = "poi.park";

    /**
     * private constructor for GoogleMapStyler
     */
    private GoogleMapStyler() {
    }

    /**
     * Method returns the generated MapStyleOptions object to set to the google map.
     *
     * @return mapStyleOptions google map style options
     */
    public MapStyleOptions getMapStyleOptions() {
        return mapStyleOptions;
    }

    /**
     * Method sets the MapStyleOptions object
     *
     * @param mapStyleOptions google map style options
     */
    private void setMapStyleOptions(MapStyleOptions mapStyleOptions) {
        this.mapStyleOptions = mapStyleOptions;
    }

    /**
     * Builder class to generate the map style
     */
    public static class Builder {
        /**
         * Map style to be applied
         */
        private GoogleMapStyler googleMapStyler;
        /**
         * Generated json string of map style
         */
        private StringBuilder json;
        /**
         * Application context
         */
        private Context context;

        /**
         * Builder class constructor
         */
        public Builder(Context context) {
            this.googleMapStyler = new GoogleMapStyler();
            this.json = new StringBuilder();
            this.context = context;
            init();
        }

        /**
         * Method to initialise the json as array object
         */
        private void init() {
            json = json.append("[");
        }

        /**
         * Call this method to build the GoogleMapStyler
         *
         * @return GoogleMapStyler
         */
        public GoogleMapStyler build() {
            if (json.length() > 1) {
                json = json.deleteCharAt(json.length() - 1);
            }
            json = json.append("]");
            String temp = json.toString().replaceAll("\\\\", "");
            googleMapStyler.setMapStyleOptions(new MapStyleOptions(temp));
            return googleMapStyler;
        }

        /**
         * Create json object for each feature in a json array object
         *
         * @param featureType    type of feature to be added
         * @param elementType    element in which property to be applied
         * @param stylerProperty property name to be applied eg:color
         * @param stylerValue    property value
         */
        private void createFeature(String featureType, String elementType, String stylerProperty, String stylerValue) {
            json.append("{\n" + "      \\\"featureType\\\": \\\"").append(featureType).append("\\\",\n").append("      \\\"elementType\\\": \\\"").append(elementType).append("\\\",\n").append("      \\\"stylers\\\": [\n").append("        {\n").append("          \\\"").append(stylerProperty).append("\\\": \\\"").append(stylerValue).append("\\\"\n").append("        }\n").append("      ]\n").append("    },");
        }

        /**
         * Sets background color for all the continentals
         *
         * @param color background color to be applied
         */
        public Builder setMainGeometryColor(@ColorInt int color) {
            String mColor = HASH_SYMBOL + Integer.toHexString(color);
            createFeature(ALL, GEOMETRY, COLOR, mColor);
            return this;
        }

        /**
         * Sets background color for all the continentals
         *
         * @param color resource of background color to be applied
         */
        public Builder setMainGeometryColorRes(@ColorRes int color) {
            return setMainGeometryColor(ContextCompat.getColor(context, color));
        }

        /**
         * Sets text stroke to all place labels
         *
         * @param lightness alpha to be applied,use -ve values for lesser alpha and +ve values for increased alpha
         */
        public Builder setAllPlaceTextStrokeAlpha(int lightness) {
            createFeature(ALL, LABELS_TEXT_STROKE, LIGHTNESS, lightness + "");
            return this;
        }

        /**
         * Sets  color for all the place texts excluding water label text, main city text etc.
         *
         * @param color color to be applied for the label
         */
        public Builder setAllPlaceTextColor(@ColorInt int color) {
            String mColor = HASH_SYMBOL + Integer.toHexString(color);
            createFeature(ADMINISTRATIVE, LABELS_TEXT_FILL, COLOR, mColor);
            return this;
        }

        /**
         * Sets  color for all the place texts excluding water label text, main city text etc.
         *
         * @param color color resource to be applied for the label
         */
        public Builder setAllPlaceTextColorRes(@ColorRes int color) {
            return setAllPlaceTextColor(ContextCompat.getColor(context, color));
        }

        /**
         * Sets color for all main city labels.
         *
         * @param color color to be applied for the label
         */
        public Builder setAllMainTownTextColor(@ColorInt int color) {
            String mColor = HASH_SYMBOL + Integer.toHexString(color);
            createFeature(ADMINISTRATIVE_LOCALITY, LABELS_TEXT_FILL, COLOR, mColor);
            return this;
        }

        /**
         * Sets color for all main city labels.
         *
         * @param color color resource to be applied for the label
         */
        public Builder setAllMainTownTextColorRes(@ColorRes int color) {
            return setAllMainTownTextColor(ContextCompat.getColor(context, color));
        }

        /**
         * Sets color for all resturant labels.
         *
         * @param color color to be applied for the label
         */
        public Builder setAllPoiTextColor(@ColorInt int color) {
            String mColor = HASH_SYMBOL + Integer.toHexString(color);
            createFeature(POI, LABELS_TEXT_FILL, COLOR, mColor);
            return this;
        }

        /**
         * Sets color for all resturant labels.
         *
         * @param color color resource to be applied for the label
         */
        public Builder setAllPoiTextColorRes(@ColorRes int color) {
            return setAllPoiParkTextColor(ContextCompat.getColor(context, color));
        }

        /**
         * Sets background color for all restaurant parks.
         *
         * @param color color to be applied for restaurant parks
         */
        public Builder setAllPoiParkBackgroundColor(@ColorInt int color) {
            String mColor = HASH_SYMBOL + Integer.toHexString(color);
            createFeature(POI_PARK, GEOMETRY, COLOR, mColor);
            return this;
        }

        /**
         * Sets background color for all restaurant parks.
         *
         * @param color color resource to be applied for restaurant parks
         */
        public Builder setAllPoiParkBackgroundColorRes(@ColorRes int color) {
            return setAllPoiParkBackgroundColor(ContextCompat.getColor(context, color));
        }

        /**
         * Sets color for all restaurant park labels.
         *
         * @param color color to be applied for the label
         */
        public Builder setAllPoiParkTextColor(@ColorInt int color) {
            String mColor = HASH_SYMBOL + Integer.toHexString(color);
            createFeature(POI_PARK, LABELS_TEXT_FILL, COLOR, mColor);
            return this;
        }

        /**
         * Sets color for all restaurant park labels.
         *
         * @param color color resource to be applied for the label
         */
        public Builder setAllPoiParkTextColorRes(@ColorRes int color) {
            return setAllPoiParkTextColor(ContextCompat.getColor(context, color));
        }

        /**
         * Sets color for all roads.
         *
         * @param color color to be applied for the road
         */
        public Builder setAllRoadBackgroundColor(@ColorInt int color) {
            String mColor = HASH_SYMBOL + Integer.toHexString(color);
            createFeature(ROAD, GEOMETRY_FILL, COLOR, mColor);
            return this;
        }

        /**
         * Sets color for all roads.
         *
         * @param color color resource to be applied for the road
         */
        public Builder setAllRoadBackgroundColorRes(@ColorRes int color) {
            return setAllRoadBackgroundColor(ContextCompat.getColor(context, color));
        }

        /**
         * Sets label color for all roads.
         *
         * @param color color to be applied for the label
         */
        public Builder setAllRoadTextColor(@ColorInt int color) {
            String mColor = HASH_SYMBOL + Integer.toHexString(color);
            createFeature(ROAD, LABELS_TEXT_FILL, COLOR, mColor);
            return this;
        }

        /**
         * Sets label color for all roads.
         *
         * @param color color resource to be applied for the label
         */
        public Builder setAllRoadTextColorRes(@ColorRes int color) {
            return setAllRoadTextColor(ContextCompat.getColor(context, color));
        }

        /**
         * Sets color for all arterial roads. Arterial means important route in a system of roads, railway lines, or rivers.
         *
         * @param color color to be applied
         */
        public Builder setAllRoadArterialBackgroundColor(@ColorInt int color) {
            String mColor = HASH_SYMBOL + Integer.toHexString(color);
            createFeature(ROAD_ARTERIAL, GEOMETRY_FILL, COLOR, mColor);
            return this;
        }

        /**
         * Sets color for all arterial roads. Arterial means important route in a system of roads, railway lines, or rivers.
         *
         * @param color color resource to be applied
         */
        public Builder setAllRoadArterialBackgroundColorRes(@ColorRes int color) {
            return setAllRoadArterialBackgroundColor(ContextCompat.getColor(context, color));
        }

        /**
         * Sets stroke color for all arterial roads. Arterial means important route in a system of roads, railway lines, or rivers.
         *
         * @param color color to be applied for the stroke
         */
        public Builder setAllRoadArterialStrokeColor(@ColorInt int color) {
            String mColor = HASH_SYMBOL + Integer.toHexString(color);
            createFeature(ROAD_ARTERIAL, GEOMETRY_STROKE, COLOR, mColor);
            return this;
        }

        /**
         * Sets stroke color for all arterial roads. Arterial means important route in a system of roads, railway lines, or rivers.
         *
         * @param color color resource to be applied for the stroke
         */
        public Builder setAllRoadArterialStrokeColorRes(@ColorRes int color) {
            return setAllRoadArterialStrokeColor(ContextCompat.getColor(context, color));
        }

        /**
         * Sets color for all highway roads.
         *
         * @param color color to be applied
         */
        public Builder setAllRoadHighwayBackgroundColor(@ColorInt int color) {
            String mColor = HASH_SYMBOL + Integer.toHexString(color);
            createFeature(ROAD_HIGHWAY, GEOMETRY_FILL, COLOR, mColor);
            return this;
        }

        /**
         * Sets color for all highway roads.
         *
         * @param color color resource to be applied
         */
        public Builder setAllRoadHighwayBackgroundColorRes(@ColorRes int color) {
            return setAllRoadHighwayBackgroundColor(ContextCompat.getColor(context, color));
        }

        /**
         * Sets stroke color for all highway roads.
         *
         * @param color color to be applied for the stoke
         */
        public Builder setAllRoadHighwayStrokeColor(@ColorInt int color) {
            String mColor = HASH_SYMBOL + Integer.toHexString(color);
            createFeature(ROAD_HIGHWAY, GEOMETRY_STROKE, COLOR, mColor);
            return this;
        }

        /**
         * Sets stroke color for all highway roads.
         *
         * @param color color resource to be applied for the stoke
         */
        public Builder setAllRoadHighwayStrokeColorRes(@ColorRes int color) {
            return setAllRoadHighwayStrokeColor(ContextCompat.getColor(context, color));
        }

        /**
         * Sets color for labels in all highway roads.
         *
         * @param color color to be applied for the label
         */
        public Builder setAllRoadHighwayTextColor(@ColorInt int color) {
            String mColor = HASH_SYMBOL + Integer.toHexString(color);
            createFeature(ROAD_HIGHWAY, LABELS_TEXT_FILL, COLOR, mColor);
            return this;
        }

        /**
         * Sets color for labels in all highway roads.
         *
         * @param color color resource to be applied for the label
         */
        public Builder setAllRoadHighwayTextColorRes(@ColorRes int color) {
            return setAllRoadHighwayTextColor(ContextCompat.getColor(context, color));
        }

        /**
         * Sets color for all local roads.
         *
         * @param color color to be applied
         */
        public Builder setAllRoadLocalBackgroundColor(@ColorInt int color) {
            String mColor = HASH_SYMBOL + Integer.toHexString(color);
            createFeature(ROAD_LOCAL, GEOMETRY_FILL, COLOR, mColor);
            return this;
        }

        /**
         * Sets color for all local roads.
         *
         * @param color color resource to be applied
         */
        public Builder setAllRoadLocalBackgroundColorRes(@ColorRes int color) {
            return setAllRoadLocalBackgroundColor(ContextCompat.getColor(context, color));
        }

        /**
         * Sets stroke color for all local roads.
         *
         * @param color color to be applied for the stroke
         */
        public Builder setAllRoadLocalStrokeColor(@ColorInt int color) {
            String mColor = HASH_SYMBOL + Integer.toHexString(color);
            createFeature(ROAD_LOCAL, GEOMETRY_STROKE, COLOR, mColor);
            return this;
        }

        /**
         * Sets stroke color for all local roads.
         *
         * @param color color resource to be applied for the stroke
         */
        public Builder setAllRoadLocalStrokeColorRes(@ColorRes int color) {
            return setAllRoadLocalStrokeColor(ContextCompat.getColor(context, color));
        }

        /**
         * Sets color for all transits.
         *
         * @param color color to be applied
         */
        public Builder setAllTransitBackgroundColor(@ColorInt int color) {
            String mColor = HASH_SYMBOL + Integer.toHexString(color);
            createFeature(TRANSIT, GEOMETRY, COLOR, mColor);
            return this;
        }

        /**
         * Sets color for all transits.
         *
         * @param color color resource to be applied
         */
        public Builder setAllTransitBackgroundColorRes(@ColorRes int color) {
            return setAllTransitBackgroundColor(ContextCompat.getColor(context, color));
        }

        /**
         * Sets label color for all transit stations.
         *
         * @param color color to be applied for the label
         */
        public Builder setAllTransitStationTextColor(int color) {
            String mColor = HASH_SYMBOL + Integer.toHexString(color);
            createFeature(TRANSIT_STATION, LABELS_TEXT_FILL, COLOR, mColor);
            return this;
        }

        /**
         * Sets label color for all transit stations.
         *
         * @param color color resource to be applied for the label
         */
        public Builder setAllTransitStationTextColorRes(int color) {
            return setAllTransitStationTextColor(ContextCompat.getColor(context, color));
        }

        /**
         * Sets color for water.
         *
         * @param color color to be applied
         */
        public Builder setAllWaterBackgroundColor(@ColorInt int color) {
            String mColor = HASH_SYMBOL + Integer.toHexString(color);
            createFeature(WATER, GEOMETRY, COLOR, mColor);
            return this;
        }

        /**
         * Sets color for water.
         *
         * @param color color resource to be applied
         */
        public Builder setAllWaterBackgroundColorRes(@ColorRes int color) {
            return setAllWaterBackgroundColor(ContextCompat.getColor(context, color));
        }

        /**
         * Sets color for labels in water.
         *
         * @param color color to be applied for the label
         */
        public Builder setAllWaterTextColor(@ColorInt int color) {
            String mColor = HASH_SYMBOL + Integer.toHexString(color);
            createFeature(WATER, LABELS_TEXT_FILL, COLOR, mColor);
            return this;
        }

        /**
         * Sets color for labels in water.
         *
         * @param color color resource to be applied for the label
         */
        public Builder setAllWaterTextColorRes(@ColorRes int color) {
            return setAllWaterTextColor(ContextCompat.getColor(context, color));
        }

        /**
         * Sets stroke alpha for labels in water.
         *
         * @param lightness alpha to be applied,use -ve values for lesser alpha and +ve values for increased alpha
         */
        public Builder setAllWaterTextStrokeAlpha(int lightness) {
            createFeature(WATER, LABELS_TEXT_STROKE, LIGHTNESS, lightness + "");
            return this;
        }

        /**
         * Sets custom feature color to be applied
         * for more details visit https://developers.google.com/maps/documentation/javascript/style-reference
         *
         * @param featureType type of feature to be added
         * @param elementType element in which property to be applied
         * @param color       color to be applied
         */
        public Builder setCustomFeatureColor(String featureType, String elementType, @ColorInt int color) {
            String mColor = HASH_SYMBOL + Integer.toHexString(color);
            createFeature(featureType, elementType, COLOR, mColor);
            return this;
        }

        /**
         * Sets custom feature color to be applied
         * for more details visit https://developers.google.com/maps/documentation/javascript/style-reference
         *
         * @param featureType type of feature to be added
         * @param elementType element in which property to be applied
         * @param color       color resource to be applied
         */
        public Builder setCustomFeatureColorRes(String featureType, String elementType, @ColorRes int color) {
            return setCustomFeatureColor(featureType, elementType, ContextCompat.getColor(context, color));
        }

        /**
         * Sets custom feature lightness to be applied
         * for more details visit https://developers.google.com/maps/documentation/javascript/style-reference
         *
         * @param featureType type of feature to be added
         * @param elementType element in which property to be applied
         * @param lightness   color to be applied
         */
        public Builder setCustomFeatureLightness(String featureType, String elementType, int lightness) {
            createFeature(featureType, elementType, LIGHTNESS, lightness + "");
            return this;
        }
    }
}
