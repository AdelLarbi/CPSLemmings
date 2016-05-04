service : Level
enum Nature {EMPTY, DIRT, METAL}

observators :
    const height : [Level] → int
	const width: [Level] → int
	isEditing : [Level] → bool
	nature : [Level] × int × int → Nature
		pre nature(L,x,y) require  x => 0 & x < width & y => 0 && y < height
	xEntrance : [Level] → int
	yEntrance : [Level] → int
	xExit : [Level] → int
	yExit : [Level] → int
	
Constructors :
	init : int × int → [Level]
		pre init(width,height) require width > 4 & height > 4
		
Operators :
	setNature : [Level] × int × int → [Level]
		pre setNature(L,x,y) require x >= 0 & x < width & y => 0 & y < height
	
	goPlay : [Level] × int × int × int × int → [Level]
		pre setNature(L,xEntrance,yEntrance,xExit,yExit) require
		∀x,y / (x = 0 & 0 <= y < height) || (y = 0 & 0 <= x < width) 
	    || (x = width()-1 & 0 <= y < height()) || (y = height()-1 & 0 <= x < width)
	    & isEditing = true 
	    & xEntrance > 0 & xEntrance < width-1 & yEntrance > 0 & yEntrance < height-1
	    & xExit > 0 & xExit < width-1 & yExit > 0 & yExit < height-1
	    & ¬(xEntrance = xExit & yEntrance = yExit)
	    & nature(L,xEntrance,yEntrance) = Nature.EMPTY & nature(L,xEntrance,yEntrance-1) = Nature.EMPTY 
	    & nature(xEntrance,yEntrance+1) = Nature.EMPTY & nature(xExit,yExit) = Nature.EMPTY 
	    & nature(xExit,yExit-1) = Nature.EMPTY & nature(xExit,yExit+1) = Nature.METAL
	
	goEditing : [Level] → [Level]
		pre goEditing(L) require isEditing = false
		
	remove : [Level] × int × int → [Level]
		pre remove(L,x,y) require nature(L,x,y) = Nature.DIRT & isEditing = false
		& x > 0 & x < width-1 & y > 0 & y < height()-1
		& !(x = xEntrance & y = yEntrance) & (x = xExit & y != yExit)
		
	build : [Level] × int × int → [Level]
		pre remove(L,x,y) require nature(L,x,y) = Nature.EMPTY & isEditing = false
		& x > 0 & x < width-1 & y > 0 & y < height()-1
		& !(x = xEntrance & y = yEntrance) & (x = xExit & y != yExit)

Observations :
[invariants]
// pas d'invariants
[init]
	height(init(w,h)) = h
	width(init(w,h)) = w
	isEditing(init(w,h)) = true
	xEntrance(init(w,h)) = -1
	yEntrance(init(w,h)) = -1
	xExit(init(w,h)) = -1
	yExit(init(w,h)) = -1
	nature(init(w,h)) = 
		
		
		
		
		
		
		
		
		
		
		
		 