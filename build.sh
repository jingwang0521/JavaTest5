#!/bin/bash

#echo "构建镜像"

mvn clean package

mv Exam1/target/Exam.jar docker/java/

docker-compose build




