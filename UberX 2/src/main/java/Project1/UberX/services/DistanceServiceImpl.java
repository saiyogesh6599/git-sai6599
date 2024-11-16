package Project1.UberX.services;

import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import Project1.UberX.dto.OSRMResponseDTO;

@Service
public class DistanceServiceImpl implements DistanceService {

    private static final String OSRM_API = "http://router.project-osrm.org/route/v1/driving/";

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public Double calculateDistance(Point src, Point dest) {
        try {
            String uri = src.getX() + "," + src.getY() + ";" + dest.getX() + "," + dest.getY();
            OSRMResponseDTO responseDto = restTemplate.getForObject(OSRM_API + uri, OSRMResponseDTO.class);
            return responseDto.getRoutes().get(0).getDistance() / 1000.0; // Convert to kilometers
        } catch (Exception e) {
            throw new RuntimeException("Error fetching data from OSRM: " + e.getMessage(), e);
        }
    }
}


