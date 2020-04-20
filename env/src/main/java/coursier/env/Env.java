package coursier.env;

public class Env {

    public static void main(String[] args) {

        for (String arg: args) {
            String value = System.getenv(arg);

            if (value == null) {
                System.err.println("Environment variable " + arg + " is not defined.");
                System.exit(-1);
            }

            System.out.println(value);
        }
    }

}
