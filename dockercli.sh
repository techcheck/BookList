#!/bin/bash
docker run -d --name postgres -e POSTGRES_PASSWORD=bookpass -e POSTGRES_USER=bookadmin -e POSTGRES_DB=book -e PGDATA=/var/lib/postgresql/data/pgdata -p 5432:5432 postgres:latest
sleep 10
docker run -d --name link-test --link postgres:docker-pgsql -p 9080:9080 -e DB_HOST=docker-pgsql  -e DB_PORT=5432 -e DB_NAME=book -e DB_USER=bookadmin -e DB_PASSWORD=bookpass techcheck/booklist 


