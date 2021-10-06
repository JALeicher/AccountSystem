package za.ac.nwu.ac.logic.config;

import org.springframework.context.annotation.*;
import za.ac.nwu.ac.translator.config.TranslatorConfig;

@Import({TranslatorConfig.class})
@Configuration
public class LogicConfig {
}
