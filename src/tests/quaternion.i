L1:	x = 2
L3:	y = 1
L4:	r = false
L5:	a = minus 1
L6:	if x < y goto L8
	t1 = true
	goto L9
L8:	t1 = false
L9:	r = t1
L7:	if x > y goto L12
L11:	r = true
	goto L10
L12:	r = false
L10:	a = x + 1
L13:	a = y / x
L14:	a = x * 3
L15:L16:	iffalse x > 10 goto L17
L18:	goto L2
L17:	x = x + 1
	goto L15
L2:
