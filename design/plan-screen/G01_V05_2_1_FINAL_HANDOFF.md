# AERUNO — G01 V05.2.1: Final Correction Pass Handoff

**Deliverable Prototype:** `aeruno-manage-plan-g01-v05-2-1.html`  
**Baseline:** `aeruno-manage-plan-g01-v05-2.html` (preserved unchanged)  
**Date:** 2026-11-23  
**Final Status:** **`PROPOSED FOR OWNER APPROVAL`**

**Preservation Statement:** No earlier prototypes (`V01`, `V02`, `V03`, `V05`, `V05.1`, `V05.2`), prior handoff documents, legacy source files, or Android/Capacitor/Compose architecture files were modified or overwritten. Visual design, hierarchy, typography, colours, layout, sticky header, scrolling architecture, progressive blur, liquid glass, and interaction patterns from V05.2 remain strictly locked and unchanged.

---

## 1. Summary of the Three Corrections

### Fix 1 — Smart Week Adherence Sample (`progress` / Step Up)
* **Problem in V05.2:** Displayed `"8 of 9 planned sessions done (89%)"`, which conflicted with both the displayed `Home Hybrid` schedule and `coachcalc.js`'s verified adherence window.
* **Source Verification (`coach.js` & `coachcalc.js`):**
  * `coachcalc.js` `analyze()` computes recent adherence over `win(today - 14, today - 1)` — explicitly **excluding Today** (`Fri 20 Nov`).
  * `coach.js` `gather()` counts non-rest, non-mobility sessions with core items (`planned = t && !t.r && !t.m && core > 0 ? 1 : 0`).
  * In `Home Hybrid` (`9 Nov – 6 Dec`, 5 planned sessions/week: Mon, Tue, Thu, Fri, Sat; 2 rest days: Wed, Sun), the elapsed window prior to Today (`Mon 9 Nov – Thu 19 Nov`) contains **5 planned sessions in Week 1** + **3 planned sessions in Week 2** (`Mon 16`, `Tue 17`, `Thu 19`) = **8 eligible planned sessions**, with all **8 completed**.
  * `8 / 8 = 100%` (`>= 85%` and `!declining`), which cleanly triggers `recommend()` mode **`progress` (`Step up`)** (`top: 1`, `level: clamp(ll + 1, 0, maxL)`).
* **Correction in V05.2.1:**
  * Updated Step Up explanation to: `"Strong two weeks: 8 of 8 planned sessions done (100% — 5 in Week 1, 3 prior to today in Week 2). +1 set on the first two exercises of each strength session, and run/walk intervals one step harder."`
  * Also aligned Upper Body and Lower Body set-count strings to 6 exercises (`3-3-3-3-3-2 → 4-4-3-3-3-2`) so they match V03's displayed `6 EXERCISES` metadata.
  * Clearly retained `"ILLUSTRATIVE PREVIEW"` and `"WHAT CHANGES (ILLUSTRATIVE SAMPLE)"` labels plus the non-live demonstration disclaimer.

### Fix 2 — Switch Plan Week / Date / Progress Consistency (`5K Base Builder`)
* **Problem in V05.2:** `5K Base Builder` displayed `6 WEEKS · 12 OCT – 22 NOV`, `Week 5 of 6`, `22 sessions done`, and `72%`.
  * **Date/Week error:** Relative to the prototype's current date (**Friday, 20 Nov 2026**), a 6-week plan running `Mon 12 Oct – Sun 22 Nov 2026` (`20 + 22 = 42 days = 6 weeks`) is in **Week 6 of 6** (`Mon 16 Nov – Sun 22 Nov`), not Week 5 of 6.
  * **Percentage error:** No integer total session count yields `Math.round(22 / N * 100) === 72%` (`22 / 30 = 73.33% → 73%`; `22 / 31 = 70.97% → 71%`).
* **Correction in V05.2.1:**
  * **`5K Base Builder`:** `6 WEEKS · 12 OCT – 22 NOV` · **`Week 6 of 6 · 22 of 30 sessions done`** · **`73%`** (`5 sessions/week × 6 weeks = 30`; `22 / 30 = 73.33% → 73%`). Confirmation copy automatically reflects `5K Base Builder (73%)`.
  * For uniform clarity across the Switch Plan list without altering layout: `Home Hybrid` displays `Week 2 of 4 · 8 of 20 sessions done` (`40%`), and `Starter Plan` (`4 weeks × 3 days/week` per `starterPlan()` in `sheets-views.js`) displays `Not started · 0 of 12 sessions done` (`0%`).

### Fix 3 — Manual Edit Preservation Label (`Thu 26 · Core & Mobility`)
* **Problem in V05.2:** Used the ambiguous tag `"EDIT KEPT"`.
* **Correction in V05.2.1:**
  * Replaced `"EDIT KEPT"` with **`"MANUAL EDIT PRESERVED"`**.
  * Updated detail text to: `"Move 1 stays untouched at your hand-edited 4 sets · Move 2 steps up 3 → 4 sets (other moves unchanged)"` — matching `coach.js` `apply()` (`if (... || day[k]) return;`) where hand-edited exercises are skipped while other eligible exercises (`k < 2` in `progress` mode) still receive the Smart Week adjustment.
  * Added `flex-wrap: wrap; gap: 4px 8px;` to `.smart-diff-top` so the longer badge never causes horizontal overflow on `360 px` viewports.

---

## 2. Phase 2 — Run Interval Verification Result

* **V05.2 Example Audited:** `"Run/walk Level 2 → Level 3 intervals (4 min jog, 1 min walk)"` (and in Comeback: `"Level 2 → Level 1 intervals (1 min jog, 2 min walk)"`).
* **Actual Source Findings (`sheets-views.js`, `state.js`, `coach.js`, `coachcalc.js`, `coachcalc.test.js`):**
  1. In `sheets-views.js` (`defaultPlan()`) and `state.js` (`IV` / `ivt(w)`), the default 4-week plan defines **0-indexed** run/walk levels `0..3`:
     * `level 0` (Week 1): `[60, 120]` → `1 min jog, 2 min walk`
     * `level 1` (Week 2): `[120, 60]` → `2 min jog, 1 min walk`
     * `level 2` (Week 3): `[240, 60]` → `4 min jog, 1 min walk`
     * `level 3` (Week 4): `[360, 60]` → `6 min jog, 1 min walk`
  2. **Verification Result — NOT VERIFIED as written in V05.2:** Because `coachcalc.js` operates on 0-indexed `level` (`0..3`), `level 3` in code maps to `6 min jog, 1 min walk` (`IVS[3]`), not `4 min jog, 1 min walk` (`IVS[2]`), and `level 1` maps to `2 min jog, 1 min walk` (`IVS[1]`), not `1 min jog, 2 min walk` (`IVS[0]`). Additionally, `jog.weeks` is plan-defined in `vplan()`, and `coach.js` / `coachcalc.js` express Smart Week run adjustments qualitatively (`"one step harder"`, `"back one level"`, `"same run/walk level"`) rather than hardcoding minute timings in the sheet.
* **Action Taken in V05.2.1:** Removed the unverified/off-by-one minute durations across all Smart Week scenarios and replaced them with the verified interval-level progression copy:
  * **Step Up (`progress`):** `INTERVAL +1` — `"Run/walk intervals → one step harder (next interval level in plan)"`
  * **Welcome Back (`comeback`):** `INTERVAL -1` — `"Run/walk intervals → back one level (easier interval step in plan)"`
  * **Lighter Week (`deload`):** `SAME LEVEL` — `"Run/walk intervals → same level (unchanged)"`

---

## 3. Files Actually Inspected & Source Verification Status

| Asset | Access & Inspection Status | Verification Role |
| :--- | :--- | :--- |
| `aeruno-manage-plan-g01-v05-2.html` | Read full HTML/CSS/JS source | Baseline prototype corrected in V05.2.1 |
| `G01_V05_2_FINAL_HANDOFF.md` | Read full Markdown | Baseline handoff reference |
| `web/js/features/coach.js` | Read full source (`14,668 bytes`) | Verified `gather()`, `compute()`, `apply()`, `undo()`, `openSheet()`, manual-edit protection |
| `web/js/features/coachcalc.js` | Read full source (`10,104 bytes`) | Verified `win(today - 14, today - 1)`, `adh >= 0.85` Step Up rule, `buildWeek()`, qualitative run-level copy |
| `tests/coachcalc.test.js` | Read full source (`7,989 bytes`) | Verified 0-indexed run levels (`level 0..3`) and set-cap / comeback / progress assertions |
| `tests/coach_ui_test.py` | Read full source (`7,146 bytes`) | Verified end-to-end Smart Week UI flow, hand-edit protection, and Undo |
| `state.js` & `sheets-views.js` | Read full sources (`9,504` & `39,561 bytes`) | Verified `IV` / `ivt(w)` / `defaultPlan()` `jog.weeks`, `starterPlan()`, per-plan progress storage |
| `plan-ui.js`, `swap.js`, `index.html` | Read full sources | Verified plan/schedule context |
| `OWNER_DECISIONS_OVERRIDE_2026-11-22.md` & `AERUNO_G01_DIRECT_CONTEXT.md` | Read full contents | Verified locked palette, fonts, navigation, and preservation constraints |
| AERUNO Visual Reference Pack (`01`–`08`, `205222.png`–`205229.png`) | Visually inspected all 8 images | Visual direction authority |
| V05 & V05.1 Mobile Captures (`206313`–`206316.jpg`, `206329`–`206332.jpg`) | Visually inspected all 8 captures | Prior mobile verification baseline |
| **V05.2 Mobile Captures** | **Not provided in conversation** | **UNTESTED** (not claimed as inspected) |

---

## 4. QA Results & Testing Boundaries

### Source-Level & Mathematical Verification (Performed)
* **Data Integrity — Verified:**
  * Adherence calculation (`8 of 8 = 100%` across `Mon 9 Nov – Thu 19 Nov`) matches `coachcalc.js` `win(today - 14, today - 1)` and V03/Active Plan's `8 DONE`.
  * `5K Base Builder` date range (`12 Oct – 22 Nov 2026` = 42 days = 6 weeks), current week on `Fri 20 Nov 2026` (`Week 6 of 6`), sessions (`22 of 30`), and percentage (`73%`) are mathematically consistent.
  * `Home Hybrid` (`9 Nov – 6 Dec`, `Week 2 of 4`, `8 of 20`, `40%`) and `Starter Plan` (`4 weeks · 3 days/wk`, `0 of 12`, `0%`) are internally consistent.
  * `"MANUAL EDIT PRESERVED"` badge and Move 1 / Move 2 explanation match `coach.js` `apply()`.
  * Run interval rows contain zero unverified/off-by-one timings.
  * All preview headers and disclaimers clearly distinguish illustrative sample data from live workout analysis.
* **Code & Logic Inspection — Verified:**
  * Strictly one visible `.sheet-header-row` and one visible `.sheet-close-btn` per state (`[hidden] { display: none !important; }`).
  * Smart Week expand/collapse, `scrollSheetBodyToElement()`, `NOT NOW`, `APPLY THIS WEEK`, `UNDO`, Switch Plan selection, `CONFIRM SWITCH` (`CANCEL` / `USE THIS PLAN`), `< Back to Manage`, and Close (`×`, scrim, `Escape`) all verified in JS source with zero syntax issues.
  * `.smart-diff-top` updated with `flex-wrap: wrap` to prevent horizontal overflow from `"MANUAL EDIT PRESERVED"` on `360 px` screens.

### Viewport & Runtime Items Explicitly Marked `UNTESTED`
Because this environment cannot execute a headless browser, live DOM runtime, or physical mobile device render:
* **Live browser rendering at `360 × 800`, `390 × 844`, and `412 × 915`:** **UNTESTED** (verify in desktop browser via built-in `360×800`, `390×844`, `412×915`, `All 3`, `Sheet State`, and `State QA` controls, plus on physical mobile).
* **Live JS execution / console zero-error verification in browser:** **UNTESTED**.
* **Visual check of Smart Week sticky-header clearance, progressive blur, liquid glass, font metrics, and `MANUAL EDIT PRESERVED` wrapping on device:** **UNTESTED**.
* **V05.2 / V05.2.1 mobile captures & real Android WebView/Compose performance:** **UNTESTED**.

---

## 5. Final Status & Stop Condition

* **Status:** **`PROPOSED FOR OWNER APPROVAL`**
* **Stop Condition Honored:** Work stops here. Waiting for owner browser/mobile inspection and explicit approval before beginning any subsequent Plan companion sheet (`Day Actions`, `Full Plan Calendar`), other screens, or implementation phase.