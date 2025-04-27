package lld.DesignUberOla;

public class RatingBasedPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(TripMetadata tripMetadata) {
        double price = isHighRating(tripMetadata.getRiderRating()) ? 55.0 : 65.0;
        System.out.println("Based on rating based pricing strategy, setting price");
        return price;
    }

    private boolean isHighRating(Double riderRating) {
        if (riderRating > 3.0){
            return true;
        } else {
            return false;
        }
    }
}
