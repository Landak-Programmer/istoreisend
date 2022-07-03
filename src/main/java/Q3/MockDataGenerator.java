package Q3;

import com.jfinal.plugin.activerecord.Record;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MockDataGenerator {

    public static List<Record> generateMockGameList() {
        List<Record> list = new ArrayList<>();

        Map<String, String> data = new HashMap<>();
        data.put("value", "game1");
        list.add(generateRecord(data));
        data.put("value", "game2");
        list.add(generateRecord(data));
        data.put("value", "game3");
        list.add(generateRecord(data));

        return list;
    }

    public static List<Record> generateMockRecordList() {
        List<Record> list = new ArrayList<>();

        Map<String, String> data = new HashMap<>();
        data.put("game", "game1");
        data.put("eventId", "event1");
        list.add(generateRecord(data));
        data.put("game", "game2");
        data.put("eventId", "event1");
        list.add(generateRecord(data));
        data.put("game", "game3");
        data.put("eventId", "event4");
        list.add(generateRecord(data));

        return list;
    }

    public static List<String> generateMockEventIds() {
        List<String> eventIds = new ArrayList<>();
        eventIds.add("event1");
        eventIds.add("event2");
        eventIds.add("event3");
        return eventIds;
    }

    private static Record generateRecord(Map<String, String> var) {
        Record record = new Record();
        var.forEach(record::set);
        return record;
    }
}
