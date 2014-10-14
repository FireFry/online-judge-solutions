const
   size=1000000000;
type
   long=array[0..1000]of longint;
var
   a:array[0..10001]of long;
   x,y,z,s:long;
   i,n,k,j:integer;

procedure norm(var a:long);
var
   i:integer;
begin
   i:=1;
   while i<=a[0] do
   begin
      while a[i]<0 do
      begin
         inc(a[i],size);
         dec(a[i+1]);
      end;
      a[i+1]:=a[i+1]+a[i] div size;
      a[i]:=a[i] mod size;
      if (i=a[0]) and (a[i+1]>0)
         then inc(a[0]);
      inc(i);
   end;
   while a[a[0]]=0 do
      dec(a[0]);
end;

procedure Plus(var z:long; x,y:long);
var
   i:integer;
begin
   fillchar(z,sizeof(z),0);
   if x[0]>y[0] then
      z[0]:=x[0]
      else z[0]:=y[0];
   for i:=1 to z[0] do
   begin
      z[i]:=x[i]+y[i];
   end;
   Norm(Z);
end;

procedure Minus(var z:long; x,y:long);
var
   i:integer;
begin
   fillchar(z,sizeof(z),0);
   z[0]:=x[0];
   for i:=1 to z[0] do
   begin
      z[i]:=x[i]-y[i];
   end;
   Norm(Z);
end;

procedure writelnlong(a:long);
var
   i:integer;
   j:longint;
begin
   for i:=a[0] downto 1 do
   begin
      j:=size div 10;
      while (i<a[0]) and (j>1) and (a[i] div j=0) do
      begin
         write('0');
         j:=j div 10;
      end;
      write(a[i]);
   end;
   writeln;
end;

begin
{   readln(x[0]);
   for i:=x[0] downto 1 do
      read(x[i]);
   readln(y[0]);
   for i:=y[0] downto 1 do
      read(y[i]);
   Plus(z,x,y);
   writelnlong(z);
   Minus(z,x,y);
   writelnlong(z);}
   readln(n,k);
   if k=0 then writeln(1) else
   begin
      a[0,1]:=1;
      a[0,0]:=1;
      a[1,1]:=2;
      a[1,0]:=1;
      s[0]:=1;
      s[1]:=3;
      for i:=2 to K do
      begin
         a[i]:=a[i-1];
         Plus(a[i],a[i],a[i]);
         Plus(s,s,a[i]);
      end;
      a[K+1]:=s;
      Plus(s,s,s);
      i:=0;
      if n<k then
         writelnlong(a[n]) else
      begin
         for j:=K+2 to N do
         begin
            Minus(a[i],s,a[i]);
            Plus(s,a[i],a[i]);
            i:=(i+1) mod (k+2);
         end;
         if i=0 then
         begin
            if k=n then
               writelnlong(a[k])
               else writelnlong(a[k+1]);
         end
            else writelnlong(a[i-1]);
      end;
   end;
end.