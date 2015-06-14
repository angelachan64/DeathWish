PImage Cint, Cext, Market;
BaseChar bc;
int xcorCint, ycorCint, xcorCext, ycorCext, time, prevkey;
int mapx, mapy, maxX, maxY, mapyMIN, mapyMAX, mapxMIN, mapxMAX;
boolean up, down, left, right;
boolean CintBool, CextBool, MarketBool;
char[][] collisionMap;
int currentX, currentY;

void setup() {
  size(600, 400);
  Cint = loadImage("Cathedral.PNG");
  Cext = loadImage("ExtCathedral.PNG");
  Market = loadImage("Market.PNG");
  xcorCint = -100;
  ycorCint = -100;
  xcorCext = -160;
  ycorCext = -190;
  mapx = xcorCint;
  mapy = ycorCint;
  mapxMIN = -350;
  mapxMAX = 100;
  mapyMIN = -400;
  mapyMAX = 25;
  
  collisionMap = new char[10][10];
  bc = new BaseChar("Jason");
  up = false; down = false; left = false; right = false; 
  CintBool = true; CextBool = false; MarketBool = false;
  time = 0;
  loadCollisions("CathedralCollision.dat");
}

void loadCollisions(String file) {  
  String[] map = loadStrings(file);
  collisionMap = new char[map[0].length()][map.length];
  maxX = map[0].length();
  maxY = map.length;
  for (int r = 0; r < map.length; r++) {
    String s = map[r];
    for (int c = 0; c < s.length(); c++) {
      collisionMap[c][r] = s.charAt(c);
    }
  }
  if (CintBool) {
    currentX = map[0].length()/2; currentY = 38;
  } else if (CextBool) {
    currentX = map[0].length()/2; currentY = 76;
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
      //bc.setspnum(12);
    } if (keyCode == 40) {
      down = false;
      //bc.setspnum(0);
    } if (keyCode == 39) {
      right = false;
      //bc.setspnum(8);
    } if (keyCode == 37) {
      left = false;
      //bc.setspnum(4);
    }
    //time = 0;
  }
}

void move() {
  if (up) {
    if (currentY > 1 && collisionMap[currentX][currentY - 1] == 'O') { 
        currentY = currentY - 1;
    }
    System.out.println(collisionMap[currentX][currentY - 1]);
    if(collisionMap[currentX][currentY - 1] == 'O' && bc.getycor() == 190) {
      mapy = mapy + 5;
    }
    //When the map moves
    /*
    if (mapy < 25 && bc.getycor() == 190) {
      mapy = mapy + 5;      
    } 
    */
    //When the character moves
    if (collisionMap[currentX][currentY - 1] == 'O' && (mapy >= mapyMAX || mapy <= mapyMIN)) {
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
    if (currentY < maxY - 2 && collisionMap[currentX][currentY + 1] == 'O') {
      currentY = currentY + 1;
    }
    System.out.println(collisionMap[currentX][currentY + 1]);
    if (collisionMap[currentX][currentY + 1] == 'O' && bc.getycor() == 190) {
      mapy = mapy - 5;
    }
    /*
    if (mapy > -400 && bc.getycor() == 190) {
      mapy = mapy - 5;
    }
    */
    //When the character moves
    if (collisionMap[currentX][currentY + 1] == 'O' && (mapy <= mapyMIN || mapy >= mapyMAX)) {
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
      mapxMIN = -360;
      mapxMAX = -5;
      mapyMIN = -225;
      mapyMAX = -5;
      loadCollisions("CathedralExtCollision.dat");
    }
    //Animation
    time++;
    if (time % 8 == 0 && bc.spnum < 4) {
        bc.setspnum(bc.getspnum() + 1);
    } if (time % 32 == 0) {
      bc.setspnum(0);
    } 
  } else if (left) {
    if (currentX > 1 && collisionMap[currentX - 1][currentY] == 'O') { 
        currentX = currentX - 1;
    }
    //When the map moves
    System.out.println(collisionMap[currentX - 1][currentY]);
    if (collisionMap[currentX - 1][currentY] == 'O' && bc.getxcor() == 285) {
      mapx = mapx + 5;
    }
    /*
    if (mapx < 100 && bc.getxcor() == 285) {
      mapx = mapx + 5;
    }
    */
    //When the character moves
    if (collisionMap[currentX - 1][currentY] == 'O' && (mapx >= mapxMAX || mapx <= mapxMIN)) {
      bc.setxcor(bc.getxcor() - 5);
    }
    /*
    if (mapx >= 100 && bc.getxcor() > 160) {
      bc.setxcor(bc.getxcor() - 5);
    } if (mapx <= -300 && bc.getxcor() <= 410) {
      bc.setxcor(bc.getxcor() - 5);
    }
    */
    //Animation 
    time++;
    if (time % 8 == 0 && bc.spnum >= 4 && bc.spnum < 8) {
        bc.setspnum(bc.getspnum() + 1);
    } if (time % 32 == 0) {
      bc.setspnum(4);
    } 
  } else if (right) {
    if (currentX < maxX - 2 && collisionMap[currentX + 1][currentY] == 'O') { 
        currentX = currentX + 1;
    }
    //When the map moves
    System.out.println(collisionMap[currentX + 1][currentY]);
    if (collisionMap[currentX + 1][currentY] == 'O' && bc.getxcor() == 285) {
      mapx = mapx - 5;
    }
    /*
    if (mapx > -300 && bc.getxcor() == 285) {
      mapx = mapx - 5;  
    } 
    */
    //When the character moves
    if (collisionMap[currentX + 1][currentY] == 'O' && (mapx >= mapxMAX || mapx <= mapxMIN)) {
      bc.setxcor(bc.getxcor() + 5);
    }
    /*
    if (mapx <= -300 && bc.getxcor() < 410) {
      bc.setxcor(bc.getxcor() + 5);
    } if (mapx >= 100 && bc.getxcor() >= 160) {
      bc.setxcor(bc.getxcor() + 5);
    }
    */
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
  text("Collision cor: " + collisionMap[currentX][currentY], 200, 300);
  fill(0, 102, 153);
  move();
}
