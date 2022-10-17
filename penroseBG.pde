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

void setup() {
  noCursor();
  size(1920, 1080);
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

void draw() {
}
