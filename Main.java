package thevallerinquest;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Random;

public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
    Scanner userInput = new Scanner(System.in);
    System.out.println("Hello adventurer! What's your name?");
    Player player = new Player();
    Quest quest = new Quest();
    //Enemy enemy = new Enemy();
		String name = userInput.nextLine();
		player.setName(name);
    String Q1 = "\nWhat is your favorite food? (Just write the number and press enter)\n1.Juice\n2.Apples\n3.Sweetroll\n4.Burger";
    String Q2 = "\nWhat is your favorite weapon? (Just write the number and press enter)\n1.Insult\n2.Magic\n3.Bow\n4.Sword";
    String Q3 = "\nHow do you travel? (Just write the number and press enter)\n1.Teleportation\n2.Walking\n3.Horseback\n4.Swimming";
    String Q4 = "\nPick a card. (Just write the number and press enter)\n1.Queen\n2.King\n3.Ace\n4.Joker";
    System.out.println("\nHere, let's determine what your stats are. Answer the following questions.");
		System.out.println(Q1);
		int q1A = (int)userInput.nextInt();
    System.out.println(Q2);
		int q2A = (int)userInput.nextInt();
    System.out.println(Q3);
		int q3A = (int)userInput.nextInt();
    System.out.println(Q4);
		int q4A = (int)userInput.nextInt();
    //player.health = getHealth(q1A);
    player.setHealth(q1A);
    player.setAttack(q2A);
    player.setDefense(q3A);
    player.setCharm(q4A);
    int outcome = 0; //you are getting the amulet for the dwarf
    System.out.println("\nHere are your stats: " + "\nHealth: " + player.health + "\nAttack: " + player.attack + "\nDefense: " + player.defense + "\nCharm: " + player.charm);
    //System.out.println("\nIf you ever need to see these again, type in \"stats\". Let's go ahead and start! Press spacebar to start.\n...\n...\n...");
    //String waitForInput = userInput.nextLine();
    String[] questgiver = {"dwarf", "golden sword", "satin robe", "his", "he"};
    int[] questgiverStats = {5, 3, 1, 14};
    int response = quest.firstTask();
		boolean dwarfAlive = true;
		boolean hasFakeAmulet = false;
    if (response == 1){
      int fightOutcome = fight(questgiver, questgiverStats);
			if (fightOutcome == 0){
				System.out.println("\nWould you like to continue this quest? You would get to keep the amulet.\n1.Yes, that amulet is mine!\n2.Yes, but I need more information. Maybe I should go investigate that town.\n3.Nope, this place sucks and I'm kind of done with it.");
	      response = (int)userInput.nextInt();
				if (response == 3) {
	        System.out.println("\nYou tire of this place. Time to move on and go kill more civilians.\n---You have failed.---");
					System.exit(0);
	      }
				else if (response == 2){
					System.out.println("\nYou turn around and head towards the town, eager to learn something about this amulet and that cave.");
					dwarfAlive = false;
					outcome = 2; //head into town
				}
	      else if (response == 1){
	        System.out.println("\nYou move forwards, now focused on aquiring this precious amulet.");
					dwarfAlive = false;
					outcome = 1; //you are getting the amulet for yourself
	      }
			}
			else if (fightOutcome == 1) {
				System.out.println("\nAs the dwarf runs away, you stare after him, wondering about how such a cowardly man got an amulet. What do you do?\n1.Go to the cave to find the amulet\n2.Follow the man further into the town.\n3.Just leave this place.");
				response = (int)userInput.nextInt();
				if (response == 3) {
					System.out.println("\nYou tire of this place. Time to move on.\n---You have failed.---");
					System.exit(0);
				}
				else if (response == 2) {
					System.out.println("\nAs he runs away, you follow the dwarven man into the town.");
					outcome = 2;
				}
				else if (response == 1) {
					System.out.println("You stare as the dwarven man runs into town. You turn around and face the cave, eager to get the amulet that is rightfully yours.");
					outcome = 1;
				}
			}
			else if (fightOutcome == 2){
				System.out.println("You run away, scared of this dwarven man who has seemed to best you! What do you do?\n1.Run into the cave\n2.Get out of this town man!");
				response = (int)userInput.nextInt();
				if (response == 2) {
					System.out.println("This adventure is dangerous! It was definitely not meant for the likes of you!\n---You have failed.---");
					System.exit(0);
				}
				else if (response == 1){
					System.out.println("Well, there's no coming back from that! That dwarven man is tough, so now you're just gonna have to get that amulet and escape this town.");
					outcome = 1;
				}
			}
		}
		else if (response == 2) {
			System.out.println("After stealing some gold from the dwarf, you look towards the cave he pointed at. \nWould you like to continue this quest? You would get to keep the amulet.\n1.Yes, that amulet is mine!\n2.Yes, but I need more information. Maybe I should go investigate that town.\n3.Nope, this place sucks and I'm kind of done with it.");
			response = (int)userInput.nextInt();
			if (response == 3) {
				System.out.println("You tire of this place. Time to move on and go kill more civilians.\n---You have failed.---");
				System.exit(0);
			}
			else if (response == 2){
				System.out.println("You turn around and head towards the town, eager to learn something about this amulet and that cave.");
				outcome = 2; //head into town
			}
			else if (response == 1){
				System.out.println("You move forwards, now focused on aquiring this precious amulet.");
				outcome = 1; //you are getting the amulet for yourself
			}
		}
		else if (response == 3){
			outcome = 3;
		}
		else if (response == 4){
			outcome = 2;
		}
		else if (response == 5){
			outcome = 1;
		}
		if (outcome == 3){
			int nightfall = quest.townDetour();
			int newResponse = quest.thirdTask(nightfall);
			hasFakeAmulet = quest.fourthTask();
			quest.fightGoblins(newResponse);
			quest.finalTask(outcome, hasFakeAmulet);
			//return amulet to dwarven man
		}
		else if (outcome == 2){
			int nightfall = quest.townDetour();
			int newResponse = quest.thirdTask(nightfall);
			hasFakeAmulet = quest.fourthTask();
			quest.fightGoblins(newResponse);
			quest.finalTask(outcome, hasFakeAmulet);
			//leave town, system.exit(0)
		}
		else if (outcome == 0 || outcome == 1) {
			response = quest.secondTask();
			int newResponse = quest.thirdTask(response);
			hasFakeAmulet = quest.fourthTask();
			quest.fightGoblins(newResponse);
			quest.finalTask(outcome, hasFakeAmulet);
			//if outcome == 1, leave town, system.exit(0)
		}
		//give amulet back to dwarven man task
	}

	//return 0 means you won the fight
	//return 1 means that the enemy ran away
	//return 2 means that you ran away
  public static int fight(String[] enemyInfo, int[] enemyStats){
		Scanner userInput = new Scanner(System.in);
    Player player = new Player();
    String[] playerItems = {"sword", "shield", "armor"};
    //Enemy enemy = new Enemy();
    int enemyHealth = (int)enemyStats[0];
    int enemyAttack = (int)enemyStats[1];
    int enemyDefense = (int)enemyStats[2];
    int enemyCharm = (int)enemyStats[3];
    int count = 0;
    int enemyDefenseCount = 1;
		int oldDefense = player.defense;

    int defenseCount = 0;
    int runAway = 0;
    Random rand = new Random();
    int playerHealth = player.health;
    int playerDefense = player.defense;

    String[] attackTerms = {"swipe up", "slice down", "jab forward", "spin"};
    String[] enemyAttackTerms = {"swipes up", "slices down", "jabs forward", "spins"};
    String[] enemyResponse = {"howl", "scream", "curse", "grunt"};
    //System.out.println("The " + enemyInfo[0] + " pulls out his " + enemyInfo[1] + " and lunges at you.");
    while (true){
      System.out.println("\nWhat do you do?\n1.Attack (lower " + enemyInfo[3] + " health or " + enemyInfo[3] + " defense)\n2.Defend (strengthen your defense to withstand " + enemyInfo[3] + " attacks)\n3.Heal (heal yourself)\n4.Intimidate (use charm to stop the fight)\n5.Run away (your health will not be restored)\n0.Print stat (print out your stats)");
      boolean defenseUp = false;
      boolean attackHit = false;
      int answer = (int)userInput.nextInt();
      if (answer == 4){
        if (player.charm >= enemyCharm){
          System.out.println("You roar at the " + enemyInfo[0] + ". The " + enemyInfo[0] + " panics, dropping " + enemyInfo[3] + " " + enemyInfo[1] + " and running away as fast as possible in the " + enemyInfo[2] + " " + enemyInfo[4] + " wears.");
          return 1;
        }
        else {
          System.out.println("You roar at the " + enemyInfo[0] + " but " + enemyInfo[4] + " seems to be unaffected.");
        }
      }
      if (answer == 0){
        System.out.println("---\nHere are your stats:\nHealth: " + player.health + "\nAttack: " + player.attack + "\nDefense: " + player.defense + "\nCharm: " + player.charm + "\n---");
        continue;
      }
      if (answer == 1 && player.attack > enemyDefense){
          enemyHealth = enemyHealth - (player.attack - enemyDefense);
          int a = rand.nextInt(4);
          int b = rand.nextInt(4);
          System.out.println("You " + attackTerms[a] + " with your sword. You watch as your attack makes the " + enemyInfo[0] + " " + enemyResponse[b] + " in pain.\n---The enemy has " + enemyHealth + " health remaining.---");
      }
      else if (answer == 1 && player.attack <= enemyDefense){
        int a = rand.nextInt(4);
        enemyDefense = enemyDefense - (player.attack/2);
        System.out.println("You " + attackTerms[a] + " with your sword. However, your attack barely misses, only striking the " + enemyInfo[2] + " he wears.\n---The " + enemyInfo[0] + "\'s defense has been lowered.---");
      }
      else if (answer == 2) {
        defenseCount++;
				if (defenseCount > 2){
					defenseCount = 2;
				}
        defenseUp = true;
				oldDefense = player.defense;
        player.defense = player.defense + (2*defenseCount);
        System.out.println("You steady yourself and face your enemy.\n---Your defense has been increased by " + (2*defenseCount) + " for this round.---");
      }
      else if (answer == 3){
        if (player.health == playerHealth) {
          System.out.println("---You are already at full health! Go ahead and choose another option.---");
          continue;
        }
        else {
          int amt = rand.nextInt(5) + 1;
          player.health = player.health + amt;
					if (player.health > playerHealth){
						player.health = playerHealth;
					}
          System.out.println("---You have healed! Your health has been increased by " + amt + "! Your total health is at " + player.health + ".---");
        }
      }
      else if (answer == 5){
        System.out.println("You attempt to run away! Let's see if fate is in your favor!\n---Hint: \"Fate\" is calculated with your defense and charm and the " + enemyInfo[0] + "'s attack and charm.---");
        runAway = player.defense + player.charm - enemyAttack - enemyCharm;
        if (runAway >= 0){
          System.out.println("You dodge the " + enemyInfo[0] + "\'s attacks, and sprint off!");
          return 2;
        } else {
          player.health = player.health - enemyAttack;
          System.out.println("You try to run away, but you get hit as you try to run away.\n---You take " + enemyAttack + " points of damage! You have " + player.health + " health left.");
        }
      }
      if (enemyHealth <= 0){
        System.out.println("The " + enemyInfo[0] + " staggers for a second, before toppling over. You have defeated the " + enemyInfo[0] + "!");
        if (player.health <= playerHealth){
            player.health = playerHealth;
            System.out.println("Your health has been reset.");
        }
				//else {
        //  System.out.println("Your health has been increased to " + player.health + ".");
        //}
        player.defense = playerDefense;
        System.out.println("Your defense has been reset.");
        return 0;
      }
      else if (enemyHealth > 0){
        int decision = rand.nextInt(2);
        int playerItemValue = rand.nextInt(3);
        int c = rand.nextInt(4);
        if (decision == 0 || count > 1) {
            if (player.defense >= enemyAttack){
							player.defense = player.defense - (enemyAttack/2);
							System.out.println("The " + enemyInfo[0] + " " + enemyAttackTerms[c] + " with his sword, but ends up clashing " + enemyInfo[3] + " " + enemyInfo[1] + " against your " + playerItems[playerItemValue] +".\n---Your defense has been lowered by " + (enemyAttack/2) + ". Your defense is " + player.defense + ".---");
              attackHit = true;
            } else if (player.defense < enemyAttack) {
              player.health = player.health - (enemyAttack - player.defense);
              System.out.println("The " + enemyInfo[0] + " " + enemyAttackTerms[c] + " with his sword, but hits your " + playerItems[playerItemValue] + ". Unfortunately, you are still hurt from the attack.\n---You take " + (enemyAttack - player.defense) + " points of damage. You have " + player.health + " health.---");
            }
            //count++;
            //attack the player, most common item
            //definitely on count 3+
        } else if (decision == 1){
          enemyDefense = enemyDefense + enemyDefenseCount;
          count++;
          enemyDefenseCount++;
          System.out.println("The " + enemyInfo[0] + " readies " + enemyInfo[3] + "self.\n---The " + enemyInfo[0] + "\'s defense has increased by " + enemyDefenseCount + ".---");
        }
      }
      if (player.health <= 0) {
        System.out.println("The hit you took has now crippled you. You watch as the " + enemyInfo[0] + " stands over you, laughing in victory. The light fades as you die from your wounds.\n---You have been killed.---");
        System.exit(0);
      }
      if ((defenseUp == true && player.defense > playerDefense) && (attackHit == false || attackHit == true)){
        player.defense = oldDefense;
        System.out.println("---Your defense has been reset to before your defending move.---");
      }
      continue;
    }
  }
}
