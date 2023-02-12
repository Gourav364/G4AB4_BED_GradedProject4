package com.gl.employee.service.impl;

import java.util.Collection;

public final class Functions {

    private Functions() {
        //
    }

    public static boolean contains(Collection<Object> collection, Object item) {
        return collection.contains(item);
    }

}