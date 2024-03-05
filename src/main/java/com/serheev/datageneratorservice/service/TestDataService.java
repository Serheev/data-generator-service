package com.serheev.datageneratorservice.service;

import com.serheev.datageneratorservice.model.test.DataTestOptions;

public interface TestDataService {
    void sendMessages(DataTestOptions testOptions);
}
