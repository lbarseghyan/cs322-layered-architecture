package am.cs322.model;

import jakarta.annotation.Nonnull;

public record DebitRequest(@Nonnull
                                String accountNumber,
                           double amount) {
}