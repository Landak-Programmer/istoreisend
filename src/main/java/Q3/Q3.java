package Q3;

import com.jfinal.plugin.activerecord.Record;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Q3 {

    private static final Logger LOGGER = LoggerFactory.getLogger(Q3.class);

    // please refer to MockDataGenerator.java
    public static void main(String[] args) {
        List<Record> gameList = MockDataGenerator.generateMockGameList();
        List<Record> recordList = MockDataGenerator.generateMockRecordList();
        List<String> eventIds = MockDataGenerator.generateMockEventIds();

        setGameModel(recordList, gameList, eventIds);
        setGameModelV2(recordList, gameList, eventIds);
    }


    // original code
    private static void setGameModel(List<Record> records, List<Record> gameList,
                                     List<String> eventIds) {
        List<Record> gameModel = new ArrayList<>();
        for (Record game : gameList) {
            String _game = game.getStr("value");
            int idx = 0;
            for (String eventId : eventIds) {
                for (Record record : records) {
                    String _eventId = record.getStr("eventId");
                    if (record.getStr("game").equals(_game) &&
                            eventId.equals(_eventId)) {
                        idx++;
                    }
                }
            }
            if (idx > 0) {
                gameModel.add(game);
            }
        }
        set("gameModel", gameModel);
        System.out.println("=============================================");
    }

    /**
     * Answer:
     * <p>
     * Refactored code.
     * <p>
     * The intention behind original code:
     * create a list of gameRecord that
     * gameRecord.value = record.game
     * AND
     * record.eventId that exist in eventIds
     *
     * @param records
     * @param gameList
     * @param eventIds
     */
    private static void setGameModelV2(List<Record> records, List<Record> gameList,
                                       List<String> eventIds) {
        // what we do here is to filter the record. Once we know which record that have
        // the specific eventId, then...
        List<Record> filteredRecord =
                records.stream().filter(r -> eventIds.stream()
                                .anyMatch(eIds -> eIds.equals(r.getStr("eventId"))))
                        .collect(Collectors.toList());

        // we use the filtered list of record to pull gameRecord
        List<Record> gameModel = gameList.stream().filter(gr -> filteredRecord.stream()
                        .anyMatch(r -> r.getStr("game").equals(gr.getStr("value"))))
                .collect(Collectors.toList());
        set("gameModel", gameModel);
        System.out.println("=============================================");
    }

    // verified solution is correct
    private static void set(final String str, final List<Record> list) {
        list.forEach(System.out::println);
    }


}
