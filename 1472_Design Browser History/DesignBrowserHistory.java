class BrowserHistory {
    private Node head;
    private Node curr;

    public BrowserHistory(String homepage) {
        head = new Node(homepage);
        curr = head;
    }
    
    public void visit(String url) {
        Node next = new Node(url);
        curr.right = next;
        next.left = curr;
        curr = next;
    }
    
    public String back(int steps) {
        while(steps-- > 0) {
            if(curr.left !=null) curr = curr.left;
            else break;
        }
        return curr.url;
    }
    
    public String forward(int steps) {
        while(steps-- > 0) {
            if(curr.right != null) curr = curr.right;
            else break;
        }
        return curr.url;
    }
}

class Node {
    public Node(String url){
        this.url = url;
    }
    public String url;
    public Node left;
    public Node right;
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);

leetcode.com
google.com
->linkedlin.com
youtube.com

 */