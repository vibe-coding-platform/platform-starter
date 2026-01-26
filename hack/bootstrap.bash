#!/bin/bash
# Ch 23: Self-service service creation
read -p "Service name: " name
cp -r golden-paths/service/ "services/$name"
cd "services/$name"
git init && git add . && git commit -m "Initial golden path"
echo "✅ $name ready. Deploy: git push origin main"
