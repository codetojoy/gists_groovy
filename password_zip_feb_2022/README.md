
### Summary

* uses [zip4j](https://github.com/srikanth-lingala/zip4j) 2.9.1
    - jar is included in `./lib` folder, just in case
* has two modes: `create` and `open`
* note on Mac, Finder will ask for password and unzips correctly 

### Usage

* set `ZIP_PASSWORD` env var
* see `run_roundtrip.sh` for example  
    - uses `test_data` PDFs which are not in this repo 
* usage: `groovy Runner.groovy [create|open] {targetDir} {zipFile}`
