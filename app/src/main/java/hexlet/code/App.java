package hexlet.code;

import picocli.CommandLine;


public class App {
    public static void main(String[] args) {
        new CommandLine(new Differ()).execute("-h");
    }
}

@CommandLine.Command(
        name = "gendiff", version = "1.0.0", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference."
)

class Differ implements Runnable {
    @Override
    public void run() {
        System.out.println("[gendiff]");
    }
}

