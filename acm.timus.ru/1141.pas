var
   pr:array[0..3432]of integer;
   T,e,M,k,d,p,q,pq,n,c,i,j,tr:longint;

function Step(a,n,m:longint):longint;
var
   b:array[1..50]of byte;
   j,k:integer;
   i:longint;
   d:longint;
begin
   d:=1;
   i:=1;
   k:=1;
   while 2*i<=n do
   begin
      inc(k);
      i:=i*2;
   end;
   for j:=k downto 1 do
   begin
      if i<=n then
      begin
         b[j]:=1;
         n:=n-i;
      end else b[j]:=0;
      i:=i div 2;
   end;

   for i:=k downto 1 do
   begin
      d:=d*d mod m;
      if b[i]=1 then
         d:=d*a mod m;
   end;
   Step:=d;
end;

begin

   (* Proverka Step *)
   {  writeln(Step(2,10,1000));  }

   (* Proctoy massiv *)
   pr[0]:=4;
   pr[1]:=2;
   pr[2]:=3;
   pr[3]:=5;
   pr[4]:=7;
   i:=9;
   while (i<=31999) do
   begin
      j:=1;
      tr:=trunc(sqrt(i));
      while (j<=pr[0]) and (pr[j]<=tr) and (i mod pr[j]<>0) do
         inc(j);
      if (pr[j]>tr) then
      begin
         inc(pr[0]);
         pr[pr[0]]:=i;
      end;
      i:=i+2;
   end;

   (* Main *)
   readln(T);
   while T>0 do
   begin
      readln(e,n,c);
      i:=1;
      while n mod pr[i]<>0 do
         inc(i);
      p:=pr[i];
      q:=n div p;
      pq:=(p-1)*(q-1);
      k:=1;
      while (1+k*pq) mod e<>0 do
         inc(k);
      d:=(1+k*pq) div e;
      M:=Step(C,d,n);
      writeln(M);
      dec(T);
   end;
end.