package Q2.entity;

import lombok.Data;

@Data
public class Employee implements IEntity<String> {

    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    protected Long clearanceLevel;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("{id: %s, name: %s, email: %s, phoneNumber: %s, clearanceLevel: %s}",
                id, name, email, phoneNumber, clearanceLevel);
    }
}
