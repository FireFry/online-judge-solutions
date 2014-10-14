var
   n,heapsize,i,j,k:word;
   a,b:array[1..25000]of word;

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
      heapify(larg);
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
      readln(a[i]);
   heapsort;
   {i:=2;
   k:=1;
   b[1]:=N;
   for i:=i to N do
      for j:=1 to a[i]-a[i-1] do
      begin
         inc(k);
         b[k]:=N-i+1;
      end;
   for i:=1 to k do
      a[i]:=b[i];
   N:=k;
   heapsort;
   k:=1;
   i:=2;
   b[1]:=N;
   for i:=i to N do
      for j:=1 to a[i]-a[i-1] do
      begin
         inc(k);
         b[k]:=N-i+1;
      end;
   for i:=1 to k do
      writeln(b[i]);   }
   for i:=N downto 1 do
      writeln(a[i]);
end.