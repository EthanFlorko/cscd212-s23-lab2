package cscd212comparators.lab2;

import java.util.Comparator;
import cscd212classes.lab2.Television;

public class TelevisionModelScreenSizeComparator implements Comparator<Television> {

    public TelevisionModelScreenSizeComparator() {
    }

    @Override
    public int compare(Television t1, Television t2) {
        if (t1 == null || t2 == null) {
            throw new IllegalArgumentException("null parameter in TelevisionModelScreenSizeComparator");
        }
        int modelCompare = t1.getModel().compareTo(t2.getModel());
        if (modelCompare != 0) {
            return modelCompare;
        }
        return Integer.compare(t1.getScreenSize(), t2.getScreenSize());
    }
}
