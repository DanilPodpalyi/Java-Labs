package Lab3;

/**
 * This class represents a specific location in a 2D map.  Coordinates are
 * integer values.
 **/
public class Location {
    /** X coordinate of this location. **/
    public int xCoord;

    /** Y coordinate of this location. **/
    public int yCoord;


    /** Creates a new location with the specified integer coordinates. **/
    public Location(int x, int y) {
        xCoord = x;
        yCoord = y;
    }

    /** Creates a new location with coordinates (0, 0). **/
    public Location() {
        this(0, 0);
    }
    public boolean equals(Location r) {
        return xCoord == r.xCoord & yCoord ==r.yCoord;
    }
    public int hashcodeTo(){
        return (yCoord*73)+(xCoord*71);
    }
}
