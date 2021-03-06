package za.ac.nwu.ac.repo.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@EnableJpaRepositories("za.ac.nwu.ac.repo.persistence")
@EntityScan(basePackages = {"za.ac.nwu.ac.domain.persistence",
})
@PropertySource(value = "classpath:database.properties")
public class RepoConfig {
}
