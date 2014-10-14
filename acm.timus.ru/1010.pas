var
   y1,y2,max:real;
   i,m,n:word;
begin
   readln(n);
   readln(y1);
   i:=0;
   max:=-1;
   while n>1 do
   begin
      dec(n);
      inc(i);
      readln(y2);
      if abs(y2-y1)>max then
      begin
         max:=abs(y2-y1);
         m:=i;
      end;
   end;
   writeln(m,' ',m+1);
end.