package za.ac.nwu.ac.translator.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import za.ac.nwu.ac.repo.config.RepoConfig;

@Import({RepoConfig.class})
@Configuration
public class TranslatorConfig {
}
