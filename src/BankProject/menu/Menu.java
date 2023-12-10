package BankProject.menu;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class Menu {
    final String ANSI_RESET = "\u001B[0m"; //ANSI codes
    final String ANSI_BLUE = "\u001B[34m";

    private final String name;
    private final String text;

    private LinkedHashMap<String, Runnable> actionsMap = new LinkedHashMap<>();

    public Menu(String name, String text){
        this.name = name;
        this.text = text;
    }

    public void putAction(String name, Runnable action){
        actionsMap.put(name, action);
    }

    private String generateText(){
        StringBuilder sb = new StringBuilder();
        sb.append("\n").append(name).append(": ");
        sb.append(text).append(":\n");
        List<String> actionNames = new ArrayList<>(actionsMap.keySet());
        for(int i = 0; i < actionNames.size(); i++)
            sb.append("\t").append(i+1).append(": ").append(actionNames.get(i)).append("\n");
        return sb.toString();
    }

    private void executeAction(int actionNumber){
        int effectiveActionNumber = actionNumber - 1;
        if(effectiveActionNumber < 0 || effectiveActionNumber >= actionsMap.size())
            System.out.println("Wrong menu choice: "+ actionNumber);
        else {
            List<Runnable> actions = new ArrayList<>(actionsMap.values());
            actions.get(effectiveActionNumber).run();
        }
    }

    public void activateMenu(){
        System.out.println(ANSI_BLUE + generateText() + ANSI_RESET);
        Scanner scanner = new Scanner(System.in);
        while (true){
            int actionNumber = scanner.nextInt();
            executeAction(actionNumber);
            activateMenu();
        }
    }
}
