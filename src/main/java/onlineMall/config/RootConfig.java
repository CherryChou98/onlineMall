package onlineMall.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @ Package: config
 * @ Author     ：linsola
 * @ Date       ：Created in 17:57 2018/12/14
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
@Configuration
@ComponentScan(basePackages={"onlineMall"},
        excludeFilters={
                @ComponentScan.Filter(type= FilterType.ANNOTATION, value=EnableWebMvc.class)
        })
public class RootConfig {
}
