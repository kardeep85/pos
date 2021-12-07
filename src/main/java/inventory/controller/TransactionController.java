package inventory.controller;


import inventory.model.request.Sale;
import inventory.model.request.Transaction;
import inventory.service.SaleService;
import inventory.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("v1")
public class TransactionController {

    @Autowired
    TransactionService transactionService;



    @GetMapping(value = "transaction", produces = "application/json")
    public ResponseEntity<?> getTransactionNo(@RequestParam(value = "filter.id", required = false) String id) {
        return ResponseEntity.ok().body(transactionService.getTransactionById(id));
    }

    @GetMapping(value = "newTransaction", produces = "application/json")
    public ResponseEntity<?> getNewTransactionNo() {
        return ResponseEntity.ok().body(transactionService.getNewTransactionById());
    }

    @PostMapping(value = "transaction", produces = "application/json")
    public ResponseEntity<?> addTransactionNo(
            @Valid @RequestBody Transaction transaction) {
        transactionService.addTransaction(transaction);
        return ResponseEntity.ok().body(transaction);
    }


}
