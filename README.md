# 📈 Prometheus-Grafana Java Monitoring App

This project demonstrates how to monitor a Java application using **Prometheus** and **Grafana**. It includes:

- A **Java app** that exposes metrics in Prometheus format.
- **Prometheus** for collecting those metrics.
- **Grafana** for visualizing the metrics.

All components are containerized using Docker for easy deployment.

## 🧱 Architecture

```
+---------------------+          +---------------------+          +---------------------+
|     Java App        |  --->    |     Prometheus      |  --->    |       Grafana       |
| (metrics /metrics)  |          |  (metrics scrape)   |          |   (visualization)   |
+---------------------+          +---------------------+          +---------------------+
```

- **Java App**: Exposes metrics via `/metrics` endpoint.
- **Prometheus**: Scrapes the metrics from Java App.
- **Grafana**: Visualizes metrics collected by Prometheus.

## 📂 Project Structure

```
prometheus-grafana/
├── Dockerfile
├── docker-compose.yaml
├── pom.xml
├── src/
│   └── main/java/com/example/demo/App.java
├── monitoring/
│   └── grafana/total-http-requests-dashboard.json
└── prometheus/prometheus.yml
```

## 🚀 Quick Start

### 🔧 Requirements

- Docker
- Docker Compose

### 🛠 Build the Java App

```bash
mvn clean package
```

This will generate `prometheus-demo-1.0-SNAPSHOT-shaded.jar` in the `target/` directory.

### 🐳 Start the Stack

```bash
docker-compose up --build
```

## 🌐 Access Services

- **Java App Metrics**: [http://localhost:9091/metrics](http://localhost:9091/metrics)
- **Prometheus UI**: [http://localhost:9090](http://localhost:9090)
- **Grafana UI**: [http://localhost:3000](http://localhost:3000)

## 📊 Grafana Setup

### 🔐 Login
- **Username**: `admin`
- **Password**: `admin`

### ➕ Add Prometheus as Data Source

1. Go to **Configuration > Data Sources**
2. Click **Add data source**
3. Choose **Prometheus**
4. Set URL to: `http://prometheus:9090`
5. Click **Save & Test**

### 📈 Import Dashboard

1. Go to **Dashboards > Manage**
2. Click **Import**
3. Upload the file `monitoring/grafana/total-http-requests-dashboard.json`
4. Click **Import**

## 📥 Metrics

### 🚪 Application Endpoints

- ``/metrics`` - exposes all collected metrics in Prometheus format. 
    
  This is automatically handled by Micrometer with Prometheus support.


- ``/hello`` - returns a plain text response:
    ```plain
    Hello World!
    ```

    Every request to this endpoint increments a custom metric:

    ```plain
    myapp_requests_total
    ```

## 📘 Resources

- [Prometheus Documentation](https://prometheus.io/docs/introduction/overview/)
- [Grafana Documentation](https://grafana.com/docs/grafana/latest/)
- [Micrometer Metrics](https://micrometer.io/)


## 📄 License

This project is a modified version of [vtatarin/prometheus-lab](https://github.com/vtatarin/prometheus-lab). All rights belong to the original author.
