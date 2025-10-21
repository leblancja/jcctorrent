package org.joralebl.bencode;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface MessageCodec {
    byte[] encodeToBytes(BValue value) throws CodecException;
    BValue decodeFromBytes(byte[] data) throws CodecException;

    void encode(BValue value, OutputStream out) throws IOException, CodecException;
    BValue decode(InputStream in) throws IOException, CodecException;
}
