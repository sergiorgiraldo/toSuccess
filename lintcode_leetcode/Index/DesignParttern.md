Singleton: : http://wuchong.me/blog/2014/08/28/how-to-correctly-write-singleton-pattern/\\

1 8 9 2 3 3 4 5

int dp[i][j] stands for the max value from i to j

so 

//initial
for(int i= 0 ; i< a.length;i++){
	dp[i][i] = a[i];
}

for(int i = 0 ; i < a.length ; i++){
	for(int j = a.length -1 ; j>=0 ; j--){
		for(int k = i ; k<j ; k++){
			dp[i][j] = math.max( dp[i][k] + dp[k+1][j] , dp[i][k] * dp[K+1][j] );
		}
	}
}


1 3 2 4 5 6 7 8 9

int dp[i] stands for the max value from 0 to i max value

dp[0]= 1;
dp[i]= max(dp[i-1], num[i]+ dp[i-2])


OOOXXOO
XXOOXXO
oooxx00

// update
for(j: len)
axil[j]= axil[j]+ axil[j-1]
dp[i]= sum(axil)

//扫雷
OOOOXXXOO
XXOOOOXOO
OOOOOXXXX
OOOOXXXXX

//  

 
