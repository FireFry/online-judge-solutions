var
   a,b:array[0..32000]of integer;
   c:array[0..14999]of integer;
   i,j,n,s,delta,x,y,q:integer;
begin
   read(n);
   for q:=1 to N do
   begin
      read(x,y);
      i:=32768 div 2-1;
      delta:=i+1;
      s:=0;
      while i<>x do
      begin
         delta:=delta div 2;
         if x<i then
         begin
            inc(a[i]);
            i:=i-delta;
         end else
         begin
            s:=s+a[i]+b[i];
            i:=i+delta;
         end;
      end;
      inc(b[x]);
      inc(c[s+b[x]+a[x]-1]);
   end;
   for i:=0 to N-1 do
      writeln(c[i]);
end.