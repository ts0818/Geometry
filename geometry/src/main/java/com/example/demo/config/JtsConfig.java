package com.example.demo.config;

import org.locationtech.jts.geom.Geometry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.example.demo.dto.flood.CustomGeometryDeserializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

@Configuration
public class JtsConfig {

    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Geometry.class, new CustomGeometryDeserializer());
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        mapper.registerModule(module);
        return mapper;
    }
}