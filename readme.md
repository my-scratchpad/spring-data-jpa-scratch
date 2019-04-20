# spring-data-jpa-scratch

## 테스트 DB 설정

```shell
$ docker-compose build
$ docker-compose up -d
$ docker exec -it test-psql bash

# docker 접속
root@dd755ff299ef:/# psql -d test -U foo

# psql 접속
test=# \dt
test=# select 1;
```

