{ var A:array [1..10000] of
longint;
     c,n:longint;
     i:integer;
 function 
P(l,r:longint):longint;
 var i,j,t,x:longint;
 begin
  x:=A[l]; i:=l-1; j:=r+1;
  while true do
  begin
   repeat dec(j);inc(c)
   until A[j]<=x;
   repeat inc(i);inc(c)
   until A[i]>=x;
   if i<j then
   begin
    t:=A[i];
    A[i]:=A[j];
    A[j]:=t
   end
   else
   begin P:=j; exit end
  end
 end;
 
 procedure Q(l,r:longint);
 var n:longint;
 begin
  if l<r then
  begin
   n:=P(l,r);
   Q(l,n);
   Q(n+1,r)
  end
 end;
 
 begin
  c:=0;
  readln(N);
  for i:=1 to N do
read(A[i]);
  Q(1,N);
  if c=(N*N+3*N-4) div 2 
then
   writeln
   ('Vasia prekr')
  else writeln
   ('Nespir bessmertniy');
 end.
                           }
var
   i,N:word;
begin
   readln(N);
   if N=0
      then write(1)
      else for i:=1 to N do
         write(i,' ');
   writeln;
end.