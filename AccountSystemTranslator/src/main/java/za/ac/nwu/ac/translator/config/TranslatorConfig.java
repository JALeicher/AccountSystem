package za.ac.nwu.ac.translator.config;

/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;*/
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import za.ac.nwu.ac.repo.config.RepoConfig;
import za.ac.nwu.ac.repo.persistence.AccountTypeRepo;

@Import({RepoConfig.class})
@Configuration
@ComponentScan(basePackages = {
        "za.ac.nwu.ac.translator"
})
public class TranslatorConfig {
}
