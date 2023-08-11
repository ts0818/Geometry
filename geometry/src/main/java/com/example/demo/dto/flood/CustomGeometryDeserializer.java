package com.example.demo.dto.flood;

import java.io.IOException;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryCollection;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.LinearRing;
import org.locationtech.jts.geom.MultiLineString;
import org.locationtech.jts.geom.MultiPoint;
import org.locationtech.jts.geom.MultiPolygon;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.Polygon;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.geojson.GeoJsonReader;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class CustomGeometryDeserializer extends JsonDeserializer<Geometry> {

    @Override
    public Geometry deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        GeoJsonReader reader = new GeoJsonReader();
        Geometry geometry = null;
        try {
            geometry = castTypeForGeometry(reader.read(node.toString()));
        } catch (ParseException e) {
            e.printStackTrace();
            // 例外処理
        }
        return geometry;
    }
    
    private static Geometry castTypeForGeometry (Geometry geometry) {
    	
    	if (geometry instanceof Point) {
    		return (Point)geometry;
    		
    	} else if (geometry instanceof MultiPoint) {
    		return (MultiPoint)geometry;
    		
    	} else if (geometry instanceof LineString) {
    		return (LineString)geometry;
    		
    	} else if (geometry instanceof LinearRing) {
    		return (LinearRing)geometry;
    		
    	} else if (geometry instanceof MultiLineString) {
    		return (MultiLineString)geometry;
    		
    	} else if (geometry instanceof Polygon) {
    		return (Polygon)geometry;
    		
    	} else if (geometry instanceof MultiPolygon) {
    		return (MultiPolygon)geometry;
    		
    	} else if (geometry instanceof GeometryCollection) {
    		return (GeometryCollection)geometry;
    		
    	}
    	
    	return geometry;
    }
    
    
}