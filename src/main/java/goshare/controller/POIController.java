package goshare.controller;

import org.springframework.web.bind.annotation.RestController;

import goshare.domain.PointOfInterest;
import goshare.filter.PointFilter;
import goshare.repository.PointRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.geo.Box;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.GeospatialIndex;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author mexu
 * Restful CRUD and Search nearby Point of Interest API
 */

@RestController
public class POIController {
	
	@Autowired
	PointRepository pointRepo;
	
	@Autowired 
	MongoTemplate template;
    
    @RequestMapping("/")
    public String index() {
        return "<p>Welcome to Goshare V1!</p>";
    }
    

    /**
     * @param PointFilter: one refer point and the distance
     * @return list of points nearby
     */
    @RequestMapping(value = "/getNearbyPoints", method = RequestMethod.POST)
    public List<PointOfInterest> getNearby(@RequestBody PointFilter pfilter) {
    	assert(pfilter.getDistance() > 0 && pfilter.getP1() != null);
    	template.indexOps(PointOfInterest.class).ensureIndex( new GeospatialIndex("position") );
    	Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, pfilter.getOrderBy()));
    	PageRequest page = new PageRequest(pfilter.getPageSize(), pfilter.getPageNum());
    	return pointRepo.findByPositionNear(pfilter.getP1() , new Distance(pfilter.getDistance(), pfilter.getMetrics()), sort, page);
    }
    
    
    /**
     * @param PointFilter: 2 points， upper left and down right
     * @return list of points in this box
     */
    @RequestMapping(value = "/getPointsWithinBox", method = RequestMethod.POST)
    public List<PointOfInterest> getWithinBox(@RequestBody PointFilter pfilter) {
    	assert(pfilter.getP1() != null && pfilter.getP2() != null);
    	template.indexOps(PointOfInterest.class).ensureIndex( new GeospatialIndex("position") );
    	Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, pfilter.getOrderBy()));
    	PageRequest page = new PageRequest(pfilter.getPageSize(), pfilter.getPageNum());
    	return pointRepo.findByPositionWithin(new Box(pfilter.getP1(), pfilter.getP2()), sort, page);
    }
    
    /**
     * @param p
     * @return saved/updated point in database
     */
    @RequestMapping(value = "/savePoint", method = RequestMethod.POST)
    public PointOfInterest create(@RequestBody PointOfInterest p) {
    	template.indexOps(PointOfInterest.class).ensureIndex( new GeospatialIndex("position") );
    	return pointRepo.save(p);
    }
    
    @RequestMapping(value = "/readPoint/{pid}", method = RequestMethod.GET)
    public PointOfInterest read(@PathVariable String pid) {
    	return pointRepo.findOne(pid);
    }
    
    
    @RequestMapping(value = "/deletePoint/{pid}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String pid) {
    	pointRepo.delete(pid);
    }
    
    @RequestMapping(value = "/deleteAllPoint", method = RequestMethod.DELETE)
    public void deleteAll() {
    	pointRepo.deleteAll();
    }
    
    /**
     * @return total count of points in database
     */
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public long count() {
    	return pointRepo.count();
    }
    
    
    /**
     * @param pid
     * @return whether this point id is in database
     */
    @RequestMapping(value = "/exists/{pid}", method = RequestMethod.GET)
    public boolean remove(@PathVariable String pid) {
    	return pointRepo.exists(pid);
    }
    
}