package containers;

import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;
import org.testcontainers.utility.MountableFile;

public class PostgreSQLTestContainer extends GenericContainer<PostgreSQLTestContainer> {
    public static final String SERVICE_NAME = "POSTGRESQL_CONTAINER";
    public final int postgresPort = 5432;

    public PostgreSQLTestContainer() {
        super(DockerImageName.parse("postgres:13.3"));
        this.withCreateContainerCmdModifier(cmd -> cmd.withName(SERVICE_NAME));
        this.withEnv("POSTGRES_PASSWORD", "qwerty");
        this.withCopyFileToContainer(MountableFile.forClasspathResource("init_postgresql.sql"), "/docker-entrypoint-initdb.d/init_db.sql");
    }

    public void start() {
        super.addFixedExposedPort(postgresPort, postgresPort);
        super.start();
    }
}