#! /bin/sh
#printf "Running %s in %s \n" "$1" "$PWD"
export PYTHONPATH="$PWD"
python3 "$1"
#printf "Command exited with status code %d \n" $?
