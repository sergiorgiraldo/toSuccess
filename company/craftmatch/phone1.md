
int[] myfunct(int[] a, int[] b)
return a new array of ints such that it contains those elements of ‘a’ that are also in ‘b’. not sorted.

```java
int[] myfunct(int[] a, int[] b){
HashSet<Integer> set= new HashSet<Integer>(f);

for(int i=0; i<a.length; ++i){
    if(!set.contains( a[i] ))
        set.add(a[i]);
}

ArrayList<Integer> res= new ArrayList<Integer>();
for(int i=0; i < b.length; ++i){
if( set.contains(b[i]) ){
     res.add(b[i]);
}
}
  return res.toArray();
}
```

int[] myfunction( int[] a )

returns a new array that contains the elements of a multiplied by 2, 
e.g. y[i] = x[i] * 2;
returns a new array that is the sqrt of the elements of ‘a’


```java
int[] myfunction( int[] a ){
ArrayList<Integer> res= new ArrayList<Integer>();

for( int i=0; i< a.length; ++i) {
    if( a[i] >=0)
        res.add(Math.sqrt( a[i]) );
    else
        res.add(0);
}
return res.toArray();
}
interface Example{
    public int f(int x){};
}

int[] myfunct ( Example x,  int[] a){
ArrayList<Integer> res= new ArrayList<Integer>();

       for( int i=0; i< a.length; ++i) {
    res.add(x.f(a[i]));
    
}
return res.toArray();

}
```
Implment above funtions using interface:
```
class myclass implements Example{

        public int f(int x){    
       return x*2;
}

    public void main(String[] args){
        myclass  c= new myclass();
        a = { 1, 4, 3, 5, 10 };
        int[] b = myfunct( new myclass(), a )
        
}
}
```

