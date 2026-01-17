package software.ulpgc.moneycalculator.application;

import software.ulpgc.moneycalculator.architecture.io.Store;
import software.ulpgc.moneycalculator.architecture.model.ExchangeOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class OperationStore implements Store {
    private final List<ExchangeOperation> operations;

    public OperationStore() {
        operations = new ArrayList<>();
    }

    @Override
    public void put(ExchangeOperation operation) {
        operations.add(operation);
    }

    @Override
    public Stream<ExchangeOperation> operations() {
        return operations.stream();
    }
}
