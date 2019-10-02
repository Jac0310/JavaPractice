import java.util.ArrayList;

class Node {

    // keep these​​​​​​‌​​​‌​​‌​​‌​​‌​​​​​‌​​‌‌​ fields
    Node left, right;
    int value;

    public Node(Node left, Node right, int value)
    {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    Node find(int n)
    {

        if (value < n)
        {
            if (right == null) return null;

            return right.find(n);
        }

        if (value > n)
        {
            if (left == null) return null;

            return left.find(n);

            //search left
        }
        if (n == value) return this;

        return null;
    }

    public static void main(String[] args)
    {

        System.out.println(2 >> 5);
        ArrayList<Integer> ar = new ArrayList<>();
        ar.add(1);
        ar.add(1);
        ar.add(1);
        System.out.println(ar.size());

        Node a = new Node(null, null, 1);
        Node b = new Node(a, null, 2);
        Node c = new Node(null, null, 4);
        Node d = new Node(b, c, 3);
        Node g = new Node(null, null, 7);
        Node f = new Node(null, g, 6);
        Node e = new Node(d, f, 5);
        System.out.println(e.find(10));
        System.out.println(e.find(7).value);


    }

}



