var
   s,m:longint;
   i,j,n:integer;
begin
   readln(N);
   for i:=1 to N do
   begin
      readln(j);
      if s+j<0
         then s:=0 else
         inc(s,j);
      if s>m
         then m:=s;
   end;
   writeln(m);
end.