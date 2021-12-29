package basic.javaSE.genericT.demo7;

/**
 * @author: long
 * @create: 2021-12-16 23:37
 * @Description
 **/

public class Box<E> {

    public E first;

    public E getFirst(){
        return first;
    }

    public void setFirst(E first){
        this.first = first;
    }

}
