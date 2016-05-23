
/*
 Full name :  ROHIT AMGAONKAR
 LU ID : L20315473
 Course : COSC_5369_01_2014_90_1: 2014 Fall - COSC 5369_01_1 - Graduate Project
 Program title : Feature.java

 Instructor: Jing Zhang;  

 Below program does the following:
 this is program for SIFT feature container
 */
package sift;

import java.io.Serializable;

public class Feature implements Comparable< Feature>, Serializable {

    public float scale;
    public float orientation;
    public float[] location;
    public float[] descriptor;

    /**
     * Dummy constructor for Serialization to work properly.
     */
    public Feature() {
    }

    public Feature(float s, float o, float[] l, float[] d) {
        scale = s;
        orientation = o;
        location = l;
        descriptor = d;
    }

    /**
     * comparator for making Features sortable please note, that the comparator
     * returns -1 for this.scale &gt; o.scale, to sort the features in a
     * descending order
     */
    public int compareTo(Feature f) {
        return scale < f.scale ? 1 : scale == f.scale ? 0 : -1;
    }

    public float descriptorDistance(Feature f) {
        float d = 0;
        for (int i = 0; i < descriptor.length; ++i) {
            float a = descriptor[ i] - f.descriptor[ i];
            d += a * a;
        }
        return (float) Math.sqrt(d);
    }
}
