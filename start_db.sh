#!/usr/bin/env bash

# This is a bash script to start a Postgresql database container with database-backend.yml as
# as the source file

docker-compose -f database-backend.yml up -d