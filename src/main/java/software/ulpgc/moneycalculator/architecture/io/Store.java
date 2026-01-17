package software.ulpgc.moneycalculator.architecture.io;

import software.ulpgc.moneycalculator.architecture.model.ExchangeOperation;

import java.util.stream.Stream;

public interface Store {
    void put (ExchangeOperation operation);
    public Stream<ExchangeOperation> operations();
}
