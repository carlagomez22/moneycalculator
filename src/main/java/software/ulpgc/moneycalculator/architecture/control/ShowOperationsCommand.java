package software.ulpgc.moneycalculator.architecture.control;

import software.ulpgc.moneycalculator.application.OperationStore;
import software.ulpgc.moneycalculator.architecture.model.ExchangeOperation;
import software.ulpgc.moneycalculator.architecture.ui.OperationDisplay;

import java.util.stream.Stream;

public class ShowOperationsCommand implements Command {
    private final OperationStore operationStore;
    private final OperationDisplay operationDisplay;

    public ShowOperationsCommand(OperationStore operations, OperationDisplay operationDisplay) {
        this.operationStore = operations;
        this.operationDisplay = operationDisplay;
    }


    @Override
    public void execute() {
        Stream<ExchangeOperation> operations = operationStore.operations();
        operations.forEach(operationDisplay::show);
    }
}
