package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.TransactionDto;

public interface CreateTransactionFlow {
    TransactionDto CreateTransaction(TransactionDto transactionDto);
}
