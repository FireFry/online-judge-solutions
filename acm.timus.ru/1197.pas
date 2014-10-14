var
   x,y,kol,N:integer;
   ch:char;
begin
   readln(N);
   while N>0 do
   begin
      kol:=0;
      dec(N);
      read(ch);
      x:=ord(ch)-96;
      readln(y);
      if (x+1>=1) and (x+1<=8) and (y+2>=1) and (y+2<=8)
         then inc(kol);
      if (x+1>=1) and (x+1<=8) and (y-2>=1) and (y-2<=8)
         then inc(kol);
      if (x-1>=1) and (x-1<=8) and (y+2>=1) and (y+2<=8)
         then inc(kol);
      if (x-1>=1) and (x-1<=8) and (y-2>=1) and (y-2<=8)
         then inc(kol);
      if (x+2>=1) and (x+2<=8) and (y+1>=1) and (y+1<=8)
         then inc(kol);
      if (x+2>=1) and (x+2<=8) and (y-1>=1) and (y-1<=8)
         then inc(kol);
      if (x-2>=1) and (x-2<=8) and (y+1>=1) and (y+1<=8)
         then inc(kol);
      if (x-2>=1) and (x-2<=8) and (y-1>=1) and (y-1<=8)
         then inc(kol);
      writeln(kol);
   end;
end.