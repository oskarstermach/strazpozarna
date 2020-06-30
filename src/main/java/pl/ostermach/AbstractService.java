package pl.ostermach;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import java.io.File;
import java.util.Scanner;

public abstract class AbstractService {

    public Scanner in;
    public GraphDatabaseService graphDatabaseService;

    public AbstractService() {
        this.in = new Scanner(System.in);
        GraphDatabaseFactory graphDbFactory = new GraphDatabaseFactory();
        this.graphDatabaseService = graphDbFactory.newEmbeddedDatabase(
                new File("data/firefighter"));
    }


}
