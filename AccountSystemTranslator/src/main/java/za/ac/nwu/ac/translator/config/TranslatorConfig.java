package za.ac.nwu.ac.translator.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import za.ac.nwu.ac.repo.config.RepoConfig;
import za.ac.nwu.ac.repo.persistence.AccountTypeRepo;

@Import({RepoConfig.class})
@Configuration
@ComponentScan(basePackages = {
        "za.ac.nwu.ac.translator"
})
public class TranslatorConfig {
    AccountTypeRepo accountTypeRepo;

    @Autowired
    public TranslatorConfig(AccountTypeRepo accountTypeRepo){
        this.accountTypeRepo =accountTypeRepo;
    }
}
