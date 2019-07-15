import services.*;

public class Start {
    public static void main(String[] args) {
        TextService textServiceUsual = new TextServiceImpl();
        TextService textServiceWithStreams = new TextServiceWithStreams();

        DemoService demoService = new DemoServiceImpl(textServiceUsual, "Plain way");
        DemoService demoServiceWithStreams = new DemoServiceImpl(textServiceWithStreams, "Stream API used");
        demoService.run();
        demoServiceWithStreams.run();
    }
}
