#include "stdio.h"

struct wp
{
long a,b; 
char c; /*color*/
struct wp *next;
}head;

main()
{
long a,b,s;
char c;
int i,n;
struct wp *p,*q,*k;
head.a=0;
head.b=1000000000;
head.c='w';
head.next=NULL;
scanf("%d",&n);
for(i=0;i<n;i++)
{
scanf("%ld%ld",&a,&b);
c=0;
while(c!='b' && c!='w') c=getchar();
for(p=&head;p!=NULL;p=p->next) if(p->a<=a && p->b>=a) break;
for(q=&head;q!=NULL;q=q->next) if(q->a<=b && q->b>=b) break;
if(q->next!=NULL && q->next->a==b) q=q->next;

if(p->c==c && q->c==c)
{
p->b=q->b;
p->next=q->next;

continue;
}
if(p==q)
{
if(p->a==a && p->b==b) {p->c=c;continue;}
if(p->a==a)
{
k=p->next;
p->next=new struct wp;
p->next->next=k;
p->next->a=b;
p->next->b=p->b;
p->next->c=p->c;
p->c=c;
p->b=b;
continue;
}
if(p->b==b)
{
k=p->next;
p->next=new struct wp;
p->next->next=k;
p->next->a=a;
p->next->b=b;
p->next->c=c;
p->b=a;
continue;
}
k=p->next;
p->next=new struct wp;
p->next->next=new struct wp;
q=p->next->next;
q->next=k;
q->b=p->b;
q->a=b;
q->c=p->c;
p->next->a=a;
p->next->b=b;
p->next->c=c;
p->b=a;
continue;
}
if(p->a==a) p->c=c;
if(q->b==b) q->c=c;
if(p->c==c) a=p->a;
if(q->c==c) b=q->b;
if(p->c!=c && q->c!=c)
{
p->b=a;
q->a=b;
p->next=new struct wp;
p->next->a=a;
p->next->b=b;
p->next->c=c;
p->next->next=q;
continue;
}
if(p->c==c && q->c!=c)
{
p->next=q;
p->b=b;
q->a=b;
continue;
}
p->next=q;
p->b=a;
q->a=a;
}
s=-1;
for(k=&head;k!=NULL;k=k->next)
if(k->b-k->a>s && k->c=='w')
{
s=k->b-k->a;
a=k->a;
b=k->b;
}
printf("%ld %ld\n",a,b);
return 0;
}