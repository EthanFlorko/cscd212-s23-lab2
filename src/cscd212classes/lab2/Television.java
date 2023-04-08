package cscd212classes.lab2;

import java.util.Objects;

public class Television implements Comparable<Television> {

    private final String make;
    private final String model;
    private final int screenSize;
    private final int resolution;
    private final boolean smart;
    private final boolean fourK;

    public Television(String make, String model, boolean smart, int screenSize, int resolution) {
        if (make == null || make.isEmpty() || model == null || model.isEmpty() || screenSize < 32 || resolution < 720) {
            throw new IllegalArgumentException();
        }
        this.make = make;
        this.model = model;
        this.screenSize = screenSize;
        this.resolution = resolution;
        this.smart = smart;
        this.fourK = (resolution == 2160);
    }

    public Television(String model, boolean smart, int screenSize, int resolution, String make) {
        this(make, model, smart, screenSize, resolution);
    }

    public int getScreenSize() {

        return screenSize;
    }

    public int getResolution() {
        return resolution;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        String str = make + "-" + model + ", " + screenSize + " inch tv";
        if (smart) {
            str += " smart";
        }
        if (resolution == 2160) {
            str += " with 4K resolution";
        } else {
            str += " with " + resolution + " resolution";
        }
        return str;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Television)) {
            return false;
        }
        Television other = (Television) o;
        return make.equals(other.make) && model.equals(other.model)
                && screenSize == other.screenSize && resolution == other.resolution && smart == other.smart && fourK == other.fourK;
    }

    @Override
    public int hashCode() {
        int result = make.hashCode();
        result = 31 * result + model.hashCode();
        result = 31 * result + resolution;
        result = 31 * result + Boolean.hashCode(smart);
        result = 31 * result + Boolean.hashCode(fourK);
        return result;
    }

    @Override
    public int compareTo(Television another) {
        if (another == null) {
            throw new IllegalArgumentException();
        }
        int makeCompare = make.compareTo(another.make);
        if (makeCompare != 0) {
            return makeCompare;
        }
        int modelCompare = model.compareTo(another.model);
        if (modelCompare != 0) {
            return modelCompare;
        }
        return Integer.compare(screenSize, another.screenSize);
    }
}