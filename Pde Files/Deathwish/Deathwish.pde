import java.io.*;
import java.util.*;

PImage Cint, Cext, Market, Intersection, Trainext, Trainint, Castleext, Castleint;
PImage RoyalHall, CastUp1, CastUp2, CastDungeon, Residint, Residext;
PImage AngelMira;
BaseChar bc;
int xcorCint, ycorCint, xcorCext, ycorCext, xcorMarket, ycorMarket, xcorIntersection, ycorIntersection;
int xcorTrainext, ycorTrainext;
int time, prevkey;
int mapx, mapy, maxX, maxY, mapyMIN, mapyMAX, mapxMIN, mapxMAX;
int talkIndex;
boolean up, down, left, right;
boolean CintBool, CextBool, MarketBool, IntersectionBool, TrainextBool, TrainintBool;
boolean CastleextBool, Cast1Bool, Cast2Bool, Cast3Bool;
boolean talkBool, AngelTalkBool;
String[] talkScript;
char[][] collisionMap;
int currentX, currentY;

void setup() {
  size(600, 400);
  Cint = loadImage("Cathedral.PNG");
  Cext = loadImage("ExtCathedral.PNG");
  Market = loadImage("Market.PNG");
  Intersection = loadImage("Intersection.PNG");
  Trainext = loadImage("ExtTrain.PNG");
  Trainint = loadImage("IntTrain.PNG");
  Castleext = loadImage("ExtCastle.PNG");
  RoyalHall = loadImage("RoyalHall.PNG");
  CastUp1 = loadImage("CastleUp1.PNG");
  CastUp2 = loadImage("CastleUp2.PNG");
  CastDungeon = loadImage("CastleDungeon.PNG");
  Residint = loadImage("IntHouse.PNG");
  Residext = loadImage("Residential.PNG");
  AngelMira = loadImage("AngelMira.PNG");
  xcorCint = -100;
  ycorCint = -100;
  xcorCext = -160;
  ycorCext = -190;
  xcorMarket = -80;
  ycorMarket = 0;
  xcorIntersection = 0;
  ycorIntersection = 0;
  xcorTrainext = 0;
  ycorTrainext = -220;
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
  AngelTalkBool = false; talkBool = false;
  talkIndex = 0;
  talkScript = loadStrings("AngelTalk.dat");
  loadCollisions("CathedralCollision.dat");
  currentX = maxX/2; currentY = 38;
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
}

void keyPressed() {
  if (key == CODED && !(talkBool)) {
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
  if (CintBool && key == 'z' || key == 'Z') {
    if (talkBool == false && Math.abs(mapx - -100) < 100 && Math.abs(mapy - -100) < 100) {
      talkBool = true;
      talkIndex = 0;
      bc.setspnum(12);
    } else if (talkIndex < 17 && talkBool == true) {
       talkIndex = talkIndex + 1;
       if (talkIndex == 17) {
         talkBool = false;
       }
    } else if (talkBool == false && Math.abs(bc.getxcor() - 180) < 20 && Math.abs(mapy - 25) < 20) {
      talkBool = true;
      talkIndex = 17;
      bc.setspnum(12);
    } else if (talkIndex < 22 && talkBool == true) {
       talkIndex = talkIndex + 1;
       if (talkIndex == 22) {
         talkBool = false;
       }
    } else if (talkBool == false && Math.abs(mapx - -210) < 20 && Math.abs(mapy - 25) < 20) {
      talkBool = true;
      talkIndex = 22;
      bc.setspnum(12);
    } else if (talkIndex < 26 && talkBool == true) {
      talkIndex = talkIndex + 1;
      if (talkIndex == 26) {
        talkBool = false;
      }  
    } else if (talkBool == false && Math.abs(mapx - -35) < 20 && Math.abs(bc.getycor() - 275) < 20) {
      talkBool = true;
      talkIndex = 26;
      bc.setspnum(4);
    } else if (talkIndex < 31 && talkBool == true) {
      talkIndex = talkIndex + 1;
      if (talkIndex == 31) {
        talkBool = false;
      } 
    }
  } else if (CextBool && key == 'z' || key == 'Z') {
    if (talkBool == false && Math.abs(mapx - -195) < 20 && Math.abs(bc.getycor() - 190) < 20) {
      talkBool = true;
      talkIndex = 31;
      bc.setspnum(8);
    } else if (talkIndex < 35 && talkBool == true) {
      talkIndex = talkIndex + 1;
      if (talkIndex == 35) {
        talkBool = false;
      }  
    } else if (talkBool == false && Math.abs(mapx - -50) < 20 && Math.abs(bc.getycor() - 195) < 20) {
      talkBool = true;
      talkIndex = 35;
      bc.setspnum(12);
    } else if (talkIndex < 38 && talkBool == true) {
      talkIndex = talkIndex + 1;
      if (talkIndex == 38) {
        talkBool = false;
      } 
    } else if (talkBool == false && Math.abs(mapx - -275) < 20 && Math.abs(bc.getycor() - 195) < 20) {
      talkBool = true;
      talkIndex = 35;
      bc.setspnum(12);
    } else if (talkIndex < 38 && talkBool == true) {
       talkIndex = talkIndex + 1; 
       if (talkIndex == 38) {
        talkBool = false;
      } 
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
    if (currentY > 0 && collisionMap[currentX][currentY - 1] == 'O') { 
        currentY = currentY - 1;
        if (bc.getycor() == 190) {
          mapy = mapy + 5;
        } if (mapy >= mapyMAX || mapy <= mapyMIN) {
          bc.setycor(bc.getycor() - 5);
        }
    }
    System.out.println(collisionMap[currentX][currentY]);
    //Animation
    time++;
    if (time % 8 == 0 && bc.spnum >= 12 && bc.spnum < 16) {
        bc.setspnum(bc.getspnum() + 1);
    } if (time % 32 == 0) {
      bc.setspnum(12);
    } 
  } else if (down) {
    //When the map moves
    if (currentY < maxY - 1 && collisionMap[currentX][currentY + 1] == 'O') {
      currentY = currentY + 1;
      if (bc.getycor() == 190) {
        mapy = mapy - 5;
      } if (mapy <= mapyMIN || mapy >= mapyMAX) {
        bc.setycor(bc.getycor() + 5);
      }
    }
    System.out.println(collisionMap[currentX][currentY]);
    //Exiting Cathedral
    if (CintBool && bc.getycor() == 285 && mapx > -135 && mapx < -55) {
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
      currentX = maxX/2; currentY = 76;
    }
    //Entering Market
    if (CextBool && bc.getycor() == 310 && mapx > -200 && mapx < -130) {
      CextBool = false;
      MarketBool = true;
      bc.setxcor(285);
      bc.setycor(15);
      mapx = xcorMarket;
      mapy = ycorMarket;
      mapxMIN = -200;
      mapxMAX = -5;
      mapyMIN = -400;
      mapyMAX = 0;
      loadCollisions("MarketCollision.dat");
      currentX = maxX/2; currentY = 3;
    }
    //Entering Intersection
    if (MarketBool && bc.getycor() == 310 && mapx > -130 && mapx < -35) {
      MarketBool = false;
      IntersectionBool = true;
      bc.setxcor(285);
      bc.setycor(15);
      mapx = xcorIntersection;
      mapy = ycorIntersection;
      mapxMIN = -25;
      mapxMAX = 0;
      mapyMIN = -70;
      mapyMAX = 0;
      loadCollisions("IntersectionCollision.dat");
      currentX = maxX/2; currentY = 3;
    }
    //Animation
    time++;
    if (time % 8 == 0 && bc.spnum < 4) {
        bc.setspnum(bc.getspnum() + 1);
    } if (time % 32 == 0) {
      bc.setspnum(0);
    } 
  } else if (left) {
    if (currentX > 0 && collisionMap[currentX - 1][currentY] == 'O') { 
      currentX = currentX - 1;
      if (bc.getxcor() == 285) {
        mapx = mapx + 5;
      } if (mapx >= mapxMAX || mapx <= mapxMIN) {
        bc.setxcor(bc.getxcor() - 5);
      }
    }
    System.out.println(collisionMap[currentX][currentY]);
    //Animation 
    time++;
    if (time % 8 == 0 && bc.spnum >= 4 && bc.spnum < 8) {
        bc.setspnum(bc.getspnum() + 1);
    } if (time % 32 == 0) {
      bc.setspnum(4);
    } 
  } else if (right) {
    if (currentX < maxX - 1 && collisionMap[currentX + 1][currentY] == 'O') { 
      currentX = currentX + 1;
      if (bc.getxcor() == 285) {
        mapx = mapx - 5;
      } if (mapx >= mapxMAX || mapx <= mapxMIN) {
        bc.setxcor(bc.getxcor() + 5);
      }
    }
    System.out.println(collisionMap[currentX][currentY]);
    //Entering Training
    if (IntersectionBool && bc.getxcor() >= 550 && bc.getycor() >= 130 && bc.getycor() <= 190) {
      IntersectionBool = false;
      TrainextBool = true;
      bc.setxcor(15);
      bc.setycor(260);
      mapx = xcorTrainext;
      mapy = ycorTrainext;
      mapxMIN = -355;
      mapxMAX = 0;
      mapyMIN = -220;
      mapyMAX = -5;
      loadCollisions("TrainintCollision.dat");
      currentX = 1; currentY = maxY - 3;
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
  } else if (MarketBool) {
    image(Market, mapx, mapy);
  } else if (IntersectionBool) {
    image(Intersection, mapx, mapy);
  } else if (TrainextBool) {
    image(Trainext, mapx, mapy);
  } else if (TrainintBool) {
    image(Trainint, mapx, mapy);
  }
  if (talkBool && talkIndex < 17) {
    image(AngelMira, 273, 115);
  }
  bc.display();
  if (talkBool && CintBool) {
    textSize(18);
    text(talkScript[talkIndex], 5, 100);
  } else if (talkBool && CextBool) {
    textSize(18);
    text(talkScript[talkIndex], 5, 100);
  }
  text("TalkBool: " + talkBool, 10, 300);
  text("TalkIndex: " + talkIndex, 250, 300);
  text("Background xcor: " + mapx + "\nBackground ycor: " + mapy, 400, 300);
  text("Char xcor: " + bc.getxcor() + "\nChar ycor : " + bc.getycor(), 300, 350);
  //text("cX, xY: " + currentX + ", " + currentY, 100, 300);
  //text("Collision cor: " + collisionMap[currentX][currentY], 200, 300);
  //fill(0, 102, 153);
  move();
}
