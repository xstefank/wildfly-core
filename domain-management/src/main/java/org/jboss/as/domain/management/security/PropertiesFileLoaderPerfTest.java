package org.jboss.as.domain.management.security;

import org.jboss.msc.service.StartException;

import java.io.File;
import java.io.IOException;

public class PropertiesFileLoaderPerfTest {

    public static void main(String[] args) throws IOException, StartException {
        File file = new File("test-large.properties");
        System.out.println(file.getAbsolutePath());

        long start = System.currentTimeMillis();

        PropertiesFileLoader loader = new PropertiesFileLoader(file.getAbsolutePath(), null);
        loader.start(null);
        loader.load();
        loader.stop(null);

        long time = System.currentTimeMillis() - start;
        System.out.println("total time - " + time + "ms");
    }
}
