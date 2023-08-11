package com.example.demo.service.impl.flood;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LinearRing;
import org.locationtech.jts.geom.MultiPolygon;
import org.locationtech.jts.geom.Polygon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.flood.FloodGeoJsonDto;
import com.example.demo.entity.flood.FloodAssumedAreaShizuoka;
import com.example.demo.repository.flood.FloodAssumedAreaShizuokaRepository;
import com.example.demo.service.flood.FloodAssumedAreaShizuokaService;

@Service
public class FloodAssumedAreaShizuokaServiceImpl implements FloodAssumedAreaShizuokaService {

	@Autowired
	private FloodAssumedAreaShizuokaRepository floodAssumedAreaShizuokaRepository;
	
	@Override
	public List<FloodAssumedAreaShizuoka> findAll() {
		// 全件検索
		List<FloodAssumedAreaShizuoka> floodAssumedAreaShizuoka = floodAssumedAreaShizuokaRepository.findAll();
		return floodAssumedAreaShizuoka;
	}

	@Override
	public FloodAssumedAreaShizuoka findById(Long gid) {
		// 検索（gid）
		Optional<FloodAssumedAreaShizuoka> floodAssumedAreaShizuoka = floodAssumedAreaShizuokaRepository.findById(gid);
		return floodAssumedAreaShizuoka.isPresent() ? floodAssumedAreaShizuoka.get() : null;
	}

	@Override
	public int insert(FloodAssumedAreaShizuoka floodAssumedAreaShizuoka) {
		// 登録
		floodAssumedAreaShizuokaRepository.save(floodAssumedAreaShizuoka);
		return 1;
	}

	public FloodAssumedAreaShizuoka createSaveData(FloodGeoJsonDto floodGeoJsonDto) {
        // input check
		if (Objects.isNull(floodGeoJsonDto) 
				|| Objects.isNull(floodGeoJsonDto.getGeometryInfo())
				|| Objects.isNull(floodGeoJsonDto.getGeometryInfo().getCoordinates())) {
			return null;
		}
		
		// create a MultiPolygon object
        GeometryFactory geometryFactory = new GeometryFactory();
        
        Coordinate[] coordinates = floodGeoJsonDto.getGeometryInfo().getCoordinates();
        LinearRing linearRing = geometryFactory.createLinearRing(coordinates);
        Polygon polygon = geometryFactory.createPolygon(linearRing);
        MultiPolygon multiPolygon = geometryFactory.createMultiPolygon(new Polygon[] {polygon});
        
        FloodAssumedAreaShizuoka floodAssumedAreaShizuoka = new FloodAssumedAreaShizuoka();
		multiPolygon.setSRID(
				Objects.nonNull(floodGeoJsonDto.getSrid()) 
				  ? floodGeoJsonDto.getSrid() 
				  : 6668
		);
        floodAssumedAreaShizuoka.setGeometry(multiPolygon);
        
        return floodAssumedAreaShizuoka;
	}
	
}
