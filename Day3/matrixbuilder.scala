import scala.io.Source



var TARG = 361527

val arrsz = 604

val matrix = Array.ofDim[Int](arrsz,arrsz)
ArrInit()

//traverse initialize to 2
var traverse = 2

var row = arrsz/2
var col = arrsz/2
var curNum = 1
matrix(row)(col) = curNum
curNum += 1

while(row < arrsz && col < arrsz){
	//start right 1
	col += 1
	//go up traverse-1
	for(i <- 0 to traverse-1){
		matrix(row-i)(col) = curNum
		curNum += 1
	}
	row = row - traverse + 1
	//go left traverse
	for(i <- 1 to traverse){
		matrix(row)(col-i) = curNum
		curNum += 1
	}
	col = col - traverse
	//traverse down
	for(i <- 1 to traverse){
		matrix(row+i)(col) = curNum
		curNum += 1
	}
	row = row + traverse
	//traverse right
	for(i <- 1 to traverse){
		matrix(row)(col+i) = curNum
		curNum += 1
	}
	col = col + traverse
	if(curNum > TARG)
		row = arrsz
	traverse += 2
}

PrintMat()

def ArrInit(){
	for(i <- 0 to arrsz-1)
		for(j <- 0 to arrsz-1)
			matrix(i)(j) = 0
}

def PrintMat(){
	for(i <- 0 to arrsz-1){
		for(j <- 0 to arrsz-1){
			var space = ""
			if (matrix(i)(j) < 10)
				space = "    "
			else if(matrix(i)(j) < 100)
				space = "   "
			else if(matrix(i)(j) < 1000)
				space = "  "
			else
				space = " "
			print(space + matrix(i)(j))
		}
		print('\n')
	}
}

