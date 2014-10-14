#include <iostream.h>

bool next(unsigned long int n)
{
for (unsigned short int i=9;i>1;i--)
if (n%i==0&&(n/i>9?next(n/i):i+=n/i*10))
{
cout << i;
return 1;
}
return 0;
}

int main()
{
unsigned long int n;
cin >> n;
if (n<10)
cout << (n==0?10:n);
else
if (!next(n))
cout << -1;
return 0;
}
