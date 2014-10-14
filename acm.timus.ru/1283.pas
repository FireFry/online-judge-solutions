var
   k:longint;
   a,b,c:real;
begin
   readln(a,b,c);
   while a>b do
   begin
      inc(k);
      a:=a-(a*c/100);
   end;
   writeln(k);
end.