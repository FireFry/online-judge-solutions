Program P1053;
Const Max=1000;
Type TList=Array[1..Max] of Longint;
Var A:TList;
n,s,i:Integer;
r1,r2:longint;

Procedure Sort(l,r:Integer);
Var x,t:Longint;
i,j:Integer;
Begin
i:=l; j:=r; x:=A[(i+j) div 2];
repeat
while A[i]>x do inc(i);
while A[j]<x do dec(j);
if i<=j then begin
if i<>j then begin
t:=A[i]; A[i]:=A[j]; A
[j]:=t
end;
inc(i); dec(j)
end
until i>j;
if i<r then Sort(i,r);
if l<j then Sort(l,j)
End;

Function Gcd(A,B:Longint):Longint;
Var C:Longint;
Begin
while B<>0 do
begin
C:=A;
A:=B;
B:=C mod B
end;
Gcd:=A
End;

Begin
readln(n);
for i:=1 to n do read(A[i]);
Sort(1,n);
for i:=n-1 downto 1 do A[i]:=Gcd(A[i+1],A[i]);
writeln(A[1])
End.