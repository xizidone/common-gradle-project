package tech.tongyu.bct.config;

import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *
 */
@ConfigurationProperties(prefix = "ty.info")
@Component
@Data
public class DsBaseInfoProperties {

    private String username;

    private String pwd;

    private String kiHedgingFun;
}
