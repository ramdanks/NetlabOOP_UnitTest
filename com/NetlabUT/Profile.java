package com.NetlabUT;

/** class to show a state of a assumption or comparison
 * @author Ramadhan Kalih Sewu
 * @version 1.0
 */
public class Profile<T extends Object>
{
    private Metric<T> metric;
    private T reference;
    private Class<?> classReference;
    private String message;
    private int referenceStatus;
    private boolean correct;

    public Profile(Metric<T> metric, T reference, int referenceStatus, boolean correct, String message)
    {
        this.metric = metric;
        this.reference = reference;
        this.classReference = null;
        this.referenceStatus = referenceStatus;
        this.message = message;
        this.correct = correct;
    }
    public Profile(Metric<T> metric, Class<?> reference, int referenceStatus, boolean correct, String message)
    {
        this.metric = metric;
        this.reference = null;
        this.classReference = reference;
        this.referenceStatus = referenceStatus;
        this.message = message;
        this.correct = correct;
    }

    public Metric<T> getMetric()        { return metric; }
    public T getReference()             { return reference; }
    public Class<?> getClassReference() { return classReference; }
    public int getReferenceStatus()     { return referenceStatus; }
    public String getReferenceString()
    {
        if (reference == null && classReference == null)
            return "null";
        return reference == null ? classReference.getName() : getObjectIdentifierString(reference);
    }
    public String getMessage()          { return message; }
    public boolean isCorrect()          { return correct; }

    public static <T> String toString(T object)
    {
        if (object == null)
            return "null";
        if (!object.getClass().isArray())
            return object.toString();

        T[] array = (T[]) object;
        String str = "";
        if (array.length > 0)
        {
            str += array[0].toString();
            for (int i = 1; i < array.length; i++)
                str += ',' + array[i].toString();
        }
        return str;
    }

    public static String getObjectIdentifierString(Object obj) {
        if (obj == null) return "null";
        return obj.getClass().getName() + "@" + Integer.toHexString(obj.hashCode());
    }
}