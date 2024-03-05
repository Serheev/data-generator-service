package com.serheev.datageneratorservice.web.mapper;

import com.serheev.datageneratorservice.model.test.DataTestOptions;
import com.serheev.datageneratorservice.web.dto.DataTestOptionsDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DataTestOptionsMapper extends Mappable<DataTestOptions, DataTestOptionsDto> {

}
