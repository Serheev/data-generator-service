package com.serheev.datageneratorservice.web.controller;

import com.serheev.datageneratorservice.model.Data;
import com.serheev.datageneratorservice.model.test.DataTestOptions;
import com.serheev.datageneratorservice.service.KafkaDataService;
import com.serheev.datageneratorservice.service.TestDataService;
import com.serheev.datageneratorservice.web.dto.DataDto;
import com.serheev.datageneratorservice.web.dto.DataTestOptionsDto;
import com.serheev.datageneratorservice.web.mapper.DataMapper;
import com.serheev.datageneratorservice.web.mapper.DataTestOptionsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/data")
@RequiredArgsConstructor
public class DataController {

    private final DataMapper dataMapper;
    private final DataTestOptionsMapper dataTestOptionsMapper;

    private final KafkaDataService kafkaDataService;
    private final TestDataService testDataService;

    @PostMapping("/send")
    public void send(@RequestBody DataDto dto) {
        Data data = dataMapper.toEntity(dto);
        kafkaDataService.send(data);
    }

    @PostMapping("/test/send")
    public void testSend(@RequestBody DataTestOptionsDto testOptionsDto) {
        DataTestOptions testOptions = dataTestOptionsMapper.toEntity(testOptionsDto);
        testDataService.sendMessages(testOptions);
    }
}
