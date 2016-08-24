package goshare.filter;

import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;

import goshare.domain.OrderDirection;

public class PointFilter {
	
	private Point p1;
	private Point p2;
	private int distance;
	private Metrics metrics = Metrics.KILOMETERS;
	private int pageSize = 100;
	private int pageNum = 1;
	private String orderBy = "id";
	private OrderDirection dir = OrderDirection.DESC;
	
	public Point getP1() {
		return p1;
	}
	public void setP1(Point p1) {
		this.p1 = p1;
	}
	public Point getP2() {
		return p2;
	}
	public void setP2(Point p2) {
		this.p2 = p2;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public Metrics getMetrics() {
		return metrics;
	}
	public void setMetrics(Metrics metrics) {
		this.metrics = metrics;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public OrderDirection getDir() {
		return dir;
	}
	public void setDir(OrderDirection dir) {
		this.dir = dir;
	}

}
