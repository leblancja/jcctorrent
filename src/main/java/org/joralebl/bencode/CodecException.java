package org.joralebl.bencode;

public class CodecException extends RuntimeException {
    public CodecException(String message) {
        super(message);
    }
    public CodecException(String message, Throwable cause) { super(message,cause); }
    public CodecException(Throwable cause) { super(cause); }

}
