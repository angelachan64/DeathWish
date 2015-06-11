square s;  // The PShape object
PImage Cint;
BaseChar bc;
int xcorCint, ycorCint, time;

void setup() {
  size(600, 400, P2D);
  // Creating the PShape as a square. The
  // numeric arguments are similar to rect().
  //s = new square(color(255,0,0),0,100);
  Cint = loadImage("CathedralInterior.jpg");
  xcorCint = -100;
  ycorCint = -100;
  bc = new BaseChar("Jason");
  time = 0;
}

void draw() {
  image(Cint, xcorCint, ycorCint); 
  bc.display();
}

void keyPressed() {
  if (key == CODED) {
    if (keyCode == 38) {
      ycorCint = ycorCint + 10;
    } if (keyCode == 40) {
      ycorCint = ycorCint - 10;
      time++;
      if (time = 10 && spnum < 4) {
        bc.setspnum(bc.getspnum() + 1);
    } 
      if (time = 
    } if (keyCode == 39) {
      xcorCint = xcorCint - 10;
    } if (keyCode == 37) {
      xcorCint = xcorCint + 10;
    }
  }
}

void keyReleased() {
  if (key == CODED) {
    if (keyCode == 38) {
      spnum = 0;
      time = 0;
    /*if (keyCode == 40) {
      ;
    } if (keyCode == 39) {
      xcorCint = xcorCint - 10;
    } if (keyCode == 37) {
      xcorCint = xcorCint + 10;
    }
    */
  }
}
    
