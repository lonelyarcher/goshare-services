package Inteface;

import org.springframework.data.mongodb.repository.MongoRepository;

import domain.Point;

public interface PointRepository extends
	MongoRepository<Point, String> {
 
}
