package edu.miracosta.cs113.hw1.project1;

/**
 * Martin Dorobczynski
 * CS 113
 * 1/30/2017
 *
 * HW1 - Clue
 *
 * Program as if I were Detective Jill
 * Finds the solution with fewer than 20 checks for the case
 */

public class Main
{

    public static void main(String[] args)
    {
        int answerSet, solution, murder, weapon, location;
        Scanner keyboard = new Scanner(System.in);
        Theory answer = null;
        AssistantJack jack;

        System.out.print("Which theory would like you like to test? (1, 2, 3[random]): ");
        answerSet = keyboard.nextInt();
        keyboard.close();

        jack = new AssistantJack(answerSet);

        Random random = new Random();

        // Select a murder, a weapon and a location
        murder = 1;
        location = 1;
        weapon = 1;
        do
        {
            solution = jack.checkAnswer(weapon, location, murder);

            // At least one of murder, weapon, location is wrong
            if(solution != 0)
            {
                if (solution == 1)
                {
                    weapon++;
                }
                else if (solution == 2)
                {
                    location++;
                }
                else if (solution == 3)
                {
                    murder++;
                }
                else
                {
                    // This should not happen
                }
            }
        }
        while (solution != 0);
        answer = new Theory(weapon, location, murder);
        System.out.println("Total Checks = " + jack.getTimesAsked() + ", Solution = " + answer);

        if (jack.getTimesAsked() > 20)
        {
            System.out.println("Failed");
        }
        else
        {
            System.out.println("Congratulations");
        }

    }

}

