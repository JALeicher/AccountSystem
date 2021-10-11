package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.dto.TransactionDto;
import za.ac.nwu.ac.domain.persistence.Transaction;

public interface TransactionTranslator {
    TransactionDto CreateTransaction(TransactionDto transactionDto);
}
