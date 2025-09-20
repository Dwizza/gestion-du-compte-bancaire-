package model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class Account {

         private String accountId;
         private UUID ownerUserId;
         private BigDecimal balance;
         private Instant createdAt;
         private boolean active;

         public Account(String accountId, UUID ownerUserId) {
             this.accountId = accountId;
             this.ownerUserId = ownerUserId;
             balance = BigDecimal.ZERO;
             createdAt = Instant.now();
             active = true;
         }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public UUID getOwnerUserId() {
        return ownerUserId;
    }

    public void setOwnerUserId(UUID ownerUserId) {
        this.ownerUserId = ownerUserId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
