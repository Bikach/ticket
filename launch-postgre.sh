#!/bin/bash

if [ -z "$1" ]; then
    echo "Usage: $0 [start|stop]"
    exit 1
fi

if docker inspect db-ticket &> /dev/null; then
    if [ "$1" == "start" ]; then
        echo "The Docker container 'db-ticket' is already running."
    elif [ "$1" == "stop" ]; then
         docker stop db-ticket && docker rm db-ticket
        echo "Docker container 'db-ticket' stopped."
    else
        echo "Unrecognized command: $1"
        exit 1
    fi
else
    if [ "$1" == "start" ]; then
        docker run --name db-ticket -p 5455:5432 -e POSTGRES_USER=postgresUser -e POSTGRES_PASSWORD=postgresPW -e POSTGRES_DB=postgresDB -d postgres
        echo "Docker container 'db-ticket' started."
    elif [ "$1" == "stop" ]; then
        echo "The Docker container 'db-ticket' does not exist."
    else
        echo "Unrecognized command: $1"
        exit 1
    fi
fi
