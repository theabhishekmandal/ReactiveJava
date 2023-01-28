package org.example.dto;

public final class Util {
    private Util() {}

    public static void sleep(int secs) {
        try {
            Thread.sleep(1000L * secs);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
