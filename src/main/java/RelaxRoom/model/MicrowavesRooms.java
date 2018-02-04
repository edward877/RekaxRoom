package RelaxRoom.model;

import java.util.HashMap;
import java.util.Map;

///связь микроволновок и румов
public class MicrowavesRooms {
    private Map<Integer,Integer> microwavesRoom;

    public MicrowavesRooms() {
        microwavesRoom = new HashMap<>();
        microwavesRoom.put(1, 1);
        microwavesRoom.put(2, 1);
        microwavesRoom.put(3, 2);
        microwavesRoom.put(4, 2);
    }

    public Map<Integer, Integer> getMicrowavesRoom() {
        return microwavesRoom;
    }
}
