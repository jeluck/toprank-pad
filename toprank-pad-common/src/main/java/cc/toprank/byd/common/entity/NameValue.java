package cc.toprank.byd.common.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class NameValue implements Serializable {

    /** Field description */
    private static final long serialVersionUID = -1652551893819030093L;

    /** Field description */
    private final String name;

    /** Field description */
    private final Object value;

    /**
     * Constructs ...
     *
     *
     * @param name
     * @param value
     */
    @JsonCreator
    public NameValue(@JsonProperty(
        value    = "name",
        required = true
    ) String name, @JsonProperty(value = "value") Object value) {
        this.name  = name;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if ((o == null) || (getClass() != o.getClass())) {
            return false;
        }

        NameValue nameValue = (NameValue) o;

        if (!name.equals(nameValue.name)) {
            return false;
        }

        return value.equals(nameValue.value);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();

        result = 31 * result + value.hashCode();

        return result;
    }

    /**
     * Method description
     *
     *
     * @param map
     *
     * @return
     */
    public static List<NameValue> map2nameValueList(Map<String, String> map) {
        List<NameValue> list = new ArrayList<>(map.size());

        for (Map.Entry<String, String> entry : map.entrySet()) {
            NameValue nameValue = new NameValue(entry.getKey(), entry.getValue());

            list.add(nameValue);
        }

        return list;
    }

    @Override
    public String toString() {
        return "NameValue [name=" + name + ", value=" + value + "]";
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public Object getValue() {
        return value;
    }
}



