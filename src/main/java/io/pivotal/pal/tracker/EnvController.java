package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    String port;
    String memory_limit;
    String index;
    String addr;

    public EnvController(@Value("${PORT:NOT SET}") String port,
                              @Value("${MEMORY_LIMIT:NOT SET}") String memory_limit,
                              @Value("${CF_INSTANCE_INDEX:NOT SET}") String index,
                              @Value("${CF_INSTANCE_ADDR:NOT SET}") String addr){
        this.port=port;
        this.memory_limit=memory_limit;
        this.index=index;
        this.addr=addr;
    }

    @GetMapping("/env")
    public Map<String, String> getEnv() {
        Map<String, String> envMap = new HashMap<>();
        envMap.put("PORT", port);
        envMap.put("MEMORY_LIMIT", memory_limit);
        envMap.put("CF_INSTANCE_INDEX", index);
        envMap.put("CF_INSTANCE_ADDR", addr);
        return  envMap;
    }
}
