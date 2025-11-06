package lld.design_inventory_and_order_management;

import java.util.List;

public class NearestWarehouseSelectionStrategy implements WarehouseSelectionStrategy {
    @Override
    public Warehouse selectWarehouse(List<Warehouse> warehouses) {
        //algo to pick the nearest algo, for now I am just picking the first warehouse for demo purpose
        return warehouses.get(0);

    }
}
