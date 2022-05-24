package com.sorgeligt.factory;

import com.sorgeligt.BaseEntry;
import com.sorgeligt.Config;
import com.sorgeligt.Dao;
import com.sorgeligt.Entry;
import com.sorgeligt.bytebufferdao.PersistentDao;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class ByteBufferDaoFactory implements DaoFactory.Factory<ByteBuffer, BaseEntry<ByteBuffer>> {
    @Override
    public Dao<ByteBuffer, BaseEntry<ByteBuffer>> createDao(Config config) throws IOException {
        return new PersistentDao(config);
    }

    @Override
    public String toString(ByteBuffer data) {
        if (data == null) {
            return null;
        }
        int dataCurrentPosition = data.arrayOffset() + data.position();
        return new String(data.array(), dataCurrentPosition, data.remaining(), StandardCharsets.UTF_8);
    }

    @Override
    public ByteBuffer fromString(String data) {
        return data == null ? null : ByteBuffer.wrap(data.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public BaseEntry<ByteBuffer> fromBaseEntry(Entry<ByteBuffer> baseEntry) {
        return new BaseEntry<>(baseEntry.key(), baseEntry.value());
    }
}
