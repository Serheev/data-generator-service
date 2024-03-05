package com.serheev.datageneratorservice.service;

import com.serheev.datageneratorservice.model.Data;

public interface KafkaDataService {
    void send(Data data);
}
