#include <stdio.h>
#include <algorithm>

using namespace std;

static const int max_line = 16;

int main() {
#ifndef ONLINE_JUDGE
    freopen("input.txt", "rt", stdin);
#endif

    int size = 'Z' - 'A' + 1;
    int a[size];
    fill_n(a, size, 2);
    for (char c = 'A'; c <= 'Z'; c++)
        a[c - 'A'] = 2;
    a['A' - 'A'] = a['P' - 'A'] = a['O' - 'A'] = a['R' - 'A'] = 0;
    a['B' - 'A'] = a['M' - 'A'] = a['S' - 'A'] = 1;

    int n;
    scanf("%d\n", &n);

    char line[max_line];
    int steps = 0;
    int pos = 0;
    for (int i = 0; i < n; ++i) {
        gets(line);
        int new_pos = a[line[0] - 'A'];
        steps += abs(new_pos - pos);
        pos = new_pos;
    }
    printf("%d\n", steps);

    return 0;
}