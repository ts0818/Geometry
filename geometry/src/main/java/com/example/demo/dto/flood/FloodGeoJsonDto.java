package com.example.demo.dto.flood;

import java.io.Serializable;

import org.locationtech.jts.geom.Geometry;
import org.springframework.stereotype.Component;

import com.bedatadriven.jackson.datatype.jts.serialization.GeometrySerializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FloodGeoJsonDto implements Serializable {

	@JsonProperty(value="srid")
	private Integer srid;
	
	@JsonInclude(JsonInclude.Include.ALWAYS)
	@JsonProperty(value="geometryId")
	private Long geometryId;
	
	@JsonProperty(value="hazardousAreaClassification")
	private short hazardousAreaClassification;
	
	@JsonProperty(value="geometry")
	@JsonSerialize(using = GeometrySerializer.class)
	//@JsonDeserialize(using = CustomGeometryDeserializer.class)
	//@JsonBackReference
	private Geometry geometryInfo;
}
