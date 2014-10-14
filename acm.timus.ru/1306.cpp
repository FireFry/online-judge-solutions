#include <stdio.h>

int incKey(unsigned long* a, int i, unsigned long key)
{
    if (a[i] >= key) {
        return 0;
    }
    a[i] = key;
    int parent = i / 2;
    while (i > 0 && a[parent] < key) {
        a[i] = a[parent];
        a[parent] = key;
        i = parent;
        parent = i / 2;
    }
}

int add(unsigned long* a, int size, unsigned long key)
{
    a[size++] = 0;
    incKey(a, size - 1, key);
}

int swap(unsigned long*a, int i, int j)
{
    unsigned long key = a[i];
    a[i] = a[j];
    a[j] = key;
}

int heapify(unsigned long* a, int size, int i)
{
    int l = i * 2;
    int r = l + 1;
    int m = i;
    if (l < size && a[l] > a[m]) {
        m = l;
    }
    if (r < size && a[r] > a[m]) {
        m = r;
    }
    if (m != i) {
        swap(a, i, m);
        heapify(a, size, m);
    }
}

unsigned long pop(unsigned long* a, int size)
{
    int key = a[0];
    a[0] = a[--size];
    heapify(a, size, 0);
    return key;
}

int main()
{
    #ifndef ONLINE_JUDGE
        freopen("input.txt", "rt", stdin);
        freopen("output.txt", "wt", stdout);
    #endif
    int n;
    scanf("%d", &n);
    int m = n / 2 + 2;
    int size = 0;
    unsigned long a[m];
    for (int i = 0; i < n; i++)
    {
        int key;
        scanf("%lu", &key);
        add(a, size++, key);
        if (size == m)
        {
            pop(a, size--);
        }
   }
   unsigned long x1 = pop(a, size--);
   unsigned long x2 = n % 2 == 0 ? pop(a, size--) : x1;
   unsigned long x0 = (x1 % 2) + (x2 % 2);
   unsigned long sum = x1 / 2 + x2 / 2 + x0 / 2;
   printf("%lu", sum);
   if (x0 == 1) {
        printf(".5", sum);
   }
   printf("\n");
   return 0;
}
