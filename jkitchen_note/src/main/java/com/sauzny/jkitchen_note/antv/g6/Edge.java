package com.sauzny.jkitchen_note.antv.g6;

import java.util.List;

import lombok.Data;

@Data
public class Edge {

    private String shape;
    private String source;
    private String id;
    private String target;
    private int size;
    List<ControlPoints> controlPoints;
    private String label;
    private LabelStyle labelStyle;
}
