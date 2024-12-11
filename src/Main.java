import java.util.ArrayList;
import java.util.Scanner;
//add to gitHub
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to TO-DO List in JAVA\n");

        ArrayList<String> tasks = new ArrayList<>();
        tasks.add("Wash dishes");
        tasks.add("Watch Youtube");

        String response;
        String newTask;
        do {
            System.out.println("What to you want to do?");
            System.out.println();
            System.out.println("\t1. View Tasks");
            System.out.println("\t2. Add Tasks");
            System.out.println("\t3. Delete Tasks");
            System.out.println();

            System.out.println("Please choose from the selection: (type \"exit\" to exit the app)");
            response = scanner.nextLine().trim().toLowerCase();
            System.out.println();

        switch (response) {
                case "1":
                    if (!tasks.isEmpty()){
                        for (String task : tasks){
                            System.out.println(task);
                        }
                        System.out.println();
                    }
                    else {
                        System.out.println("Task is empty");
                    }
                    System.out.println("Press Enter to continue...");
                    scanner.nextLine();
                    break;

                case "2":
                    System.out.println("Enter your new task:");
                    newTask = scanner.nextLine().trim();
                    if (newTask.isEmpty()) {
                        System.out.println("Task cannot be empty.");
                    } else {
                        tasks.add(newTask);
                        System.out.println("Task saved successfully!");
                    }

                    System.out.println("Press Enter to continue...");
                    scanner.nextLine();
                    break;

                case "3":
                    if (tasks.isEmpty()) {
                        System.out.println("The task list is empty.");
                        System.out.println("Press Enter to continue...");
                        scanner.nextLine();
                    } else {
                        System.out.println("Here are your tasks:");
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i));
                        }
                        System.out.println("Which task do you want to delete? Type \"cancel\" to cancel.");
                        String input = scanner.nextLine().trim();
                        if (input.equalsIgnoreCase("cancel")) {
                            break;
                        }
                        try {
                            int taskNumber = Integer.parseInt(input);
                            if (taskNumber > 0 && taskNumber <= tasks.size()) {
                                String removedTask = tasks.remove(taskNumber - 1);
                                System.out.println("Task \"" + removedTask + "\" is deleted.");
                                scanner.nextLine();
                            } else {
                                System.out.println("Invalid task number.");
                                scanner.nextLine();
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter a valid number.");
                        }
                    }
                    break;
            }
        } while (!response.equals("exit"));
    }
}