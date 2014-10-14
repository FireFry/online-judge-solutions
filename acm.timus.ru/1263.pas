var
   a:array[1..10000]of word;
   n,i,j,m:word;
begin
   readln(n,m);
   for i:=1 to m do
   begin
      readln(j);
      inc(a[j]);
   end;
   for i:=1 to n do
      writeln(a[i]/m*100:0:2,'%');
end.