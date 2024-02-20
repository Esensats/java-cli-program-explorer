package esensats.su.oop;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Navigation {
    private final static Scanner in = ScannerStatic.scan();
    private Route tree;
    private Path currentPath;

    public class InvalidCommandException extends Exception {
        InvalidCommandException(String str) {
            super(str);
        }
    }

    public class ExitNavigationRoute extends Route {
        public ExitNavigationRoute() {
            super("ExitNavigationRoute");
        }
    }

    public Navigation(Route tree) {
        this.tree = tree;
        this.currentPath = new Path(this.tree);
    }

    public void init(boolean... flags) throws Exception {

        if (flags.length > 0 && flags[0]) {
            System.in.read();
        }

        clearScreen();

        try {
            System.out.println("Маршрут: " + currentPath.getLast().getName());
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

        Map<String, Route> commandMap = listChildren();

        String command = null;

        System.out.println("Введите команду: ");

        boolean validCommand = true;

        do {
            while (!in.hasNext()) {
                System.out.println("Ошибка, попробуйте снова: ");
                in.next();
            }
            command = in.next();
            try {
                executeCommand(commandMap, command);
                validCommand = true;
            } catch (Exception e) {
                if (e instanceof InvalidCommandException) {
                    System.out.printf("Неправильная команда \"%s\", попробуйте снова: ", e.getMessage());
                    validCommand = false;
                }
                throw e;
            }
        } while (!validCommand);
    }

    private Map<String, Route> listChildren() {
        Map<String, Route> map = new HashMap<String, Route>();

        try {
            if (currentPath.getLast().hasProgram()) {
                map.put("e", currentPath.getLast());
                System.out.println("e: Запустить программу");
            }

            if (currentPath.size() >= 2) {
                map.put("" + 0, currentPath.getParent());
                System.out.println("0: Назад");
            } else {
                map.put("" + 0, new ExitNavigationRoute());
                System.out.println("0: Выйти");
            }

            int idx = 1;
            for (Route rt : currentPath.getLast().getChildren()) {
                map.put("" + idx, rt);
                System.out.printf("%d: %s\n", idx++, rt.getName());
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

        return map;
    }

    private void executeCommand(Map<String, Route> commandMap, String command) throws Exception {

        if (command.equals("exit") || command.equals("q"))
            return;

        Route commandRoute = commandMap.get(command);

        if (commandRoute == null) {
            throw new InvalidCommandException(command);
        }

        try {
            boolean wait = false;
            if (commandRoute instanceof ExitNavigationRoute)
                return;
            else if (commandRoute == currentPath.getLast()) {
                wait = currentPath.getLast().executeProgram();
            } else if (currentPath.size() >= 2 && commandRoute == currentPath.getParent()) {
                currentPath.pop();
            } else {
                currentPath.append(commandRoute);
            }
            init(wait);

        } catch (Exception e) {
            throw e;
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
