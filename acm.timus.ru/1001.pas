{$N+}
var
   a:array[1..100000000]of extended;
   i:longint;
   x:extended;
begin
   {assign(input,'1001.dat');
   reset(input);}
   i:=0;
   while not SEEKEOF do
   begin
      {whil not EOLN do}
      begin
         read(x);
         inc(i);
         a[i]:=sqrt(x);
      end;
    {  readln; }
   end;
   while i>0 do
   begin
      writeln(a[i]:0:4);
      dec(i);
   end;
end.