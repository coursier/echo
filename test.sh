#!/usr/bin/env bash
set -e

if [ ! -e jvm/target/pack/bin/echo ]; then
  sbt jvm/pack
fi


runEcho() {
  jvm/target/pack/bin/echo "$@"
}

RED='\033[0;31m'
GREEN='\033[0;32m'
RESET='\033[0m'


passed() {
  echo -e "$GREEN$@ passed$RESET"
}

failed() {
  echo -e "$RED$@ failed$RESET"
}


echoTest1() {
  local MSG="foo"
  local OUTPUT="$(runEcho "$MSG")"
  if [ "$OUTPUT" = "$MSG" ]; then
    passed echoTest1
  else
    echo "Expected $MSG, got $OUTPUT"
    failed echoTest1
  fi
}


echoTest1
