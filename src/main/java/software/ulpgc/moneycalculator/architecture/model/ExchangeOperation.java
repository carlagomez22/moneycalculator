package software.ulpgc.moneycalculator.architecture.model;

import java.time.LocalDateTime;

public record ExchangeOperation(ExchangeRate exchange, Money result, LocalDateTime date) {
}
