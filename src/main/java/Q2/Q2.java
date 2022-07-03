package Q2;

import Q2.entity.Employee;
import Q2.service.EmployeeService;
import Q2.service.EmployeeServiceImpl;

public class Q2 {

    public static void main(String[] args) {

        // this is only to mock backend service
        // this does not connect to webpage

        EmployeeService service = new EmployeeServiceImpl();

        Employee employee = new Employee();
        employee.setId("1");
        employee.setName("Tester");
        employee.setEmail("tester@gmail.com");
        employee.setPhoneNumber("60133456789");
        employee.setClearanceLevel(5L);

        service.create(employee);

        Employee updateEmployee = new Employee();
        updateEmployee.setId("1");
        updateEmployee.setClearanceLevel(3L);

        service.update(updateEmployee);
    }
}
