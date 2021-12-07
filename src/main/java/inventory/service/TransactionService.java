package inventory.service;

import inventory.exception.FailedLoadDB;
import inventory.model.request.Sale;
import inventory.model.request.Transaction;
import inventory.repositories.SaleRepositories;
import inventory.repositories.TransactionRepositories;
import inventory.table.SaleById;
import inventory.table.TransactionById;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    private TransactionRepositories transactionRepositories;

    public TransactionService(TransactionRepositories transactionRepositories) {
        this.transactionRepositories = transactionRepositories;
    }


    public void addTransaction(Transaction transaction) {
        try {
            transactionRepositories.addTransaction(transaction);
        }catch (Exception e)
        {
            System.out.println(e);
            throw new FailedLoadDB("Failed to load DB");
        }

    }


    public List<TransactionById> getTransactionById(String transactionId) {
        return transactionRepositories.getTransactionByNo(transactionId);
    }

    public Map<String,String> getNewTransactionById() {
        return Collections
                .singletonMap("transaction",String.valueOf(transactionRepositories.getTransactionByNo(null).size() +1));

    }


}
