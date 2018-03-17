/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package turtle;

import java.util.List;
import java.util.ArrayList;

public class TurtleSoup {

    /**
     * Draw a square.
     * 
     * @param turtle the turtle context
     * @param sideLength length of each side
     */
    public static void drawSquare(Turtle turtle, int sideLength) {
        //throw new RuntimeException("implement me!");
    	turtle.forward(sideLength);
    	turtle.turn(90);
    	turtle.forward(sideLength);
    	turtle.turn(90);
    	turtle.forward(sideLength);
    	turtle.turn(90);
    	turtle.forward(sideLength);
    }

    /**
     * Determine inside angles of a regular polygon.
     * 
     * There is a simple formula for calculating the inside angles of a polygon;
     * you should derive it and use it here.
     * 
     * @param sides number of sides, where sides must be > 2
     * @return angle in degrees, where 0 <= angle < 360
     */
    public static double calculateRegularPolygonAngle(int sides) {
        //throw new RuntimeException("implement me!");
    	if(sides>2)
    		return 180.0*(sides-2)/sides;
    	else
    	{
    		System.out.println("Wrong!sides<3");
    		return -1;
    	}
    }

    /**
     * Determine number of sides given the size of interior angles of a regular polygon.
     * 
     * There is a simple formula for this; you should derive it and use it here.
     * Make sure you *properly round* the answer before you return it (see java.lang.Math).
     * HINT: it is easier if you think about the exterior angles.
     * 
     * @param angle size of interior angles in degrees, where 0 < angle < 180
     * @return the integer number of sides
     */
    public static int calculatePolygonSidesFromAngle(double angle) {
        //throw new RuntimeException("implement me!");
    	if(angle<60)
    	{
    		System.out.println("wrong!angle < 60");
    		return -1;
    	}
    	else if(360/(180-angle)%1>0.5)
    		return (int)(360/(180-angle))+1;
    	else
    		return (int)(360/(180-angle));
    }

    /**
     * Given the number of sides, draw a regular polygon.
     * 
     * (0,0) is the lower-left corner of the polygon; use only right-hand turns to draw.
     * 
     * @param turtle the turtle context
     * @param sides number of sides of the polygon to draw
     * @param sideLength length of each side
     */
    public static void drawRegularPolygon(Turtle turtle, int sides, int sideLength) {
        //throw new RuntimeException("implement me!");
    	int i;
    	for(i=0;i<sides;i++)
    	{
    		turtle.forward(sideLength);
    		turtle.turn(180-calculateRegularPolygonAngle(sides));
    	}
    }

    /**
     * Given the current direction, current location, and a target location, calculate the heading
     * towards the target point.
     * 
     * The return value is the angle input to turn() that would point the turtle in the direction of
     * the target point (targetX,targetY), given that the turtle is already at the point
     * (currentX,currentY) and is facing at angle currentHeading. The angle must be expressed in
     * degrees, where 0 <= angle < 360. 
     *
     * HINT: look at http://en.wikipedia.org/wiki/Atan2 and Java's math libraries
     * 
     * @param currentHeading current direction as clockwise from north
     * @param currentX current location x-coordinate
     * @param currentY current location y-coordinate
     * @param targetX target point x-coordinate
     * @param targetY target point y-coordinate
     * @return adjustment to heading (right turn amount) to get to target point,
     *         must be 0 <= angle < 360
     */
    public static double calculateHeadingToPoint(double currentHeading, int currentX, int currentY,
                                                 int targetX, int targetY) {
        //throw new RuntimeException("implement me!");
    	int x = targetX-currentX;
    	int y = targetY-currentY;
    	double cos = y/Math.sqrt(x*x+y*y);
    	double angle = Math.toDegrees(Math.acos(cos));
    	return (angle-currentHeading+360)%360;
    }

    /**
     * Given a sequence of points, calculate the heading adjustments needed to get from each point
     * to the next.
     * 
     * Assumes that the turtle starts at the first point given, facing up (i.e. 0 degrees).
     * For each subsequent point, assumes that the turtle is still facing in the direction it was
     * facing when it moved to the previous point.
     * You should use calculateHeadingToPoint() to implement this function.
     * 
     * @param xCoords list of x-coordinates (must be same length as yCoords)
     * @param yCoords list of y-coordinates (must be same length as xCoords)
     * @return list of heading adjustments between points, of size 0 if (# of points) == 0,
     *         otherwise of size (# of points) - 1
     */
    public static List<Double> calculateHeadings(List<Integer> xCoords, List<Integer> yCoords) {
        //throw new RuntimeException("implement me!");
        int i;
        double angle = 0.0;    //每次的旋转角度
        double temp;
        List<Double> angles = new ArrayList<Double>();
        for(i=0;i<xCoords.size()-1;i++)
        {
        	temp = calculateHeadingToPoint(angle, xCoords.get(i), yCoords.get(i), xCoords.get(i+1), yCoords.get(i+1));
        	angles.add(temp);
        	angle = (angle+temp)%360;
        }
        return angles;
    }

    /**
     * Draw your personal, custom art.
     * 
     * Many interesting images can be drawn using the simple implementation of a turtle.  For this
     * function, draw something interesting; the complexity can be as little or as much as you want.
     * 
     * @param turtle the turtle context
     */
    public static void drawPersonalArt(Turtle turtle) {
        //throw new RuntimeException("implement me!");
    	PenColor k = null;  
        int i=0;  
        while(i<90)  
        {  
            turtle.color(k.RED);  
            turtle.forward(10);  
            turtle.turn(4);  
            i++;  
              
        }  
          
      turtle.color(k.GREEN);  
      turtle.turn(90);  
      turtle.forward(140);  
      for(i=0;i<9;i++)  
      {  
          turtle.color(k.BLACK);  
          turtle.turn(120);  
          turtle.forward(140);  
          turtle.color(k.GREEN);  
          turtle.turn(180);  
          turtle.forward(140);  
          i++;  
      }  
      turtle.color(k.CYAN);  
      turtle.turn(180);  
      turtle.forward(70);  
      turtle.turn(90);  
      i=0;  
      while(i<90)  
    {  
        turtle.color(k.RED);  
        turtle.forward(10);  
        turtle.turn(8);  
        i++;  
          
    }  
                  
          
      
        turtle.turn(90);  
        
    } 

    /**
     * Main method.
     * 
     * This is the method that runs when you run "java TurtleSoup".
     * 
     * @param args unused
     */
    public static void main(String args[]) {
        DrawableTurtle turtle = new DrawableTurtle();

        //drawSquare(turtle, 40);
        //drawRegularPolygon(turtle, 12, 50);
        drawPersonalArt(turtle);
        System.out.println(calculateRegularPolygonAngle(12));
        System.out.println(calculatePolygonSidesFromAngle(calculateRegularPolygonAngle(12)));
        // draw the window
        turtle.draw();
        System.out.println(calculateHeadingToPoint(0.0, 0, 0, 1, 0));
        List<Integer> xpoints = new ArrayList<>();
        List<Integer> ypoints = new ArrayList<>();
        xpoints.add(0);
        xpoints.add(1);
        xpoints.add(1);
        ypoints.add(0);
        ypoints.add(1);
        ypoints.add(2);

        List<Double> result = calculateHeadings(xpoints, ypoints);
        
    }

}
