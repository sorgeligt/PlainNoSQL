package com.sorgeligt;

public record BaseEntry<Data>(Data key, Data value) implements Entry<Data> {
    @Override
    public String toString() {
        return "{" + key + ":" + value + "}";
    }
}
