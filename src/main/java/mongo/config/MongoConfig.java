package mongo.config;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "mongo.repository")
public class MongoConfig extends AbstractMongoConfiguration {

    private static final String host = "127.0.0.1";
    private static final int port = 27017;

    @Override
    public MongoClient mongoClient() {
        return new MongoClient(host, port);
    }

    @Override
    protected String getDatabaseName() {
        return "exampleDb";
    }
}
