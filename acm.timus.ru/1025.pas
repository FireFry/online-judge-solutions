var
   n,heapsize,i:word;
   a:array[1..101]of word;

procedure swap(var x,y:word);
var
   z:word;
begin
   z:=x;
   x:=y;
   y:=z;
end;

procedure heapify(i:word);
var
   l,r,larg:word;
begin
   l:=2*i;
   r:=l+1;
   if (l<=heapsize) and (a[l]>a[i])
      then larg:=l
      else larg:=i;
   if (r<=heapsize) and (a[r]>a[larg])
      then larg:=r;
   if larg<>i then
   begin
      swap(a[i],a[larg]);
      heapify(a[larg]);
   end;
end;

procedure heapsort;
var
   i:word;
begin
   heapsize:=N;
   for i:=N div 2 downto 1 do
      heapify(i);
   for i:=N downto 2 do
   begin
      swap(a[1],a[i]);
      dec(heapsize);
      heapify(1);
   end;
end;

begin
   readln(N);
   for i:=1 to N do
      read(a[i]);
   {heapsort;}
   for heapsize:=N-1 downto 1 do
      for i:=1 to heapsize do
         if a[i]>a[i+1]
            then swap(a[i],a[i+1]);
   heapsize:=0;
   for i:=1 to (N+1) div 2 do
      inc(heapsize,(a[i]+1) div 2);
   writeln(heapsize);
end.