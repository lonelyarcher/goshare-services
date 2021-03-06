package goshare.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import goshare.domain.PointOfInterest;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.geo.Box;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;

public interface PointRepository extends MongoRepository<PointOfInterest, String> {
	
		List<PointOfInterest> findByPositionNear(Point point, Distance distance, Sort sort, PageRequest pr);
		
		List<PointOfInterest> findByPositionWithin(Box b, Sort sort, PageRequest pr);
	
}
