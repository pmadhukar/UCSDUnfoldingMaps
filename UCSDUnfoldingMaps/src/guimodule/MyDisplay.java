package guimodule;

import processing.core.PApplet;
import processing.core.PImage;

public class MyDisplay extends PApplet {
	PImage img;

	public void setup(){
		size(400, 400); //set canvas size
		background(255);//set canvas color
		stroke(0);//set pen color
		img = loadImage("http://cseweb.ucsd.edu/~minnes/palmTrees.jpg","jpg");
		img.resize(0, height);//resize loaded image to full height of canvas
		image(img, 0, 0);//display image
	}

	public void draw(){
		//Add drawing code for MyApplet
		int[] color = sunColorsec(second());
		fill(color[0], color[1],  color[2]);
		ellipse(width/4, height/5, width/4, height/5);
	}

	public int[] sunColorsec(float seconds) {
		int[] rgb = new int[3];

		System.out.println("seconds: " + seconds);
		float differFrom30 = Math.abs(30 - seconds);
		System.out.println("difference: " + differFrom30);
		float ratio = differFrom30/30;

		rgb[0] = (int) (255 * ratio);
		rgb[1] = (int) (255 * ratio);
		rgb[2] = 0;

		return rgb;
	}
}
