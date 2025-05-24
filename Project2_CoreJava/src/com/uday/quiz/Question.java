package com.uday.quiz;

import java.util.ArrayList;

public class Question {
	private String questionText;
	private String[] options;
	private int correctAnswerIndex;
	String RESET = "\033[0m";
	String CYAN = "\033[0;36m";
	public static ArrayList<Question> questions;
	public Question(String questionText, String[] options, int correctAnswerIndex) {
		this.questionText = questionText;
		this.options = options;
		this.correctAnswerIndex = correctAnswerIndex;
	}

	public String getQuestionText() {
		return questionText;
	}

	public String[] getOptions() {
		return options;
	}

	public int getCorrectAnswerIndex() {
		return correctAnswerIndex;
	}

	static void loadQuestions() {
		questions.add(new Question("Capital of India?", new String[] { "Mumbai", "Delhi", "Chennai", "Kolkata" }, 1));
		questions.add(new Question("2 + 2 = ?", new String[] { "3", "4", "5", "2" }, 1));
		questions.add(new Question("Sun rises in?", new String[] { "East", "West", "North", "South" }, 0));
		questions.add(new Question("Largest ocean?", new String[] { "Atlantic", "Indian", "Arctic", "Pacific" }, 3));
		questions.add(new Question("Currency of Japan?", new String[] { "Yuan", "Yen", "Won", "Dollar" }, 1));
		questions.add(new Question("Fastest land animal?", new String[] { "Cheetah", "Tiger", "Horse", "Leopard" }, 0));
		questions.add(new Question("Which is a prime number?", new String[] { "4", "6", "11", "15" }, 2));
		questions.add(new Question("Google CEO?",new String[] { "Sundar Pichai", "Elon Musk", "Jeff Bezos", "Satya Nadella" }, 0));
		questions.add(new Question("Most spoken language?", new String[] { "Hindi", "English", "Mandarin", "Spanish" }, 1));
		questions.add(new Question("Smallest state of India?", new String[] { "Goa", "Sikkim", "Delhi", "Tripura" }, 0));
	}

	public void displayQuestion(String playerName) {
		System.out.println(CYAN + "----------------------------------------" + RESET);
		System.out.println(playerName + ", here is your question:");
		System.out.println();
		System.out.println(questionText);
		for (int i = 0; i < options.length; i++) {
			System.out.println((i + 1) + ". " + options[i]);
		}
		System.out.println(CYAN + "----------------------------------------" + RESET);
	}

	public boolean isCorrectAnswer(int userAnswer) {
		return userAnswer - 1 == correctAnswerIndex;
	}

}
