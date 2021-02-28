package de.slimou.mysql.purchase;

import de.slimou.mysql.customer.Customer;
import de.slimou.mysql.product.Product;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "transaction_date")
    private LocalDate transaction_date;
    @ManyToOne
    @JoinColumn(name = "p_customer")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "p_product")
    private Product product;


    public Purchase() {
    }

    public Purchase(LocalDate transaction_date) {
        this.transaction_date = transaction_date;
    }

    public Purchase(LocalDate transaction_date, Customer customer, Product product) {
        this.transaction_date = transaction_date;
        this.customer = customer;
        this.product = product;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", transaction_date=" + transaction_date +
                ", domain=" + customer +
                ", product=" + product +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(LocalDate transaction_date) {
        this.transaction_date = transaction_date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
