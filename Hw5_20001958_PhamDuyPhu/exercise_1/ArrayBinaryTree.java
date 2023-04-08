package Hw5_20001958_PhamDuyPhu.exercise_1;

public class ArrayBinaryTree<E> implements BinaryTreeInterface<E> {
    private E[] array;
    private int n = 0;
    private int defaultsize = 100;

    public ArrayBinaryTree() {
        array = (E[]) new Object[defaultsize];
    }

    // update methods
    public void setRoot(E element) {
        // Set element to root of an empty tree
        if (n > 0) {
            throw new IllegalStateException("Cây đã có nút gốc");
        }
        
        array[0] = null;
        array[1] = element;
        n++;

    }

    public void setLeft(int p, E element) {

        if (array[p] == null) {
            throw new NullPointerException("Nút rỗng");
        } else if (p < 1 || p >= array.length) {
            throw new IndexOutOfBoundsException("Chỉ số không hợp lệ");
        } else {
            if (2 * p >= array.length)
                throw new ArrayIndexOutOfBoundsException("Cây đã đầy!!!!");
            else {
                array[2 * p] = element;
                n++;
            }
        }

    }

    public void setRight(int p, E element) {

        if (array[p] == null) {
            throw new NullPointerException("Nút rỗng");
        } else if (p < 1 || p >= array.length) {
            throw new IndexOutOfBoundsException("Chỉ số không hợp lệ");
        } else {
            if (2 * p + 1 >= array.length)
                throw new ArrayIndexOutOfBoundsException("Cây đã đầy!!!!");
            else {
                array[2 * p + 1] = element;
                n++;
            }
        }

    }

    @Override
    public E root() {
        // set root index = 1
        if (isEmpty())
            throw new NullPointerException("Cây đang rỗng");
        return array[1];
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return (n == 0);
    }

    @Override
    public int numChildren(E p) {
        int num = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == p) {
                if (array[2 * i] != null)
                    num++;
                if (array[2 * i + 1] != null)
                    num++;
            }
        }
        return num;
    }

    @Override
    public E parent(E p) {
        for (int i = 0; i < n; i++) {
            if (array[i] == p) {
                return array[(int) i / 2]; // lấy phần nguyên của i/2
            }
        }
        return null;
    }

    @Override
    public E left(E p) {
        for (int i = 0; i < n; i++) {
            if (array[i] == p) {
                return array[2 * i];
            }
        }
        return null;
    }

    @Override
    public E right(E p) {
        for (int i = 0; i < n; i++) {
            if (array[i] == p) {
                return array[2 * i + 1];
            }
        }
        return null;
    }

    @Override
    public E sibling(E p) {
        int idxNode = -1;
        int siblingIdx;

        for (int i = 0; i < n; i++) {
            if (array[i] == p) {
                idxNode = i;
                break;
            }
        }

        if (idxNode == -1) {
            return null;
        }

        if (idxNode % 2 == 0) {
            siblingIdx = idxNode + 1;
        } else {
            siblingIdx = idxNode - 1;
        }

        if (siblingIdx < 1 || siblingIdx > n) {
            // Không tìm thấy sibling
            return null;
        }
        return array[siblingIdx];
    }

   

    public static void main(String[] args) {
        ArrayBinaryTree<Character> tree = new ArrayBinaryTree<Character>();
        tree.setRoot('A');
        System.out.println("Root of tree: " + tree.root());
        tree.setLeft(1, 'B');
        System.out.println("Left of A: " + tree.left('A'));
        tree.setRight(1, 'C');
        tree.setRight(3, 'D');

        System.out.println("Right of A: " + tree.right('A'));
        System.out.println("Sibling of B: " + tree.sibling('B'));
        System.out.println("Sibling of C: " + tree.sibling('C'));
    }
}