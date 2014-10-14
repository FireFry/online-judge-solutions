var
   N,i,sum:longint;
begin
   readln(N);
   if N<1 then
      for i:=1 downto N do
         inc(sum,i)
      else
      for i:=1 to N do
         inc(sum,i);
   writeln(sum);
end.