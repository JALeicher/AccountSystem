package za.ac.nwu.ac.translator.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import za.ac.nwu.ac.domain.dto.TransactionDto;
import za.ac.nwu.ac.domain.persistence.Account;
import za.ac.nwu.ac.domain.persistence.Transaction;
import za.ac.nwu.ac.repo.persistence.AccountRepo;
import za.ac.nwu.ac.repo.persistence.TransactionRepo;
import za.ac.nwu.ac.translator.TransactionTranslator;

@Transactional
@Component
public class TransactionTranslatorImpl implements TransactionTranslator {

    private TransactionRepo transactionRepo;
    private AccountRepo accountRepo;

    @Autowired
    public TransactionTranslatorImpl(TransactionRepo transactionRepo, AccountRepo accountRepo) {
        this.transactionRepo = transactionRepo;
        this.accountRepo = accountRepo;
    }

    @Override
    public TransactionDto CreateTransaction(TransactionDto transactionDto) {
        Account account = accountRepo.fetchAccountByEmail(transactionDto.getAccount());
        Transaction transaction = transactionRepo.save(transactionDto.BuildTransaction(account));
        return new TransactionDto(transaction);
    }
}
