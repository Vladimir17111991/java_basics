import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();

        findPlanesLeavingInTheNextTwoHours(airport).forEach(System.out::println);
    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {

        Date dateNow = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateNow);
        calendar.add(Calendar.HOUR, 2);
        Date dateFuture = calendar.getTime();

        List<Terminal> terminals = airport.getTerminals();
        return terminals.stream().flatMap(terminal -> terminal.getFlights().stream())
                .filter((flight -> (dateNow.compareTo(flight.getDate()) < 0) &&
                        (dateFuture.compareTo(flight.getDate()) > 0) &&
                        (flight.getType().compareTo(Flight.Type.DEPARTURE) == 0)))
                .collect(Collectors.toList());
    }
}