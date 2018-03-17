/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package twitter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * SocialNetwork provides methods that operate on a social network.
 * 
 * A social network is represented by a Map<String, Set<String>> where map[A] is
 * the set of people that person A follows on Twitter, and all people are
 * represented by their Twitter usernames. Users can't follow themselves. If A
 * doesn't follow anybody, then map[A] may be the empty set, or A may not even exist
 * as a key in the map; this is true even if A is followed by other people in the network.
 * Twitter usernames are not case sensitive, so "ernie" is the same as "ERNie".
 * A username should appear at most once as a key in the map or in any given
 * map[A] set.
 * 
 * DO NOT change the method signatures and specifications of these methods, but
 * you should implement their method bodies, and you may add new public or
 * private methods or classes if you like.
 */
public class SocialNetwork {

    /**
     * Guess who might follow whom, from evidence found in tweets.
     * 
     * @param tweets
     *            a list of tweets providing the evidence, not modified by this
     *            method.
     * @return a social network (as defined above) in which Ernie follows Bert
     *         if and only if there is evidence for it in the given list of
     *         tweets.
     *         One kind of evidence that Ernie follows Bert is if Ernie
     *         @-mentions Bert in a tweet. This must be implemented. Other kinds
     *         of evidence may be used at the implementor's discretion.
     *         All the Twitter usernames in the returned social network must be
     *         either authors or @-mentions in the list of tweets.
     */
    public static Map<String, Set<String>> guessFollowsGraph(List<Tweet> tweets) {
        //throw new RuntimeException("not implemented");
    	Map<String,Set<String>> gfg = new HashMap<>();
    	Pattern p = Pattern.compile("([^a-zA-Z0-9_-]@[a-zA-Z0-9_-]+)");
    	int i,j;
    	for(i=0;i<tweets.size();i++)
    	{
    		if(!gfg.containsKey(tweets.get(i).getAuthor()))
    			gfg.put(tweets.get(i).getAuthor(), new HashSet<String>());
    		java.util.regex.Matcher m = p.matcher(tweets.get(i).getText());
    		if(m.find())
    		{
    			for(j=1;j<=m.groupCount();j++)
    			{
    				if(!gfg.containsKey(m.group(j).substring(2)))
    				{
    					gfg.put(m.group(j).substring(2), new HashSet<String>());
        				gfg.get(m.group(j).substring(2)).add(tweets.get(i).getAuthor());
        				
    				}
    				else
    					gfg.get(m.group(j).substring(2)).add(tweets.get(i).getAuthor());
    			}
    		}
    	}
    	for(String str1:gfg.keySet())
    	{
    		if(gfg.get(str1).size()!=0)
    		{
    			for(String str2:gfg.get(str1))
    			{
    				if(gfg.get(str2).size()!=0)
    				{
    					for(String str3:gfg.get(str2))
    					{
    						if(!gfg.get(str1).contains(str3))
    							gfg.get(str1).add(str3);
    					}
    				}
    			}
    		}
    	}
    	return gfg;
    }

    /**
     * Find the people in a social network who have the greatest influence, in
     * the sense that they have the most followers.
     * 
     * @param followsGraph
     *            a social network (as defined above)
     * @return a list of all distinct Twitter usernames in followsGraph, in
     *         descending order of follower count.
     */
    public static List<String> influencers(Map<String, Set<String>> followsGraph) {
        //throw new RuntimeException("not implemented");
        List<String> inf = new ArrayList<>();
        int biggest,i,j;
        String name;
        String[] strings = new String[followsGraph.keySet().toArray().length];
        strings = followsGraph.keySet().toArray(strings);
        System.out.println(strings.length);
        	for(i=0;i<strings.length;i++)
            {
            	biggest = followsGraph.get(strings[i]).size();
            	name = strings[i];
            	for(j=i+1;j<strings.length;j++)
            	{
            		if(biggest<followsGraph.get(strings[j]).size())
            		{
            			biggest = followsGraph.get(strings[j]).size();
            			name = strings[j];
            			strings[j] = strings[i];
            			strings[i] = name;
            		}
            	}
            	inf.add(name);
            }
        	return inf;
    }

}
