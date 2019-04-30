package thevallerinquest;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

public class Quest {

  public static int firstTask(){
    Scanner userInput = new Scanner(System.in);
    Player player = new Player();
    int count = 0;
    System.out.println("\nYou walk up to a short dwarven man standing by a cave entrance.");
    System.out.println("\"I have a task for you " + player.name + "!\" he says. \"I need you to go find my family's blue amulet. It should be in that cave!\"");
    while(true){
      if (count > 0){
        System.out.println("\n\"So, will you help me?\"");
      }
      System.out.println("1.Sure! \n2.Ummm... \n3.Give me your money! (Intimidate) \n4.Wierdo! I'll kill you! (Attack)\n0.Print stats.");
      int answer = (int)userInput.nextInt();
      if (answer == 0){
        System.out.println("---\nHere are your stats:\nHealth: " + player.health + "\nAttack: " + player.attack + "\nDefense: " + player.defense + "\nCharm: " + player.charm + "\n---");
        count++;
        continue;
      }
      else if (answer == 1){
        System.out.println("\"Great!\" he responds. \"Well, I'll wait here. You should go into that cave and find my family's blue amulet.\" \nHe points towards the cave.\"If you need to know more about the cave, maybe someone in town can help you.\"\nWhere do you go?\n1.Into the cave.\n2.Towards the town.");
        int answer3 = (int)userInput.nextInt();
        if (answer3 == 1){
          return 0;
        }
        else if (answer3 == 2){
          System.out.println("\nYou begin the short walk into town.");
          return 3;
        }
      }
      else if (answer == 2){
        System.out.println("\"Are you sure? I could really use the help.\" \n1.Actually, I'll help you!\n2.Nah, I'm good.");
        int answer2 = (int)userInput.nextInt();
        if (answer2 == 1){
          System.out.println("\"Great!\" he responds. \"Well, I'll wait here. You should go into that cave and find my family's blue amulet.!\" \nHe points towards the cave.\"If you need to know more about the cave, maybe someone in town can help you.\"\nWhere do you go?\n1.Into the cave\n2.Towards the town.");
          int answer3 = (int)userInput.nextInt();
          if (answer3 == 1){
            return 0;
          }
          else if (answer3 == 2){
            System.out.println("\nYou begin the short walk into town.");
            return 3;
          }
        }
        else if (answer2 == 2){
          System.out.println("\"Alright then, suit yourself. \"What do you do now?\n1.Go into the cave anyways.\n2.Go into town.\n3.Leave this place.");
          answer2 = (int)userInput.nextInt();
          if (answer2 == 3){
            System.out.println("You leave this town.\n---You have failed.---");
            System.exit(0);
          }
          else if (answer2 == 2){
            System.out.println("\nYou decide to keep the blue amulet for yourself, and decide to try and learn more about it. You begin the short walk into town.");
            return 4;
          }
          else if (answer2 == 1){
            System.out.print("\nYou decide to keep the blue amulet for yourself, and decide to head into the cave.");
            return 0;
          }
        }
      }
      else if (answer == 3){
        if (player.charm > 14){
          System.out.println("\"Aaaah! Fine, here take everything!\"");
          return 2;
        }
        System.out.println("He looks at you weirdly. You don't seem intimidating to him at all.");
        count++;
        continue;
      }
      else if (answer == 4){
        System.out.println("\n\"Urghh fine, you asked for it!\" The dwarven man pulls out a bright golden sword!");
        return 1;
      }
    }
  }

  public static int townDetour(){
    Main main = new Main();
    Scanner userInput = new Scanner(System.in);
    Player player = new Player();
    System.out.println("\nYou arrive into town, looking around at the shops and buildings. The people walking around dont rush by, obviously content to lazily move around during the day. However, none come up to talk with you. The buildings made of wood and stone, it is fairly bustling for a riverside town.");
    int placesGone = 3;
    List<Integer> myList = new ArrayList<Integer>();
    while (placesGone > 0){
      System.out.println("\nWhere do you go? You can only go to 3 locations, and cannot go to the same location twice. You have gone to " + placesGone + " locations already.\n1.Alchemist (get more health)\n2.Blacksmith (get a higher attack)\n3.Armory (get a higher defense)\n4.Courtesan (get a higher charm)\n5.Bar (find out hints about the amulet)\n0.Print stats.");
      int locationGiven = userInput.nextInt();
      if (myList.contains(locationGiven)){
        System.out.println("\nYou have already been to that location. Please pick another location.");
        continue;
      }
      if (locationGiven == 0){
        System.out.println("---\nHere are your stats:\nHealth: " + player.health + "\nAttack: " + player.attack + "\nDefense: " + player.defense + "\nCharm: " + player.charm + "\n---");
        continue;
      }
      else if (locationGiven == 1){
        System.out.println("You walk into the alchemist's shop. It smells a mixture of sulfur, gunpowder, roses, and grape wine. Bottles line the sides of the store, all different colors. Each bottle seems to be swirling with some different cocktail, eager to give some effect to its user. The owner, a short, lanky man with bushy white hair, and an unhealthy thinness, nods at you.\n\"Wha' d'ya need, adventurer?\" he asks. \n1.I need a health potion.\n2.I need a great health potion. (requires medium charm)\n---Current charm value: " + player.charm + "---");
        int playerResponse = userInput.nextInt();
        if (playerResponse == 2){
          if (player.charm > 9){
            player.health = player.health + 5;
            System.out.println("\nHe nods at you, and pulls out a maroon bottle, larger than any others you have seen. You drink it and the effects are instantenous - you feel yourself getting stronger and stronger, and feel rejuvenated within seconds. You leave the store.\n---Your health has been increased by 5 points. You have " + player.health + " health points.---");
            myList.add(1);
            placesGone--;
            continue;
          }
          System.out.println("He shakes his head. \"I don't know about anything other than a standard red potion.\"");
        }
        player.health = player.health + 3;
        System.out.println("He hands you a red potion, which you drink. You feel slightly rejuvanted.\n---Your health has been increased by 3 points. You have " + player.health + " health points.---");
        myList.add(1);
        placesGone--;
        continue;
      }
      else if (locationGiven == 2){
        //player.attack = player.attack + 3;
        System.out.println("You walk into the blacksmith's shop. It smells like iron and burnt leather, but most of that smell is overshadowed by the sounds of clanging of steel and the sizzling of molten metal dipping into water. The whole place is dirty and covered in soot, except for the weapons. Each weapon is a shining, stellar example of the craftsmanship that the blacksmiths provide to adventurers. \nThe blacksmith just looks at you, and grunts.\n1.Repair my sword.\n2.Buy a better sword. (requires high charm)\n---Current charm value: " + player.charm + "---");
        int playerResponse = userInput.nextInt();
        if (playerResponse == 2){
          if (player.charm> 12){
            player.attack = player.attack + 4;
            System.out.println("\nHe sort of nods at you, and pulls out a shiny sword with a red gem in its hilt. You pay your gold, and put the sword in your scabbard.\n---Your attack has been increased by 4 points. You have " + player.attack + " attack points.---");
            myList.add(2);
            placesGone--;
            continue;
          }
          System.out.println("He just looks at you disapprovingly. \"I ain't sellin' youse nothin'. Gim' me yours sword.\"");
        }
        player.attack = player.attack + 2;
        System.out.println("He takes your sword, and gets to work. After about an hour, he hands it back to you, and you can see the fixes.\n---Your attack has been increased by 2 points. You have " + player.attack + " attack points.---");
        myList.add(2);
        placesGone--;
        continue;
      }
      else if (locationGiven == 3){
        //player.defense = player.defense + 3;
        System.out.println("You walk into the armory. Shields and chain mail adorn the shelves and walls. It's clean - astonishingly clean for a smithing shop. You assume that the back is where they make everything in order to keep the front looking immaculate. The guy behind the counter has a giant mustache and seems to frown in your direction. You browse the items, very aware that his eyeline is boring into your skull, as he intently waits for you to either buy something and get out of his shop or just get out of his shop.\n\"What do you want?\"\n1. Can you repair my armor?\n2.I want that shield. (requires very high charm)\n---Current charm value: " + player.charm + "---");
        int playerResponse = userInput.nextInt();
        if (playerResponse == 2){
          if (player.charm > 15){
            player.defense = player.defense + 3;
            System.out.println("\nHe sort of angrily grumbles, before getting a maroon bordered shield, with a lush blue and silver center. He gives it to you, and you find it fits perfectly in your hand. You equip the shield.\n---Your defense has been increased by 3 points. You have " + player.defense + " defense points.---");
            myList.add(3);
            placesGone--;
            continue;
          }
          System.out.println("He just angrily tells you to shut up. \"Armor or nothing.\"");
        }
        player.defense = player.defense + 1;
        System.out.println("He takes your armor, and gets to work. After about an hour, he hands it back to you, and you can see the fixes.\n---Your defense has been increased by 1 point. You have " + player.defense + " defense points.---");
        myList.add(3);
        placesGone--;
        continue;
      }
      else if (locationGiven == 4){
        //player.charm = player.charm + 5;
        System.out.println("You walk into the building, fervently trying not to make eye contact with the women who approach you, not caring what you look like or smell like. They can sense that you have money, and they want you to spend it. You hurriedly push past them to get to the star of the show - a lady dressed in a navy blue silk dress, her toned body showing through the curves of the cloth, her body laced with golden accoutrements, her face shining a beacon of beauty onto the world. You feel weak in her prescence, but nonetheless, you need to get better at convincing people to do what you ask. \n\"What do you desire, you beautiful creature?\" she asks, with a voice of an angel.\n1.Teach me to talk better.\n2.Teach me to get my way. (requires low charm)\n---Current charm value: " + player.charm + "---");
        int playerResponse = userInput.nextInt();
        if (playerResponse == 2){
          if (player.charm > 5){
            player.charm = player.charm + 5;
            System.out.println("\nShe laughs, and grabs you by the hand and takes you into a room, where you learn many things. Afterwards, you leave her harem, now blessed with the abilities of the courtesans.\n---Your charm has been increased by 5 points. You have " + player.charm + " charm points.---");
            myList.add(4);
            placesGone--;
            continue;
          }
        }
        player.charm = player.charm + 3;
        System.out.println("She laughs, and caresses your arm. You feel the need to bolt out of there, run away. She leans down and breathes in your ear.\n---Your charm has been increased by 3 points. You have " + player.charm + " charm points.---");
        myList.add(4);
        placesGone--;
        continue;
      }
      else if (locationGiven == 5){
        System.out.println("\nWalking into the stone building in the center of the city, you find yourself in a crowded bar, with multiple patrons strewn across the room. Some are on chairs, some on tables, some even laid out on the floor. You walk up to the bar and see the bartender, who nods at you. He sets down his handcloth and asks you, \n\"Can I help you?\" \n1.What can you tell me about that cave with the amulet?\n2.Tell me what you know about that amulet, inside that cave. (requires medium charm)\n---Current charm value: " + player.charm + "---");
        //You bring up the amulet that you are going to get from that cave, and the bartender );
        int playerResponse = userInput.nextInt();
        if (playerResponse == 2){
          if (player.charm > 10){
            player.knowledge = true;
            System.out.println("\nHe looks you up and down. He chuckles. \"Yeah, I've heard about that one,\" he says. \"It's apparently surrounded by 2 fake amulets. If you grab the wrong one, then apparently the cave kills you. There's a way to turn off that trap by pulling a lever and pulling a rope, but I think there's one step in the middle too. I've always heard that the blue amulet is the prettiest of the three. Good luck, adventurer!\" You nod and walk out the door.");
            myList.add(5);
            placesGone--;
            continue;
          }
        }
        System.out.println("\n\"Not much, sorry,\" he says. \"That cave is off limits to people in the town, and so I don't really know what happens there.\"");
        myList.add(5);
        placesGone--;
        continue;
      }
    }
    System.out.println("\nHaving spent a good amount of time in the town, you turn around and head back to the cave that you had seen earlier that day, believing that you are ready to face the challenges it might provide.\nBy the time you get there, however, you realize it has become nighttime, and the sounds from inside have increased, and your chance at facing lesser enemies has diminished. Nonetheless, you push forward.");
    return 2;
  }

  public static int secondTask(){
    int count = 0;
    Scanner userInput = new Scanner(System.in);
    Player player = new Player();
    Random rand = new Random();
    String[] action = {"trip on", "fall on", "slip on", "run into"};
    String[] item = {"a pail of goblin poop", "a rake used for combing wolf hair", "a sticky trap used for catching pixies"};
    System.out.println("\nYou begin to walk in the direction of the cave entrance.\nIt becomes apparent that the cave might be infested with something. A quick look around reveals traces of goblin footprints, along with wolf footprints. \nWhat do you do?");
    while (true){
      System.out.println("\nWhat do you do? Do you: \n1.Run into the cave\n2.Sneak in (uses your charm ability)\n3.Wait till nightfall\n4.Get out of here!\n0.Print stats");
      int answer = userInput.nextInt();
      if (answer == 0){
        System.out.println("---\nHere are your stats:\nHealth: " + player.health + "\nAttack: " + player.attack + "\nDefense: " + player.defense + "\nCharm: " + player.charm + "\n---");
        continue;
      }
      if (answer == 4) {
        System.out.println("\nYou change your mind about this quest, and run off in the opposite direction.\n---You have failed.---");
        System.exit(0);
      }
      if (answer == 3) {
        System.out.println("\nYou crouch down by the cave entrance, deciding to wait until the darkness of nightfall in order to sneak in. In this process though, you do see a couple more goblins go into the cave.");
        return 2; //extra enemies
      }
      if (answer == 2) {
        System.out.println("\nYou decide to sneak into the cave, trying your hardest to not be seen by any of the goblins that may be inside.");
        int sneakChance = player.charm + (rand.nextInt(5) + 1);
        int itemChance = rand.nextInt(2);
        int actionChance = rand.nextInt(3);
        if (sneakChance >= 13){
          System.out.println("It seems fate is on your side. As you slink through the shadows, it's almost as if you have become invisible to the world. You get in unnoticed by the goblins and wolves near the opening.");
          return 0; //snuck in undetected
        } else {
          System.out.println("\nWhile you try your hardest to sneak in, it seems as if luck isn't on your side, as you instantly " + action[actionChance] + " " + item[itemChance] + ". A goblin standing nearby sees you and rushes at you! \n---Your defense is lowered by 1.---");
          player.defense = player.defense - 1;
          return 1; //get into a fight
        }
      }
      if (answer == 1) {
        System.out.println("\nThrowing shade to subtlety, you storm in, wreaking havoc on the dogs of war, rushing at the first goblin you see.");
        return 1; //get into a fight
      }
    }
  }

  public static int thirdTask(int response){
    Main main = new Main();
    Player player = new Player();
    int gobHealth = ThreadLocalRandom.current().nextInt(player.health, (player.health+5)) - 5;
    int gobAttack = ThreadLocalRandom.current().nextInt(player.attack, (player.atttack+3)) - 3;
    int gobDefense = ThreadLocalRandom.current().nextInt(player.defense, (player.defense+3)) - 3;
    int gobCharm = ThreadLocalRandom.current().nextInt(player.charm, (player.charm+4)) - 4;
    int gobHealth2 = ThreadLocalRandom.current().nextInt(player.health, (player.health+5)) - 5;
    int gobAttack2 = ThreadLocalRandom.current().nextInt(player.attack, (player.atttack+3)) - 3;
    int gobDefense2 = ThreadLocalRandom.current().nextInt(player.defense, (player.defense+3)) - 3;
    int gobCharm2 = ThreadLocalRandom.current().nextInt(player.charm, (player.charm+4)) - 4;
    String[] goblin1 = {"small goblin", "wooden club", "dirty rag", "his", "he"};
    int[] goblin1Stats = {gobHealth, gobAttack, gobDefense, gobCharm};
    String[] goblin2 = {"round goblin", "wooden sword", "splotchy dress", "her", "she"};
    int[] goblin2Stats = {gobHealth, gobAttack, gobDefense, gobCharm};
    String[] warlockGoblin = {"warlock goblin", "mystic wand sword", "ebony robes", "his", "he"};
    int[] warlockGoblinStats = {gobHealth2, gobAttack2, gobDefense2, gobCharm2};
    String[] armoredGoblin = {"armored goblin", "warhammer", "iron suit", "her", "she"};
    int[] armoredGoblinStats = {gobHealth2, gobAttack2, gobDefense2, gobCharm2};
    boolean armoredGoblinAlive = false;
    boolean warlockGoblinAlive = false;
    //int previousTaskResult = response;
    int goblinNum = 0;
    int caughtChance = 8;
    int fightOutcome = 0;
    if (response == 2) {
      caughtChance = 15;//sneak in, but extra enemies
    }
    else if (response == 1) {
      fightOutcome = main.fight(goblin1, goblin1Stats);
      goblinNum++;
      if (fightOutcome == 0){
          System.out.println("\nYou have defeated this goblin, but you are going to have to be sneakier.");
      }
      else if (fightOutcome == 1){
        System.out.println("\nThe goblin runs out of the cave, terrified of you. However, despite your intimidating stature, you should be sneakier.");
      }
      else if (fightOutcome == 2){
        System.out.println("\nAfter sprinting away, you realize you ran forward into the cave. There are voices coming from inside.");
      }
    }
    else if (response == 0) {
      caughtChance = 4;//sneak in
    }
    if (response != 1){
      System.out.println("\nYou proceed to move in further, trying your hardest to be sneaky.");
      if (player.charm < caughtChance) {
        System.out.println("Standing against the wall is a goblin, almost staring wistfully into space. However, the goblin sees you and runs at you, screaming!");
        if (goblinNum == 0) {
          fightOutcome = main.fight(goblin1, goblin1Stats);
          //goblinNum++;
        }
        else if (goblinNum == 1){
          fightOutcome = main.fight(goblin2, goblin2Stats);
          //goblinNum++;
        }
        if (fightOutcome == 0){
          System.out.println("\nStanding victorious, you wish to move forward, and not deal with anymore goblins.");
        }
        else if (fightOutcome == 1){
          System.out.println("\nThe goblin runs towards the mouth of the cave, terrified of you. You move forwad, and wish to not deal with anymore goblins.");
        }
        else if (fightOutcome == 2){
          System.out.println("\nYou sprint away.");
        }
      }
      else if (player.charm > caughtChance){
        System.out.println("\nSilently moving through the corridors, you notice a goblin standing against the cavern wall. You roll past, blending into the shadows, not making even the slightest sound.");
      }
    }
    System.out.println("\nReaching ahead, you realize you ran into a giant cavern. And in front of you stands a behemoth of a goblin. You need to hide, quick!");
    if (player.charm < (caughtChance - 2)) {
      System.out.println("Unfortunately, the armored goblin sees you! He rushes at you!");
      fightOutcome = main.fight(armoredGoblin, armoredGoblinStats);
      if (response == 2) {
        if (fightOutcome == 0){
            System.out.println("\nStanding victorious, you only have a second to catch your breath, as a giant goblin in a robe rushes at you!");
        }
        else if (fightOutcome == 1){
          System.out.println("\nThe goblin runs towards the mouth of the cave, terrified of you, despite its giant size. You take a breath, but then notice a goblin in a robe rushing at you!");
        }
        else if (fightOutcome == 2){
          System.out.println("\nYou run away from the goblin, but immediately run into a goblin wearing a robe!");
          armoredGoblinAlive = true;
        }
        fightOutcome = main.fight(warlockGoblin, warlockGoblinStats);
        if (fightOutcome == 0){
            if (armoredGoblinAlive == false){
                System.out.println("\nThis was tiring, almost devestating. You won and defeated both giant goblins and should be proud of yourself.");
            }
            else {
              System.out.println("\nThis was tiring, but you did it. You defeated the warlock goblin, but left the other one alive. Hopefully it doesn't return.");
              //fightOutcome = main.fight(armoredGoblin, armoredGoblinStats);
            }
        }
        else if (fightOutcome == 1){
          if (armoredGoblinAlive == false) {
              System.out.println("\nYou have defeated two giant goblins. You should be proud of yourself.");
          }
          else {
            System.out.println("\nYou scared off the warlock goblin! The fight seems to be over for now, but that armored goblin might still be here.");
          }
        }
        else if (fightOutcome == 2){
          if (armoredGoblinAlive == false){
              System.out.println("\nYou run away from the warlock goblin, hoping to stay hidden from her!");
              warlockGoblinAlive = true;
          }
          else {
            System.out.println("\nYou ran away from the warlock goblin! You seem to be safe for now, but either of those two big goblins could come back.");
            warlockGoblinAlive = true;
          }
        }
      }
      else {
        if (fightOutcome == 0){
            System.out.println("\nStanding victorious, you step over the defeated corpse of the armored goblin.");
        }
        else if (fightOutcome == 1){
          System.out.println("\nThe goblin runs towards the mouth of the cave, terrified of you, despite its giant size. You take a breath, and turn around.");
        }
        else if (fightOutcome == 2){
          System.out.println("\nYou run away from the goblin, but are sure that it could probably find you again later.");
          armoredGoblinAlive = true;
        }
      }
    }
    else if (player.charm > (caughtChance - 2)) {
      System.out.println("\nThinking quickly, you duck behind a rock, hiding from the giant goblin. It lumbers around, sniffing for something it can smell, but you have hidden yourself so well, it cannot find you. It walks out of the room, leaving it empty.");
    }
    System.out.println("\nNow standing in an empty room, you take a breath. Perhaps the hard part is over, but then you realize your folly. There are three amulets in front of you, all sitting on stone columns jutting out from the ground.");
    int outcome = 0;
    if (armoredGoblinAlive == true && warlockGoblinAlive == true){
      outcome = 3;
    }
    else if (armoredGoblinAlive == true && warlockGoblinAlive == false){
      outcome = 2;
    }
    else if (armoredGoblinAlive == false && warlockGoblinAlive == true){
      outcome = 1;
    }
    return outcome;
  }

  public static boolean fourthTask(){
    Main main = new Main();
    Scanner userInput = new Scanner(System.in);
    Player player = new Player();
    boolean trap = true;
    boolean hasFakeAmulet = false;
    List<Integer> amuletsTaken = new ArrayList<Integer>();
    System.out.println("\nStaring at the three stone columns, you debate on your next move.");
    while (true){
      System.out.println("\nDo you:\n1.Grab an amulet.\n2.Investigate around the amulet.\n3.Remember any hints you may have gotten before.\n0.Print stats");
      int response = userInput.nextInt();
      if (response == 0){
        System.out.println("---\nHere are your stats:\nHealth: " + player.health + "\nAttack: " + player.attack + "\nDefense: " + player.defense + "\nCharm: " + player.charm + "\n---");
        continue;
      }
      else if (response == 3){
        System.out.println("\nYou think back to what you may have heard...");
        if (player.knowledge == false){
          System.out.println("You try your hardest, but all you know is that this is an amulet. Nothing else.");
          continue;
        }
        else if (player.knowledge == true){
          System.out.println("\nYou remember what the bartender said to you...\n-----\n1.There is a real amulet and 2 fake amulets.\n2.Grabbing the wrong one may kill you.\n3.To turn off the trap, pull a lever, do an unknown task, and then pull a rope.\n4.The blue amulet is the prettiest one.\n-----");
          continue;
        }
      }
      else if (response == 2){
        int step1 = 0;
        while(true){
          System.out.println("\nYou look around the stone columns and see a pressure plate, a hole, and a rope. What do you do?\n1.Step on the plate.\n2.Put your hand in the hole.\n3.Pull the rope.\n4.Don't do anything.");
          response = userInput.nextInt();
          if (response == 4) {
            System.out.println("You step away from the columns.");
            break;
          }
          else if (response == 2){
            if (step1 == 0){
              System.out.println("You gingerly reach into the hole and grasp around. Your fingers find a lever. You pull it, and you hear a *ping* noise.");
              step1++;
              continue;
            }
            else {
              System.out.println("You gingerly reach into the hole and grasp around. You find nothing.");
              if (player.knowledge == true){
                  System.out.println("\n---You feel as if the trap has been reset.---");
              }
              step1 = 0;
              continue;
            }
          }
          else if (response == 1){
            if (step1 == 1){
              System.out.println("You walk up and step onto the plate. You feel the ground go down beneath you and then you hear a sound, a *ping.*");
              step1++;
              continue;
            }
            else {
              System.out.println("You walk up and step onto the plate. You feel nothing.");
              if (player.knowledge == true){
                  System.out.println("\n---You feel as if the trap has been reset.---");
              }
              step1 = 0;
              continue;
            }

          }
          else if (response == 3){
            if (step1 == 2){
              System.out.println("You grab the rope and yank on it. You feel the rope come into your hands and quickly be pulled from the ground. You hear one final *ping* noise, as if the trap had been turned off.");
              trap = false;
              break;
            }
            else{
              System.out.println("You grab the rope and yank on it. Nothing happens.");
              if (player.knowledge == true){
                  System.out.println("\n---You feel as if the trap has been reset.---");
              }
              step1 = 0;
              continue;
            }
          }
        }
      }
      else if (response == 1) {
        System.out.println("\nYou walk up to the stones. There are three amulets: ruby, sapphire, and jade.");
        while (true){
          System.out.println("\nWhich one do you take?\n1.The Ruby Amulet\n2.The Sapphire Amulet\n3.The Jade Amulet\n0.Print stats");
          response = userInput.nextInt();
          if (amuletsTaken.contains(response)){
            System.out.println("\nYou have already picked that amulet. Pick another one.");
            continue;
          }
          if (response == 0){
            System.out.println("---\nHere are your stats:\nHealth: " + player.health + "\nAttack: " + player.attack + "\nDefense: " + player.defense + "\nCharm: " + player.charm + "\n---");
            continue;
          }
          if ((trap == false && response == 1) || (trap == false && response == 3)) {
            System.out.println("You pick up the amulet, but don't feel anything.");
            amuletsTaken.add(response);
            hasFakeAmulet = true;
            continue;
          }
          else if ((trap == true && response == 1) || (trap == true && response == 3)){
            System.out.println("You pick up the amulet, but don't feel anything. However, a sudden *woosh* noise comes from the walls, and you feel a sharp pain in your neck.\n---You take 10 points of health damage.---");
            player.health = player.health - 10;
            amuletsTaken.add(response);
            hasFakeAmulet = true;
            if (player.health <= 0){
              System.out.println("\n---You have died.---");
              System.exit(0);
            }
          }
          else if (response == 2){
            System.out.println("\nYou pick up the blue amulet, and begin to feel strange power coursing through you, as if the winds of change are billowing through you. This magical amulet is probably worth a lot, and is very powerful.\n---Your stats are all 25 now.---");
            player.health = 25;
            player.attack = 25;
            player.defense = 25;
            player.charm = 25;
            return hasFakeAmulet;
          }
          continue;
        }
      }
    }
  }

  //warlockGoblin and armoredGoblin may fight at the end of this task
  //to determine:
  //areGoblinsAlive == 0 {both are dead}
  //areGoblinsAlive == 1 {warlockGoblin is alive}
  //areGoblinsAlive == 2 {armoredGoblin is alive}
  //areGoblinsAlive == 3 {both are alive}
  public static void fightGoblins(int areGoblinsAlive){
    Main main = new Main();
    Player player = new Player();
    int fightOutcome;
    String[] warlockGoblin = {"warlock goblin", "mystic wand sword", "ebony robes", "his", "he"};
    int[] warlockGoblinStats = {10, 6, 2, 12};
    String[] armoredGoblin = {"armored goblin", "warhammer", "iron suit", "her", "she"};
    int[] armoredGoblinStats = {10, 6, 6, 15};
    if (areGoblinsAlive == 0){
      return;
    }
    else if (areGoblinsAlive == 1){
      System.out.println("\nSuddenly, you hear a sound. Turning around, you see the familiar shape of the warlock goblin rushing towards you!");
      fightOutcome = main.fight(warlockGoblin, warlockGoblinStats);
      if (fightOutcome == 0){
          System.out.println("\nStanding victorious, you realize your true potential, now that you are truly powerful.");
      }
      else if (fightOutcome == 1){
        System.out.println("\nThe goblin runs towards the mouth of the cave, terrified of facing this diety you have become.");
      }
      else if (fightOutcome == 2){
        System.out.println("\nYou sprint away, for god knows what reason. I mean, you know all your stats are 25, right?");
      }
    }
    else if (areGoblinsAlive == 2){
      System.out.println("\nSuddenly, you hear a sound. Turning around, you see the familiar shape of the armored goblin rushing towards you!");
      fightOutcome = main.fight(armoredGoblin, armoredGoblinStats);
      if (fightOutcome == 0){
          System.out.println("\nStanding victorious, you realize your true potential, now that you are truly powerful.");
      }
      else if (fightOutcome == 1){
        System.out.println("\nThe goblin runs towards the mouth of the cave, terrified of facing this diety you have become.");
      }
      else if (fightOutcome == 2){
        System.out.println("\nYou sprint away, for god knows what reason. I mean, you know all your stats are 25, right?");
      }
    }
    else if (areGoblinsAlive == 3){
      System.out.println("\nSuddenly, you hear a sound. Turning around, you see the familiar shape of the warlock goblin rushing towards you!");
      fightOutcome = main.fight(warlockGoblin, warlockGoblinStats);
      if (fightOutcome == 0){
          System.out.println("\nStanding victorious, you realize your true potential, now that you are truly powerful.");
      }
      else if (fightOutcome == 1){
        System.out.println("\nThe goblin runs towards the mouth of the cave, terrified of facing this diety you have become.");
      }
      else if (fightOutcome == 2){
        System.out.println("\nYou sprint away, for god knows what reason. I mean, you know all your stats are 25, right?");
      }
      System.out.println("Also out of the blue, that giant armored goblin tries to attack you! You should have killed these guys when you had the chance!");
      fightOutcome = main.fight(armoredGoblin, armoredGoblinStats);
      if (fightOutcome == 0){
          System.out.println("\nYou've killed the second big goblin. Nicely done.");
      }
      else if (fightOutcome == 1){
        System.out.println("\nThe goblin runs towards the mouth of the cave, terrified of facing this diety you have become.");
      }
      else if (fightOutcome == 2){
        System.out.println("\nYou're a coward.");
      }
    }
    return;
  }

  public static void finalTask(int outcome, boolean hasFakeAmulet){
    Main main = new Main();
    Scanner userInput = new Scanner(System.in);
    Player player = new Player();
    boolean hasAmulet = true;
    Random rand = new Random();
    System.out.println("\nYou look for a way out of the cave. You see a straight path, an uphill path, and a hole.\nWhich way do you go?\n1.Straight path\n2.Uphill path\n3.Hole");
    int response = userInput.nextInt();
    System.out.println("\nAs you begin to move forwards, a voice rings out.\"Stop!\" You turn around and you see a humanoid creature, somehow floating in the air, and made of flesh and nothing, all at the same time. \"You cannot leave with that amulet. It is not to be removed from this cave. Heed my warning, or suffer the consequences!\"\nWhat do you do?\n1.Leave with the amulet\n2.Put the amulet back.");
    String[] ghost = {"mystical creature", "shimmering warhammer", "undead armor", "its", "it"};
    //int randomStat1 = rand.nextInt(28, 36)
    int randomStat1 = ThreadLocalRandom.current().nextInt(28, 36);
    int randomStat2 = ThreadLocalRandom.current().nextInt(23, 25);
    int[] ghostStats = {randomStat1, randomStat1, randomStat2, 40};
    response = userInput.nextInt();
    if (response == 2){
      System.out.println("\"You have made a wise choice, " + player.name + ",\" the creature says. \"Here, let me guide you out of the cave.\" The creature waves his hand, and the wall behind him shimmers, revealing a staircase going outwards into the open.");
      hasAmulet = false;
    }
    else if (response == 1){
      System.out.println("The creature's entire body flares and glows bright for a second, as if it is angry at your choice.");
      while (true){
        System.out.println("\n\"Why do you do this?\" it says.\n1.The amulet is mine to keep. (charm)\n2.The amulet must be returned to its rightful owner (charm)\n3.You are a fool to guard it (charm)\n4.Sneak away. (charm)\n0.Print stats");
        response = userInput.nextInt();
        if (response == 0){
          System.out.println("---\nHere are your stats:\nHealth: " + player.health + "\nAttack: " + player.attack + "\nDefense: " + player.defense + "\nCharm: " + player.charm + "\n---");
          continue;
        }
        break;
      }
      int sneakChance = player.charm + (rand.nextInt(5));
      if (response == 4){
        if (sneakChance > 29){
          System.out.println("\nAs you try your hardest to sneak out, the creature suddenly looks confused. You realize the amulet helped you sneak so well, the creature lost sight of you while you were in front of it! The creature angrily panics and you see the wall behind it shimmer slightly. Creeping up to it, you recognize it as an illusion, and you run through it, revealing a staircase going out into the open.");
        }
        else {
          System.out.println("The creature sees you try to sneak away, and roars in anger!");
          int fightOutcome = 2;
          while (fightOutcome == 2 || fightOutcome == 1){
            fightOutcome = main.fight(ghost, ghostStats);
            if (fightOutcome == 0){
              System.out.println("\nStanding victorious, you realize your true potential, now that you are truly powerful.");
            }
            else if (fightOutcome == 1){
              System.out.println("\n---This scenario can literally never happen. If you are reading this, there's a bug. Fight him again.---");
            }
            else if (fightOutcome == 2){
              System.out.println("\nBut why? Why sprint away? Fight him again!");
            }
          }
          System.out.println("\nAs the creature breathes its last, the wall behind it shimmers out of existence, revealing a staircase leading outwards into the open.");
        }
      }
      else if (response == 1 || response == 2 || response == 3){
        if (sneakChance == 29) {
          System.out.println("The creature frowns for a second. \"It seems as if there is some truth to your words,\" it says. \"Please, right this way.\" He gestures behind him, and the wall shimmers away, revealing a staircase going outwards into the open.");
        }
        else {
          System.out.println("The creature grimaces. \"You cannot leave with that amulet. YOUR SOUL SHALL NEVER LEAVE THIS CAVE!\"");
          int fightOutcome = 2;
          while (fightOutcome == 2 || fightOutcome == 1){
            fightOutcome = main.fight(ghost, ghostStats);
            if (fightOutcome == 0){
                System.out.println("\nStanding victorious, you realize your true potential, now that you are truly powerful.");
            }
            else if (fightOutcome == 1){
              System.out.println("\n---This scenario can literally never happen. If you are reading this, there's a bug. Fight him again.---");
            }
            else if (fightOutcome == 2){
              System.out.println("\nBut why? Why sprint away? Fight him again!");
            }
          }
          System.out.println("\nAs the creature breathes its last, the wall behind it shimmers out of existence, revealing a staircase leading outwards into the open.");
        }
      }
    }
    if (hasAmulet == true){
      System.out.println("\nAs you emerge into the open, you can feel the strength of the amulet on you.");
      if (outcome == 3 || outcome == 0){
        if (hasFakeAmulet == false) {
          System.out.println("You see the dwarven man waiting near the same place you had last seen him. He runs up to you, and his eyes go wide. \"Is that it?\" he asks. \"I can't believe it! You are wonderful " + player.name + "!\"\nDo you give him the amulet?\n1.Yes\n2.No");
          response = userInput.nextInt();
          if (response == 1){
            System.out.println("Handing over the amulet to him, you feel happy. As if the gods were smiling down themselves, you feel strangely powerful still, even after removing the amulet. The dwarven man happily takes the amulet and runs into the towwn, chanting your name, \"" + player.name + "! " + player.name + "! " + player.name + "!\" You smile. It is good to be the world's greatest adventurer.\n-----\nThe End\n-----");
            return;
          }
          else if (response == 2){
            System.out.println("You scoff, suddenly realizing that this amulet is amazing. Why would you give it to this man? Shoving him aside, you start walking out of the town, the voice of his screaming being left in the distance.");
            outcome = 2;
          }
        }
        if (hasFakeAmulet == true){
          System.out.println("You see the dwarven man waiting near the same place you had last seen him. He runs up to you, and his eyes go wide. \"Is that it?\" he asks. \"I can't believe it! You are wonderful " + player.name + "!\"\nDo you give him the amulet?\n1.Yes\n2.No\n3.Give him the fake amulet");
          response = userInput.nextInt();
          if (response == 1){
            System.out.println("Handing over the amulet to him, you feel happy. As if the gods were smiling down themselves, you feel strangely powerful still, even after removing the amulet. The dwarven man happily takes the amulet and runs into the towwn, chanting your name, \"" + player.name + "! " + player.name + "! " + player.name + "!\" You smile. It is good to be the world's greatest adventurer.\n-----\nThe End\n-----");
            return;
          }
          else if (response == 2){
            System.out.println("You scoff, suddenly realizing that this amulet is amazing. Why would you give it to this man? Shoving him aside, you start walking out of the town, the voice of his screaming being left in the distance.");
            outcome = 2;
          }
          else if (response == 3){
            System.out.println("You nod at him, and hand him a fake amulet, one of the ones you picked up while you were trying to get the real one. He takes it, and excitedly yells in happiness. You turn around and walk away.");
            outcome = 2;
          }
        }
      }
      if ((outcome == 2) || (outcome == 1)) {
        System.out.println("Walking out of town, a thought crosses your mind. Keeping the amulet was the right choice to make. You scoff at the mere idea that you would have given it to that dwarven man. You are " + player.name + ", the true adventurer and god.");
        System.out.println("\n-----\nThe End\n-----");
        return;
      }
    }
    else if (hasAmulet == false){
      System.out.println("\nYou emerge into the open, wondering if you made the right choice.");
      if (hasFakeAmulet == false){
        if ((outcome == 3) || (outcome == 0)){
          System.out.println("You see the dwarven man waiting near the same place you had last seen him. He runs up to you, and his eyes search over your body, looking for the amulet. \n\"Where's the amulet " + player.name + "?\"\1.I left it there.");
          response = userInput.nextInt();
          if (response == 1){
            System.out.println("The dwarven man remarks angrily. \"That is not your decision to make!\" He storms off, leaving you standing there. You turn around to walk away.");
            outcome = 2;
          }
        }
      }
      if (hasFakeAmulet == true){
        if ((outcome == 3) || (outcome == 0)){
          System.out.println("You see the dwarven man waiting near the same place you had last seen him. He runs up to you, and his eyes search over your body, looking for the amulet. \n\"Where's the amulet " + player.name + "?\"\1.I left it there.\n2.It's right here! (hand him the fake amulet)");
          response = userInput.nextInt();
          if (response == 1){
            System.out.println("The dwarven man remarks angrily. \"That is not your decision to make!\" He storms off, leaving you standing there. You turn around to walk away.");
            outcome = 2;
          }
          else if (response == 2){
            System.out.println("The dwarven man happily takes the amulet you give him, not knowing that it's not real. He turns around and runs happily through the town, chanting your name, " + player.name + ", " + player.name + ", " + player.name + "! \nYou turn around and walk away, confident in your choices. You made the dwarven man happy, and protected the town. You are a good person, " + player.name + ".\n-----The End-----");
            return;
          }
        }
      }
      if ((outcome ==2) || (outcome == 1)) {
        System.out.println("Walking out of town, a thought crosses your mind. This place was dangerous, and that amulet was kept there for safekeeping. You made the right choice. You are smarter than that dwarven man, after all, " + player.name + ".");
        System.out.println("\n-----\nThe End\n-----");
        return;
      }
    }
  }

  //fight outcomes:
  //return 0 means you won the fight
	//return 1 means that the enemy ran away
	//return 2 means that you ran away
}
