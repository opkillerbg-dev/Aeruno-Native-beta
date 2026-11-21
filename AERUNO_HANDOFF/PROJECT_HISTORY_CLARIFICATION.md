# Project history clarification — V1, V2 and Smooth mode

**Owner clarification — 2026-11-21.** This document records the owner's correction to the earlier performance narrative. It supersedes any older suggestion that the owner should test legacy V1 Smooth/Lite mode to diagnose the V2 issue.

## What the owner clarified

- **Legacy V1:** The owner did not have a lag problem using V1 on his own device. V1 was running normally for him.
- **Smooth mode:** The owner added this primarily to help friends using lower-end devices who experienced lag. It was a compatibility/performance option for those devices, not a fix for a V1 lag problem on the owner's phone. The owner reports that contemporary devices can generally run the app normally.
- **V2:** V2 was a failed visual/technical experiment and is not the target product or the UI baseline for the redesign. Its reported lag is historical context only. The project does not need to diagnose, rescue or reproduce V2 before proceeding with AERUNO's new design.

## How future work must use this history

1. Use the legacy V1 source as a **functional reference** for existing capabilities and integrations, not as a constraint on the new visual design.
2. Do not treat V2's lag as evidence that WebView, CSS blur, the GPU or any particular layer is inherently unsuitable. The cause was not measured, and V2 itself is not the target.
3. Do not ask the owner to run the V1 Smooth/Lite-mode comparison as an architecture diagnostic. That test does not answer the question the project needs answered.
4. Do not spend a new account's limited context analysing V2 internals unless the owner identifies a specific reusable component or a concrete question that requires it.
5. Keep the architecture decision open. Evaluate native Compose versus a redesigned WebView only against the **new AERUNO requirements and approved design**, implementation effort, access to required Android features, maintainability, and a focused proof-of-concept if one is genuinely needed.
6. Performance testing, if later justified, must test the proposed new UI/implementation on the owner's current target device. It must not use V2's failure as a proxy for the new design's performance.

## Current interpretation

The failed V2 experiment is closed as a product direction. The redesign moves forward from the approved AERUNO visual direction and the legacy app's functional capabilities. No legacy code, app identity, storage, services or workflows are changed by this clarification.
