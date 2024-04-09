package am.cs322;

public interface BankAccountService {
    void credit(String accountNumber, double amount);
    void debit(String accountNumber, double amount);
}

