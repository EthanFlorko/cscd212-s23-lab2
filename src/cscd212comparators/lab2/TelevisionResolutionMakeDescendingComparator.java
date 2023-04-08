package cscd212comparators.lab2;

import java.util.Comparator;
import cscd212classes.lab2.Television;

public class TelevisionResolutionMakeDescendingComparator implements Comparator<Television> {

    public TelevisionResolutionMakeDescendingComparator() {
    }

    @Override
    public int compare(Television t1, Television t2) {
        if (t1 == null || t2 == null) {
            throw new IllegalArgumentException("null parameter in TelevisionResolutionMakeDescendingComparator");
        }

        int resolutionCompare = Integer.compare(t2.getResolution(), t1.getResolution());
        if (resolutionCompare != 0) {
            return resolutionCompare;
        }
        return t1.getMake().compareTo(t2.getMake());
    }
}