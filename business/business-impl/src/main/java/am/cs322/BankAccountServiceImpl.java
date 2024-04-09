package am.cs322;

import am.cs322.model.BankAccount;
import org.springframework.stereotype.Service;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    private final BankAccountRepository bankAccountRepository;

    public BankAccountServiceImpl(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public void credit(String accountNumber, double amount) {
        BankAccount account = bankAccountRepository.findByAccountNumber(accountNumber);
        if (account != null) {
            double newBalance = account.getBalance() + amount;
            account.setBalance(newBalance);
            bankAccountRepository.save(account);
        } else {
            throw new RuntimeException("Bank account not found with account number: " + accountNumber);
        }
    }

    @Override
    public void debit(String accountNumber, double amount) {
        BankAccount account = bankAccountRepository.findByAccountNumber(accountNumber);
        if (account != null) {
            double newBalance = account.getBalance() - amount;
            if (newBalance >= 0) {
                account.setBalance(newBalance);
                bankAccountRepository.save(account);
            } else {
                throw new RuntimeException("Insufficient funds in account: " + accountNumber);
            }
        } else {
            throw new RuntimeException("Bank account not found with account number: " + accountNumber);
        }
    }
}

