package am.cs322.model;

import jakarta.annotation.Nonnull;

public record CreditRequest(@Nonnull
                            String accountNumber,
                            double amount) {
}