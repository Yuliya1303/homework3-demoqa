package com.yuliya1303.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:com/yuliya1303/config/CredentialsConfig.java")
public interface CredentialsConfig extends Config {
    String loginPassword();
}

