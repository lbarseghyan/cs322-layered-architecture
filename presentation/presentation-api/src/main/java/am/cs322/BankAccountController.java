package am.cs322;
import am.cs322.model.DebitRequest;
import am.cs322.model.CreditRequest;

public interface BankAccountController {
    public void credit(CreditRequest request);
    public void debit(DebitRequest request);
}


