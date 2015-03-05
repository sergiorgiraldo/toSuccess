Imagine a large city like Los Angeles. Suppose someone shows up at location A, then N minutes later at location B. Design a function that approximates the probability they passed a Starbucks.


class Location {
  double lat;
  double lng;
  // assume any geometry-related methods are defined already (e.g. distance, dot product, etc)
}

class Edge {
  Location from;
  Location to;
  boolean starbucks;      // whether the edge passes a starbucks
  int minutes;            // minimum travel time
  double flowRate;        // average #people/hour who take this edge
}

// these functions are provided:
Edge[] edgesFrom(Location x);     // a list of edges pointing outwards from the specified location
Location[] allStarbucks();        // the location of every starbucks
double maxSpeed();                // the maximum rate of travel for any person

/*
         S            S            <- S means starbucks along an edge
   A --------- C ---------- B
   |                        |
   ----------- D ------------

   P(starbucks) = 0.5       // we're looking for probability
   E(starbucks) = 1

*/

class getProbability{
Location from;
Location To;
public void init(Location A,  Location B){
    from=A;
    to = B;
}

// suppose we used DFS; is that something you think you could write up?
// how about we write something up in comments as pseudocode?
public void BFS( ){
        int countPah=0, countStar=0;
        Stack<Location> s;
        for E in alll edgesFrom(A)y
              if( E.to ==B)

}


}

// our job is to write edgesFrom()
// we have a giant file of edge data
// 120GB of text:

from           to            starbucks minutes flowrate
lat1,lng1      lat2,lng2     true      5       40.0
lat1,lng1      lat2,lng2     true      5       40.0
lat1,lng1      lat2,lng2     true      5       40.0
lat1,lng1      lat2,lng2     true      5       40.0

// you can preprocess this data however you'd like
// you're also free to use any libraries/software as dependencies
// how would you go about writing edgesFrom()?

// this function is not very good:
$ function edgesfrom() {
    local lat=$1
    local lng=$2
    grep ^$lat,$lng data.txt | cut -f2
  }
$ edgesfrom 34 -117
...
$ 
you want to get all "to" locations for a fixed "from " ? 
yes, or we can just return the whole line anytime the "from" matches


// mostly we use:
// postgresql
// sqlite
// redis
// mongo






