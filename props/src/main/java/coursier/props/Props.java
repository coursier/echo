package coursier.props;

public class Props {

    public static void main(String[] args) {

        for (String arg: args) {
            String value = System.getProperty(arg);

            if (value == null) {
                System.err.println("Property " + arg + " is not defined.");
                System.exit(-1);
            }

            System.out.println(value);
        }
    }

}
