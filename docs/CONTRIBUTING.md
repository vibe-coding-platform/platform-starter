# Contributing to Platform Starter (Golden Paths)

This repo is the **single source of truth** for:

- Golden path service template  
- Golden path pipelines  
- Observability defaults

Treat changes here as **production-affecting** for all teams.

---

## Who Can Change What

- **Platform Team (Core):**
  - Owns `golden-paths/` and `.pre-commit-config.yaml`
  - Approves or rejects all changes to templates
- **Domain / Feature Teams:**
  - Can propose changes via Pull Requests
  - Can suggest new examples and docs

---

## Contribution Workflow

1. **Open an Issue**
   - Type: `proposal`, `bug`, or `improvement`
   - Include: context, impact, and affected golden path (service/pipeline/observability)

2. **Create a Branch**
   ```bash
   git checkout -b feature/update-service-template
   
3.**Run Checks**
```bash
cd platform-starter/
chmod +x hack/run-all-checks.sh
./hack/run-all-checks.sh    # Validates service + pipeline + observability

**Readers/contributors:** `git clone → ./hack/run-all-checks.sh → Green → PR.` Perfect Ch 23 enforcement.
