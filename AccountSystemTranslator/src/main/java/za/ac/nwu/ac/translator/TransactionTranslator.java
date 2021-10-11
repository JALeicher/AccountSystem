package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.dto.TransactionDto;
import za.ac.nwu.ac.domain.persistence.Transaction;

import java.util.List;

public interface TransactionTranslator {
    TransactionDto CreateTransaction(TransactionDto transactionDto);
    List<TransactionDto> getAll();
}
