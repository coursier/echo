#!/usr/bin/env bash
set -e

if [ ! -e jvm/target/pack/bin/echo ]; then
  sbt jvm/pack
fi

if [ ! -e props/target/pack/bin/props ]; then
  sbt props/pack
fi


runEcho() {
  jvm/target/pack/bin/echo "$@"
}

runProps() {
  props/target/pack/bin/props "$@"
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

propsTest1() {
  local EXPECTED="$(pwd)"
  local OUTPUT="$(runProps user.dir)"
  if [ "$OUTPUT" = "$EXPECTED" ]; then
    passed propsTest1
  else
    echo "Expected $EXPECTED, got $OUTPUT"
    failed propsTest1
  fi
}


echoTest1

propsTest1
