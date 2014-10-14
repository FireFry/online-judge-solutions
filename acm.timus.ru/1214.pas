var x,y:longint;
Procedure out(x,y:longint);
begin writeln(x,' ',y);halt;end;
begin readln(x,y);
if (x=y)or(x<0)or(y<0) then out(x,y);
if ((x mod 2= 0)and(y mod 2 = 0))or((x mod 2<>0)and(y mod 2<>0)) then out(x,y);out(y,x);end.