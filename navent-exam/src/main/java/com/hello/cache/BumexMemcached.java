package com.hello.cache;

public class BumexMemcached {
    private static BumexMemcached ourInstance = new BumexMemcached();

    public static BumexMemcached getInstance() {
        return ourInstance;
    }

    private BumexMemcached() {
    }

    public void set(long key, Object value) {}
    public Object get(long key) {return null;}
    public void delete(String key) {}
}
