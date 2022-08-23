package tk.mwacha.entity;

import lombok.Builder;

import java.util.UUID;

public class Customer {

    private UUID id;
    private String name;
    private String address;
    private boolean active;

    public Customer(UUID id, String name) {
        this.id = id;
        this.name = name;
        this.validate();
    }

    public void changeName(String name) {
        this.name = name;
        this.validate();
    }

    public void activate() {
        if (this.address == null || this.address.isEmpty()) {
            throw new RuntimeException("Address is required to activate a customer");
        }
        this.active = true;
    }

    public void deactivate() {
        this.active = false;
    }

    private void validate() {
        if (this.name == null || this.name.isEmpty()) {
            throw new RuntimeException("Name is required");
        }

        if (this.id == null) {
            throw new RuntimeException("Id is required");
        }
    }
}
