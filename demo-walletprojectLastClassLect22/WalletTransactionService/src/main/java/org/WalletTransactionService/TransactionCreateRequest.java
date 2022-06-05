package org.WalletTransactionService;

import java.util.Date;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionCreateRequest {

	private Integer senderUserId;

	private Integer receiverUserId;

	private Double amount;

	private String purpose;

	public Transaction to() {
		return Transaction.builder().senderUserId(senderUserId).receiverUserId(receiverUserId).amount(amount)
				.purpose(purpose).build();

	}

}
