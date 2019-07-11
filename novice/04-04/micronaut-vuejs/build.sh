#!/bin/bash
docker run -v "$PWD:/usr/src/micronaut-vuejs" -w /usr/src/micronaut-vuejs node:8 npm run build
docker run -v "$PWD:/usr/src/micronaut-vuejs" -w /usr/src/micronaut-vuejs openjdk:8u171-alpine3.7 ./gradlew assemble

