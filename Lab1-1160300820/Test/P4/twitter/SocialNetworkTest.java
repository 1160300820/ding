/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package twitter;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import twitter.SocialNetwork;

public class SocialNetworkTest {

    /*
     * TODO: your testing strategies for these methods should go here.
     * See the ic03-testing exercise for examples of what a testing strategy comment looks like.
     * Make sure you have partitions.
     */
	    private static final Instant d1 = Instant.parse("2016-02-17T10:00:00Z");
	    private static final Instant d2 = Instant.parse("2016-02-17T11:00:00Z");
	    private static final Instant d3 = Instant.parse("2016-02-17T11:10:00Z");
	    private static final Instant d4 = Instant.parse("2016-02-17T11:20:00Z");
	    private static final Instant d5 = Instant.parse("2016-02-17T11:30:00Z");
	    
	    private static final Tweet tweet1 = new Tweet(1, "alyssa", "is it reasonable @bbi to talk about rivest so much?", d1);
	    private static final Tweet tweet2 = new Tweet(2, "bbitdiddle", "rivest talk in 30 minutes #hype", d2);
	    private static final Tweet tweet3 = new Tweet(3, "bbi", "rivest talk in 30 min, @paul utes #hype", d3);
	    private static final Tweet tweet4 = new Tweet(4, "bbit", "rivest talk@hello #hype", d4);
	    private static final Tweet tweet5 = new Tweet(5, "itdiddle", "rivest @pop talk in 30 minutes #hype", d5);
	    
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    @Test
    public void testGuessFollowsGraphEmpty() {
        Map<String, Set<String>> followsGraph = SocialNetwork.guessFollowsGraph(Arrays.asList(tweet1,tweet2,tweet3,tweet4,tweet5));
        
        assertFalse("expected non-empty graph", followsGraph.isEmpty());
        assertEquals(1, followsGraph.get("bbi").size());
        assertEquals(2, followsGraph.get("paul").size());
    }
    
    @Test
    public void testInfluencersEmpty() {
    	Map<String, Set<String>> followsGraph = SocialNetwork.guessFollowsGraph(Arrays.asList(tweet1,tweet2,tweet3,tweet4,tweet5));
        List<String> influencers = SocialNetwork.influencers(followsGraph);
        
        assertFalse("expected non-empty list", influencers.isEmpty());
        assertEquals(7, influencers.size());
        assertTrue(influencers.get(0).equals("paul"));
        assertTrue(influencers.get(1).equals("bbi"));
        assertTrue(influencers.get(2).equals("pop"));
    }

    /*
     * Warning: all the tests you write here must be runnable against any
     * SocialNetwork class that follows the spec. It will be run against several
     * staff implementations of SocialNetwork, which will be done by overwriting
     * (temporarily) your version of SocialNetwork with the staff's version.
     * DO NOT strengthen the spec of SocialNetwork or its methods.
     * 
     * In particular, your test cases must not call helper methods of your own
     * that you have put in SocialNetwork, because that means you're testing a
     * stronger spec than SocialNetwork says. If you need such helper methods,
     * define them in a different class. If you only need them in this test
     * class, then keep them in this test class.
     */

}
