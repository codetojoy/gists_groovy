#!/bin/bash

set -e

# groovy Runner.groovy create {targetDir} {zipFile}

ROOT_DIR=~/src/github/codetojoy/gists_groovy/password_zip_feb_2022

ZIP_FILE=$ROOT_DIR/output/test.zip
SRC_DIR=$ROOT_DIR/test_data
OUTPUT_DIR=$ROOT_DIR/output
EXTRACT_DIR=$ROOT_DIR/extract

rm -rf $OUTPUT_DIR
mkdir $OUTPUT_DIR
groovy Runner.groovy create $SRC_DIR $ZIP_FILE

rm -rf $EXTRACT_DIR
mkdir $EXTRACT_DIR
groovy Runner.groovy open $EXTRACT_DIR $ZIP_FILE

echo "diffing files ..."
diff $EXTRACT_DIR/test_file_abc.pdf $SRC_DIR/test_file_abc.pdf
diff $EXTRACT_DIR/test_file_def.pdf $SRC_DIR/test_file_def.pdf

echo "Ready."
