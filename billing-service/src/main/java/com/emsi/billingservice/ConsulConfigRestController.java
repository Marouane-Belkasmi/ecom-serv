package com.emsi.billingservice;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
public class ConsulConfigRestController {
    private final MyConsulConfig myConsulConfig;
    private final MyVaultConfig myVaultConfig;

    @GetMapping(path = "/myConfig")
    public Map<String, Object> myConfig(){
        return Map.of("consulConfig", myConsulConfig,
                "vaultConfig", myVaultConfig);
    }
}
