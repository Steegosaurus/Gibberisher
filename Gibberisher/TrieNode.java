public class TrieNode<T> {
    private T nodeData;
    private TrieNode<T>[] next;
    // Constructor that creates a trie node object with an empty array of potential next nodes and null data
    public TrieNode(){
        nodeData = null;
        next = (TrieNode<T>[]) new TrieNode[26];
        for(int i = 0; i < 26; i++){
            next[i] = null;
        }
    }
    // Returns the data of the node
    public T getData(){
        return nodeData;
    }
    // Sets the data of the node
    public void setData(T newData){
        nodeData = newData;
    }
    // Returns the next node that is associated with the letter inputted
    public TrieNode<T> getChild(char letter){
        if(((int)letter >= 65 && (int)letter <= 90) || ((int)letter >= 97 && (int)letter <= 122)){
            if((int)letter >= 65 && (int)letter <= 90){
                letter += 32;
            }
            if(next[(int)letter - 97] == null){
                next[(int)letter - 97] = new TrieNode<>(); 
            }
            return next[(int)letter - 97];
        }
        else{
            return null;
        }
    }
    // Returns the number of nodes is the tree/system of nodes
    public int getTreeSize(){
        int treeSum = 1;
        for(int i = 0; i < 26; i++){
            if(next[i] != null){
                treeSum += next[i].getTreeSize();
            }
        }
        return treeSum;
    }
}
