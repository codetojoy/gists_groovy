#!/bin/bash

set -e

# groovy Runner.groovy open {targetDir} {zipFile}

mkdir -p extract
groovy Runner.groovy open ./extract ./output/test.zip 

