package lld.DesignUberOla;

public class DefaultPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(TripMetadata tripMetadata) {
        System.out.println("Based on default pricing strategy, setting price");
        return 100.0;
    }
}
