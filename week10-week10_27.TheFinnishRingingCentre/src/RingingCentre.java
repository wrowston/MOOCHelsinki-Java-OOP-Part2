import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RingingCentre {
    private Map<Bird, List<String>> observationPlaces;

    public RingingCentre() {
        this.observationPlaces = new HashMap<Bird, List<String>>();
    }

    public void observe(Bird bird, String place) {
        //which records the observation and its place among the bird information
        if (!this.observationPlaces.containsKey(bird)) {
            this.observationPlaces.put(bird, new ArrayList<String>());
        }
        this.observationPlaces.get(bird).add(place);
    }

    public void observations(Bird bird) {
        //which prints all the observations of the parameter bird
        if (this.observationPlaces.get(bird) == null) {
            System.out.println(bird + " observations: 0");
        } else {
            int observations = this.observationPlaces.get(bird).size();
            System.out.println(bird + " observations: " + observations);
            for (int i = 0; i < observations; i++) {
                System.out.println(this.observationPlaces.get(bird).get(i));
            }
        }
    }
}
