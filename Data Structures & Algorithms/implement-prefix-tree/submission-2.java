class PrefixTree {
    Tree root;

    public PrefixTree() {
        root = new Tree();
         
    }

    public void insert(String word) {
         Tree cur = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (cur.children[i] == null) {
                cur.children[i] = new Tree();
            }
            cur = cur.children[i];
        }
        cur.isLast = true;

    }

    public boolean search(String word) {
        Tree cur = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (cur.children[i] == null) {
                return false;
            }
            cur = cur.children[i];
        }

        return cur.isLast;

    }

    public boolean startsWith(String prefix) {
        Tree cur = root;
        for (char c : prefix.toCharArray()) {
            int i = c - 'a';
            if (cur.children[i] == null) {
                return false;
            }
            cur = cur.children[i];
        }

        return true;

    }
}

class Tree {
    Tree[] children = new Tree[26];
    boolean isLast = false;
}
