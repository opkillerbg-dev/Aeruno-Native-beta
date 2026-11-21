# Architecture investigation override — 2026-11-21

This note supersedes the old proposed evidence item "Does the legacy lag disappear in Lite mode?" and any instruction to investigate V2 lag as a prerequisite to choosing the new architecture.

## Owner's clarification

- V1 ran normally for the owner.
- Smooth mode was made primarily to help friends on lower-end devices, not to fix an owner-reported V1 lag issue.
- V2 was a failed experiment and is not the target product. The new AERUNO design is not an effort to recover V2.

## Consequences

- Do not ask the owner to test V1 Smooth/Lite mode to decide between native Compose and WebView.
- Do not inspect or profile V2 unless the owner asks a specific question about a particular component worth reusing.
- Do not use the V2 lag report as evidence that WebView, CSS blur, GPU composition or a platform is inherently unsuitable.
- Keep the architecture undecided for now. First finish the design foundation and representative screen designs. When implementation planning begins, compare paths using the new design's actual requirements, legacy functional integration needs, maintainability, and a small, relevant proof-of-concept only if it resolves a real uncertainty.
- If performance testing later becomes necessary, test the new proposed UI on the owner's current device. Do not use the failed V2 experiment as a proxy.

No code or architecture decision is made by this override.
