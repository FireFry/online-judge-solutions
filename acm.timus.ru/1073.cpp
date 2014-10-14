#include <stdio.h>
#include <math.h>

int nice( int k ){
int f=int( 0.0000001+sqrt( double(k) ) );
return f*f==k;
}

int solve( int n ){
if ( nice(n) ) return 1;
int i,j;

for ( i=1; i*i<=n; i++ )
if ( nice(n-i*i) ) return 2;

for ( i=1; i*i<=n; i++ )
for ( j=i; j*j<=n; j++ )
if ( nice(n-i*i-j*j) ) return 3;

return 4;
}

int main( void ){
int n;

scanf( "%d", &n );
printf( "%d\n", solve(n) );

return 0;
}
