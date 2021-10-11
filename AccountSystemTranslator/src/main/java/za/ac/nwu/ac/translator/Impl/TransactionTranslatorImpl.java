package za.ac.nwu.ac.translator.Impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import za.ac.nwu.ac.domain.dto.TransactionDto;
import za.ac.nwu.ac.domain.persistence.Account;
import za.ac.nwu.ac.domain.persistence.Transaction;
import za.ac.nwu.ac.repo.persistence.AccountRepo;
import za.ac.nwu.ac.repo.persistence.TransactionRepo;
import za.ac.nwu.ac.translator.TransactionTranslator;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class TransactionTranslatorImpl implements TransactionTranslator {

    Logger logger = LoggerFactory.getLogger(TransactionTranslator.class);

    private TransactionRepo transactionRepo;
    private AccountRepo accountRepo;

    @Autowired
    public TransactionTranslatorImpl(TransactionRepo transactionRepo, AccountRepo accountRepo) {
        this.transactionRepo = transactionRepo;
        this.accountRepo = accountRepo;
    }

    @Override
    public TransactionDto CreateTransaction(TransactionDto transactionDto) {
        try{
            Account account = accountRepo.fetchAccountByEmail(transactionDto.getAccount());
            Transaction transaction = transactionRepo.save(transactionDto.BuildTransaction(account));
            return new TransactionDto(transaction);
        }catch (Exception e){
            logger.error("Failed to create new transaction");
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<TransactionDto> getAll() {
        try{
            List<TransactionDto>transactionDtos = new ArrayList<>();
            for (Transaction i : transactionRepo.findAll()
            ) {
                transactionDtos.add(new TransactionDto(i));
            }
            logger.trace("Grabbed all transactions");
            return transactionDtos;
        }
        catch (Exception e){
            logger.error("Something went wrong trying to fetch transactions :"+e);
            throw new RuntimeException(e);
        }

    }


}
