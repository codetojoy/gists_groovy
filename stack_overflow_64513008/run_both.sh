#!/bin/bash

set -e

groovy Original.groovy > tmp.txt
groovy MyVersion.groovy > tmp2.txt

diff tmp.txt tmp2.txt 

echo "Ready."
