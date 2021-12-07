package inventory.model.response;

import java.util.List;

public class SaleResponse {

    private Transaction transaction;
    private List<SaleData> sale;

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public List<SaleData> getSale() {
        return sale;
    }

    public void setSale(List<SaleData> sale) {
        this.sale = sale;
    }

    public static class Transaction {
        private double allItemsPrice;

        public double getAllItemsPrice() {
            return allItemsPrice;
        }

        public void setAllItemsPrice(double allItemsPrice) {
            this.allItemsPrice = allItemsPrice;
        }
    }
}
