package engage.technology.ryan.engage.technology.expenses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping
public class ExpensesController {
    @Autowired ExpensesService expensesService;

    @GetMapping("/getExpenses")
    public List<Expenses> findAllSensorResults(){
        return expensesService.getExpenses();
    }

    @PostMapping("/addExpenses")
    public Expenses addExpense(@RequestBody Expenses expenses){
        return expensesService.addExpenseAsEuro(expenses);
    }

    @PostMapping("/addExpenses/{currency}")
    public Expenses addExpenseWithCurrency(@PathVariable(required = false) String currency, @RequestBody Expenses expenses){
        expenses.setAmount(convertEURToGBP(expenses.getAmount()));
        return expensesService.addExpenseAdjustedWithCurrency(expenses, (currency));
    }

    private double convertEURToGBP(double amount) {
        final String uri = "http://127.0.0.1:5000/get_eur_to_gbp";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return amount * Double.parseDouble(result);
    }
}
