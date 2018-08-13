#!/bin/bash

#while ! nc -z ${MYSQL_IP} ${MYSQL_PORT}; do sleep 3; done

#echo "${MYSQL_IP}:${MYSQL_PORT}"

sleep 20;
java -jar Exam1.jar
echo "${MYSQL_IP}:${MYSQL_PORT}"




