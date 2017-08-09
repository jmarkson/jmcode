// q feed.q  / with a default port of 5010 and default timer of 1000
// q feed.q -port 10000 / with a default timer of 1000
// q feed.q -port 10000 -t 2000

tph:hopen $[0=count .z.x;5010;"J"$first .Q.opt[.z.x]`port]
if[not system"t";system"t 1000"]

publishTradeToTickerPlant:{
	nRows:first 1?1+til 3;
	tph(".u.upd";`trade;(nRows#.z.N;nRows?`IBM`FB`GS`JPM;nRows?150.35;nRows?1000));
 }
 
.z.ts:{
	publishTradeToTickerPlant[];
 }