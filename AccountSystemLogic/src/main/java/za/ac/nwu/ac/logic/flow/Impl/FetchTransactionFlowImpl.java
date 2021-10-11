package za.ac.nwu.ac.logic.flow.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.TransactionDto;
import za.ac.nwu.ac.logic.flow.FetchTransactionFlow;
import za.ac.nwu.ac.translator.TransactionTranslator;

import java.util.List;

@Component
public class FetchTransactionFlowImpl implements FetchTransactionFlow {

    private TransactionTranslator transactionTranslator;

    @Autowired
    public FetchTransactionFlowImpl(TransactionTranslator transactionTranslator) {
        this.transactionTranslator = transactionTranslator;
    }

    @Override
    public List<TransactionDto> getAll() {
        return this.transactionTranslator.getAll();
    }

    @Override
    public List<TransactionDto> convertTo(String currency) {
        return null;
    }
}
