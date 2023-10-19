

public class LinkedBinaryTree implements BinaryTreeBasis{

    private TreeNode root;


    public LinkedBinaryTree(){
        root = null;
    }

    public Object getRoot(){
        if(root == null) throw new Exception("Arbol vacio");
        return root.getElement();

    }

    public void setRoot(Object item){
        root.setElement(item);
        
    }

    public boolean isEmpty(){
        return root==null;
    }


    public void insertar(Object elem){
        



    }

    public void makeEmpty(){

        if(root.getLeft() != null){
            root.getLeft().makeEmpty();
            root.getLeft().setElement(null);
        }

        if(root.getRight() != null){
            root.getRight().makeEmpty();
            root.getRight().setElement(null);
        }

    }


    // Despues la eliminacion de la raiz se hace por fuera 




}