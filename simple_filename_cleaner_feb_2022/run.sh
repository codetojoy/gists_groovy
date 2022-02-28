#!/bin/bash

set -e

# groovy Runner.groovy {targetDir} {backupDir}

ROOT_DIR=~/src/github/codetojoy/gists_groovy/simple_filename_cleaner_feb_2022

SRC_DIR=$ROOT_DIR/test_data
BACKUP_DIR=$ROOT_DIR/backup

rm -rf $BACKUP_DIR
mkdir $BACKUP_DIR
groovy Runner.groovy $SRC_DIR $BACKUP_DIR

echo "Ready."
