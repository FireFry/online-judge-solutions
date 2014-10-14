var
   a:array[1..100]of string;
   b:array[1..100]of integer;
   N,i,M:integer;
   s:string;

procedure Find(s:string);
var
   i:integer;
begin
   i:=1;
   while (i<=M) and (a[i]<>s) do
      inc(i);
   if i>M then
   begin
      inc(M);
      a[m]:=s;
   end else
      b[i]:=1;
end;

begin
   readln(N);
   for i:=1 to N do
   begin
      readln(s);
      find(s);
   end;
   for i:=1 to M do
      if b[i]=1 then
         writeln(a[i]);
end.