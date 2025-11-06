package lld.design_inventory_and_order_management;

import lld.design_zomato.Order;

import java.util.List;

public interface WarehouseSelectionStrategy {
    Warehouse selectWarehouse(List<Warehouse> warehouses);
}
