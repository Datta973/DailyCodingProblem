/*

Problem statement : 

cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns the first and last element of that pair. For example, car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4.

Given this implementation of cons:

def cons(a, b):
    def pair(f):
        return f(a, b)
    return pair
    
Implement car and cdr

Comments : 
    After some research I found out that this is a problem based on functional programming.
    This was easy to implement in Javascript and python but seemed challenging in Java.
    But after some tinkering finally finished this using interfaces and anonymous methods.
    The key concept to achieve this in Java is "SAM" - Single Abstract Method
*/
public class Day_5_FirstAndLastOfPair{
    public static void main(String[] args){
        Callable<Pair<Integer>> cons = (a, b) -> {
            Pair<Integer> pair = f -> f.call(a, b);
            return pair;
        };
        
        Func<Integer> car = (pair) -> {
            Callable<Integer> f = (a, b) -> a;
            return pair.call(f);
        };
        
        Func<Integer> cdr = (pair) -> {
            Callable<Integer> f = (a, b) -> b;
            return pair.call(f);
        };
        
        System.out.println(car.call(cons.call(3, 4))); // outputs 3
        System.out.println(cdr.call(cons.call(3, 4))); // outputs 4
    }
    
    static interface Callable<T>{
        public T call(int a, int b);
    }
    
    static interface Pair<T>{
        public T call(Callable<Integer> f);
    }
    
    static interface Func<T>{
        public T call(Pair<Integer> p);
    }
}