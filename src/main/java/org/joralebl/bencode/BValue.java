package org.joralebl.bencode;

import java.util.List;
import java.util.Map;

public sealed interface BValue permits BString, BInteger, BList, BDict {
}

record BString(byte[] value) implements BValue {}
record BInteger(long value) implements BValue {}
record BList(List<BValue> items) implements BValue {}
record BDict(Map<String, BValue> entries) implements BValue {}
