docker build --tag patient-service .
docker run --net=host -d --name patient-service patient-service