package com.example.demo;

import io.micrometer.prometheus.PrometheusMeterRegistry;
import io.micrometer.prometheus.PrometheusConfig;
import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.Counter;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        PrometheusMeterRegistry registry = new PrometheusMeterRegistry(PrometheusConfig.DEFAULT);
        Metrics.addRegistry(registry);

        Counter requestCounter = registry.counter("myapp_requests_total");

        port(9091);

        get("/metrics", (req, res) -> {
            res.type("text/plain");
            return registry.scrape();
        });

        get("/hello", (req, res) -> {
            requestCounter.increment();
            return "Hello, Prometheus!";
        });
    }
}
