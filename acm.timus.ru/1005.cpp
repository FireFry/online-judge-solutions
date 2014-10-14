#include <stdio.h>
#include <math.h>

int arr[20], sum = 0, min = -1, cal;

void Solution(int i,int cur)
{
if(i == 20)
{
cal = abs(2*cur-sum);
if(min == -1)
{
min = cal;
}
else
{
if(cal < min)
min = cal;
}
return;
}
Solution(i+1,cur+arr[i]);
Solution(i+1,cur);
}
int main(void)
{
int n, i;
scanf("%d",&n);
for(i=0; i<n; i++)
{
scanf("%d",&arr[i]);
sum += arr[i];
}
Solution(0,0);
printf("%d",min);
return 0;
}