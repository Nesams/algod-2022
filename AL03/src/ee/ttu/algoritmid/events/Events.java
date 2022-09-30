package ee.ttu.algoritmid.events;

import java.util.*;


public class Events {

    private final HashMap<Integer, Integer> eventParticipants;
    private static int leftSpots;
    private final HashMap<Integer, Integer> topMap;
    int top1 = 0;
    int top2 = 0;

    public Events(int maxParticipants) {
        leftSpots = maxParticipants;
        if (maxParticipants > 0) {
            eventParticipants = new HashMap<>(leftSpots);
        }
        else {
            eventParticipants = new HashMap<>(0);
        }
        this.topMap = new HashMap<Integer, Integer>(2);
        this.top1 = 0;
        this.top2 = 0;
        topMap.put(top1, 0); //(registered, eventHash)
        topMap.put(top2, 1); //(registered, eventHash)
    }

    public HashMap<Integer, Integer> getEventParticipants() {
        return eventParticipants;
    }

    private void top1Top2(int event, int howManyRegistered) {
        if (howManyRegistered > top1) {
            if (topMap.get(top1).equals(event)) {
                topMap.remove(top1);
                topMap.put(howManyRegistered, event);
            } else {
                topMap.remove(top2);
                topMap.put(howManyRegistered, event);
                top2 = top1;
            }
            top1 = howManyRegistered;
        } else if (howManyRegistered > top2) {
            topMap.remove(top2);
            topMap.put(howManyRegistered, event);
            top2 = howManyRegistered;
        }
    }


    public void registerParticipant(String eventName, int eventLengthMinutes, boolean freeTickets) {
        int event = Objects.hash(eventName, eventLengthMinutes, freeTickets);
        if (eventParticipants.containsKey(event)) {
            eventParticipants.put(event, eventParticipants.get(event) + 1);
            top1Top2(event, eventParticipants.get(event));
        } else
            eventParticipants.putIfAbsent(event, 1);
            top1Top2(event, 1);
    }

    public int eventPopularity(String eventName, int eventLengthMinutes, boolean freeTickets) {
        int event = Objects.hash(eventName, eventLengthMinutes, freeTickets);
        if (eventParticipants.containsKey(event)) {
            return eventParticipants.get(event);
        }
        return 0;
    }

    public int getTop1Participants() {
        return top1;
    }

    public List<Integer> getTop2Participants() {
        return List.of(top1, top2);
    }
    public static void main(String[] args) {
        Events events1 = new Events(30);
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



