/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package twitter;

import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



import java.util.List;
import java.util.Set;
import java.time.Instant;


/**
 * Extract consists of methods that extract information from a list of tweets.
 * 
 * DO NOT change the method signatures and specifications of these methods, but
 * you should implement their method bodies, and you may add new public or
 * private methods or classes if you like.
 */
public class Extract {

    /**
     * Get the time period spanned by tweets.
     * 
     * @param tweets
     *            list of tweets with distinct ids, not modified by this method.
     * @return a minimum-length time interval that contains the timestamp of
     *         every tweet in the list.
     */
    public static Timespan getTimespan(List<Tweet> tweets) {
        //throw new RuntimeException("not implemented");
    	Instant small = tweets.get(0).getTimestamp();
    	Instant big = tweets.get(0).getTimestamp();
    	int i;
    	for(i=1;i<tweets.size();i++)
    	{
    		if(small.isAfter(tweets.get(i).getTimestamp()))
    			small = tweets.get(i).getTimestamp();
    		if(big.isBefore(tweets.get(i).getTimestamp()))
    			big = tweets.get(i).getTimestamp();
    	}
    	Timespan smallest = new Timespan(small,big);
    	return smallest;
    }

    /**
     * Get usernames mentioned in a list of tweets.
     * 
     * @param tweets
     *            list of tweets with distinct ids, not modified by this method.
     * @return the set of usernames who are mentioned in the text of the tweets.
     *         A username-mention is "@" followed by a Twitter username (as
     *         defined by Tweet.getAuthor()'s spec).
     *         The username-mention cannot be immediately preceded or followed by any
     *         character valid in a Twitter username.
     *         For this reason, an email address like bitdiddle@mit.edu does NOT 
     *         contain a mention of the username mit.
     *         Twitter usernames are case-insensitive, and the returned set may
     *         include a username at most once.
     */
    public static Set<String> getMentionedUsers(List<Tweet> tweets) {
        //throw new RuntimeException("not implemented");
        Set<String> usernames = new HashSet<>();
        int i,j;
        Pattern p = Pattern.compile("([^a-zA-Z0-9_-]@[a-zA-Z0-9_-]+)");
        for(i=0;i<tweets.size();i++)
        {
        	String text = tweets.get(i).getText();
        	Matcher m = p.matcher(text);
        	if(m.find())
        	{
        		for(j=1;j<=m.groupCount();j++)
        		{
        			usernames.add(m.group(j).substring(2));
        		}
        	}
        }
        return usernames;
    }

}
