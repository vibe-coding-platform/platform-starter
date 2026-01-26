# Observability Golden Path (Ch 20)

Drop-in defaults for any service created from the golden path.

## Files

- `application-observability.yml` – Spring Boot Actuator + logging
- `prometheus-scrape-config.yml` – Prometheus job fragment
- `grafana-dashboard.json` – Starter dashboard (5xx + latency)

## How to Use

1. **Service:**  
   - Import `application-observability.yml` into your `application.yml` (profile: `obs`).

2. **Platform:**  
   - Merge `prometheus-scrape-config.yml` into your Prometheus config.  
   - Import `grafana-dashboard.json` into Grafana.

This gives every service a **standard, enforced** observability baseline.