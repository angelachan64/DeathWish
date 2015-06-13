PImage Cint, Cext, Market;
BaseChar bc;
int xcorCint, ycorCint, xcorCext, ycorCext, time, prevkey;
int mapx, mapy, maxX, maxY;
boolean up, down, left, right;
boolean CintBool, CextBool, MarketBool;
char[][] CintMap;
int currentX, currentY;

void setup() {
  size(600, 400);
  Cint = loadImage("Cathedral.PNG");
  Cext = loadImage("ExtCathedral.PNG");
  Market = loadImage("Market.PNG");
  xcorCint = -100;
  ycorCint = -100;
  xcorCext = -160;
  ycorCext = -150;
  mapx = xcorCint;
  mapy = ycorCint;
  bc = new BaseChar("Jason");
  up = false; down = false; left = false; right = false; 
  CintBool = true; CextBool = false; MarketBool = false;
  time = 0;
  currentX = 46; currentY = 38;
  String[] map = loadStrings("CathedralCollision.txt");
  CintMap = new char[map[0].length()][map.length];
  maxX = map[0].length();
  maxY = map.length;
  for (int r = 0; r < map.length; r++) {
    String s = map[r];
    for (int c = 0; c < s.length(); c++) {
      CintMap[c][r] = s.charAt(c);
    }
  }
  
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
      bc.setspnum(12);
    } if (keyCode == 40) {
      down = false;
      bc.setspnum(0);
    } if (keyCode == 39) {
      right = false;
      bc.setspnum(8);
    } if (keyCode == 37) {
      left = false;
      bc.setspnum(4);
    }
    //time = 0;
  }
}

void move() {
  if (up) {
    if (currentY >= 2) {
      currentY = currentY - 1;
    }
    System.out.println(CintMap[currentX][currentY - 1]);
    if (CintMap[currentX][currentY - 1] == 'O' && bc.getycor() == 190) {
      mapy = mapy + 5;
    }
    //When the map moves
    /*
    if (mapy < 25 && bc.getycor() == 190) {
      mapy = mapy + 5;      
    } 
    */
    //When the character moves
    if (CintMap[currentX][currentY - 1] == 'O' && (mapy >= 25 || mapy <= -400)) {
      bc.setycor(bc.getycor() - 5);
    }
    /*
    if (mapy >= 25 && bc.getycor() > 135) {
      bc.setycor(bc.getycor() - 5);
    }
    if (mapy <= -400 && bc.getycor() <= 280) {
      bc.setycor(bc.getycor() - 5);
    }
    */
    //Animation
    time++;
    if (time % 8 == 0 && bc.spnum >= 12 && bc.spnum < 16) {
        bc.setspnum(bc.getspnum() + 1);
    } if (time % 32 == 0) {
      bc.setspnum(12);
    } 
  } else if (down) {
    //When the map moves
    if (currentY <= maxY - 3) {
      currentY = currentY + 1;
    }
    System.out.println(CintMap[currentX][currentY + 1]);
    if (CintMap[currentX][currentY + 1] == 'O' && bc.getycor() == 190) {
      mapy = mapy - 5;
    }
    /*
    if (mapy > -400 && bc.getycor() == 190) {
      mapy = mapy - 5;
    }
    */
    //When the character moves
    if (CintMap[currentX][currentY + 1] == 'O' && (mapy <= -400 || mapy >= 25)) {
      bc.setycor(bc.getycor() + 5);
    }
    
    /*
    if (mapy <= -400 && bc.getycor() < 280) {
      bc.setycor(bc.getycor() + 5);
    }
    if (mapy >= 25 && bc.getycor() >= 135) {
      bc.setycor(bc.getycor() + 5);
    }
    */
    //Exiting Cathedral
    if (CintBool && bc.getycor() == 280 && mapx > -135 && mapx < -55) {
      CintBool = false;
      CextBool = true;
      bc.setxcor(285);
      bc.setycor(190);
      mapx = xcorCext;
      mapy = ycorCext;
    }
    //Animation
    time++;
    if (time % 8 == 0 && bc.spnum < 4) {
        bc.setspnum(bc.getspnum() + 1);
    } if (time % 32 == 0) {
      bc.setspnum(0);
    } 
  } else if (left) {
    //When the map moves
    if (mapx < 100 && bc.getxcor() == 285) {
      mapx = mapx + 5;
    }
    //When the character moves
    if (mapx >= 100 && bc.getxcor() > 160) {
      bc.setxcor(bc.getxcor() - 5);
    } if (mapx <= -300 && bc.getxcor() <= 410) {
      bc.setxcor(bc.getxcor() - 5);
    }
    //Animation 
    time++;
    if (time % 8 == 0 && bc.spnum >= 4 && bc.spnum < 8) {
        bc.setspnum(bc.getspnum() + 1);
    } if (time % 32 == 0) {
      bc.setspnum(4);
    } 
  } else if (right) {
    //When the map moves
    if (mapx > -300 && bc.getxcor() == 285) {
      mapx = mapx - 5;  
    } 
    //When the character moves
    if (mapx <= -300 && bc.getxcor() < 410) {
      bc.setxcor(bc.getxcor() + 5);
    } if (mapx >= 100 && bc.getxcor() >= 160) {
      bc.setxcor(bc.getxcor() + 5);
    }
    //Animation
    time++;
    if (time % 8 == 0 && bc.spnum >= 8 && bc.spnum < 12) {
        bc.setspnum(bc.getspnum() + 1);
    } if (time % 32 == 0) {
      bc.setspnum(8);
    } 
  }
}

void draw() {
  if (CintBool) {
    image(Cint, mapx, mapy);
  } else if (CextBool) {
    image(Cext, mapx, mapy);
  }
  bc.display();
  text("Background xcor: " + mapx + "\nBackground ycor: " + mapy, 400, 300);
  text("Char xcor: " + bc.getxcor() + "\nChar ycor : " + bc.getycor(), 300, 300);
  text("cX, xY: " + currentX + ", " + currentY, 100, 300);
  text("Collision cor: " + CintMap[currentX][currentY], 200, 300);
  fill(0, 102, 153);
  move();
}
