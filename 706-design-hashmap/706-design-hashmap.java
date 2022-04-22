class MyHashMap {
/** Initialize your data structure here. */
    ArrayList<Node> a= new ArrayList<>();
    static class Node{
        int key, value;
        Node(int key, int value){
            this.key = key;
            this.value=value;
        }
        public int getKey()
        {
            return key;
        }
        public int getValue()
        {
            return value;
        }
        public void setValue(int value)
        {
            this.value = value;
        }
        
    }
    
    
    
    
    public MyHashMap() {
        
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        
        int ex = -1;
        for(Node z: a)
        {
            if(z.getKey()==key){
                z.setValue(value);
                return;
            }
        }
        a.add(new Node(key,value));
        
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        for(Node z: a)
        {
            if(z.getKey()==key){
                return z.getValue();
            }
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        for(int i=0;i<a.size();i++)
        {
            //System.out.println(a.get(i).getKey()+" "+a.get(i).getValue());
            if(a.get(i).getKey()==key){
                //System.out.println(a.get(i).getKey()+" "+a.get(i).getValue());
               a.remove(a.get(i));
                //System.out.println(a.size());
                break;
            }
        }
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */