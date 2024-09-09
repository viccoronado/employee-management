import java.time.LocalDate;
import java.util.Objects;

public class Employee {
    private Long id;
    private Long genderId;
    private Long jobId;
    private String name;
    private String lastName;
    private LocalDate birthDate;

    private Employee(EmployeeBuilder builder) {
        this.id = builder.id;
        this.genderId = builder.genderId;
        this.jobId = builder.jobId;
        this.name = builder.name;
        this.lastName = builder.lastName;
        this.birthDate = builder.birthDate;

        validate();
    }

    // Validate Employee fields
    private void validate() {
        if (Objects.isNull(name) || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        if (Objects.isNull(lastName) || lastName.isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be null or empty.");
        }
        if (Objects.isNull(birthDate) || birthDate.isAfter(LocalDate.now().minusYears(18))) {
            throw new IllegalArgumentException("Employee must be at least 18 years old.");
        }
        if (Objects.isNull(genderId)) {
            throw new IllegalArgumentException("Gender ID cannot be null.");
        }
        if (Objects.isNull(jobId)) {
            throw new IllegalArgumentException("Job ID cannot be null.");
        }
    }

    // Getters
    public Long getId() { return id; }
    public Long getGenderId() { return genderId; }
    public Long getJobId() { return jobId; }
    public String getName() { return name; }
    public String getLastName() { return lastName; }
    public LocalDate getBirthDate() { return birthDate; }

    // Employee Builder
    public static class EmployeeBuilder {
        private Long id;
        private Long genderId;
        private Long jobId;
        private String name;
        private String lastName;
        private LocalDate birthDate;

        public EmployeeBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public EmployeeBuilder withGenderId(Long genderId) {
            this.genderId = genderId;
            return this;
        }

        public EmployeeBuilder withJobId(Long jobId) {
            this.jobId = jobId;
            return this;
        }

        public EmployeeBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public EmployeeBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public EmployeeBuilder withBirthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }
}
