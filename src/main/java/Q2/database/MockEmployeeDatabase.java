package Q2.database;

import Q2.entity.Employee;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class MockEmployeeDatabase implements MockDatabase<String, Employee> {

    private final ConcurrentMap<String, Employee> db = new ConcurrentHashMap<>();

    @Override
    public ConcurrentMap<String, Employee> getResource() {
        return db;
    }
}
