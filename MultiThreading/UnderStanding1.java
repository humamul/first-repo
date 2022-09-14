package Generics;

public class US1{
    public static void main(String[] args) throws Exception{
        ThreadA a = new ThreadA();
        Thread t = new Thread(a);
        t.start();  // this is the second thread here that we are applying
                        // and the first one is the main thread;
        try {
            t.join();  // without this the answer can be 1 or 3628800  but now its only 3628800
        }catch (Exception e){
            throw e;
        }

        System.out.println(a.p);
    }
}
class ThreadA implements Runnable{

        int p=1;
    @Override
    public void run() {

        for(int i=1;i<=10;i++){
            p*=i;
        }
        System.out.println("Task Done");
    }
}
