package inventory.repositories;


import inventory.model.request.Sale;
import inventory.table.SaleById;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.InsertOptions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SaleRepositories {

    private CassandraTemplate cassandraTemplate;
    private InsertOptions insertOptions;


    public SaleRepositories(CassandraTemplate cassandraTemplate) {
        this.cassandraTemplate = cassandraTemplate;
        insertOptions = InsertOptions.builder().build();
    }

    public void addSale(Sale sale) {
        SaleById saleById = new SaleById();
        saleById.setTransactionNo(sale.getTransactionNo());
        saleById.setItemId(sale.getItemId());
        saleById.setDescription(sale.getDescription());
        saleById.setQuantity(sale.getQuantity());
        saleById.setTotalPrice(sale.getPrice() * sale.getQuantity());
        saleById.setPrice(sale.getPrice());
        cassandraTemplate.insert(saleById);
    }

    public List<SaleById> getSaleByTransactionId(String id) {
        return cassandraTemplate.select(
                    "SELECT * FROM store.sale_id WHERE transactionNo = '" + id + "'",
                    SaleById.class);

    }

}


