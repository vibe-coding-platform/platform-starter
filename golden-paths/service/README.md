# Golden Path Service Template (Ch 12 Compliant)

**Fork → Rename → Deploy prod in 15min.**

✅ Saga/CQRS patterns baked  
✅ Observability-ready (Ch 20)  
✅ Pre-commit hooks (Ch 23)  
✅ OpenAPI docs + Health checks  

## 🚀 Quick Start

```bash
mvn clean package
docker build -t orders-service .
docker run -p 8080:8080 orders-service
open http://localhost:8080/swagger-ui.html

## 📁 File Structure (Ch 12 Hexagonal)

service-template/
├── README.md          ← SINGLE FILE with structure section inside
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── ndurai/
│                   └── orders/
│                       ├── domain/
│                       │   ├── OrderRequest.java
│                       │   └── OrderResponse.java
│                       ├── application/
│                       │   └── OrderService.java
│                       └── adapter/
│                           └── in/
│                               └── api/
│                                   └── OrderController.java
└── pom.xml
|__ .gitlab-ci.yml
