#!/usr/bin/env bash
set -euo pipefail

sbt -Dunison.reports=true test
./error_counts.sh
