import Exceptions.EmptyStackException;
import Exceptions.FullStackException;

public class StackImpl<E> implements Stack<E>{
    private E[] v;
    private int i = 0;
    private int maxLen;

    public StackImpl(int len){
        this.maxLen = len;
        this.v = (E[]) new Object[len];
    }

    @Override
    public void push(E o) throws FullStackException {
        if(i == maxLen)
            throw new FullStackException("The Stack is already full");
        v[i++] = o;

    }

    @Override
    public E pop() throws EmptyStackException {
        if (i == 0) {
            throw new EmptyStackException("The Stack is already full");
        }else{
            E ret = this.v[i-1];
            this.v[i-1] = null;
            this.i--;
            return ret;
        }

    }
    private boolean isEmpty(){
        return (i==0);
    }
    @Override
    public E peek() {
        return this.v[this.i-1];
    }

    @Override
    public int size() {
        return this.i;
    }
}
