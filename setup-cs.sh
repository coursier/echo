#!/usr/bin/env bash
set -ev

VERSION="2.0.0-RC6-10"

URL=""
CACHE_BASE=""
CS="./cs"
DO_CHMOD="1"
EXT=""

# https://stackoverflow.com/questions/3466166/how-to-check-if-running-in-cygwin-mac-or-linux/17072017#17072017
if [ "$(expr substr $(uname -s) 1 5)" == "Linux" ]; then
  URL="https://github.com/coursier/coursier/releases/download/v$VERSION/cs-x86_64-pc-linux"
  CACHE_BASE="$HOME/.cache/coursier/v1"
elif [ "$(uname)" == "Darwin" ]; then
  URL="https://github.com/coursier/coursier/releases/download/v$VERSION/cs-x86_64-apple-darwin"
  CACHE_BASE="$HOME/Library/Caches/Coursier/v1"
else
  # assuming Windows…
  URL="https://github.com/coursier/coursier/releases/download/v$VERSION/cs-x86_64-pc-win32.exe"
  env
  CACHE_BASE="$LOCALAPPDATA/Coursier/v1" # TODO Check that
  EXT=".exe"
DO_CHMOD="0"
fi

DEST="$CACHE_BASE/$(echo "$URL" | sed 's@://@/@')"

if [ -f "$DEST" ]; then
  echo "Found $DEST in cache"
else
  mkdir -p "$(dirname "$DEST")"
  TMP_DEST="$DEST.tmp-setup"
  echo "Downloading $URL"
  curl -Lo "$TMP_DEST" "$URL"
  mv "$TMP_DEST" "$DEST"
fi

cp "$DEST" "$CS$EXT"
if [ "$DO_CHMOD" = "1" ]; then
  chmod +x "$CS$EXT"
fi

