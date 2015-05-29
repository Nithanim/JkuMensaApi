package me.nithanim.mensaapi.util;

public class Objects {
    public static final boolean equals(Object obj1, Object obj2) {
        return obj1 == obj2 || (obj1 != null && obj1.equals(obj2));
    }
    
    private Objects() {
    }
}
