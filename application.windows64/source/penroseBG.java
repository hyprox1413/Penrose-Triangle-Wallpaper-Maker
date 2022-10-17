import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 
import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class penroseBG extends PApplet {

 
 
 
 

 
 
 
 
 
 
 
 

float s = 300;
//triangle outer side length
float is = 75;
//triangle inner side length
PShape third;
Point[] points = new Point[6];
PImage img;
float timer = 0;
float theta = 30;
float hueSpeed = 30;

public void setup() {
  noCursor();
  
  background(0);
  img = loadImage("background.jpg");
  background(img);
  strokeWeight(1);
  colorMode(RGB, 255);
  //img = loadImage("bgrad4.png");
  points[0] = new Point(-(s-is)/12, -s/sqrt(3)+(s-is)/sqrt(3)/4);
  points[1] = new Point((s-is)/12, -s/sqrt(3)+(s-is)/sqrt(3)/4);
  points[2] = new Point(s/2-(s-is)/12, s/2/sqrt(3)-(s-is)/sqrt(3)/4);
  points[3] = new Point(-s/2+(s-is)*5/12, s/2/sqrt(3)-(s-is)/sqrt(3)/4);
  points[4] = new Point(-s/2+(s-is)*1/2, s/2/sqrt(3)-(s-is)/sqrt(3)/2);
  points[5] = new Point(s/2-(s-is)/3, s/2/sqrt(3)-(s-is)/sqrt(3)/2);
  thirdSetup();
  //image(img, 0, 0);
  strokeCap(ROUND);
  rotate(radians(20));
  strokeWeight(7);
  twoRow();
  translate(3*s, 0);
  twoRow();
  translate(3*s, 0);
  twoRow();
  translate(3*s, 0);
  twoRow();
  translate(3*s, 0);
  twoRow();
  saveFrame();
  println("done");
}

public void draw() {
}

class Point{
  float x, y;
  Point(float x, float y){
    this.x = x;
    this.y = y;
  }
}

public void thirdSetup(){
  third = createShape();
  third.beginShape();
  third.noStroke();
  third.fill(255, 75);
  third.vertex(-(s-is)/12, -s/sqrt(3)+(s-is)/sqrt(3)/4);
  third.vertex((s-is)/12, -s/sqrt(3)+(s-is)/sqrt(3)/4);
  third.vertex(s/2-(s-is)/12, s/2/sqrt(3)-(s-is)/sqrt(3)/4);
  third.vertex(-s/2+(s-is)*5/12, s/2/sqrt(3)-(s-is)/sqrt(3)/4);
  third.vertex(-s/2+(s-is)*1/2, s/2/sqrt(3)-(s-is)/sqrt(3)/2);
  third.vertex(s/2-(s-is)/3, s/2/sqrt(3)-(s-is)/sqrt(3)/2);
  third.endShape(CLOSE);
}

public void thirdStroke(){
  stroke(0);
  for(int i = 0; i < 6; i++){
    line(points[i].x, points[i].y, points[(i + 1) % 6].x, points[(i + 1) % 6].y);
  }
}

public void penrose(){
  pushMatrix();
  shape(third);
  rotate(radians(120));
  shape(third);
  rotate(radians(120));
  shape(third);
  popMatrix();
  pushMatrix();
  thirdStroke();
  rotate(radians(120));
  thirdStroke();
  rotate(radians(120));
  thirdStroke();
  popMatrix();
}

public void hexagon(){
  pushMatrix();
  for (int i = 0; i < 6; i ++) {
    penrose();
    rotate(radians(60));
    translate(0, -s/sqrt(3));
  }
  popMatrix();
}

public void row(){
  pushMatrix();
  translate(0, -3*sqrt(3)*s);
  hexagon();
  translate(0, sqrt(3)*s);
  hexagon();
  translate(0, sqrt(3)*s);
  hexagon();
  translate(0, sqrt(3)*s);
  hexagon();
  translate(0, sqrt(3)*s);
  hexagon();
  translate(0, sqrt(3)*s);
  hexagon();
  translate(0, sqrt(3)*s);
  hexagon();
  popMatrix();
}

public void twoRow(){
  pushMatrix();
  row();
  translate(3*s/2, sqrt(3)*s/2);
  row();
  popMatrix();
}
  public void settings() {  size(1920, 1080); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "penroseBG" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
