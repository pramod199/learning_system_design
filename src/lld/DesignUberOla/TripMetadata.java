package lld.DesignUberOla;

public class TripMetadata {
    Location srcLoc;
    Location destLoc;
    Double riderRating;
    Double driverRating;

    public TripMetadata(Location srcLoc, Location destLoc, Double riderRating) {
        this.srcLoc = srcLoc;
        this.destLoc = destLoc;
        this.riderRating = riderRating;
    }

    public void setDriverRating(Double driverRating) {
        this.driverRating = driverRating;
    }
    public Double getDriverRating() {
        return driverRating;
    }

    public Double getRiderRating() {
        return riderRating;
    }
}
