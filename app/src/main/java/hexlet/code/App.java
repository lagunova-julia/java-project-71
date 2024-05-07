package hexlet.code;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.nio.file.Files;
import java.util.List;
import java.util.concurrent.Callable;


@Command(
        name = "gendiff", version = "1.0.0", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference."
)
public class App implements Callable {
    @Parameters(index = "0", description = "path to first file", paramLabel = "filepath1")
    private String filepath1;// = new File("/src/test/resources/file1.json"); мб не нужно создавать файл
    @Parameters(index = "1", description = "path to second file", paramLabel = "filepath2")
    private String filepath2;// = new File("/src/test/resources/file2.json");
    @Option(names={"-f", "--format"}, description = "output format [default: stylish]", paramLabel = "format")
    private String format;

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args); //"-h" was instead of args
        System.exit(exitCode);
    }

    @Override
    public Object call() throws Exception {
        System.out.println(Differ.generate(filepath1, filepath2));
        return 0;
    }
}
