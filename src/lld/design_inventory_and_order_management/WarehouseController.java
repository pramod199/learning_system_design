package lld.design_inventory_and_order_management;

import java.util.List;

public class WarehouseController {

    List<Warehouse> warehouses;
    WarehouseSelectionStrategy warehouseSelectionStrategy;

    public WarehouseController(List<Warehouse> warehouses, WarehouseSelectionStrategy warehouseSelectionStrategy) {
        this.warehouses = warehouses;
        this.warehouseSelectionStrategy = warehouseSelectionStrategy;
    }

    public void addWarehouse(Warehouse warehouse) {
        warehouses.add(warehouse);
    }

    //remove warehouse
    public void removeWarehouse(Warehouse warehouse){
        warehouses.remove(warehouse);
    }

    public Warehouse selectWarehouse(){
        return warehouseSelectionStrategy.selectWarehouse(warehouses);
    }

}
