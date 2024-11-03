package Project1.UberX.configs;

import org.locationtech.jts.geom.Point;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import Project1.UberX.dto.PointDTO;
import Project1.UberX.utils.GeometryUtil;

@Configuration
@EnableJpaAuditing
public class MapperConfig {

	@Bean
	public ModelMapper modelMapper() {
		 ModelMapper modelMapper=new ModelMapper();
		 modelMapper.typeMap(PointDTO.class, Point.class).setConverter(context -> {
			 PointDTO pointDTO= context.getSource();
			 return GeometryUtil.createPoint(pointDTO);
		 });
		 modelMapper.typeMap(Point.class, PointDTO.class).setConverter(context -> {
			 Point point=context.getSource();
			 double coordinates[]= {
					 point.getX(),
					 point.getY()
			 };
			 return new PointDTO(coordinates);
		 });
		 
		return modelMapper;
		 
		 
	}

}
