package com.example.demo.entity.flood;

import org.locationtech.jts.geom.Geometry;

import com.bedatadriven.jackson.datatype.jts.serialization.GeometryDeserializer;
import com.bedatadriven.jackson.datatype.jts.serialization.GeometrySerializer;
import com.example.demo.constants.flood.FloodConstant;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import net.postgis.jdbc.geometry.Geometry;

@Entity
@Table(name="flood_assumed_area_shizuoka")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FloodAssumedAreaShizuoka {

	@Id
	@SequenceGenerator(name = FloodConstant.FLOOD_ASSUMED_AREA_SHIZUOKA
	, sequenceName = FloodConstant.FLOOD_ASSUMED_AREA_SHIZUOKA_SEQ
	, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="gid")
	private Long geometryId;
	
	/** 危険区域区分 */
	@Column(name="a31_401")
	private short hazardousAreaClassification;
	
	@Column(name="geom", columnDefinition ="geometry(Multipolygon, 6668)")
	@JsonSerialize(using = GeometrySerializer.class)
	@JsonDeserialize(using = GeometryDeserializer.class)
	//@Type(value=GeometryType.class)
	private Geometry geometry;
}
