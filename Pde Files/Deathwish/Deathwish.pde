PImage Cint;
BaseChar bc;
int xcorCint, ycorCint, time;
boolean up, down, left, right;

void setup() {
  size(600, 400, P2D);
  Cint = loadImage("CathedralInterior.jpg");
  xcorCint = -100;
  ycorCint = -100;
  bc = new BaseChar("Jason");
  up = false; down = false; left = false; right = false; 
  time = 0;
}

void keyPressed() {
  if (key == CODED) {
    if (keyCode == 38) {
      up = true;
    } if (keyCode == 40) {
      down = true;
      time++;
      if (time % 5 == 0 && bc.spnum < 4) {
          bc.setspnum(bc.getspnum() + 1);
      }
      if (time == 20) {
        time = 0;
        bc.setspnum(0);
      } 
    } if (keyCode == 39) {
      left = true;
    } if (keyCode == 37) {
      right = true;
    }
  }
}

void keyReleased() {
  if (key == CODED) {
    if (keyCode == 38) {
      up = false;
    } if (keyCode == 40) {
      down = false;
    } if (keyCode == 39) {
      left = false;
    } if (keyCode == 37) {
      right = false;
    }
  }
}

void move() {
  if (up) {
    ycorCint = ycorCint + 10;
  } else if (down) {
    ycorCint = ycorCint - 5;
  } else if (left) {
    xcorCint = xcorCint - 10;
  } else if (right) {
    xcorCint = xcorCint + 10;  
  }
}

void draw() {
  image(Cint, xcorCint, ycorCint); 
  bc.display();
  move();
}
