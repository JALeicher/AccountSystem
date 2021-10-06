package za.ac.nwu.ac.web.sb.config;

import org.springframework.context.annotation.*;
import za.ac.nwu.ac.logic.config.LogicConfig;

@Import({LogicConfig.class})
@Configuration
@ComponentScan(basePackages = {
        "za.ac.nwu.ac.web.sb.controller",
        "za.ac.nwu.ac.web.sb.exception",
})
public class WebConfig {
}