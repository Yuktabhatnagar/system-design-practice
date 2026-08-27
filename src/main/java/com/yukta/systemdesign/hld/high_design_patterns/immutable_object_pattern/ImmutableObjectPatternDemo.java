package com.yukta.systemdesign.hld.high_design_patterns.immutable_object_pattern;

import java.util.ArrayList;
import java.util.List;

public class ImmutableObjectPatternDemo {
    public static void main(String[] args) {
        MoneyTransfer transfer = new MoneyTransfer("A-1", "A-2", 500, List.of("created"));
        System.out.println(transfer.withAuditEntry("reviewed"));
    }
}

record MoneyTransfer(String fromAccount, String toAccount, int amount, List<String> auditTrail) {
    MoneyTransfer { auditTrail = List.copyOf(auditTrail); }
    MoneyTransfer withAuditEntry(String entry) {
        ArrayList<String> entries = new ArrayList<>(auditTrail);
        entries.add(entry);
        return new MoneyTransfer(fromAccount, toAccount, amount, entries);
    }
}
