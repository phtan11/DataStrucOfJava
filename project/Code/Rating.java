public class Rating {
    Customer customer;
    Product product;
    int rate;
    public Rating(Customer customer, Product product, int rate) {
        this.customer = customer;
        this.product = product;
        this.rate = rate;
    }
    public Customer getCustomer() {
        return this.customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Product getProduct() {
        return this.product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public int getRate() {
        return this.rate;
    }
    public void setRate(int rate) {
        this.rate = rate;
    }
    @Override
    public String toString() {
        return "Customer: " + customer + ", Product: " + product + ", Rate: " + rate;
    }
}
