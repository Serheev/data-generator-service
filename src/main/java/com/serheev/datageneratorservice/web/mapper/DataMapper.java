package com.serheev.datageneratorservice.web.mapper;

import com.serheev.datageneratorservice.model.Data;
import com.serheev.datageneratorservice.web.dto.DataDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DataMapper extends Mappable<Data, DataDto> {
}
