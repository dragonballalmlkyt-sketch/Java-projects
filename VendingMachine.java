public class VendingMachine {
    public static void main(String[] args) {

        Product product = new Product("Soda", 1.50, 10);
        Vending vendingMachine = new Vending(product);

        System.out.println("Product: " + product.getProductName());
        System.out.println("Price: $" + product.getPrice());
        System.out.println("Stock: " + product.getstock());
        System.out.println("Total Sales: $" + vendingMachine.getTotalSales());

        if (vendingMachine.purchase(2.00)) {
            System.out.println("Purchase successful.");
            System.out.println("Remaining Stock: " + product.getstock());
            System.out.println("Total Sales: $" + vendingMachine.getTotalSales());
        } else {
            System.out.println("Purchase failed. Insufficient funds or out of stock.");
        }

    }

    static class Product {
        private String name;
        private double price;
        private int stock;

        public Product(String name, double price, int stock) {
            if(price < 0 || stock < 0) {
                
                throw new IllegalArgumentException("Price and stock must be non-negative.");
            }
            this.name = name;
            this.price = price;
            this.stock = stock;
        }

        public String getProductName() {
                return name;
        }
        

        public double getPrice() {
            return price;
        }

        public int getstock() {
            return stock;
        }      

        public void updateStock() {
            stock--;
        }
    }

    static class Vending {
        private Product product;
        private double Total;



        public Vending(Product product) {
            
            this.product = product;
            this.Total = 0.0;
            
        }

        public boolean purchase(double amount) {
            if (amount >= product.getPrice() && product.getstock() > 0) {
                product.updateStock();
                Total += product.getPrice();
                return true;
            } else {
                return false;
            }
        }

        public double getTotalSales() {
            return Total;
        }
    }
}
