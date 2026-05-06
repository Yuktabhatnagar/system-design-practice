package com.yukta.systemdesign.lld.designpatterns.structural.flyweight;

import java.util.*;

// ============= TreeType Class ================
class TreeType {
    // Properties that are common among all trees of this type
    private String name;
    private String color;
    private String texture;

    public TreeType(String name, String color, String texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    public void draw(int x, int y) {
        System.out.println("Drawing " + name + " tree at (" + x + ", " + y + ")");
    }
}


// ================ Tree Class =================
class Tree2 {
    // Attributes that keep on changing
    private int x;
    private int y;

    // Attributes that remain constant
    private TreeType treeType;

    public Tree2(int x, int y, TreeType treeType) {
        this.x = x;
        this.y = y;
        this.treeType = treeType;
    }

    public void draw() {
        treeType.draw(x, y);
    }
}


// ============ TreeFactory Class ==============
class TreeFactory {

    static Map<String, TreeType> treeTypeMap = new HashMap<>();

    public static TreeType getTreeType(String name, String color, String texture) {
        String key = name + " - " + color + " - " + texture;

        if (!treeTypeMap.containsKey(key)) {
            treeTypeMap.put(key, new TreeType(name, color, texture));
        }
        return treeTypeMap.get(key);
    }
}


// ================ Forest Class =================
class Forest2 {
    private List<Tree2> trees = new ArrayList<>();

    public void plantTree(int x, int y, String name, String color, String texture) {
        Tree2 tree = new Tree2(x, y, TreeFactory.getTreeType(name, color, texture));
        trees.add(tree);
    }

    public void draw() {
        for (Tree2 tree : trees) {
            tree.draw();
        }
    }
}


// =============== Client Code ==================
class FlyweightPattern {
    public static void main(String[] args) {
        Forest2 forest = new Forest2();

        // Planting 1 million trees
        for(int i = 0; i < 1000000; i++) {
            forest.plantTree(i, i, "Oak", "Green", "Rough");
        }

        System.out.println("Planted 1 million trees.");
    }
}
