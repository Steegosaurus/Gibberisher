public class Trie<T>{
    private TrieNode<T> root;
    // Contructor that creates a Trie object, which is a system of trienode objects
    public Trie(){
        root = new TrieNode<>();
    }
    // Returns the node associted to the inputted string
    private TrieNode<T> getNode(String nodeString){
        TrieNode<T> retNode;
        if(nodeString.length() == 0){
            retNode = root;
        }
        else{
            retNode = root.getChild(nodeString.charAt(0));
            for(int i = 1; i < nodeString.length(); i++){
                retNode = retNode.getChild(nodeString.charAt(i));
            }
        }
        return retNode;
    }
    // Returns the data of the node associated to the inputted string
    public T get(String inputString){
        return this.getNode(inputString).getData();
    }
    // Changes the data of the node associated to the inputted string and returns that data
    public T put(String inputString, T newValue){
        this.getNode(inputString).setData(newValue);
        return this.getNode(inputString).getData();
    }
    // Returns the root of the system of trie nodes
    public TrieNode<T> getRoot(){
        return root;
    }
}
