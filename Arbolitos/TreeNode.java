public class TreeNode {

    private Object element;
    private TreeNode left;
    private TreeNode right;
    

    public TreeNode(){
        element = null;
        left = null;
        right = null;
    }

    public Object getElement(){
        return element;
    }

    public void setElement(Object elem){
        element = elem;
    }

    public TreeNode getLeft(){
        return left;
    }

    public TreeNode getRight(){
        return right;
    }

    public void printPreOrder(){
        System.out.println(element);

        if(left != null){
            left.printPreOrder();
        }

        if(right != null){
            right.printPreOrder();
        }
    }

    public void printInOrder(){

        if(left != null){
            left.printInOrder();
        }
        System.out.println(element);

        if(right != null){
            right.printInOrder();
        }


    }


    public void printPostOrder(){
        if(left != null){
            left.printPostOrder();
        }
        if(right != null){
            right.printPostOrder();
        }
        System.out.println(element);




    }


}
