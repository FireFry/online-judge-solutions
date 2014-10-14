var
   r,l,a,b,c,alpha,s:real;
begin
   readln(l,r);
   if r<=l/2 then writeln(pi*r*r:0:3) else if r>=sqrt(2)*l/2 then writeln(l*l:0:34) else
   begin
      a:=l/2;
      c:=r;
      b:=sqrt(sqr(c)-sqr(a));
      alpha:=arctan(b/a);
      s:=pi*sqr(r)-4*(alpha*sqr(r)-(b*l)/2);
      writeln(s:0:3);
   end;
end.