package Q2.service;

import Q2.database.MockDatabase;
import Q2.entity.Employee;

public interface EmployeeService {

    MockDatabase<String, Employee> getDatabase();

    Employee create(Employee employee);

    Employee read(String id);

    Employee update(Employee changeSet);

    void delete(String id);
}
