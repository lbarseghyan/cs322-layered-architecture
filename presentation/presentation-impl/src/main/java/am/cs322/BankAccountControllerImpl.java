package am.cs322;

import am.cs322.model.DebitRequest;
import am.cs322.model.CreditRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/accounts")

public class BankAccountControllerImpl implements BankAccountController{
    private final BankAccountService bankAccountService;

    public BankAccountControllerImpl(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @Override
    @PostMapping("/credit")
    public void credit(@RequestBody CreditRequest request) {
        bankAccountService.credit(request.accountNumber(), request.amount());
    }

    @Override
    @PostMapping("/debit")
    public void debit(@RequestBody DebitRequest request) {
        bankAccountService.debit(request.accountNumber(), request.amount());
    }
}






