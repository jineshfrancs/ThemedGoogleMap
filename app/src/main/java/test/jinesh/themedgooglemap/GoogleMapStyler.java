package test.jinesh.themedgooglemap;

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
    static class Builder {
        /**
         * map style to be applied
         */
        private GoogleMapStyler googleMapStyler;
        /**
         * generated json string of map style
         */
        private StringBuilder json;

        /**
         * Builder class constructor
         */
        public Builder() {
            googleMapStyler = new GoogleMapStyler();
            json = new StringBuilder();
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
        public Builder setMainGeometryColor(int color) {
            String mColor = HASH_SYMBOL + Integer.toHexString(color);
            createFeature(ALL, GEOMETRY, COLOR, mColor);
            return this;
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
         * Sets  color for all the place texts excluding water label text,main city text etc.
         *
         * @param color color to be applied for the label
         */
        public Builder setAllPlaceTextColor(int color) {
            String mColor = HASH_SYMBOL + Integer.toHexString(color);
            createFeature(ADMINISTRATIVE, LABELS_TEXT_FILL, COLOR, mColor);
            return this;
        }

        /**
         * Sets color for all main city labels.
         *
         * @param color color to be applied for the label
         */
        public Builder setAllMainTownTextColor(int color) {
            String mColor = HASH_SYMBOL + Integer.toHexString(color);
            createFeature(ADMINISTRATIVE_LOCALITY, LABELS_TEXT_FILL, COLOR, mColor);
            return this;
        }

        /**
         * Sets color for all resturant labels.
         *
         * @param color color to be applied for the label
         */
        public Builder setAllPoiTextColor(int color) {
            String mColor = HASH_SYMBOL + Integer.toHexString(color);
            createFeature(POI, LABELS_TEXT_FILL, COLOR, mColor);
            return this;
        }

        /**
         * Sets background color for all resturant parks.
         *
         * @param color color to be applied for resturant parks
         */
        public Builder setAllPoiParkBackgroundColor(int color) {
            String mColor = HASH_SYMBOL + Integer.toHexString(color);
            createFeature(POI_PARK, GEOMETRY, COLOR, mColor);
            return this;
        }

        /**
         * Sets color for all resturant park labels.
         *
         * @param color color to be applied for the label
         */
        public Builder setAllPoiParkTextColor(int color) {
            String mColor = HASH_SYMBOL + Integer.toHexString(color);
            createFeature(POI_PARK, LABELS_TEXT_FILL, COLOR, mColor);
            return this;
        }

        /**
         * Sets color for all roads.
         *
         * @param color color to be applied for the road
         */
        public Builder setAllRoadBackgroundColor(int color) {
            String mColor = HASH_SYMBOL + Integer.toHexString(color);
            createFeature(ROAD, GEOMETRY_FILL, COLOR, mColor);
            return this;
        }

        /**
         * Sets label color for all roads.
         *
         * @param color color to be applied for the label
         */
        public Builder setAllRoadTextColor(int color) {
            String mColor = HASH_SYMBOL + Integer.toHexString(color);
            createFeature(ROAD, LABELS_TEXT_FILL, COLOR, mColor);
            return this;
        }

        /**
         * Sets color for all arterial roads.arterial means important route in a system of roads, railway lines, or rivers.
         *
         * @param color color to be applied
         */
        public Builder setAllRoadArterialBackgroundColor(int color) {
            String mColor = HASH_SYMBOL + Integer.toHexString(color);
            createFeature(ROAD_ARTERIAL, GEOMETRY_FILL, COLOR, mColor);
            return this;
        }

        /**
         * Sets stroke color for all arterial roads.arterial means important route in a system of roads, railway lines, or rivers.
         *
         * @param color color to be applied for the stroke
         */
        public Builder setAllRoadArterialStrokeColor(int color) {
            String mColor = HASH_SYMBOL + Integer.toHexString(color);
            createFeature(ROAD_ARTERIAL, GEOMETRY_STROKE, COLOR, mColor);
            return this;
        }

        /**
         * Sets color for all highway roads.
         *
         * @param color color to be applied
         */
        public Builder setAllRoadHighwayBackgroundColor(int color) {
            String mColor = HASH_SYMBOL + Integer.toHexString(color);
            createFeature(ROAD_HIGHWAY, GEOMETRY_FILL, COLOR, mColor);
            return this;
        }

        /**
         * Sets stroke color for all highway roads.
         *
         * @param color color to be applied for the stoke
         */
        public Builder setAllRoadHighwayStrokeColor(int color) {
            String mColor = HASH_SYMBOL + Integer.toHexString(color);
            createFeature(ROAD_HIGHWAY, GEOMETRY_STROKE, COLOR, mColor);
            return this;
        }

        /**
         * Sets color for labels in all highway roads.
         *
         * @param color color to be applied for the label
         */
        public Builder setAllRoadHighwayTextColor(int color) {
            String mColor = HASH_SYMBOL + Integer.toHexString(color);
            createFeature(ROAD_HIGHWAY, LABELS_TEXT_FILL, COLOR, mColor);
            return this;
        }

        /**
         * Sets color for all local roads.
         *
         * @param color color to be applied
         */
        public Builder setAllRoadLocalBackgroundColor(int color) {
            String mColor = HASH_SYMBOL + Integer.toHexString(color);
            createFeature(ROAD_LOCAL, GEOMETRY_FILL, COLOR, mColor);
            return this;
        }

        /**
         * Sets stroke color for all local roads.
         *
         * @param color color to be applied for the stroke
         */
        public Builder setAllRoadLocalStrokeColor(int color) {
            String mColor = HASH_SYMBOL + Integer.toHexString(color);
            createFeature(ROAD_LOCAL, GEOMETRY_STROKE, COLOR, mColor);
            return this;
        }

        /**
         * Sets color for all transits.
         *
         * @param color color to be applied
         */
        public Builder setAllTransitBackgroundColor(int color) {
            String mColor = HASH_SYMBOL + Integer.toHexString(color);
            createFeature(TRANSIT, GEOMETRY, COLOR, mColor);
            return this;
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
         * Sets color for water.
         *
         * @param color color to be applied
         */
        public Builder setAllWaterBackgroundColor(int color) {
            String mColor = HASH_SYMBOL + Integer.toHexString(color);
            createFeature(WATER, GEOMETRY, COLOR, mColor);
            return this;
        }

        /**
         * Sets color for labels in water.
         *
         * @param color color to be applied for the label
         */
        public Builder setAllWaterTextColor(int color) {
            String mColor = HASH_SYMBOL + Integer.toHexString(color);
            createFeature(WATER, LABELS_TEXT_FILL, COLOR, mColor);
            return this;
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
        public Builder setCustomFeatureColor(String featureType, String elementType, int color) {
            String mColor = HASH_SYMBOL + Integer.toHexString(color);
            createFeature(featureType, elementType, COLOR, mColor);
            return this;
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
