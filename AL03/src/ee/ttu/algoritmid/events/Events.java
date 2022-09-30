package ee.ttu.algoritmid.events;

import java.util.*;


public class Events {

    private HashMap<Integer, Integer> eventParticipants = new HashMap<>();
    private static int leftSpots;

    public Events(int maxParticipants) {
         leftSpots = maxParticipants;

    }

    public static int getLeftSpots() {
        return leftSpots;
    }

    public void registerParticipant(String eventName, int eventLengthMinutes, boolean freeTickets) {
        if (leftSpots != 0) {
            int event = Objects.hash(eventName, eventLengthMinutes, freeTickets);
            if (eventParticipants.containsKey(event)) {
                eventParticipants.put(event, eventParticipants.get(event) + 1);
            } else {
                eventParticipants.putIfAbsent(event, 1);
            }
            leftSpots -= 1;
        }
    }

    public int eventPopularity(String eventName, int eventLengthMinutes, boolean freeTickets) {
        int event = Objects.hash(eventName, eventLengthMinutes, freeTickets);
        return eventParticipants.get(event);
    }

    public int getTop1Participants() {
        return Collections.max(eventParticipants.values());
    }

    public List<Integer> getTop2Participants() {
//        ArrayList<Map.Entry<Integer, Integer>> arrayList = new ArrayList<>(eventParticipants.entrySet());
//        arrayList.sort((o1, o2) -> (o1.getValue()).compareTo(o2.getValue()));
//    HashMap<Integer, Integer> sortedMap = new LinkedHashMap<Integer, Integer>();
//        for (Map.Entry<Integer, Integer> arrayL : arrayList) {
//        sortedMap.put(arrayL.getKey(), arrayL.getValue());
//    }
        List<Map.Entry<Integer, Integer>> sortedList = eventParticipants.entrySet().stream()
                .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue())).toList();
        int firstValue = sortedList.get(sortedList.size() - 1).getValue();
        int secondValue = sortedList.get(sortedList.size() - 2).getValue();

        return List.of(firstValue, secondValue);
    }
}

