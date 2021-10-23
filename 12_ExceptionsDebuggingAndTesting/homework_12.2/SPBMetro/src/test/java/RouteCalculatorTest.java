import core.Line;
import core.Station;
import junit.framework.TestCase;
import org.junit.jupiter.api.DisplayName;

import java.util.*;

public class RouteCalculatorTest extends TestCase {
    private List<Station> route;
    private static StationIndex stationIndex;
    private RouteCalculator routeCalculator;
    private Line line1, line2, line3;

    @Override
    public void setUp() {
        stationIndex = new StationIndex();
        routeCalculator = new RouteCalculator(stationIndex);

        route = new ArrayList<>();
        line1 = new Line(1, "Первая");
        line2 = new Line(2, "Вторая");
        line3 = new Line(3, "Третья");
        route.add(new Station("Девяткино", line1));
        route.add(new Station("Гражданский проспект", line1));
        route.add(new Station("Парнас", line2));
        route.add(new Station("Проспект Просвещения", line2));
        route.add(new Station("Озерки", line2));
        route.add(new Station("Удельная", line2));
        route.add(new Station("Беговая", line3));
        route.add(new Station("Новокрестовская", line3));

    }

    @DisplayName("Метод calculateDuration()")
    public void testCalculateDuration() {

        double actual = RouteCalculator.calculateDuration(route);
        double expected = 19.5;
        assertEquals(expected, actual);
    }

    @DisplayName("Тест на проверку без пересадки")
    public void testGetRouteOnTheLine() {
        stationIndex.addStation(route.get(2));
        stationIndex.addStation(route.get(3));
        stationIndex.addStation(route.get(4));
        stationIndex.addStation(route.get(5));
        Station stationFrom = stationIndex.getStation(route.get(2).getName());
        Station stationTo = stationIndex.getStation(route.get(5).getName());
        line2.addStation(route.get(2));
        line2.addStation(route.get(3));
        line2.addStation(route.get(4));
        line2.addStation(route.get(5));
        List<Station> actual = routeCalculator.getShortestRoute(stationFrom, stationTo);
        List<Station> expected = List.of(route.get(2), route.get(3), route.get(4), route.get(5));
        assertEquals(expected, actual);
    }

    @DisplayName("Тест на проверку с одной пересадкой")
    public void testGetRouteWithOneConnection() {
        List<Station> connections = new ArrayList<>();
        connections.add(route.get(2));
        connections.add(route.get(5));
        connections.add(route.get(6));

        stationIndex.addStation(route.get(2));
        stationIndex.addStation(route.get(3));
        stationIndex.addStation(route.get(4));
        stationIndex.addStation(route.get(5));
        stationIndex.addStation(route.get(6));
        Station stationFrom = stationIndex.getStation(route.get(2).getName());
        Station stationTo = stationIndex.getStation(route.get(6).getName());
        line2.addStation(route.get(2));
        line2.addStation(route.get(3));
        line2.addStation(route.get(4));
        line2.addStation(route.get(5));
        line3.addStation(route.get(6));
        stationIndex.addConnection(connections);
        List<Station> actual = routeCalculator.getShortestRoute(stationFrom, stationTo);
        Collections.sort(actual);
        List<Station> expected = new ArrayList<>(List.of(route.get(2), route.get(3), route.get(4), route.get(5), route.get(6)));
        Collections.sort(expected);
        assertEquals(expected, actual);
    }

    public void testGetRouteWithTwoConnection() {
        List<Station> connections = new ArrayList<>();
        connections.add(route.get(1));
        connections.add(route.get(2));
        connections.add(route.get(5));
        connections.add(route.get(6));
        stationIndex.addConnection(connections);

        stationIndex.addStation(route.get(1));
        stationIndex.addStation(route.get(2));
        stationIndex.addStation(route.get(3));
        stationIndex.addStation(route.get(4));
        stationIndex.addStation(route.get(5));
        stationIndex.addStation(route.get(6));

        line1.addStation(route.get(1));
        line2.addStation(route.get(2));
        line2.addStation(route.get(3));
        line2.addStation(route.get(4));
        line2.addStation(route.get(5));
        line3.addStation(route.get(6));

        Station stationFrom = stationIndex.getStation(route.get(1).getName());
        Station stationTo = stationIndex.getStation(route.get(6).getName());
        List<Station> actual = routeCalculator.getShortestRoute(stationFrom, stationTo);
        List<Station> expected = List.of(route.get(1), route.get(2), route.get(3), route.get(4), route.get(5), route.get(6));
        assertEquals(expected, actual);
    }
}