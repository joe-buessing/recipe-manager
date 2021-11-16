import java.util.regex.Pattern;

public class SerializationHelper {
    public String makeNameLegal(String input){
        String[] windowsLegalNames = {"con", "prn", "aux", "nul", "com1", "com2", "com3", "com4", "com5", "com6", "com7",
                "com8", "com9", "lpt1", "lpt2", "lpt3", "lpt4", "lpt5", "lpt6", "lpt7", "lpt8", "lpt9"};

        Pattern[] illegalChars = {Pattern.compile("<"), Pattern.compile(">"), Pattern.compile(":"), Pattern.compile("\""),
                Pattern.compile(""), Pattern.compile("\\" + "\\"), Pattern.compile("/"), Pattern.compile("\\|"),
                Pattern.compile("\\?"), Pattern.compile("\\*")};

        StringBuilder inputBuilder = new StringBuilder(input);
        for (String str : windowsLegalNames) {
            if (inputBuilder.toString().equals(str)) {
                inputBuilder.append("_recipe");
            }
        }
        input = inputBuilder.toString();
        for (Pattern str : illegalChars) {
            input = input.replaceAll(str.toString(), "");
        }

        return input;
    }
}
