
class Point{
  float x, y;
  Point(float x, float y){
    this.x = x;
    this.y = y;
  }
}

void thirdSetup(){
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

void thirdStroke(){
  stroke(0);
  for(int i = 0; i < 6; i++){
    line(points[i].x, points[i].y, points[(i + 1) % 6].x, points[(i + 1) % 6].y);
  }
}

void penrose(){
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

void hexagon(){
  pushMatrix();
  for (int i = 0; i < 6; i ++) {
    penrose();
    rotate(radians(60));
    translate(0, -s/sqrt(3));
  }
  popMatrix();
}

void row(){
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

void twoRow(){
  pushMatrix();
  row();
  translate(3*s/2, sqrt(3)*s/2);
  row();
  popMatrix();
}
