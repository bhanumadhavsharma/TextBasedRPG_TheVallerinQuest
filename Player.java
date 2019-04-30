package thevallerinquest;
import java.util.*;
import java.lang.*;
import java.io.*;
//import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Player
{
  static String name = "";
  static int health = 25;
  static int charm = 25;
  static int attack = 25;
  static int defense = 25;
  static boolean knowledge = false;

  public static void setName(String a){
    name = a;
    return;
  }

  public static void setHealth(int a){
    //Random rand = new Random();
    //int value = 0;
    switch (a){
      case 1:
        health = ThreadLocalRandom.current().nextInt(8, 11);
        //health = 10;rand.nextInt(11) + 1;
        break;
      case 2:
        health = ThreadLocalRandom.current().nextInt(11, 16);
        break;
      case 3:
        health = ThreadLocalRandom.current().nextInt(12, 16);
        break;
      case 4:
        health = ThreadLocalRandom.current().nextInt(16, 21);
        break;
    }
  }

  public static void setAttack(int a){
    //Random rand = new Random();
    switch (a){
      case 1:
        attack = ThreadLocalRandom.current().nextInt(1, 3);
        break;
      case 2:
        attack = ThreadLocalRandom.current().nextInt(3, 5);
        break;
      case 3:
        attack = ThreadLocalRandom.current().nextInt(5, 7);
        break;
      case 4:
        attack = ThreadLocalRandom.current().nextInt(7, 9);
        break;
    }
  }

  public static void setDefense(int a){
    //Random rand = new Random();
    switch (a){
      case 1:
        defense = ThreadLocalRandom.current().nextInt(1, 3);
        break;
      case 2:
        defense = ThreadLocalRandom.current().nextInt(3, 5);
        break;
      case 3:
        defense = ThreadLocalRandom.current().nextInt(5, 7);
        break;
      case 4:
        defense = ThreadLocalRandom.current().nextInt(7, 9);
        break;
    }
  }

  public static void setCharm(int a){
    Random rand = new Random();
    switch (a){
      case 1:
        charm = ThreadLocalRandom.current().nextInt(1, 5);
        break;
      case 2:
        charm = ThreadLocalRandom.current().nextInt(5, 10);
        break;
      case 3:
        charm = ThreadLocalRandom.current().nextInt(10, 13);
        break;
      case 4:
        charm = ThreadLocalRandom.current().nextInt(13, 16);
        break;
    }
  }
}
