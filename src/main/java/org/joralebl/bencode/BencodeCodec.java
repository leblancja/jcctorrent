package org.joralebl.bencode;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BencodeCodec implements MessageCodec {
    public BencodeCodec() {}

    @Override
    public byte[] encodeToBytes(BValue value) throws CodecException {
        return new byte[0];
    }

    @Override
    public BValue decodeFromBytes(byte[] data) throws CodecException {
        return null;
    }

    @Override
    public void encode(BValue value, OutputStream out) throws IOException, CodecException {

    }

    @Override
    public BValue decode(InputStream in) throws IOException, CodecException {
        return null;
    }
}
