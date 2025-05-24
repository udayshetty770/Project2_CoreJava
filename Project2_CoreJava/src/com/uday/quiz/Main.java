package com.uday.quiz;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String YELLOW = "\033[0;33m";
		String RESET = "\033[0m";
		String CYAN = "\033[0;36m";
		System.out.println(YELLOW + "         USER AUTHENTICATION" + RESET);
		System.out.println(CYAN + "----------------------------------------" + RESET);
		System.out.print("Hello user, please eshnter your name: ");
		String name = sc.nextLine();

		System.out.print("Please enter your city name: ");
		String city = sc.nextLine();

		System.out.print("Please enter your state name: ");
		String state = sc.nextLine();

		Player player = new Player(name, city, state);
		player.displayWelcome();
		player.displayRules();

		System.out.print("Press 1 to start the game: ");
		int input = sc.nextInt();
		sc.nextLine();

		if (input == 1) {
			GameEngine engine = new GameEngine();
			engine.start(player);
		} else {
			System.out.println("Exiting the game. See you next time!");
		}

		sc.close();
	}
}
