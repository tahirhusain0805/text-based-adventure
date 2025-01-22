import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args)
    {
        Stack<DecisionNode> goBack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        
        //Opening scene and choices
        DecisionNode currentDecision = new DecisionNode("You are an adventurer who has found an ancient dungeon, said to contain treasure and secrets. However, it's a maze-like structure filled with dangerous traps, locked doors, and mysterious creatures. To escape with the treasure, you need to navigate through the dungeon, making choices at various junctions","You stand at the entrance of the ancient dungeon. The door is creaky, but it seems sturdy. There's a hallway to your left and a staircase going down to your right. What do you do?");
        DecisionNode hallway = new DecisionNode("Go left", "The hallway is narrow and dimly lit. You notice a door at the end. You can either try to go back or search for a key.");
        DecisionNode staircaseDown = new DecisionNode("Go right", "The stairs descend into a dark, musty basement. You can hear the faint sound of water dripping. There’s a door to your left, and the path continues straight ahead.");
        currentDecision.addChoice("1", hallway);
        currentDecision.addChoice("2", staircaseDown);

        //Go down first hallway
        DecisionNode key = new DecisionNode("Search for a key", "Searching the hallway for anything you might've missed, you see a rusty key lying in the corner and use it to open the door. You enter a dusty, old room filled with cobwebs that has an open door connected to another room. There's a strange noise coming from behind a curtain and a bookcase on the opposite side of the room. You can either approach the curtain, examine the bookshelf inside this room, or enter the next room");
        hallway.addChoice("1", key);
        //Investigate noise
        DecisionNode investigateNoise = new DecisionNode("Investigate the noise", "You cautiously approach the curtain, trying to prepare yourself for what you might find. Quickly peeling back the curtain, you discover that it's just a bunch of rats, but as they scurry away, you notice a trapdoor that was hidden behind the curtain. Carefully opening it, you can see another room below and you decide to drop down and investigate. As your eyes adjust to the darkness you see one door on the left and one door on the right. What do you choose?");
        //Door on the left
        DecisionNode doorOnLeft = new DecisionNode("The door on the left", "Deciding to go through the door on the left, you enter and notice just how dark it is. As you try to walk through the room, you feel yourself accidentally step on what feels like a pressure plate. All of a sudden the door behind you slams shut behind you - and as you rush back and try to open the door, you find that it is locked shut with no way back. You search around for any other way out, but the room is essentially empty. Unfortunately there's no way out and you're journey has come to an end here. You can always go back to the previous choices with 0 or press any other number to exit!");
        investigateNoise.addChoice("1", doorOnLeft);
        //Door on the right
        DecisionNode doorOnRight = new DecisionNode("The door on the right", "Deciding to go through the right door, you open the door and immediately notice sunlight pouring into the room. As you look around you notice that someone or something has broken through the wall and left a hole to the outside world. Other than that, the room is barren. Do you go back or take this as a sign and leave with your life?");
        investigateNoise.addChoice("2", doorOnRight);
        //Leave with life
        DecisionNode leaveSafely = new DecisionNode("Leave with your life", "You decide to just leave the dungeon - fearing that it would get more dangerous the longer you explored. After all, how can you enjoy any treasure without your life? You're journey has come to an end here. You can always go back with 0 or use any other number to exit!");
        doorOnRight.addChoice("1", leaveSafely);
        key.addChoice("1", investigateNoise);
        //Examine bookshelf
        DecisionNode examineBookshelf = new DecisionNode("Examine bookshelf", "You approach the bookshelf, hoping to perhaps discover a clue that gets you closer to the treasaure. As you're looking at the books, one stands out - a dark red book with gold embellishment. When you try to pick it up, you hear a loud click before the bookshelf opens ajar to a well lit hallway. Deciding to continue onwards, you come to an intersection where you can either continue straight, go left, or go right. Which do you choose?");
        //Go left
        DecisionNode intersectionLeft = new DecisionNode("Go left", "You decide to go left. You follow the dark path for sometime hoping for something - but you run into a dead end. You're only choice is to return back");
        examineBookshelf.addChoice("1", intersectionLeft);
        DecisionNode intersection = new DecisionNode("Return back to the intersection", "You return back to the intersection where you can either continue straight, go left, or go right. Which do you choose?");
        intersectionLeft.addChoice("1", intersection);
        intersection.addChoice("1", intersectionLeft);
        //Go right
        DecisionNode intersectionRight = new DecisionNode("Go right", "You decide to go right and follow the dark path. As careful as you are though it is extremely difficult to see and you don't notice the massive pit in front of you until you're already falling into it. You hit the ground hard, but you're relatively ok. Unfortunately, as you investigate, you notice there's no way to climb back up and there's no other way out of the pit. You're journey has ended here, but you can use 0 to go back to the previous choice or use any other number to exit!");
        examineBookshelf.addChoice("2", intersectionRight);
        intersection.addChoice("2", intersectionRight);
        //Go straight
        DecisionNode intersectionStraight = new DecisionNode("Go straight", "You decide to go straight and you're happy with your choice as you realize the further you go the brighter the path gets until you get to a door. You open the door and enter a room that's empty except for one things - a large chest that, once you examine it, is filled with all kinds of gold and silver. You carry the heavy chest all the way back to the entrance and make it out safely. Congratulations! You chose the best path and found the treasure. You're journey ends here but you can explore more options with 0 or press any other number to exit!");
        examineBookshelf.addChoice("3", intersectionStraight);
        intersection.addChoice("3", intersectionStraight);
        key.addChoice("2", examineBookshelf);

        //Continue into the next room
        DecisionNode nextRoom = new DecisionNode("Continue into the next room", "Deciding to just continue onwards, you enter the next room to find one single book in the middle of the room and a pencil. It reads 'I am not alive, but I grow; I don't have lungs, but I need air; I don't have a mouth, but water kills me. What am I?' You ponder for a moment before deciding on your answer.");
        //Correct
        DecisionNode correctAnswer = new DecisionNode("Fire", "You write down the word fire and wait a moment before you hear a loud thunk and see the book and its pedestal being lowered into the ground. In its place rises a crown that, after careful inspection, you realize was an infamous crown stolen from the royal family years ago. With the extremely hefty sum of money they're offering, you decide to take the crown and leave - realizing you're now set to live comfortably for life. Congratulations! You made it out with an expensive piece of treasure and you're journey in the dungeon has come to an end. You can explore more by using 0 or exit with any other number!");
        nextRoom.addChoice("2", correctAnswer);
        //Wrong
        DecisionNode cloudIncorrect = new DecisionNode("Clouds", "You write down the word clouds and wait a moment before you hear a loud thunk and see the book and its pedestal being lowered into the ground. You wait a little more before you hear an even louder sound and suddenly you're falling. Unfortunately your answer was wrong and there's no second chances. You hit the ground hard and don't get back up. With that you're journey has come to an end. You can use 0 to go back to the previous choice or use any other number to exit!");
        DecisionNode plantIncorrect = new DecisionNode("Plants", "You write down the word plants and wait a moment before you hear a loud thunk and see the book and its pedestal being lowered into the ground. You wait a little more before you hear an even louder sound and suddenly you're falling. Unfortunately your answer was wrong and there's no second chances. You hit the ground hard and don't get back up. With that you're journey has come to an end. You can use 0 to go back to the previous choice or use any other number to exit!");
        DecisionNode balloonIncorrect = new DecisionNode("Balloons", "You write down the word balloons and wait a moment before you hear a loud thunk and see the book and its pedestal being lowered into the ground. You wait a little more before you hear an even louder sound and suddenly you're falling. Unfortunately your answer was wrong and there's no second chances. You hit the ground hard and don't get back up. With that you're journey has come to an end. You can use 0 to go back to the previous choice or use any other number to exit!");
        nextRoom.addChoice("1", balloonIncorrect);
        nextRoom.addChoice("3", plantIncorrect);
        nextRoom.addChoice("4", cloudIncorrect);
        key.addChoice("3", nextRoom);


        //Go down the first staircase and left
        DecisionNode goLeft = new DecisionNode("Open the door to your left", "You decide to open the door to your left, leading to a massive room. As you examine the room closer you notice the walls are covered in slimy marks. You eventually notice a massive spider resting near the end of the room. It’s guarding something — a shiny, mysterious artifact that’s left unattended in the corner of the room. You can either fight the spider to get the artifact, or sneak by the spider into the next room");
        //Fight the spider
        DecisionNode fightSpider = new DecisionNode("Fight the spider", "Even though you seem horribly outmatched, the prospect of obtaining that artifact seems to good to pass up. How do you plan on defeating the spider?");
        goLeft.addChoice("1", fightSpider);
        //Run at it?
        DecisionNode runAt = new DecisionNode("Run at the spider", "For some reason you think charging at the spider head first will somehow work. Unfortunately you were wrong, the spider wakes up and sees you for a moment before hitting you to the side with one of its legs. You slam into the wall in a daze - slightly injured - and are left defenseless as the spider makes its way towards you. You're journey has come to an end, but you can press 0 to return to the previous choice or any other number to exit!");
        fightSpider.addChoice("1", runAt);
        //Try and find a weapon
        DecisionNode weapon = new DecisionNode("Try and find a weapon to use", "You decide its probably a good idea to find a weapon to try and use. Searching around the area for a little bit you find a long piece of wood that you're able to carve into a spear with a rock. Ready to try and face the spider you approach it before stabbing hard with the spear. Sadly, this did nothing more than anger the spider as it shakes off your spear before the approaching you. Your journey has come to an end. You can use 0 to return to the previous choice or any other number to exit!");
        fightSpider.addChoice("2", weapon);
        //Try and distract
        DecisionNode distraction = new DecisionNode("Try to distract the spider", "You think your best bet is to try and distract the spider. Searching the area you find a bunch of rocks and wood that you can use to distract the spider with sound. You gather the materials and then head into the room. You sneak past the spider into the other room and then throw your distraction towards the door you entered. Thankfully the spider stirs and approaches the door you entered to check out the noise. You use this as an opportunity to grab the artifact and run for the door. At first unaware, the spider now notices you and tries to stop you, but you slide under its body. It does manage to trip you on your way out but can't fit through the door. Slightly injured and not wanting to take ny more chances, you decide the artifact is enough and make your way back to the entrance. Congratulations! You escaped with some treasure! You can explore more using 0 or exit with any other number!");
        fightSpider.addChoice("3", distraction);
        //Sneak into the next room
        DecisionNode sneak = new DecisionNode("Sneak into the next room", "Deciding against fighting the spider, you attempt to cautiously and slowly sneak past the spider. Thankfully, you manage to get by without waking the spider and enter a massive foyer with stairs that lead upstairs, a path that continues straight, and a door on your right. What's your next move? ");
        goLeft.addChoice("2", sneak);

        //Go down staircase and straight
        DecisionNode waterArea = new DecisionNode("Continue straight", "Continuing straight, you notice how damp the floor is. Trekking onwards, cold, murky water begins to fill the path until it is up to your chest. Do you risk continuing forward or try to enter the closed door on your right instead?");
        //Continue forward
        DecisionNode enterCave = new DecisionNode("Push forward", "Deciding on continuing forward, the water eventually reaches a height where you must swim underwater. Taking a deep breath - you dive under the water. After about 15 seconds you're worried you might have to turn back when you make out a lever under the water. You decide to pull on it and you hear a loud crank before the water begins to drain. Unfortunately, it is draining so fast you are swept away with the water. You fall through a whole in the ground where all of the water is draining and splash down in a body of water. As you swim up, you realize you're now in a cave. You can try and find a way back up, follow a path that leads straight, or explore the current cavern you're in");
        //Try and find a way back
        DecisionNode backUp = new DecisionNode("Try and find a way back up ", "You decide to try and find a way back into the dungeon. You search for quite some time and try multiple times but you can't make it back up. What do you do?");
        enterCave.addChoice("1", backUp);
        //Explore current cavern
        DecisionNode exploreCurrent = new DecisionNode("Explore the cavern", "You take this as an opportunity to explore the cavern you've found yourself in. However, other than the straight path that you can follow you don't find anything else. What do you do?");
        enterCave.addChoice("2", exploreCurrent);
        //Follow straight path
        DecisionNode straightPath = new DecisionNode("Follow the path", "You follow the straight path hoping for some way back. After some time you see sunlight at the end of the tunnel. Walking further you realize you've made it outside of the dungeon. Disappointed you're empty handed but happy you have your life, you make your way back home - perhaps you can try your luck another day. Your journey has come to an end, but you can use 0 to go back or any other number to exit!");
        enterCave.addChoice("3", straightPath);

        backUp.addChoice("1", exploreCurrent);
        backUp.addChoice("2", straightPath);

        exploreCurrent.addChoice("1", backUp);
        exploreCurrent.addChoice("2", straightPath);

        waterArea.addChoice("1", enterCave);
        //Enter the room on right
        DecisionNode roomOnRight = new DecisionNode("Enter the room on your right", "With some effort thanks to the water, you eventually open the door on your right and enter the room. Unfortunately it is empty with no other paths. You can explore the room or just return back");
        //Explore room
        DecisionNode exploreRoom = new DecisionNode("Explore the room", "You think it might be helpful to explore the room but you don't find anything. Your only option is to return back");
        roomOnRight.addChoice("1", exploreRoom);
        DecisionNode backToWater = new DecisionNode("Return back", "You exit the room and go back to the path filled with water. What do you do next?");
        exploreRoom.addChoice("1", backToWater);

        backToWater.addChoice("1", enterCave);
        waterArea.addChoice("2", roomOnRight);
        staircaseDown.addChoice("1", goLeft);
        staircaseDown.addChoice("2", waterArea);

        
        /*A loop that initializes the game and displays all necessary information at each decision 
         * It handles all valid and invalid inputs from user
        */
        System.out.println();
        while(true)
        {
            currentDecision.displayPrompt();
            System.out.println("0: Previous choice");
            currentDecision.displayChoices();
            System.out.println("Enter the number of your next choice:");
            int choice;

            if(scanner.hasNextInt())
            {
                choice = scanner.nextInt();
                if(choice == 0)
                {
                    if(goBack.size() == 0)
                    {
                        System.out.println("Cannot go back any further!");
                        System.out.println();
                    }
                    else
                    {
                        currentDecision = goBack.pop();
                        System.out.println();
                    }
                }
                else if(currentDecision.getGraph().size() == 0)
                {
                    System.out.println("Bye!");
                    break;
                }
                else if(choice > currentDecision.getNumOfChoices() || choice < 0)
                {
                System.out.println("Invalid choice, try again!");
                System.out.println();
                }
                else
                {
                    goBack.push(currentDecision);
                    currentDecision = currentDecision.nextAction(choice);
                    System.out.println();
                }
            }
            else
            {
                System.out.println("Invalid choice, try again!");
                System.out.println();
                scanner.next();
            }
            
        
        }
        
        scanner.close();
    }
}
