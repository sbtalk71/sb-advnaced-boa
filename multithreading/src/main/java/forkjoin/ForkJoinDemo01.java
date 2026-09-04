package forkjoin;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinDemo01 {
    public static void main(String[] args) {
        ForkJoinPool fjp= new ForkJoinPool();
       
        fjp.invoke(new NumberSplitterAction(400));

    }
}
