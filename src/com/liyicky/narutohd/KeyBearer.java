package com.liyicky.narutohd;

/**
 * Created by nirinth on 9/8/13.
 */
public class KeyBearer {

    public String ppKey() {
        return "APP-7VW239506Y815252A";
    }

    public String flurryKey() {
        return "Z9GFC6D9YCXK2N9WRGJV";
    }

    public String admobKey() {
        return "a1514a9253c50e6";
    }

    public String ppEmail(int index) {

        if (index == 0) {
            return "jcchealdyn@gmail.com";
        } else if (index == 1) {
            return "scartotheface@gmail.com";
        }
        return null;
    }

}
