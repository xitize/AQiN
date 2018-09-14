package com.xitiz.airqualityindexnepal.util;

import java.util.Comparator;

public class SortPlaces implements Comparator<Loc> {
    private Loc currentLoc;

    public SortPlaces(Loc current) {
        currentLoc = current;
    }

    @Override
    public int compare(final Loc place1, final Loc place2) {
        double lat1 = place1.getLat();
        double lon1 = place1.getLng();
        double lat2 = place2.getLat();
        double lon2 = place2.getLng();

        double distanceToPlace1 = distance(currentLoc.getLat(), currentLoc.getLng(), lat1, lon1);
        double distanceToPlace2 = distance(currentLoc.getLat(), currentLoc.getLng(), lat2, lon2);
        return (int) (distanceToPlace1 - distanceToPlace2);
    }

    private double distance(double fromLat, double fromLon, double toLat, double toLon) {
        double radius = 6378137;   // approximate Earth radius, *in meters*
        double deltaLat = toLat - fromLat;
        double deltaLon = toLon - fromLon;
        double angle = 2 * Math.asin(Math.sqrt(
                Math.pow(Math.sin(deltaLat / 2), 2) +
                        Math.cos(fromLat) * Math.cos(toLat) *
                                Math.pow(Math.sin(deltaLon / 2), 2)));
        return radius * angle;
    }
}
