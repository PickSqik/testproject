import containers.PostgreSQLTestContainer;
import org.testcontainers.containers.PostgreSQLContainer;

public class Main {
    public static void main(String[] args) {
        PostgreSQLTestContainer postgres = new PostgreSQLTestContainer();
        postgres.start();
    }
}