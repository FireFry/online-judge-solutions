var
   d:array[0..100]of longint;
   N,i,j,s:longint;
begin
   readln(N);
   for i:=1 to N do
   begin
      read(d[i]);
   end;
   i:=0;
   s:=0;
   while (s+1>=d[i+1]) and (i<N) do
   begin
      inc(i);
      s:=s+d[i];
   end;
   writeln(s+1);
end.