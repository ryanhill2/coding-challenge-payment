package engage.technology.ryan.engage.technology.expenses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpensesService {
    @Autowired ExpensesRepository expensesRepository;

    public Expenses addExpenseAdjustedWithCurrency(Expenses expenses, String name) {
        expenses.setVAT(expenses.getAmount() * 0.2);
        expensesRepository.save(expenses);
        return expenses;
    }

    public Expenses addExpenseAsEuro(Expenses expenses) {
        expenses.setVAT(expenses.getAmount()*0.2);
        expensesRepository.save(expenses);
        return expenses;
    }

    public List<Expenses> getExpenses() {
        return expensesRepository.findAll();
    }
}
