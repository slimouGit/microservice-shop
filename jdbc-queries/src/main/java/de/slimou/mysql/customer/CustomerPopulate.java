package de.slimou.mysql.customer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class CustomerPopulate implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(CustomerPopulate.class);
    private JdbcTemplate jdbcTemplate;

    public CustomerPopulate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        Customer salim = new Customer("Salim", "Oussayfi");
        insertCustomer(salim);
        deleteCustomer(369);

        Customer mimi = new Customer("Michaela Maria","Illmer");
        insertCustomer(mimi);

    }



    private void insertCustomer(Customer customer) {
        {
            Object[] args = {customer.getFirstname(), customer.getLastname()};
            this.jdbcTemplate.update("INSERT INTO Customer (firstname, lastname) VALUES (?,?)", args);
        }
    }

    private void deleteCustomer(int id) {
        {
            this.jdbcTemplate.update("DELETE FROM Customer WHERE id =" + id);
        }
    }



}
