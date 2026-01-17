package software.ulpgc.moneycalculator.application.queen;

import software.ulpgc.moneycalculator.architecture.control.ExchangeMoneyCommand;
import software.ulpgc.moneycalculator.architecture.control.ShowOperationsCommand;
import software.ulpgc.moneycalculator.application.OperationStore;

public class Main {
    public static void main(String[] args) {
        Desktop desktop = new Desktop(new WebService.CurrencyLoader().loadAll());

        OperationStore operationStore = new OperationStore();

        desktop.addCommand("exchange", new ExchangeMoneyCommand(
                desktop.moneyDialog(),
                desktop.currencyDialog(),
                new WebService.ExchangeRateLoader(),
                operationStore,
                desktop.moneyDisplay()
        ));

        desktop.addCommand("history", new ShowOperationsCommand(
                operationStore,
                desktop.operationDisplay()
        ));
        desktop.setVisible(true);
    }
}
