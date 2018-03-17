package P3;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

public class FriendShipGraphTest {
	FriendShipGraph graph = new FriendShipGraph();
    Person paul = new Person("Paul");
    Person james = new Person("James");
    Person harden = new Person("Harden");
    Person jordan = new Person("Jordan");
    @Test
	public  void testaddVertex() {
		assert(FriendShipGraph.addVertex(paul));
		assert(FriendShipGraph.addVertex(james));
		assert(FriendShipGraph.addVertex(harden));
		assert(FriendShipGraph.addVertex(jordan));
	}
    @Test
    public void testaddEdge() {
    	assert(FriendShipGraph.addEdge(james, harden));
    	assert(FriendShipGraph.addEdge(harden, james));
    	assert(FriendShipGraph.addEdge(paul, harden));
    	assert(FriendShipGraph.addEdge(harden, paul));
    	assert(FriendShipGraph.addEdge(james, paul));
    	assert(FriendShipGraph.addEdge(paul, james));
    }
    @Test
    public void testgetDistance() {
    	FriendShipGraph.addVertex(paul);
    	FriendShipGraph.addVertex(james);
    	FriendShipGraph.addVertex(harden);
    	FriendShipGraph.addVertex(jordan);
    	FriendShipGraph.addEdge(james, harden);
    	FriendShipGraph.addEdge(harden, james);
    	FriendShipGraph.addEdge(paul, harden);
    	FriendShipGraph.addEdge(harden, paul);
    	FriendShipGraph.addEdge(james, paul);
    	FriendShipGraph.addEdge(paul, james);
    	assertEquals(0, FriendShipGraph.getDistance(james, james));
    	assertEquals(1, FriendShipGraph.getDistance(james, harden));
    	assertEquals(1, FriendShipGraph.getDistance(james, paul));
    	assertEquals(-1, FriendShipGraph.getDistance(james, jordan));
    }
}
