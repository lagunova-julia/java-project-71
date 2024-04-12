package hexlet.code;

import picocli.CommandLine;
import java.nio.file.Path;


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
    @CommandLine.Parameters(index = "0", description = "path to first file", paramLabel = "filepath1")
    Path filepath1;
    @CommandLine.Parameters(index = "1", description = "path to second file", paramLabel = "filepath2")
    Path filepath2;
    @CommandLine.Option(names={"-f", "--format"}, description = "output format [default: stylish]", paramLabel = "format")
    String format;
    @Override
    public void run() {
        System.out.println("[gendiff]");
    }
}

