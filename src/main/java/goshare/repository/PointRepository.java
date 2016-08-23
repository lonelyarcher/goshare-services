package goshare.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import goshare.domain.Point;

public interface PointRepository extends
	MongoRepository<Point, String> {
 
}
