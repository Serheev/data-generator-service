package com.serheev.datageneratorservice.web.mapper;

import java.util.List;

public interface Mappable<E, D> {
    E toEntity(D d);

    D toDto(E e);
}
