package Q2.service;

import Q2.database.MockDatabase;
import Q2.database.MockEmployeeDatabase;
import Q2.entity.Employee;
import Q2.exception.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class EmployeeServiceImpl implements EmployeeService {

    private final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    final MockDatabase<String, Employee> database;

    public EmployeeServiceImpl() {
        database = new MockEmployeeDatabase();
    }

    @Override
    public MockDatabase<String, Employee> getDatabase() {
        return database;
    }

    @Override
    public Employee create(final Employee employee) {
        LOGGER.info("Create employee. Input {}", employee.toString());
        if (database.read(employee.getId()) != null) {
            LOGGER.warn("Record with id {} exist", employee.getId());
        }
        validation(employee);
        return database.create(employee);
    }

    @Override
    public Employee read(final String id) {
        return database.read(id);
    }

    @Override
    public Employee update(final Employee changeSet) {
        LOGGER.info("Update employee. Input {}", changeSet.toString());
        final Employee pEmployee = read(changeSet.getId());

        if (pEmployee == null) {
            throw new EntityNotFoundException(changeSet.getId());
        }

        if (isChanged(pEmployee.getName(), changeSet.getName())) {
            pEmployee.setName(changeSet.getName());
        }

        if (isChanged(pEmployee.getEmail(), changeSet.getEmail())) {
            pEmployee.setEmail(changeSet.getEmail());
        }

        if (isChanged(pEmployee.getPhoneNumber(), changeSet.getPhoneNumber())) {
            pEmployee.setPhoneNumber(changeSet.getPhoneNumber());
        }

        if (isChanged(pEmployee.getClearanceLevel(), changeSet.getClearanceLevel())) {
            validateClearanceLevel(changeSet.getClearanceLevel());
            pEmployee.setClearanceLevel(changeSet.getClearanceLevel());
        }

        return database.update(pEmployee);
    }

    @Override
    public void delete(final String id) {
        LOGGER.info("Delete employee. Input {}", id);
        database.delete(id);
    }

    private void validation(final Employee employee) {
        validateField(employee.getName(), "name");
        validateField(employee.getEmail(), "email");
        validateField(employee.getPhoneNumber(), "phoneNumber");
        validateClearanceLevel(employee.getClearanceLevel());
    }

    private void validateClearanceLevel(Long clearanceLevel) {
        if ((clearanceLevel != null) && (clearanceLevel < 5 || clearanceLevel > 10)) {
            throw new IllegalArgumentException(
                    String.format("%s is not valid value for clearanceLevel",
                            clearanceLevel));
        }
    }

    private void validateField(String value, String fieldName) {
        if (isBlank(value) && !isAscii(value)) {
            throw new IllegalArgumentException(String.format("%s is not valid value for %s", value, value));
        }
    }

    // ------------------------- UTILITY -------------------------

    private boolean isBlank(String s) {
        return Objects.equals(s, "") || s == null;
    }

    private boolean isAscii(CharSequence cs) {
        if (cs == null) {
            return false;
        } else {
            int sz = cs.length();

            for (int i = 0; i < sz; ++i) {
                if (!isAsciiChar(cs.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    }

    private boolean isAsciiChar(char ch) {
        return ch >= ' ' && ch < 127;
    }

    private boolean isChanged(final Object persistentObj, final Object incoming) {
        if (persistentObj == null && incoming == null) {
            return false;
        }
        if (persistentObj == null) {
            return true;
        }
        if (incoming == null) {
            return false;
        }
        if (persistentObj
                .getClass()
                .equals(incoming.getClass())) {
            return !persistentObj.equals(incoming);
        }
        // default just return false.
        return false;
    }
}
