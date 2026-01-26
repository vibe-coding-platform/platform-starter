# pipeline-template
Golden Path Pipeline Template
# Ch 22 Production Pipeline Template

Build → Test → Scan → Deploy. 95% compliance enforced.

Stages: 
1. Lint/Pre-commit (patterns)
2. Build/Test (SonarQube)
3. Security (Trivy/Secrets)
4. Deploy (ArgoCD)
