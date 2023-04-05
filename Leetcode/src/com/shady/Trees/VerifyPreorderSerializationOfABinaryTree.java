package com.shady.Trees;

import java.util.LinkedList;

public class VerifyPreorderSerializationOfABinaryTree {
    public boolean isValidSerialization(String preorder) {
        LinkedList<String> nodes = new LinkedList<>();
        for (String s :preorder.split(",")
             ) {
            nodes.add(s);
        }
        return deserialize(nodes) && nodes.isEmpty();
    }
    private boolean deserialize(LinkedList<String> nodes){
        //Each time we are deleting one node in nodes.
        //If nodes is empty when the recursion is till ongoing, it returns false
        if(nodes.isEmpty()) return false;
        String s = nodes.removeFirst();
        if(s.equals("#")) return true;

        return deserialize(nodes) && deserialize(nodes);


        /**
         * But here's a special situation:
         * preorder = "9,#,#,1"
         *
         * When the whole recursion returns true, there's still one node in nodes. We should return false
         * In this case, we should add another condition(if nodes is empty) in the main method
         */
    }
}
