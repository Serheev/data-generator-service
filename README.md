# Data generator service

This is data generator service for Kafka [Apache Kafka](https://kafka.apache.org).

## Quick start:
Step 1. Get Kafka and extract it to your directory [Kafka Quickstart](https://kafka.apache.org/quickstart)
```
$ tar -xzf kafka_2.13-3.7.0.tgz
$ cd kafka_2.13-3.7.0
```
Step 2. Go to the Kafka directory and Start the Kafka Environment
```
# Start the ZooKeeper service

# Mac/Linux
$ bin/zookeeper-server-start.sh config/zookeeper.properties

# Windows
$ bin/windows/zookeeper-server-start.bat config/zookeeper.properties
```
Step 3. Open another terminal session and run
```
# Start the Kafka broker service

# Mac/Linux
$ bin/kafka-server-start.sh config/server.properties

# Windows
$ bin/windows/kafka-server-start.bat config/server.properties
```
Step 4. You can use console consumer to view messages produced on some topic https://stackoverflow.com/a/44239091
```
# Open the consumer console to view messages produced on a specific topic

# Mac/Linux
$ bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic data-temperature --from-beginning

# Windows
$ bin/windows/kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic data-temperature --from-beginning
```

## Usage

To start an application you need to pass variables to `.env` file.

Application is running on port `8081`.

All insignificant features (checkstyle, build check, dto validation) are not presented.

Application has two endpoints:
* POST `/api/v1/data/send`
#### Example JSON (send data of a specific type from sensor #1)
```json
{
  "sensorId": 1,
  "timestamp": "2024-03-04T12:10:00",
  "measurement": 15.3,
  "measurementType": "TEMPERATURE"
}
```

* POST `/api/v1/data/test/send`
#### Example JSON (every 5 seconds send random data from sensor No. 1)
```json
{
  "delayInSeconds": 5,
  "measurementTypes": [
    "POWER",
    "VOLTAGE",
    "TEMPERATURE"
  ]
}
```