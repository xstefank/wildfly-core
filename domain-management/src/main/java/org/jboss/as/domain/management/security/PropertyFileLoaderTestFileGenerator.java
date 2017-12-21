package org.jboss.as.domain.management.security;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class PropertyFileLoaderTestFileGenerator {

    public static void main(String[] args) throws Exception {
        File file = new File("test-large.properties");
        PrintWriter writer = new PrintWriter(new FileWriter(file));

        String[] usernameParts = new String[] { "abc", "DEF", "\\\\", ",", "\\=", "@", "-", "012", ".", "/" };
        String[] passwordParts = new String[] { "", ",", "ghi", "JKL", "\\\\", "\\=", "345" };

        for (int i = 0; i < 50; i++) {
            for (int usernameStart = 0; usernameStart < usernameParts.length; usernameStart++) {
                for (int usernameMid = 0; usernameMid < usernameParts.length; usernameMid++) {
                    for (int usernameEnd = 0; usernameEnd < usernameParts.length; usernameEnd++) {
                        for (int passwordStart = 0; passwordStart < passwordParts.length; passwordStart++) {
                            for (int passwordMid = 0; passwordMid < passwordParts.length; passwordMid++) {
                                for (int passwordEnd = 0; passwordEnd < passwordParts.length; passwordEnd++) {
                                    String username = usernameParts[usernameStart] + usernameParts[usernameMid] + usernameParts[usernameEnd];
                                    String password = passwordParts[passwordStart] + passwordParts[passwordMid] + passwordParts[passwordEnd];

                                    writer.printf("%s=%s%n", username, password);
                                }
                            }
                        }
                    }
                }
            }
        }

    }

}
