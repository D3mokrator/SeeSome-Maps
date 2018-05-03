import java.util.Collection;
import java.util.Map;

public interface Noise {
    int noiseValue(Object o);
    Map<?, Integer> noiseValueMap(Collection c);
}
