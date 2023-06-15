package de.neuefische.cachingscheduling;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AnyController {

    private final AnyService anyService;

    @GetMapping
    public String getHello(@RequestParam String name) throws InterruptedException {
        return anyService.getHello(name);
    }

    @GetMapping("/clear-cache")
    public String clearCache() {
        return anyService.clearCache();
    }
}
