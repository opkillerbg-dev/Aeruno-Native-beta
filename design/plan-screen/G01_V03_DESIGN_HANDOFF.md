# Repository provenance note — 2026-11-22

This HTML and handoff were supplied by the owner from Gemini G01 V03. They are stored as the current proposed Plan candidate. Owner screenshots are stored in `owner-captures/`. The author's own handoff says automated Chromium PNG capture/font verification was not performed in that generation environment; no Android device test is claimed here. See the appended/linked `docs/log/2026-11-22_plan-g01-v03.md` for what was inspected and what remains open.

---

# AERUNO — G01 V03 Design Handoff

**Artifact:** `aeruno-plan-g01-v03.html` (Scroll-aware Editorial Plan — Main Plan Screen)  
**Baselines Preserved Unchanged:** `aeruno-plan-g01.html` (V01), `aeruno-plan-g01-v02.html` (V02)  
**Status:** Design Development · **Owner Approval Pending (NOT Approved)**  
**Scope:** Main Plan screen only. Manage Plan sheet, workout execution, Today/Train/Progress/Me screens, storage, and Android/Compose/Capacitor implementation are intentionally excluded.

---

## 1. Core Design Evolution from V02 to V03

V02 solved alignment, Depth B numeral semantics (`4`), and explicit day categories (`STR / RUN / REST`), but compressed vertical proportions so the entire screen would sit inside a single `844 px` frame. V03 embraces **natural vertical editorial scrolling**, restores the **expressive unequal-height weekly rhythm**, and introduces **multi-layer masked Progressive Blur** paired with **Liquid Glass navigation**:

1. **Uncompressed Editorial Breathing Room:** Releases the artificial single-viewport squeeze. Zone B (`PLAN` + *Home Hybrid*), Zone C (`Progress Hero`), Zone D (`Weekly Rhythm`), Zone E (`Deep Forest Selected Session`), and a restrained schedule-derived Zone F (`COMING UP`) unfold with deliberate pacing rather than cramped padding.
2. **Restored Variable-Height Weekly Rhythm + Undulating Route:** Replaces V02's narrow `16–26 px` bar range with an expressive duration-proportional range (`20–44 px` for active sessions, `8 px` horizontal Sage capsules for rest days) connected by an organic cubic-Bezier route thread that rises over heavier training sessions and dips gently into rest valleys.
3. **Scroll-Aware Multi-Layer Progressive Blur:** Introduces a 6-stratum masked `backdrop-filter` field pinned to the upper viewport edge that stays invisible at `scroll = 0` (keeping the masthead crisp) and ramps smoothly to full depth as typography, contours, light surfaces, and the Deep Forest monolith scroll beneath it—without any opaque bar or hard horizontal cutoff seam.
4. **Liquid Glass Navigation in Motion:** Keeps the canonical 5-tab floating capsule (`Today · Plan · Train · Progress · Me`) fixed over scrolling content with generous bottom scroll padding so the final interactive row and session CTA never become trapped behind navigation.
5. **Grounded Supporting Scroll Context (`COMING UP`):** Derived directly from the remaining upcoming entries in the Week 02 sample schedule (`SAT 21 · TEMPO RUN` and `SUN 22 · REST DAY`) and aligned with the existing Plan functional hierarchy (`design/plan-screen/README.md`) — zero fabricated data fields or filler cards.

---

## 2. Element Hierarchy & Screen Architecture

| Zone | Component | Visual Role & Key Traits |
| :--- | :--- | :--- |
| **Top Edge** | **Progressive Blur Field** (`pointer-events: none`, `z: 35`) | 6 masked blur strata (`1.2px → 19px`) + whisper ivory atmospheric veil; ramps `opacity 0 → 1` across first `34px` of scroll |
| **Zone A** | **Editorial Masthead** (`48px` min-height excl. safe area) | `AERUNO — PERSONAL FITNESS`, horizontal hairline, `Manage` entry point (`≥44px` tap target) |
| **Zone B** | **Programme Identity + Depth B + Depth C + Contours** | Left: terracotta bar + `THE ROUTINE · 4 WEEKS`, `PLAN` (`78px` Variant C), *Home Hybrid* (`29px` Instrument Serif Italic), terracotta dash. Right: monumental solid Deep Forest `4` (`Depth B`), organic sage route with ivory-ringed terracotta waypoints (`Depth C`), fade-to-edge contours |
| **Zone C** | **Current-Week Progress Hero** (`#FFFEFA`, `26px` radius) | Solid foreground surface visibly occluding lower strokes of `4`; 3 clean rows (`WEEK 02 OF 04 · NOV 16–22`, `8 · 3/5 · 40%`, segmented `W1 ✓ · W2 · W3 · W4`). No Chapter Focus strip |
| **Zone D** | **Weekly Rhythm** (`WEEK 02 RHYTHM`) | 7 equal columns with proportional active bars (`20–44px`), `8px` rest capsules, undulating cubic-Bezier route linking elevated nodes, aligned `MON–SUN`, date numerals, and explicit `STR / RUN / REST` labels |
| **Zone E** | **Selected Session Monolith** (`#1F3B30`, `26px` radius) | Generous Deep Forest anchor with localized right-edge contours, `58px` Variant C workout title, category/facts strip, concise description, and `54px` full-pill ivory CTA with `42px` terracotta circular arrow |
| **Zone F** | **Coming Up Sequence** (`COMING UP`) | Schedule-derived upcoming days in Week 02 (`One session at a time.` serif accent); tapping a row selects that day in place |
| **Bottom Edge** | **Floating Liquid Glass Nav** (`z: 40`) | Canonical 5 destinations (`Today · Plan · Train · Progress · Me`), `Plan` active in solid Deep Forest pill, translucent warm-white glass (`rgba(255,254,250,0.78)` + `blur(20px) saturate(135%)`) |

---

## 3. Weekly Rhythm Encoding (`Zone D`)

* **Duration-Proportional Heights:** Active sessions compute height dynamically from `durationMin` across a `20–44 px` band (`25 min Core → 20 px`, `30 min Easy Run → 28 px`, `32 min Tempo Run → 31 px`, `35 min Lower Body → 36 px`, `40 min Upper Body → 44 px`). Rest days (`Wed 18`, `Sun 22`) render as `8 px` horizontal Sage pills near the baseline.
* **Undulating Connecting Route:** Each day's circular node sits `9 px` above its capsule inside a shared `64 px` elevation stage. An inline SVG (`viewBox="0 0 700 64"`, `preserveAspectRatio="none"`, `vector-effect="non-scaling-stroke"`) draws smooth cubic-Bezier segments between exact column centers `(idx * 100 + 50, nodeY)`:
  * **Completed path (`Mon → Thu`):** Solid Deep Forest (`52%` opacity).
  * **Arrival into Today (`Thu → Fri`):** Terracotta (`88%` opacity, `2 px`).
  * **Future progression (`Fri → Sun`):** Muted dashed Deep Forest (`26%` opacity).
* **Independent Today vs. Selected States:** Friday `20` retains its Terracotta capsule, ivory-ringed Terracotta node, and Terracotta underline regardless of which day is tapped. Selecting any other day applies a warm-white `#FFFEFA` highlight container to that column and updates Zone E + Zone F active row indicators without altering Today.

---

## 4. Depth B, Depth C & Topographic Construction

* **Depth B (`4`):** Rendered as solid `#1F3B30` inside an inline SVG positioned upper-right (`z-index: 2`), skewed `-8°` for architectural dynamism and clipped cleanly at the right viewport edge. Zone C (`z-index: 6`) sits cleanly in front of the lower strokes. Multi-digit durations (`PROGRAMME.totalWeeks >= 10`) automatically switch to a compact transform (`font-size: 275`, `scale(0.96, 1.0)`) so two-digit plans remain legible.
* **Depth C (Training Route):** Rendered above the numeral (`z-index: 4`) in the upper-right region only—never overlapping `PLAN`, *Home Hybrid*, or Progress Card values. Uses a `#646E65` outer casing (`3.6px`) and `#DCE5D7` inner sage core (`1.95px`) with ivory-ringed `#C97855` waypoints and restrained start/destination pins. Visually encodes programme progression rather than GPS tracks.
* **Localized Contours:** Confined to two non-competing fields: (1) fade-to-edge contours (`linearGradient` opacity `0 → 0.20 → 0`) bridging `PLAN` and the giant `4`, and (2) restrained sage contours (`0.09–0.22` opacity) inside the right half of the Deep Forest session monolith.

---

## 5. Progressive Blur & Liquid Glass Construction

* **Progressive Blur Implementation:** Built from 6 stacked `position: absolute` layers inside `.progressive-blur-field` (`height: calc(var(--blur-field-h) + env(safe-area-inset-top))`, `pointer-events: none`), stepping `backdrop-filter` across `1.2px → 2.6px → 5px → 8.5px → 13px → 19px` with staggered linear `mask-image` / `-webkit-mask-image` ramps. A light ivory atmospheric gradient (`rgba(243,239,228,0.42)` → `0`) preserves underlying Deep Forest and Ivory colour depth while eliminating any horizontal edge line.
* **Scroll-Aware Activation:** Driven by a lightweight passive scroll listener setting CSS custom property `--blur-progress` (`0` at `scrollTop = 0`, reaching `1` at `scrollTop = 34px`). No heavy per-frame DOM reflows or parallax transforms.
* **Graceful Non-Blur Fallback:** Wrapped in `@supports not ((backdrop-filter: blur(1px)) or (-webkit-backdrop-filter: blur(1px)))` so older WebViews degrade cleanly to a soft top ivory gradient and high-opacity navigation capsule.
* **Liquid Glass Navigation:** Translucent warm-white capsule (`rgba(255,254,250,0.78)`, `blur(20px) saturate(135%)`, `1px` subtle forest border, soft ambient shadow) with solid `#1F3B30` active `Plan` pill and `env(safe-area-inset-bottom)` padding.

---

## 6. Responsive Behaviour & Desktop Inspection Harness

* **`390 × 844` (Primary):** `20px` side gutters, `78px` `PLAN`, `29px` *Home Hybrid*, `58px` session title, `54px` primary CTA, `70px` nav at `16px` bottom inset. First viewport frames Masthead + Programme Identity + Depth B/C + Progress Card + Weekly Rhythm; scrolling reveals the generous Selected Session monolith and Coming Up rows with full bottom clearance.
* **`360 × 800` (Compact):** `16px` gutters, `68px` `PLAN`, `26px` *Home Hybrid*, `20px`-wide rhythm bars, `50px` session title, `50px` CTA, `66px` nav at `12px` bottom inset. All 7 weekday/date/category labels remain crisp with `0px` horizontal overflow.
* **`412 × 915` (Large):** `80px` `PLAN`, `30px` *Home Hybrid*, `60px` session title, `72px` nav at `18px` bottom inset.
* **Desktop-Only Review Harness (`≥ 560px`, hidden on mobile & inside iframes):**
  * Viewport presets: `360×800`, `390×844`, `412×915`, `All 3`
  * Height modes: `First Screen` (scrollable device frame) & `Full Length`
  * Scroll presets: `Top (0px)`, `Mid-Scroll (195px)`, `Session (380px)`, `Bottom`
  * Top material comparison: `Progressive Blur`, `No Blur`, and side-by-side `Blur vs No Blur` split at mid-scroll
  * `Geometry` inspector: live bounding boxes for Masthead, Hero, Progress Card, Weekly Rhythm, Selected Session, Nav, End-of-page clearance above Nav, and Horizontal Overflow check.

---

## 7. Performance Considerations

* Zero external JavaScript frameworks or UI libraries; inline lightweight SVG paths only.
* `prefers-reduced-motion: reduce` disables all swap/transition animations.
* Progressive blur uses 6 stacked `backdrop-filter` layers for smooth desktop/mobile browser exploration; on real Android WebView or Compose targets, multi-layer real-time backdrop blurs can carry non-trivial GPU fill-rate cost and **must be benchmarked on real hardware** (e.g., RenderEffect / AGSL shader in Compose vs. reduced layer count or fallback gradient in WebView).

---

## 8. Proposed Decisions (Pending Owner Approval)

* **Progressive Blur Scroll Ramp:** `0 → 1` opacity across the first `34 px` of scroll so the top masthead remains crisp at rest and blurs naturally as scrolling begins.
* **Progressive Blur Height & Layer Tuning:** `82 px` (+ safe-area top) at `390 px`, `74 px` at `360 px`, `88 px` at `412 px`, using 6 masked strata (`1.2–19 px`).
* **Liquid Glass Nav Tuning:** `rgba(255, 254, 250, 0.78)` with `blur(20px) saturate(135%)` for browser preview.
* **Weekly Rhythm Node Placement:** Positioning each route node `9 px` above its proportional duration bar so the undulating route traces the actual training-load topography of the week.
* **Supporting `COMING UP` Block:** Placing remaining Week 02 schedule entries beneath Zone E using interactive `16 px`-radius warm-white rows to reward vertical scroll without introducing filler.

---

## 9. Open Questions

* **Manage Plan Sheet:** Layout, hierarchy, and art direction for multi-plan switching, Smart Week, builder/personalise, import/export, and AI guide (excluded from V03).
* **Week Switching & Full-Plan Calendar:** Whether `W1–W4` pills become interactive week switchers and where the 28-day whole-plan calendar (`See all days`) lives.
* **Secondary Session Controls:** Placement of `Edit sets/reps`, `Swap`, `Reschedule`, `Finish/Reopen day`, and exercise checklist expansion inside or below Zone E.
* **Masthead Persistence vs. Scroll-Away:** Whether `Manage` should scroll naturally into the upper progressive blur (current editorial V03 behaviour) or remain pinned above the blur field during long scrolls.
* **Conditional States:** Visual treatment for light weeks, readiness adjustments, closed/finished days, and multi-week retest prompts.

---

## 10. Untested Assumptions & Preview Capture Boundary

* **No Headless-Browser PNG Captures Generated in This Environment:** This workspace cannot run headless Chromium to export binary `.png` screenshot attachments. No browser render or font-loading check is claimed as automatically executed here. To capture the exact five review states across `360×800`, `390×844`, and `412×915`, open `aeruno-plan-g01-v03.html` in a desktop browser and use the built-in toolbar presets (`First Screen`, `Mid-Scroll`, `Session`, `Full Length`, `Blur vs No Blur`, `All 3`, and `Geometry`).
* **Preview Web Fonts vs. Bundled App Fonts:** Uses Google Fonts CDN (`Big Shoulders Display`, `Instrument Serif`, `Inter`) for preview; if offline, the browser will fall back to system sans/serif fonts and exact display/Variant C metrics will not match.
* **Platform & Accessibility Unverified:** Real Android device rendering, Kotlin/Compose vs. Capacitor/WebView progressive-blur performance, TalkBack focus order across scrolling overlays, dark mode, and 200% system font scaling remain untested.
