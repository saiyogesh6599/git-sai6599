package Project1.UberX.utils;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.PrecisionModel;

import Project1.UberX.dto.PointDTO;
import lombok.experimental.UtilityClass;

@UtilityClass
public class GeometryUtil {

	public static org.locationtech.jts.geom.Point createPoint(PointDTO pointDto) {
		GeometryFactory geoF = new GeometryFactory(new PrecisionModel(), 4326);
		Coordinate coordinate = new Coordinate(pointDto.getCoordinates()[0], pointDto.getCoordinates()[1]);
		return geoF.createPoint(coordinate);

	}
}
