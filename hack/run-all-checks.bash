#!/bin/bash
# Ch 23: Validate ALL golden paths in one command

set -e  # Fail on any error

echo "🔍 Checking golden paths..."

# 1. Service template
echo "✅ Checking service template..."
cd ../golden-paths/service/
mvn validate test -DskipTests=false || { echo "❌ Service template failed"; exit 1; }

# 2. Pipeline lint (yaml syntax)
echo "✅ Checking pipeline yaml..."
yamllint .gitlab-ci.yml || { echo "❌ Pipeline yaml invalid"; exit 1; }

# 3. Observability configs
echo "✅ Checking observability..."
cd ../../observability/
yamllint *.yml || { echo "❌ Observability yaml invalid"; exit 1; }

# 4. Pre-commit hooks
echo "✅ Running pre-commit hooks..."
cd ../../
pre-commit run --all-files || { echo "❌ Pre-commit failed"; exit 1; }

echo "🎉 ALL golden paths VALIDATED!"
