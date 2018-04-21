package ayuditas;

public class AVL {
//    public AVL(main main)
//    {
//        super(main);
//    }

    public void insert(int i)
    {
        start(new AVLInsert(this, i));
    }

//    public void find(int i)
//    {
//        start(new BSTFind(this, i));
//    }

    public void delete(int i)
    {
        start(new AVLDelete(this, i));
    }

    public void clear()
    {
        root = null;
        setStats();
    }

}
