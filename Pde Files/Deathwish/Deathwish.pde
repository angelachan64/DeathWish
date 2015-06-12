PImage Cint, Cext, Market;
BaseChar bc;
int xcorCint, ycorCint, xcorCext, ycorCext, time, prevkey;
boolean up, down, left, right;
boolean CintBool, CextBool, MarketBool;

void setup() {
  size(600, 400, P2D);
  Cint = loadImage("Cathedral.PNG");
  Cext = loadImage("ExtCathedral.PNG");
  Market = loadImage("Market.PNG");
  xcorCint = -100;
  ycorCint = -100;
  xcorCext = -160;
  ycorCext = -100;
  bc = new BaseChar("Jason");
  up = false; down = false; left = false; right = false; 
  CintBool = true; CextBool = false; MarketBool = false;
  time = 0;
}

void keyPressed() {
  if (key == CODED) {
    if (keyCode == 38) {
      up = true;
    } if (keyCode == 40) {
      down = true;
    } if (keyCode == 39) {
      right = true;
    } if (keyCode == 37) {
      left = true;
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
      right = false;
    } if (keyCode == 37) {
      left = false;
    }
    //time = 0;
  }
}

void move() {
  if (up) {
    //When the map moves
    if (ycorCint < 25 && bc.getycor() == 190) {
      ycorCint = ycorCint + 5;
    } 
    //When the character moves
    if (ycorCint >= 25 && bc.getycor() > 135) {
      bc.setycor(bc.getycor() - 5);
    }
    if (ycorCint <= -400 && bc.getycor() <= 280) {
      bc.setycor(bc.getycor() - 5);
    }
    //Animation
    time++;
    if (time % 8 == 0 && bc.spnum >= 12 && bc.spnum < 16) {
        bc.setspnum(bc.getspnum() + 1);
    } if (time == 32) {
      time = 0;
      bc.setspnum(12);
    } 
  } else if (down) {
    //When the map moves
    if (ycorCint > -400 && bc.getycor() == 190) {
      ycorCint = ycorCint - 5;
    } 
    //When the character moves
    if (ycorCint <= -400 && bc.getycor() < 280) {
      bc.setycor(bc.getycor() + 5);
    }
    if (ycorCint >= 25 && bc.getycor() >= 135) {
      bc.setycor(bc.getycor() + 5);
    }
    //Exiting Cathedral
    if (CintBool && bc.getycor() == 280 && (xcorCint > -135 || xcorCint < -55)) {
      CintBool = false;
      CextBool = true;
    }
    //Animation
    time++;
    if (time % 8 == 0 && bc.spnum < 4) {
        bc.setspnum(bc.getspnum() + 1);
    } if (time == 32) {
      time = 0;
      bc.setspnum(0);
    } 
  } else if (left) {
    //When the map moves
    if (xcorCint < 100 && bc.getxcor() == 285) {
      xcorCint = xcorCint + 5;
    }
    //When the character moves
    if (xcorCint >= 100 && bc.getxcor() > 160) {
      bc.setxcor(bc.getxcor() - 5);
    } if (xcorCint <= -300 && bc.getxcor() <= 410) {
      bc.setxcor(bc.getxcor() - 5);
    }
    //Animation 
    time++;
    if (time % 8 == 0 && bc.spnum >= 4 && bc.spnum < 8) {
        bc.setspnum(bc.getspnum() + 1);
    } if (time == 32) {
      time = 0;
      bc.setspnum(4);
    } 
  } else if (right) {
    //When the map moves
    if (xcorCint > -300 && bc.getxcor() == 285) {
      xcorCint = xcorCint - 5;  
    } 
    //When the character moves
    if (xcorCint <= -300 && bc.getxcor() < 410) {
      bc.setxcor(bc.getxcor() + 5);
    } if (xcorCint >= 100 && bc.getxcor() >= 160) {
      bc.setxcor(bc.getxcor() + 5);
    }
    //Animation
    time++;
    if (time % 8 == 0 && bc.spnum >= 8 && bc.spnum < 12) {
        bc.setspnum(bc.getspnum() + 1);
    } if (time == 32) {
      time = 0;
      bc.setspnum(8);
    } 
  }
}

void draw() {
  if (CintBool) {
    image(Cint, xcorCint, ycorCint);
  } else if (CextBool) {
    image(Cext, xcorCext, ycorCext);
  }
  bc.display();
  text("Background xcor: " + xcorCint + "\nBackground ycor: " + ycorCint, 400, 300);
  text("Char xcor: " + bc.getxcor() + "\nChar ycor : " + bc.getycor(), 300, 300);
  fill(0, 102, 153);
  move();
}
