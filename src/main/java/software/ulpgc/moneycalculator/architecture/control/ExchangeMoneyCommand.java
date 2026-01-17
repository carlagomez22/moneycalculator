package software.ulpgc.moneycalculator.architecture.control;

import software.ulpgc.moneycalculator.architecture.io.ExchangeRateLoader;
import software.ulpgc.moneycalculator.application.OperationStore;
import software.ulpgc.moneycalculator.architecture.model.Currency;
import software.ulpgc.moneycalculator.architecture.model.ExchangeOperation;
import software.ulpgc.moneycalculator.architecture.model.ExchangeRate;
import software.ulpgc.moneycalculator.architecture.model.Money;
import software.ulpgc.moneycalculator.architecture.ui.CurrencyDialog;
import software.ulpgc.moneycalculator.architecture.ui.MoneyDialog;
import software.ulpgc.moneycalculator.architecture.ui.MoneyDisplay;

import java.time.LocalDateTime;

public class ExchangeMoneyCommand implements Command {
    private final MoneyDialog moneyDialog;
    private final CurrencyDialog currencyDialog;
    private final ExchangeRateLoader exchangeRateLoader;
    private final OperationStore operations;
    private final MoneyDisplay moneyDisplay;

    public ExchangeMoneyCommand(MoneyDialog moneyDialog, CurrencyDialog currencyDialog, ExchangeRateLoader exchangeRateLoader, OperationStore operations, MoneyDisplay moneyDisplay) {
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
        this.exchangeRateLoader = exchangeRateLoader;
        this.operations = operations;
        this.moneyDisplay = moneyDisplay;
    }

    @Override
    public void execute() {
        Money money = moneyDialog.get();
        Currency currency = currencyDialog.get();

        ExchangeRate exchangeRate = exchangeRateLoader.load(money.currency(), currency);

        Money result = new Money(money.amount() * exchangeRate.rate(), currency);
        operations.put(new ExchangeOperation(exchangeRate, result, LocalDateTime.now()));
        moneyDisplay.show(result);
    }
}
