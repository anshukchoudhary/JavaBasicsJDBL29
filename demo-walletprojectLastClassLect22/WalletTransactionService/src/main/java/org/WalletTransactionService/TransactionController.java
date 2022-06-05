package org.WalletTransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	@PostMapping("/transaction")
	public String createTnx(@RequestBody TransactionCreateRequest transactionCreateRequest) {

		String txnId = transactionService.createTnx(transactionCreateRequest.to());

		return "Your transcation has been initiated with transaction Id : " + txnId;

	}

}
