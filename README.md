Steps to run the setup locally.

1. Clone the repository
2. Go to the parent directory and run the following command to bring up kafka.
```bash
docker-compose up -d
```

3. Go to svc1/ directory and run the following command
```bash
mvn clean install
mvn spring-boot:run
```

4. Go to svc2/ directory and run the following command
```bash
mvn clean install
mvn spring-boot:run
```

5. Now the spring-boot applications are up and running.
6. Import the below postman collection
   (https://api.postman.com/collections/5253278-ca21893d-6a2a-4d1a-a3d2-1812319a6705?access_key=PMAT-01JG233S5KF7QAJGQD08TYHPM01
7. Hit the 1st endpoint to ingest events to Kafka. That should trigger the endpoint in svc2.
8. Bring down svc2 to see retry mechanism in action.