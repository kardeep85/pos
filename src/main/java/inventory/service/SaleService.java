package inventory.service;

import inventory.exception.FailedLoadDB;
import inventory.model.request.Sale;
import inventory.model.response.SaleData;
import inventory.model.response.SaleResponse;
import inventory.repositories.SaleRepositories;
import inventory.repositories.TransactionRepositories;
import inventory.table.SaleById;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SaleService {

    private SaleRepositories saleRepositories;
    private TransactionRepositories transactionRepositories;

    public SaleService(SaleRepositories saleRepositories, TransactionRepositories transactionRepositories) {
        this.saleRepositories = saleRepositories;
        this.transactionRepositories = transactionRepositories;
    }


    public void addTransaction(Sale inventory) {
        try {
            saleRepositories.addSale(inventory);

        } catch (Exception e) {
            throw new FailedLoadDB("Failed to load DB");
        }

    }


    public SaleResponse getTransaction(String id) {
        List<SaleById> saleDetail = saleRepositories.getSaleByTransactionId(id);
        List<SaleData> saleData = new ArrayList<>();
        SaleResponse saleResponse = new SaleResponse();
        saleDetail.stream().forEach(e -> {
            SaleData sale = new SaleData();
            sale.setTransactionNo(e.getTransactionNo());
            sale.setDescription(e.getDescription());
            sale.setItemId(e.getItemId());
            sale.setQuantity(e.getQuantity());
            sale.setPrice(e.getPrice());
            sale.setTotalPrice(e.getTotalPrice());
            saleData.add(sale);
        });
        saleResponse.setSale(saleData);

        SaleResponse.Transaction transaction = new SaleResponse.Transaction();
        transaction.setAllItemsPrice(saleData.stream().mapToDouble(SaleData::getTotalPrice).sum());
        saleResponse.setTransaction(transaction);

        return saleResponse;


    }


}
