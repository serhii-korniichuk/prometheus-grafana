# Prometheus sample app

```Start prom_middleware app:
cd prom_middleware
yarn add express express-prometheus-middleware
node index.js
curl http://127.0.0.1:9091/metrics
curl http://127.0.0.1:9091/hi
curl http://127.0.0.1:9091/hello
```

- Grafana: http://127.0.0.1:3000
- Prometheus: http://127.0.0.1:9000

