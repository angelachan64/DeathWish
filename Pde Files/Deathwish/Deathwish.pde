square s;  // The PShape object
PImage Cint;
BaseChar bc;
int xcorCint;
int ycorCint;

void setup() {
  size(600, 400, P2D);
  // Creating the PShape as a square. The
  // numeric arguments are similar to rect().
  //s = new square(color(255,0,0),0,100);
  Cint = loadImage("CathedralInterior.jpg");
  xcorCint = -100;
  ycorCint = -100;
  bc = new BaseChar("Jason");
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
    } if (keyCode == 39) {
      xcorCint = xcorCint - 10;
    } if (keyCode == 37) {
      xcorCint = xcorCint + 10;
    }
  }
}
    
