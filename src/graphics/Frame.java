package graphics;
import chemistry.FunctionalGroup;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;

import javax.swing.*;
import java.util.function.Function;

/**
 * Created by Siderskini1 on 3/29/17.
 */

public class Frame {
    // The program uses an UndirectedSparseGraph to represent FunctionalGroups
    private UndirectedSparseGraph<String, String> graph;
    private BasicVisualizationServer<String,String> visual;
    private Layout<String, String> layout;
    private JFrame frame;

    // Default Constructor creates a new SparseGraph from a FunctionalGroup
    public Frame (FunctionalGroup group) {
        graph = createGraph(group);
        layout = new CircleLayout(graph);
        visual = new BasicVisualizationServer(layout);
        frame = new JFrame("Organic Chemistry Solver");
    }

    // Takes a functional group and makes it into a graph
    private UndirectedSparseGraph createGraph(FunctionalGroup group) {
        //TODO: Write a function that takes in a functional group and turns it into a graph
        UndirectedSparseGraph<String, String> graph = new UndirectedSparseGraph<>();
        graph.addVertex("Hydrogen1");
        graph.addVertex("Oxygen");
        graph.addVertex("Hydrogen2");
        graph.addEdge("SINGLE", "Hydrogen1", "Oxygen");
        graph.addEdge("Doub", "Hydrogen2", "Oxygen");
        return graph;
    }

    // Displays the molecule as a graph
    public void display() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(visual);
        frame.pack();
        frame.setVisible(true);
    }
}
