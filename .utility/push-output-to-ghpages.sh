#!/bin/bash

REPO=concordion/concordion-excel-extension-tutorial

if [ "$TRAVIS_REPO_SLUG" == "$REPO" ] && [ "$TRAVIS_JDK_VERSION" == "oraclejdk8" ] && [ "$TRAVIS_PULL_REQUEST" == "false" ] && [ "$TRAVIS_BRANCH" == "master" ]; then

  echo -e "Publishing output...\n"

  cp -R build/reports/spec $HOME/spec-latest

  cd $HOME
  git config --global user.email "travis@travis-ci.org"
  git config --global user.name "travis-ci"
  git clone --quiet --branch=gh-pages https://${GH_TOKEN}@github.com/$REPO gh-pages > /dev/null
  
  cd gh-pages
  git rm -rf ./spec
  cp -Rf $HOME/spec-latest ./spec
  git add -f .
  git commit -m "Latest output on successful travis build $TRAVIS_BUILD_NUMBER auto-pushed to gh-pages"
  git push -fq origin gh-pages > /dev/null

  echo -e "Published output to gh-pages.\n"
  
fi