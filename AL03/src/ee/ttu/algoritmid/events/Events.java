package ee.ttu.algoritmid.events;

import java.util.*;


public class Events {

    private HashMap<Integer, Integer> eventParticipants;
    private static int leftSpots;
    private static int spotsCounter = 0;

    public Events(int maxParticipants) {
        leftSpots = maxParticipants;
        if (maxParticipants > 0) {
            eventParticipants = new HashMap<>(leftSpots);
        }
        else {
            eventParticipants = new HashMap<>(0);
        }
    }

    public void registerParticipant(String eventName, int eventLengthMinutes, boolean freeTickets) {
        if (spotsCounter < leftSpots) {
            int event = Objects.hash(eventName, eventLengthMinutes, freeTickets);
            eventParticipants.putIfAbsent(event, 0);
            eventParticipants.put(event, eventParticipants.get(event) + 1);
            spotsCounter += 1;
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
        if (eventParticipants.size() >= 2) {
            List<Map.Entry<Integer, Integer>> sortedList = eventParticipants.entrySet().stream()
                    .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue())).toList();
            int firstValue = sortedList.get(sortedList.size() - 1).getValue();
            int secondValue = sortedList.get(sortedList.size() - 2).getValue();

            return List.of(secondValue, firstValue);
        } else {
            List<Map.Entry<Integer, Integer>> sortedList = eventParticipants.entrySet().stream().toList();
            return Collections.singletonList(sortedList.get(sortedList.size() - 1).getValue());
        }
    }
}

