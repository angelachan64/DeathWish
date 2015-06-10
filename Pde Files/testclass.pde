class square() {
  color c;
  float xpos;
  float ypos;
  
  class square(color tc, float tx; float ty) {
    c = tc;
    xpos = tx;
    ypos = ty;
  }
  
  void display() {
    stroke(0);
    fill(c);
    rectMode(CENTER);
    rect(xpos,ypos,20,10);
  }
  
  void moveright() {
    xpos = xpos + 1;
      if (xpos > width) {
        xpos = 0;
      }
  }
}
