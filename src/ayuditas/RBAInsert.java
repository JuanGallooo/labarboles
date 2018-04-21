package ayuditas;

public class RBAInsert {
	// Decompiled by DJ v3.12.12.101 Copyright 2016 Atanas Neshkov  Date: 21/04/2018 15:06:52
	// Home Page:  http://www.neshkov.com/dj.html - Check often for new version!
	// Decompiler options: packimports(3) 
	// Source File Name:   RBInsert.java


	public class RBInsert extends Algorithm
	{

	    public RBInsert(RB rb, int i)
	    {
	        super(rb.M);
	        T = rb;
	        rb.v = v = new RBNode(rb, K = i);
	        setHeader("insertion");
	    }

	    public void run()
	    {
	        Object obj;
	label0:
	        {
	            obj = T.root;
	            if(T.root == T.NULL)
	            {
	                v.left = v.right = v.parent = T.NULL;
	                T.root = v;
	                v.goToRoot();
	                setText("newroot");
	                mysuspend();
	                break label0;
	            }
	            v.goAboveRoot();
	            setText("bstinsertstart");
	            mysuspend();
	            do
	            {
	                if(((BSTNode) (obj)).key == K)
	                {
	                    setText("alreadythere");
	                    v.goDown();
	                    return;
	                }
	                if(((BSTNode) (obj)).key < K)
	                {
	                    setText("bstinsertright", K, ((BSTNode) (obj)).key);
	                    if(((BSTNode) (obj)).right != T.NULL)
	                    {
	                        obj = ((BSTNode) (obj)).right;
	                    } else
	                    {
	                        ((BSTNode) (obj)).linkright(v);
	                        break;
	                    }
	                } else
	                {
	                    setText("bstinsertleft", K, ((BSTNode) (obj)).key);
	                    if(((BSTNode) (obj)).left != T.NULL)
	                    {
	                        obj = ((BSTNode) (obj)).left;
	                    } else
	                    {
	                        ((BSTNode) (obj)).linkleft(v);
	                        break;
	                    }
	                }
	                v.goAbove(((Node) (obj)));
	                mysuspend();
	            } while(true);
	            v.left = v.right = T.NULL;
	            T.reposition();
	            mysuspend();
	            obj = v;
	            RBNode rbnode = (RBNode)((BSTNode) (obj)).parent;
	            boolean flag;
	            do
	            {
	                if(((BSTNode) (obj)).isRoot() || !rbnode.red)
	                    break label0;
	                ((BSTNode) (obj)).mark();
	                flag = rbnode.isLeft();
	                RBNode rbnode1 = (RBNode)rbnode.parent;
	                RBNode rbnode2 = (RBNode)(flag ? rbnode1.right : rbnode1.left);
	                if(!rbnode2.red)
	                    break;
	                setText("rbinsertcase1");
	                mysuspend();
	                rbnode.red = false;
	                rbnode2.red = false;
	                rbnode1.red = true;
	                ((BSTNode) (obj)).unmark();
	                obj = rbnode1;
	                ((BSTNode) (obj)).mark();
	                rbnode = (RBNode)((BSTNode) (obj)).parent;
	                mysuspend();
	            } while(true);
	            if(flag != ((BSTNode) (obj)).isLeft())
	            {
	                setText("rbinsertcase2");
	                mysuspend();
	                T.rotate(((BSTNode) (obj)));
	                mysuspend();
	            } else
	            {
	                ((BSTNode) (obj)).unmark();
	                obj = ((BSTNode) (obj)).parent;
	                ((BSTNode) (obj)).mark();
	            }
	            rbnode = (RBNode)((BSTNode) (obj)).parent;
	            setText("rbinsertcase3");
	            mysuspend();
	            ((RBNode)obj).red = false;
	            rbnode.red = true;
	            T.rotate(((BSTNode) (obj)));
	            mysuspend();
	            ((BSTNode) (obj)).unmark();
	        }
	        ((BSTNode) (obj)).unmark();
	        ((RBNode)T.root).red = false;
	        T.v = null;
	        T.reposition();
	        setText("done");
	    }

	    RB T;
	    RBNode v;
	    int K;
	}

}
