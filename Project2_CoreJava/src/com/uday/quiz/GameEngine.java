package com.uday.quiz;

import java.util.ArrayList;
import java.util.Scanner;

public class GameEngine {
	private LifelineManager lifelineManager;
	private int currentQuestionIndex;
	private int currentReward;
	private final int[] rewardLevels = { 1000, 2000, 4000, 10000, 20000, 40000, 80000, 160000, 320000, 1000000 };

	private Scanner sc;

	public GameEngine() {
		Question.questions = new ArrayList<>();
		lifelineManager = new LifelineManager();
		sc = new Scanner(System.in);
		currentQuestionIndex = 0;
		currentReward = 0;
		Question.loadQuestions();
	}

	public void start(Player player) {
		boolean gameWon = false;

		while (currentQuestionIndex < Question.questions.size()) {
			Question q = Question.questions.get(currentQuestionIndex);
			q.displayQuestion(player.getName());

			System.out.println("Enter your answer (1-4), or 9 for lifelines:");
			int choice;
			try {
				choice = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Try again.");
				continue;
			}

			if (choice == 9) {
				useLifeline(q);
				continue;
			}

			if (choice == q.getCorrectAnswerIndex() + 1) {
				currentReward = rewardLevels[currentQuestionIndex];
				String GREEN = "\033[0;32m";
				String RESET = "\033[0m";
				System.out.println(GREEN + "Correct! You've won Rupees " + currentReward + RESET);
				currentQuestionIndex++;

				if (currentQuestionIndex >= 5 && currentQuestionIndex < rewardLevels.length) {
					System.out.println("Do you want to continue or quit? (Type 'c' to continue, 'q' to quit)");
					String decision = sc.nextLine();
					if (decision.equalsIgnoreCase("q")) {
						break;
					}
				}
			} else {
				String RED = "\033[0;31m";
				String RESET = "\033[0m";
				String GREEN = "\033[0;32m";
				System.out.println(RED + "Wrong Answer!" + RESET);

				if (currentQuestionIndex < 1) {
					currentReward = 0;
					System.out.println("Sorry " + player.getName() + ", you didn't win anything.");
				} else if (currentQuestionIndex < 5) {
					currentReward = rewardLevels[0];
					System.out.println("---------------RESULT---------------");
					System.out.println(GREEN + "Congratulations " + player.getName() + " from " + player.getCity()+ ", " + player.getState() + "!" + RESET);
					System.out.println("You won Rupees " + currentReward);
				} else {
					currentReward = rewardLevels[4];
					System.out.println("---------------RESULT---------------");
					System.out.println(GREEN + "Congratulations " + player.getName() + " from " + player.getCity()
							+ ", " + player.getState() + "!" + RESET);
					System.out.println("You won Rupees " + currentReward);
				}
				break;
			}
		}

		if (currentReward > 0) {
			String RESET = "\033[0m";
			String GREEN = "\033[0;32m";
			System.out.println(GREEN + "\nCongratulations " + player.getName() + " from " + player.getCity() + ", "+ player.getState() + "!" + RESET);
			System.out.println("You won ₹" + currentReward);
		}
	}

	private void useLifeline(Question q) {
	    if (lifelineManager.isUsed5050() && lifelineManager.isUsedAudience()
	            && lifelineManager.isUsedPhone() && lifelineManager.isUsedSkip()) {
	        System.out.println("You have used all lifelines. No lifelines left.");
	        return;
	    }

	    System.out.println("Available Lifelines:");
	    if (!lifelineManager.isUsed5050())
	        System.out.println("1. 50-50");
	    if (!lifelineManager.isUsedAudience())
	        System.out.println("2. Audience Poll");
	    if (!lifelineManager.isUsedPhone())
	        System.out.println("3. Phone a Friend");
	    if (!lifelineManager.isUsedSkip())
	        System.out.println("4. Skip Question");

	    System.out.print("Enter lifeline number: ");
	    int lifeline;
	    try {
	        lifeline = Integer.parseInt(sc.nextLine());
	    } catch (NumberFormatException e) {
	        System.out.println("Invalid input.");
	        return;
	    }

	    switch (lifeline) {
	        case 1:
	            lifelineManager.use5050(q);
	            break;
	        case 2:
	            lifelineManager.useAudiencePoll(q);
	            break;
	        case 3:
	            lifelineManager.usePhoneAFriend(q);
	            break;
	        case 4:
	            boolean skipped = lifelineManager.useSkipQuestion();
	            if (skipped)
	                currentQuestionIndex++;
	            break;
	        default:
	            System.out.println("Invalid lifeline choice.");
	    }
	}

}
