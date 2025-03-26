package lld.design_vending_machine.VendingStates;

import lld.design_vending_machine.Coin;
import lld.design_vending_machine.Item;

import java.util.List;

public interface State {
    public void clickOnInsertCoinButton();

    public void clickOnStartProductSelectionButton();

    public void insertCoin(Coin coin);

    public void chooseProduct(int codeNumber) throws Exception;

    int getChange(int returnChangeMoney);

    Item dispenseProduct(int codeNumber) throws Exception;

    List<Coin> refundFullMoney();

    void updateInventory(Item item, int codeNumber) throws Exception;
}
