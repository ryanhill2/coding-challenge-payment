package engage.technology.ryan.engage.technology.expenses;

import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Expenses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    @Getter @Setter
    private Date date;
    @Getter @Setter
    private double amount;
    @Getter @Setter
    private String reason;
    @Getter @Setter
    private double VAT;
}

