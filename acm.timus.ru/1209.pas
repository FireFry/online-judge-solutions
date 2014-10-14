var
   k:real;
   t,i:word;
begin
 readln(t);
 for i:=1 to T do
 begin
   readln(k);
   if trunc(sqrt(8*k-7))=sqrt(8*k-7)
      then write('1 ')
      else write('0 ');
 end;
 writeln;
end.