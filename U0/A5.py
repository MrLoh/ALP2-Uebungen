def rgb_2_cmyk(r,g,b):
	if max(r,g,b) > 255 or min (r,g,b) < 0: 
		return "(%s,%s,%s) is no valid RGB value." % (r,g,b)
	elif (r,g,b) == (0,0,0):
		(c,m,y,k) = (0,0,0,1)
	else:
		w = max(r/255, g/255, b/255) 
		c = (w-r/255)/w
		m = (w-g/255)/w
		y = (w-b/255)/w
		k = 1-w
	return (c,m,y,k)

print rgb_2_cmyk(0,0,0)
print rgb_2_cmyk(255,255,255)
print rgb_2_cmyk(255,0,0)
print rgb_2_cmyk(0,255,0)
print rgb_2_cmyk(0,0,255)
print
print rgb_2_cmyk(300,0,0)
print rgb_2_cmyk(0,-1,0)