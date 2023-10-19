package ru.job4j.io;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        byte b = 24;
        short s = 24231;
        int i = -219741;
        double d = 1.23;
        float f = 2.3F;
        long l = 9325158645L;
        boolean boo = true;
        char c = 'V';

        LOG.debug("Primitive type: byte {}, short {}, int {}, double {}, float {}, long {}, boolean {}, char {}",
                b, s, i, d, f, l, boo, c);
    }
}
