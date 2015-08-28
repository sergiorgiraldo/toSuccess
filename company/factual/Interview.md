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


class Edge:
    def __init__(self, src, dst, time, hasSB):
        """
        Args:
            src, dst: source node and destination node
            time (int): time to walk through this edge
            hasSB (bool): has StarBucks or not            
        """
        self.src = src
        self.dst = dst
        self.time = time
        self.hasSB = hasSB
        
def cal_possibility(src, dst, edges, N):
    """
    Args:
        src, dst: source node and destination node
        edges: a list of Edges
        N: given time to travel
    Returns:
        poss: a float represent possibility of go through paths with SB
    """
    #assert(木有环)
    count_N = 0
    count_Y = 0
    # edges
    
    def dfs(src, DST, n, buffSB):
        if n < 0:
            return
        if n >= 0 and src == DST:
            if buffSB:
                count_Y += 1
            else:
                count_N += 1
            return
        for edge in edges:
            if edge.src == src and n >= edge.time:
                newbuffSB = buffSB | edge.hasSB
                dfs(edge.dst, DST, n-edge.time, newbuffSB)
        
    # cal_possibility
    buff_SB = False
    dfs(src, dst, N, [], buff_SB)
    
    poss = count_Y / (count_Y + count_N)
    return poss
    

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






