package goshare.controller;

import org.springframework.web.bind.annotation.RestController;

import goshare.domain.PointOfInterest;
import goshare.repository.PointRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class GoshareController {
	
	@Autowired
	PointRepository pointRepo;
    
    @RequestMapping("/")
    public String index() {
        return "<p>Welcome to Goshare!</p>";
    }
    
    @RequestMapping(value = "/addPoint", method = RequestMethod.POST)
    public PointOfInterest create(@RequestBody PointOfInterest p) {
    	PointOfInterest point = pointRepo.save(p);
        return point;
    }
    
    @RequestMapping(value = "/getNearbyPoints/{mile}", method = RequestMethod.POST)
    public List<PointOfInterest> getNearby(@RequestBody Point point, @PathVariable int mile) {
		List<PointOfInterest> points = pointRepo.findByPositionNear(point , new Distance(mile, Metrics.MILES) );
        return points;
    }
    
}