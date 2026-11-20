# Round 2 export verification

## Result

The HTML and PDF exports with the filename suffix `(design round 1)` actually contain the latest Round 2 boards. The filename and HTML `<title>` were not updated by the artifact exporter; they are stale metadata.

## What was checked

- The HTML is a standalone bundled page with three embedded board documents (Today strength, navigation states, Today running).
- The visible navigation board uses **Train** as the active destination.
- The navigation board includes the live workout pill, paused state, and compact scroll dock.
- The running board contains the Tempo Run hero and running-specific stats and workout list.
- The three PDF pages visually match those same boards. The PDF was rendered to PNG and inspected page by page.

## Use

- Use the HTML as the richer structural reference: its bundled board HTML, CSS, typography and graphics can be inspected and adapted.
- Use the PDF and `boards/*.png` as faithful visual references.
- The HTML is a standalone export/snapshot, not a guaranteed importable Claude project or a full app source repository. A new Claude session can inspect it and continue editing/rebuilding the design from this source.

## Source files

- `claude-artifact-export.html` — original HTML bytes, filename normalized in this archive.
- `claude-artifact-export.pdf` — original PDF bytes, filename normalized in this archive.
- HTML SHA-256: `0d620656dceb43e10529ad323f03091bba8a723ec151c743de9126a83e698f73`
- PDF SHA-256: `e9e31c71b5d41cfcd484526e3baea11e33641089edc11f99ebceaba249e19dd4`

Do not classify these exports as Round 1 based only on their filenames or `<title>`.
