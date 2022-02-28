#!/bin/bash

set -e

# groovy Runner.groovy create {targetDir} {zipFile}

mkdir -p output
groovy Runner.groovy create ./test_data ./output/test.zip

