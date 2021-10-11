package za.ac.nwu.ac.logic.flow.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.TransactionDto;
import za.ac.nwu.ac.logic.flow.CreateTransactionFlow;
import za.ac.nwu.ac.translator.TransactionTranslator;

@Component
public class CreateTransactionFlowImpl implements CreateTransactionFlow {

    private TransactionTranslator transactionTranslator;

    @Autowired
    public CreateTransactionFlowImpl(TransactionTranslator transactionTranslator) {
        this.transactionTranslator = transactionTranslator;
    }

    @Override
    public TransactionDto CreateTransaction(TransactionDto transactionDto) {
        return this.transactionTranslator.CreateTransaction(transactionDto);
    }
}
