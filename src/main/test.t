{
        int x; int y; bool r;int a;
        x = 2;
        y = 1;
        r = false;
        a = -1;

        r = !(x < y);

	if( !(x > y) ) r = true;
	else r = false;

	a = x + 1;
	a = y / x;
	a = x * 3;

	while (true) {
		if (x > 10) {
			break;
		}
		x = x + 1;
	}
}
# {
# 	int i;int j;int v;int x;int[100] a;
# 	while ( true) {
# 		do i = i + 1;	while ( a[i] < v);
# 		do j = j - 1;	while( a[j] > v);
# 		if(i >= j)	break;
# 		x = a[i];	a[i] = a[j];	a[j] = x;
# 	}
# }
