#!/bin/bash

cd /home/tao/IdeaProjects/first-proj/

echo "# java8es-test" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/GeneralTao2/java8es-test.git
git push -u origin main
