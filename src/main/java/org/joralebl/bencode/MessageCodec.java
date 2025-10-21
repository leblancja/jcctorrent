package org.joralebl.bencode;

public interface MessageCodec {
    byte[] encode(BValue value) throws CodecException;
    BValue decode(byte[] data) throws CodecException;
}
