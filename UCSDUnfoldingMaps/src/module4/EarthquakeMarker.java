package module4;

import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import processing.core.PGraphics;

/** Implements a visual marker for earthquakes on an earthquake map
 *
 * @author UC San Diego Intermediate Software Development MOOC team
 * @author Pratyushotpal Madhukar
 *
 */
public abstract class EarthquakeMarker extends SimplePointMarker
{

	// Did the earthquake occur on land?  This will be set by the subclasses.
	protected boolean isOnLand;

	// The radius of the Earthquake marker
	// You will want to set this in the constructor, either
	// using the thresholds below, or a continuous function
	// based on magnitude.
	protected float radius;


	/** Greater than or equal to this threshold is a moderate earthquake */
	public static final float THRESHOLD_MODERATE = 5;
	/** Greater than or equal to this threshold is a light earthquake */
	public static final float THRESHOLD_LIGHT = 4;

	/** Greater than or equal to this threshold is an intermediate depth */
	public static final float THRESHOLD_INTERMEDIATE = 70;
	/** Greater than or equal to this threshold is a deep depth */
	public static final float THRESHOLD_DEEP = 300;

	// ADD constants for colors

	// abstract method implemented in derived classes
	public abstract void drawEarthquake(PGraphics pg, float x, float y);


	// constructor
	public EarthquakeMarker (PointFeature feature)
	{
		super(feature.getLocation());
		// Add a radius property and then set the properties
		java.util.HashMap<String, Object> properties = feature.getProperties();
		float magnitude = Float.parseFloat(properties.get("magnitude").toString());
		properties.put("radius", 2*magnitude );
		setProperties(properties);
		this.radius = 1.75f*getMagnitude();
	}


	// calls abstract method drawEarthquake and then checks age and draws X if needed
	public void draw(PGraphics pg, float x, float y) {
		// save previous styling
		pg.pushStyle();

		// determine color of marker from depth
		colorDetermine(pg);

		// Determine if earthquake occurred in past hour
		ageDetermine(pg, x, y);

		// call abstract method implemented in child class to draw marker shape
		drawEarthquake(pg, x, y);

		// OPTIONAL TODO: draw X over marker if within past day

		// reset to previous styling
		pg.popStyle();

	}

	// added by Pratyush
	// to cross the quakes which occurred in past day
	private void ageDetermine(PGraphics pg, float x, float y){
		//System.out.println("age: " + this.getProperty("age"));
		if( this.getProperty("age").toString().equalsIgnoreCase("past day") ){
			pg.line(x-7, y-7, x+7, y+7);
			pg.line(x+7, y-7, x-7, y+7);
		}
	}

	// determine color of marker from depth
	// We suggest: Deep = red, intermediate = blue, shallow = yellow
	// But this is up to you, of course.
	// You might find the getters below helpful.
	private void colorDetermine(PGraphics pg) {


		//TODO: Implement this method
		float depth = this.getDepth();

		//System.out.print("depth: " + depth);
		if( depth > 0 && depth < 70 ) {
			//this.setColor( pg.color(252,252,5) );
			pg.fill(252, 252, 5); //green
			//System.out.println(", color: yellow" );

		}
		else if( depth > 70 && depth < 300 ) {
			//this.setColor( pg.color(0, 0, 255));
			pg.fill(0, 0, 255); //blue
			//System.out.println(", color: blue" );
		}
		else {
			pg.fill(255, 0, 0); //red
			//System.out.println(", color: red" );
			//this.setColor( pg.color(255, 0, 0));
		}

	}


	/*
	 * getters for earthquake properties
	 */

	public float getMagnitude() {
		return Float.parseFloat(getProperty("magnitude").toString());
	}

	public float getDepth() {
		return Float.parseFloat(getProperty("depth").toString());
	}

	public String getTitle() {
		return (String) getProperty("title");

	}

	public float getRadius() {
		return Float.parseFloat(getProperty("radius").toString());
	}

	public boolean isOnLand()
	{
		return isOnLand;
	}


}
