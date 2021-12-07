package inventory.repositories;


import inventory.model.request.Sale;
import inventory.model.request.Transaction;
import inventory.table.SaleById;
import inventory.table.TransactionById;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.InsertOptions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionRepositories {

    private CassandraTemplate cassandraTemplate;
    private InsertOptions insertOptions;


    public TransactionRepositories(CassandraTemplate cassandraTemplate) {
        this.cassandraTemplate = cassandraTemplate;
        insertOptions = InsertOptions.builder().build();
    }

    public void addTransaction(Transaction transaction) {
        TransactionById transactionById = new TransactionById();
        transactionById.setTransactionNo(transaction.getTransactionNo());
        transactionById.setStatus(transaction.getStatus());
        transactionById.setModeOfPayment(transaction.getModeOfPayment());
        transactionById.setPaid(transaction.getPaid());
        transactionById.setCustomerTransactionNo(transaction.getCustomerTransactionNo());
        transactionById.setCustomerId(transaction.getCustomerId());
        transactionById.setCustomerContact(transaction.getCustomerContact());
        transactionById.setTotal(transaction.getTotal());
        cassandraTemplate.insert(transactionById);
    }

    public List<TransactionById> getTransactionByNo(String id) {

        if (id != null) {
            return cassandraTemplate.select(
                    "SELECT * FROM store.transaction_id WHERE transactionNo = '" + id + "'",
                    TransactionById.class);

        } else {
            return cassandraTemplate.select(
                    "SELECT * FROM store.transaction_id",
                    TransactionById.class);
        }

    }

}


