#!/bin/bash

set -e

ORIGINAL="Doe, John - 20210324 - T3 FOO - BAR - 1.pdf"

groovy Normalizer "$ORIGINAL"

echo "Ready."
