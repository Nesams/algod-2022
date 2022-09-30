package ee.ttu.algoritmid.events;

import java.util.*;


public class Events {

    private final HashMap<Integer, Integer> eventParticipants;
    private static int leftSpots;

    public Events(int maxParticipants) {
        leftSpots = maxParticipants;
        if (maxParticipants > 0) {
            eventParticipants = new HashMap<>(leftSpots);
        }
        else {
            eventParticipants = new HashMap<>(0);
        }
    }

    public HashMap<Integer, Integer> getEventParticipants() {
        return eventParticipants;
    }

    public void registerParticipant(String eventName, int eventLengthMinutes, boolean freeTickets) {
        int event = Objects.hash(eventName, eventLengthMinutes, freeTickets);
        eventParticipants.putIfAbsent(event, 0);
        eventParticipants.put(event, eventParticipants.get(event) + 1);
        leftSpots -= 1;
    }

    public int eventPopularity(String eventName, int eventLengthMinutes, boolean freeTickets) {
        int event = Objects.hash(eventName, eventLengthMinutes, freeTickets);
        if (eventParticipants.containsKey(event)) {
            return eventParticipants.get(event);
        }
        return 0;
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
        if (eventParticipants.size() >= 2) {
            List<Map.Entry<Integer, Integer>> sortedList = eventParticipants.entrySet().stream()
                    .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue())).toList();
            int firstValue = sortedList.get(0).getValue();
            int secondValue = sortedList.get(1).getValue();

            return List.of(firstValue, secondValue);
        } else {
            List<Map.Entry<Integer, Integer>> sortedList = eventParticipants.entrySet().stream().toList();
            return Collections.singletonList(sortedList.get(sortedList.size() - 1).getValue());
        }
    }
    public static void main(String[] args) {
        Events events1 = new Events(30);
        int event1 = Objects.hash("YES", 30, false);
        events1.registerParticipant("YES", 30, false);
        events1.registerParticipant("Yes", 40, false);
        events1.registerParticipant("Yes", 40, false);
        events1.registerParticipant("No", 21, true);
        System.out.println(events1.getEventParticipants());
        System.out.println(events1.eventPopularity("YES", 30, false));
        System.out.println(events1.getTop1Participants());
        System.out.println(events1.getTop2Participants());
    }
}



