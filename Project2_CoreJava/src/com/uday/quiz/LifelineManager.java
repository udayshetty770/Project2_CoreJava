package com.uday.quiz;

import java.util.Random;

public class LifelineManager {
    private boolean used5050 = false;
    private boolean usedAudience = false;
    private boolean usedPhone = false;
    private boolean usedSkip = false;

    public boolean isUsed5050() {
        return used5050;
    }

    public boolean isUsedAudience() {
        return usedAudience;
    }

    public boolean isUsedPhone() {
        return usedPhone;
    }

    public boolean isUsedSkip() {
        return usedSkip;
    }

    public void use5050(Question question) {
        if (used5050) {
        	
            System.out.println("You have already used 50-50.");
            return;
        }

        used5050 = true;
        String LIGHT_PINK = "\033[1;35m";
        String RESET = "\033[0m";
        System.out.println(LIGHT_PINK+"Activating 50-50 lifeline..."+RESET);
        String[] options = question.getOptions();
        int correctIndex = question.getCorrectAnswerIndex();
        Random rand = new Random();

        int removed = 0;
        while (removed < 2) {
            int i = rand.nextInt(4);
            if (i != correctIndex && options[i] != null) {
                options[i] = null;
                removed++;
            }
        }

        System.out.println("Remaining options:");
        for (int i = 0; i < 4; i++) {
            if (options[i] != null) {
                System.out.println((i + 1) + ". " + options[i]);
            }
        }
    }

    public void useAudiencePoll(Question question) {
        if (usedAudience) {
            System.out.println("You have already used Audience Poll.");
            return;
        }
        String LIGHT_PINK = "\033[1;35m";
        String RESET = "\033[0m";
        usedAudience = true;
        System.out.println(LIGHT_PINK+"Activating Audience Poll..."+RESET);
        Random rand = new Random();
        int correct = question.getCorrectAnswerIndex();

        for (int i = 0; i < 4; i++) {
            int percent = (i == correct) ? rand.nextInt(50) + 40 : rand.nextInt(30);
            System.out.println((i + 1) + ". " + question.getOptions()[i] + " → " + percent + "%");
        }
    }

    public void usePhoneAFriend(Question question) {
        if (usedPhone) {
            System.out.println("You have already used Phone a Friend.");
            return;
        }
        String LIGHT_PINK = "\033[1;35m";
        String RESET = "\033[0m";
        usedPhone = true;
        System.out.println(LIGHT_PINK+"Calling your friend..."+RESET);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            
        }

        System.out.println("Friend: I think the answer is option " + (question.getCorrectAnswerIndex() + 1));
    }

    public boolean useSkipQuestion() {
        if (usedSkip) {
            System.out.println("You have already used Skip Question.");
            return false;
        }

        usedSkip = true;
        System.out.println("Skipping the current question...");
        return true;
    }
    
    
    
    
}
