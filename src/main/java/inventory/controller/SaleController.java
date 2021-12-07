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
public class SaleController {

    @Autowired
    SaleService saleService;


    @GetMapping(value="sale", produces ="application/json")
    public ResponseEntity<?> getSale(@RequestParam(value= "filter.id" , required=false) String itemId) {
        return ResponseEntity.ok().body(saleService.getTransaction(itemId));
    }

    @PostMapping(value="sale", produces ="application/json")
    public ResponseEntity<?> addSaleDetails(
          @Valid @RequestBody Sale sale) {
        saleService.addTransaction(sale);
        return ResponseEntity.ok().body(sale);
    }




}
