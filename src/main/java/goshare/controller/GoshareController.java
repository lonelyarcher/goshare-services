package goshare.controller;

import org.springframework.web.bind.annotation.RestController;

import goshare.domain.Point;
import goshare.repository.PointRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    public Point create(@RequestBody Point p) {
    	Point point = pointRepo.save(p);
        return point;
    }
    
    @RequestMapping(value = "/getNearbyPoints", method = RequestMethod.POST)
    public List<Point> getNearby(@RequestBody Point loc) {
    	List<Point> points = pointRepo.findAll();
        return points;
    }
    
}