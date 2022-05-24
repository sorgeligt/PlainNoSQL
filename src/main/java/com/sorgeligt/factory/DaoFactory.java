package com.sorgeligt.factory;

import com.sorgeligt.Config;
import com.sorgeligt.Dao;
import com.sorgeligt.Entry;

import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public interface DaoFactory {

    interface Factory<D, E extends Entry<D>> {

        default Dao<D, E> createDao() throws IOException {
            throw new UnsupportedOperationException("Need to override one of createDao methods");
        }

        default Dao<D, E> createDao(Config config) throws IOException {
            return createDao();
        }

        String toString(D data);

        D fromString(String data);

        E fromBaseEntry(Entry<D> baseEntry);
    }

}
