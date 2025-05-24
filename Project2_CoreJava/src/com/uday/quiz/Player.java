package com.uday.quiz;

public class Player {
    private String name;
    private String city;
    private String state;
    String RESET = "\033[0m";
    String YELLOW = "\033[0;33m";
    String CYAN = "\033[0;36m";

    public Player(String name, String city, String state) {
        this.name = name;
        this.city = city;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public void displayWelcome() {
    	System.out.println(CYAN+"----------------------------------------"+RESET);
        System.out.println(YELLOW+"Welcome to GQT Quiz Show"+RESET);
        System.out.println(CYAN+"----------------------------------------"+RESET);
        System.out.println("Welcome " + name + " from " + city + ", " + state + "!");
        System.out.println();
    }

    public void displayRules() {
    	System.out.println(CYAN+"----------------------------------------"+RESET);
        System.out.println("Let's dive into the rules of the game:");
        System.out.println(CYAN+"----------------------------------------"+RESET);
        System.out.println("• You can use 50-50");
        System.out.println("• You can use Audience Poll");
        System.out.println("• You can do Phone a Friend");
        System.out.println("• You can also Skip the Question");
        System.out.println(CYAN+"----------------------------------------"+RESET);
    }
}
