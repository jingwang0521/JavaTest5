#!/bin/bash


## 分页查询
curl http://localhost:8080/film/films?page=1&pageSize=1
echo "------------"



## 登录
curl -l -H"Content-type:application/json" -X PUT -d '{
"name":"MARY",
"password":"SMITH"
}'  http://localhost:8080/customer/login
echo "------------"

## 添加
curl -l -H"Content-type:application/json" -X PUT -d '{
"lastName":"111",
"firstName":"11111",
"email":"23322@",
"address":"47 MySakila Drive"
}' http://localhost:8080/customer/add

echo "------------"

## 更新
curl -l -H"Content-type:application/json" -X PUT -d '{
"lastName":"111",
"firstName":"11111",
"email":"23322@",
"address":"47 MySakila Drive","customerId":602
}' http://localhost:8080/customer/update
echo "------------"

## 删除
 curl -X DELETE http://localhost:8080/customer/602

echo "------------"