#include <stdio.h>
#include <limits.h>

int M, N;
int fee[101][501];
int D[501];
int pre[101][501];
int path[101*501];
int pt_path;

int main ()
{
int i, j;

scanf("%d %d", &M, &N);
for (i = 1; i <= M; ++i) {
for (j = 1; j <= N; ++j) scanf("%d", &fee[i][j]);
}

for (i = 2; i <= M; ++i) {
for (j = 1; j <= N; ++j) {
D[j] += fee[i-1][j];
pre[i][j] = j;
}

int b;
do {
b = 0;
for (j = 2; j <= N; j++) {
if (D[j] > D[j-1] + fee[i][j-1]) 
{
D[j] = D[j-1] + fee[i]
[j-1];
pre[i][j] = j-1;
b++;
}
}
for (j = N-1; j >= 1; --j) {
if (D[j] > D[j+1] + fee[i][j+1])
{
D[j] = D[j+1] + fee[i]
[j+1];
pre[i][j] = j+1;
b++;
}
}
}while(b != 0);
}

for (j = 1; j <= N; ++j) {
D[j] += fee[i-1][j];
}

int min = INT_MAX;
int pt_j;
int pt_i = M;

for (j = 1; j <= N; ++j) {
if (D[j] < min) {
min = D[j];
pt_j = j;
}
}

pt_path = 0;
do {
pt_path++;
path[pt_path] = pt_j;
if (pre[pt_i][pt_j] == pt_j) pt_i--;
else {
pt_j = pre[pt_i][pt_j];
}
}while (pre[pt_i][pt_j] != 0);
if (M != 1) printf("%d\n", pt_j);
for (i = pt_path; i > 0; --i) printf("%d\n", path[i]);

return 0;
}