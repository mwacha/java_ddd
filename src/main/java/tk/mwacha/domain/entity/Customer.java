package tk.mwacha.domain.entity;

import lombok.Getter;
import lombok.Setter;
import tk.mwacha.domain.valueobject.Address;

import java.util.UUID;

@Getter
public class Customer {

    private UUID id;
    private String name;
    @Setter
    private Address address;
    private boolean active;

    private int rewardPoints;

    public Customer(final UUID id, final String name) {
        this.id = id;
        this.name = name;
        this.validate();
    }

    public void changeName(final String name) {
        this.name = name;
        this.validate();
    }

    public void activate() {
        if (this.address == null) {
            throw new RuntimeException("Address is required to activate a customer");
        }
        this.active = true;
    }

    public void deactivate() {
        this.active = false;
    }


    public void addRewardPoints(final int points) {
        this.rewardPoints += points;
    }

    private void validate() {

        if (this.id == null) {
            throw new RuntimeException("Id is required");
        }

        if (this.name == null || this.name.isEmpty()) {
            throw new RuntimeException("Name is required");
        }
    }
}