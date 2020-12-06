#!/usr/bin/env sh
cd $(dirname $0)
git add -A && git commit -m 'Automatic update'
git pull --rebase && git push
