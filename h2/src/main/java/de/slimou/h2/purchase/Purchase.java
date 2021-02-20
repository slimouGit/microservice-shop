package de.slimou.h2.purchase;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long purchase_id;
    private LocalDate transaction_date;
    private Long customer_;
    private Long product_;

    public Purchase() {
    }

    public Purchase(LocalDate transaction_date, Long customer_, Long product_) {
        this.transaction_date = transaction_date;
        this.customer_ = customer_;
        this.product_ = product_;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "purchase_id=" + purchase_id +
                ", transaction_date=" + transaction_date +
                ", customer_=" + customer_ +
                ", product_=" + product_ +
                '}';
    }

    public Long getPurchase_id() {
        return purchase_id;
    }

    public void setPurchase_id(Long purchase_id) {
        this.purchase_id = purchase_id;
    }

    public LocalDate getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(LocalDate transaction_date) {
        this.transaction_date = transaction_date;
    }

    public Long getCustomer_() {
        return customer_;
    }

    public void setCustomer_(Long customer_) {
        this.customer_ = customer_;
    }

    public Long getProduct_() {
        return product_;
    }

    public void setProduct_(Long product_) {
        this.product_ = product_;
    }
}
