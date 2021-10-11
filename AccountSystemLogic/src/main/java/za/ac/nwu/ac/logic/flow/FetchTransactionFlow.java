package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.TransactionDto;

import java.util.List;

public interface FetchTransactionFlow {
    List<TransactionDto> getAll();
    List<TransactionDto> convertTo(String currency);
}
