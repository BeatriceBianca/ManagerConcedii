package library;

public class TestCommand extends Command {
    public String input;

    @Override
    public Object execute() {
        return input + System.currentTimeMillis();
    }
}
