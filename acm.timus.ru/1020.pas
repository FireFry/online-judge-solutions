var
   n,i:integer;
   x,y:array[1..102]of real;
   r,s,a,b,c,cosB,tgB,Al:real;

function Leng(x1,y1,x2,y2:real):real;
begin
   Leng:=sqrt(sqr(x2-x1)+sqr(y2-y1));
end;

begin
   readln(n,R);
   for i:=1 to N do
      read(x[i],y[i]);
   x[n+1]:=x[1];
   y[n+1]:=y[1];
   x[n+2]:=x[2];
   y[n+2]:=y[2];
   for i:=1 to N do
      s:=s+Leng(x[i],y[i],x[i+1],y[i+1]);
   {for i:=2 to N+1 do
   begin
      c:=Leng(x[i-1],y[i-1],x[i+1],y[i+1]);
      a:=Leng(x[i-1],y[i-1],x[i],y[i]);
      b:=Leng(x[i],y[i],x[i+1],y[i+1]);
      cosB:=(sqr(a)+sqr(b)-sqr(c))/(2*a*b);
      if cosB<>0 then
      begin
         tgB:=sqrt(1-sqr(cosB))/cosB;
         Al:=pi-arctan(tgB);
      end
         else Al:=pi/2;
      s:=s+Al*R;
   end;}
   s:=s+2*pi*R;
   writeln(s:0:2);
end.