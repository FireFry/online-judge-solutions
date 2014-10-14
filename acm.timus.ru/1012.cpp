#include <iostream.h>
#include <stdio.h>
int ways[3][20000]={0};
int ADD(int a[], int b[], int c[]);
int MUL(int a[], int k);
int main()
{
long n, k, i, j;
cin>>n>>k;
ways[0][1] = 1;
ways[0][0] = 1;
ways[1][1] = k-1;
ways[1][0] = 1;
for (i=2; i<=n; i++)
{
ADD(ways[2], ways[1], ways[0]);
MUL(ways[2], k-1);
j = 2;
i++;
if (i>n)
break;
ADD(ways[0], ways[2], ways[1]);
MUL(ways[0], k-1);
j = 0;
i++;
if (i>n)
break;
ADD(ways[1], ways[0], ways[2]);
MUL(ways[1], k-1);
j = 1;
}
for (i=ways[j][0]; i>=1; i--)
{
cout<<ways[j][i];
}
return 0;
}

int ADD(int a[], int b[], int c[])
{
int i, remainder, carry;
for (i=1, carry=0; i<=b[0] && i<=c[0]; i++)
{
remainder = (b[i] + c[i] + carry) % 10;
carry = (b[i] + c[i] + carry) / 10;
a[i] = remainder;
}
for (; i<=b[0]; i++)
{
remainder = (b[i] + carry) % 10;
carry = (b[i] + carry) / 10;
a[i] = remainder;
}
for (; i<=c[0]; i++)
{
remainder = (c[i] + carry) % 10;
carry = (c[i] + carry) / 10;
a[i] = remainder;
}
if (carry==1)
{
a[i++] = carry;
}
a[0] = i - 1;
return 0;
}

int MUL(int a[], int k)
{
int i, remainder, carry=0;
for (i=1; i<=a[0]; i++)
{
remainder = (a[i] * k + carry) % 10;
carry = (a[i] * k + carry) / 10;
a[i] = remainder;
}
for (; carry>0; i++)
{
remainder = carry % 10;
carry = carry / 10;
a[i] = remainder;
}
a[0] = i - 1;
return 0;
}