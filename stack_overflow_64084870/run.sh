#!/bin/bash

set -e 

rm -f out.txt error.txt 

gradle clean test -Pspring.profiles.active=TEST_PROFILE

cat out.txt
