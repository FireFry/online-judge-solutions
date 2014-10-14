#include <stdio.h>
#include <string.h>

char matrix[35][35];
int m[35][35];
int N;
char ch;

void INIT(int x, int y)
{
m[x][y] = 1;
if (x + 1 <= N && matrix[x+1][y] != '#' && m[x+1][y] != 1) 
INIT(x+1, y);
if (x - 1 >= 1 && matrix[x-1][y] != '#' && m[x-1][y] != 1) 
INIT(x-1, y);
if (y + 1 <= N && matrix[x][y+1] != '#' && m[x][y+1] != 1) 
INIT(x, y+1);
if (y - 1 >= 1 && matrix[x][y-1] != '#' && m[x][y-1] != 1) 
INIT(x, y-1);

return;
}

int main()
{
int i, j, total;

scanf("%d", &N);
ch = getchar();
for (i = 1; i <= N; ++i) {
for (j = 1; j <= N; ++j)
matrix[i][j] = getchar();
ch = getchar();
}

INIT(1, 1);
INIT(N, N);

total = 0;
for (i = 1; i <= N; ++i ) {
for (j = 1; j <= N; ++j) {
if (m[i][j] == 1) {
if (m[i+1][j] == 0 || i+1 > N) 
total++;
if (m[i-1][j] == 0 || i-1 < 1) 
total++;
if (m[i][j+1] == 0 || j+1 > N) 
total++;
if (m[i][j-1] == 0 || j-1 < 1) 
total++;
} 
}
}

total -= 4;
printf("%d\n", total*9);
return 0;
}