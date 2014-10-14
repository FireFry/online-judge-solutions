#include <stdio.h>
#include <string>
using namespace std;

#define min(x,y) ( (x)<(y)?(x):(y) )
#define max(x,y) ( (x)>(y)?(x):(y) )

string w;
int best;

void inv( int i, int j ){
if ( i<0 || j<0 ) return;
if ( i>3 || j>3 ) return;

int k=4*i+j;
if ( w[k]=='w' ) w[k]='b';
else w[k]='w';
}

void recurse( int d, int moves ){
if ( moves>=best ) return;

int i;
for ( i=1; i<16; i++ )
if ( w[i]!=w[i-1] ) break;

if ( i==16 ){
best=min(best,moves);
return;
}

if ( d==16 ) return;

recurse(d+1,moves);

int j;
i=d/4;
j=d%4;

inv(i,j);
inv(i-1,j);
inv(i+1,j);
inv(i,j-1);
inv(i,j+1);
recurse(d+1,moves+1);
inv(i,j);
inv(i-1,j);
inv(i+1,j);
inv(i,j-1);
inv(i,j+1);
}

int main( void ){
FILE *in=fopen( "input.txt", "r" );
int i,j,k;
int n;
char t[9];

for ( i=0; i<4; i++ ){
scanf( "%s", t );
w+=string(t);
}

best=99999901;

recurse(0,0);

if ( best>100001 ) printf( "Impossible\n" );
else printf( "%d\n", best );

return 0;
}
