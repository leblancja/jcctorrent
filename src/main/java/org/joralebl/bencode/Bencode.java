package org.joralebl.bencode;

public final class Bencode {
    private static final MessageCodec DEFAULT = new BencodeCodec();
    private Bencode() {}

    public static byte[] encode(BValue v) { return DEFAULT.encode(v); }
    public static BValue decode(byte[] data) { return DEFAULT.decode(data); }

}
