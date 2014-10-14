#include <stdio.h>
#include <algorithm>

using namespace std;

static const int max_line = 1001;

int main() {
#ifndef ONLINE_JUDGE
    freopen("input.txt", "rt", stdin);
#endif

    char a[max_line];
    char b[max_line];
    gets(a);
    gets(b);

    int i = 0;
    int j = 0;
    int x = 0;

    for (;;) {
        char ai = a[i];
        char bj = b[j];
        if (!ai && !bj)
            break;
        if (ai && (!bj || ai != 'L' || bj == 'L'))
            i++;
        if (bj && (!ai || bj != 'L' || ai == 'L'))
            j++;
        x++;
    }

    printf("%d\n", x);

    return 0;
}