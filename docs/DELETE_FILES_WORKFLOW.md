# Guarded GitHub file-deletion workflow

Workflow file: `.github/workflows/delete-files.yml`

This is a manual-only GitHub Actions workflow for deleting tracked files or whole directories from the `main` branch of `opkillerbg-dev/Aeruno-Native-beta`.

## Install once

The existing `Apply update` workflow deliberately skips `.github/` files. Add `delete-files.yml` manually:

1. Open the repository on GitHub.
2. Choose **Add file → Create new file**.
3. Enter the path `.github/workflows/delete-files.yml`.
4. Paste the complete contents of the supplied workflow file.
5. Commit to `main`.

No repository secret or personal access token is needed. The workflow uses GitHub's automatically provided token with read permission for preview and write permission only in the separate deletion job.

## How to use it

1. Open **Actions → Delete repository paths (guarded) → Run workflow**.
2. Make sure the branch is `main`.
3. Enter one repository-relative path per line. Exact files and directories are supported. Directory deletion is recursive for tracked files.
4. Leave **Dry run** enabled and run it first.
5. Inspect the workflow summary. It lists every exact tracked file selected. Nothing is deleted during a dry run.
6. To execute, run the workflow again with **Dry run** disabled and enter exactly:

   `DELETE opkillerbg-dev/Aeruno-Native-beta`

7. The workflow revalidates the same commit and manifest, deletes only the previewed files, and creates a commit on `main`.

## Safety rules

- Manual trigger only; automatic pushes never invoke deletion.
- Runs only from `main`.
- Dry run is enabled by default.
- Real deletion requires the exact repository confirmation phrase.
- Maximum 10 requested paths and 100 tracked files per run.
- Wildcards, absolute paths, `..`, root deletion and overlapping path requests are rejected.
- Protected: `.git/`, `.github/`, `app/`, `gradle/`, `AERUNO_HANDOFF/legacy-reference/`, and critical root/current handoff files.
- Only Git-tracked files are deleted. Empty directories are not represented in Git.
- The preview and execution jobs are separate. The preview job has read-only repository permission; only the deletion job has `contents: write`.
- The deletion job checks that it is operating on the exact commit that was previewed. If the branch moves, the push will not overwrite newer work.
- This workflow does not alter the legacy application repository or modify the contents of the protected legacy-reference archive.

## Example: remove the obsolete staging folder

For the currently documented cleanup, enter:

```text
aeruno_update
```

Run a dry run first and inspect the exact file list. Only execute after confirming that the listed files are the intended obsolete staging files.

## Limitations

This workflow deletes repository files and commits the deletion. It does not delete Git history; previous file contents remain available in earlier commits. It does not delete GitHub Actions artifacts or releases. It does not modify other branches.
